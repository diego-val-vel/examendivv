package com.divv.examendivv.models;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mcharacter
{
    private String id;
    private List<String> comics;

    public Mcharacter()
    {
        comics = new ArrayList<String>();
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public List<String> getComics()
    {
        return comics;
    }

    public void setComics(List<String> comics)
    {
        this.comics = comics;
    }
}
