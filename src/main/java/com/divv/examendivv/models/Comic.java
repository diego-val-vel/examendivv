package com.divv.examendivv.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comic {
    @Id
    private String id;
    private String title;
    private CreatorList creators;
    private CharacterList characters;

    public Comic() {}

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public CreatorList getCreators()
    {
        return this.creators;
    }

    public void setCreators(CreatorList creators)
    {
        this.creators = creators;
    }

    public CharacterList getCharacters()
    {
        return this.characters;
    }

    public void setCharacters(CharacterList characters)
    {
        this.characters = characters;
    }
}
