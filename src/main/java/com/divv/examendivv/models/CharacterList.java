package com.divv.examendivv.models;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterList
{
    private Integer returned;
    private List<CharacterSummary> items;

    public CharacterList()
    {
        items = new ArrayList<CharacterSummary>();
    }

    public Integer getReturned()
    {
        return returned;
    }

    public void setReturned(Integer returned)
    {
        this.returned = returned;
    }

    public List<CharacterSummary> getItems()
    {
        return this.items;
    }

    public void setItems(List<CharacterSummary> items)
    {
        this.items = items;
    }
}
