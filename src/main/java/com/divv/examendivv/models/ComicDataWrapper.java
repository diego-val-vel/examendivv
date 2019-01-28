package com.divv.examendivv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicDataWrapper
{
    private ComicDataContainer data;

    public ComicDataWrapper() {}

    public ComicDataContainer getData()
    {
        return this.data;
    }

    public void setData(ComicDataContainer data)
    {
        this.data = data;
    }
}
