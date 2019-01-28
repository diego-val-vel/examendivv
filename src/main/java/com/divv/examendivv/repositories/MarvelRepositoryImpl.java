package com.divv.examendivv.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import com.divv.examendivv.models.Comic;
import com.divv.examendivv.models.Colaborator;
import com.divv.examendivv.models.Mcharacter;
import java.util.List;

public class MarvelRepositoryImpl implements MarvelRepository
{
    private final MongoTemplate mongoTemplate;
    
    @Autowired
    public MarvelRepositoryImpl(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate = mongoTemplate;
    }
    
    @Override
    public List<Colaborator> aggregateColaborator()
    {
        UnwindOperation unwindOperationColaborator = getUnwindOperationColaborator();
        GroupOperation groupOperationColaborator = getGroupOperationColaborator();
        MatchOperation matchOperationColaborator = getMatchOperationColaborator();
        SortOperation sortOperationColaborator = getSortOperationColaborator();
        
        return mongoTemplate.aggregate(Aggregation.newAggregation(
            unwindOperationColaborator,
            groupOperationColaborator,
            matchOperationColaborator,
            sortOperationColaborator
        ), Comic.class, Colaborator.class).getMappedResults();
    }

    @Override
    public List<Mcharacter> aggregateMcharacter()
    {
        UnwindOperation unwindOperationCharacters = getUnwindOperationCharacters();
        GroupOperation groupOperationCharacters = getGroupOperationCharacters();
        SortOperation sortOperationCharacters = getSortOperationCharacters();
        
        return mongoTemplate.aggregate(Aggregation.newAggregation(
            unwindOperationCharacters,
            groupOperationCharacters,
            sortOperationCharacters
        ), Comic.class, Mcharacter.class).getMappedResults();
    }

    // Colaborator.
    private UnwindOperation getUnwindOperationColaborator()
    {
        return unwind("$creators.items");
    }

    private GroupOperation getGroupOperationColaborator()
    {
        return group("creators.items.role")
            .last("creators.items.role").as("id")
            .addToSet("creators.items.name").as("names");
    }

    private MatchOperation getMatchOperationColaborator()
    {
        Criteria idCriteria = where("id").in("editor", "writer", "colorist");

        return match(idCriteria);
    }

    private SortOperation getSortOperationColaborator()
    {
        return sort(Sort.Direction.ASC, "id");
    }

    // Characters.
    private UnwindOperation getUnwindOperationCharacters()
    {
        return unwind("$characters.items");
    }

    private GroupOperation getGroupOperationCharacters()
    {
        return group("$characters.items.name")
            .last("$characters.items.name").as("id")
            .addToSet("$title").as("comics");
    }

    private SortOperation getSortOperationCharacters()
    {
        return sort(Sort.Direction.ASC, "id");
    }

    /*
    ===
    QUERYS IN MONGODB.
    ===
    db.comic.find({}).pretty()

    - CREATORS
        db.comic.find({}, {_id:0, "creators.items.role": 1, "creators.items.name": 1}).pretty()

        db.comic.aggregate([
            {
                $unwind : "$creators.items"
            },
            {
                $group:
                {
                    _id: "$creators.items.role",
                    "names":
                    {
                        $push: "$creators.items.name"
                    }
                }
            },
            {
                $match:
                {
                    _id: { $in: ["editor", "writer", "colorist"] }
                }
            },
            {
                $sort : { "_id" : 1 }
            }
        ]).pretty()

    - CHARACTERS
        db.comic.find({}, {_id:0, title: 1, "characters.items.name": 1}).pretty()

        db.comic.aggregate([
            {
                $unwind : "$characters.items"
            },
            {
                $group:
                {
                    "_id": "$characters.items.name",
                    "comics":
                    {
                        $push: "$title"
                    }
                }
            },
            {
                $sort : { "_id" : 1 }
            }
        ]).pretty()
    */
}
