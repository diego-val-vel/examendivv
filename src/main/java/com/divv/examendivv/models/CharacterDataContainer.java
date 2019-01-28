package com.divv.examendivv.models;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDataContainer
{
    private List<Character> results;

    public CharacterDataContainer()
    {
        results = new ArrayList<Character>();
    }

    public List<Character> getResults()
    {
        return this.results;
    }

    public void setResults(List<Character> results)
    {
        this.results = results;
    }
}
