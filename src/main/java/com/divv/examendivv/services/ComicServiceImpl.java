package com.divv.examendivv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.divv.examendivv.business.*;
import com.divv.examendivv.models.Colaborator;
import com.divv.examendivv.models.Mcharacter;
import com.divv.examendivv.models.Comic;
import com.divv.examendivv.repositories.ComicRepository;
import com.divv.examendivv.utils.Util;

@Service
public class ComicServiceImpl implements ComicService
{
    @Autowired
    private ComicRepository comicRepository;

    public List<Colaborator> aggregateColaborator(String characterName)
    {
        // Call to BL.
        CharacterBL characterBL = new CharacterBL();
        ComicBL comicBL = new ComicBL();

        // Get character's name.
        String nameCharacter = Util.getNameCharacter(characterName);

        // Comics list.
        List<Comic> listComic = new ArrayList<Comic>();

        // Colaborators list.
        List<Colaborator> listColaborator = new ArrayList<Colaborator>();

        if (nameCharacter != "")
        {
            // Get character's comics by his id.
            String idCharacter = characterBL.characterId(nameCharacter);
            listComic = comicBL.characterComicsById(idCharacter);

            // Mongo.
            comicRepository.deleteAll();
    
            // Save comics in db.
            listComic.forEach((comic) -> {
                comicRepository.save(comic);
            });
    
            // Get colaborators list grouped by role.
            listColaborator = this.comicRepository.aggregateColaborator();
        }

        // Return documents.
        return listColaborator;
    }

    public List<Mcharacter> aggregateMcharacter(String characterName)
    {
        // Call to BL.
        CharacterBL characterBL = new CharacterBL();
        ComicBL comicBL = new ComicBL();

        // Get character's name.
        String nameCharacter = Util.getNameCharacter(characterName);

        // Comics list.
        List<Comic> listComic = new ArrayList<Comic>();

        // Colaborators list.
        List<Mcharacter> listInteract = new ArrayList<Mcharacter>();

        if (nameCharacter != "")
        {
            // Get character's comics by his id.
            String idCharacter = characterBL.characterId(nameCharacter);
            listComic = comicBL.characterComicsById(idCharacter);

            // Mongo.
            comicRepository.deleteAll();
    
            // Save comics in db.
            listComic.forEach((comic) -> {
                comicRepository.save(comic);
            });
    
            // Get colaborators list grouped by role.
            listInteract = this.comicRepository.aggregateMcharacter();
        }

        // Return documents.
        return listInteract;
    }
}
