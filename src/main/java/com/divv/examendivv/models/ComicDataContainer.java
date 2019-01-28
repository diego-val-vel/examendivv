package com.divv.examendivv.models;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicDataContainer
{
    private List<Comic> results;

    public ComicDataContainer()
    {
        results = new ArrayList<Comic>();
    }

    public List<Comic> getResults()
    {
        return this.results;
    }

    public void setResults(List<Comic> results)
    {
        this.results = results;
    }
}
