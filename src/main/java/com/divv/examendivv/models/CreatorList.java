package com.divv.examendivv.models;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatorList
{
    private Integer returned;
    private List<CreatorSummary> items;

    public CreatorList()
    {
        items = new ArrayList<CreatorSummary>();
    }

    public Integer getReturned()
    {
        return returned;
    }

    public void setReturned(Integer returned)
    {
        this.returned = returned;
    }

    public List<CreatorSummary> getItems()
    {
        return this.items;
    }

    public void setItems(List<CreatorSummary> items)
    {
        this.items = items;
    }
}
