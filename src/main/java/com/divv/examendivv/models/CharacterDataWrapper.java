package com.divv.examendivv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDataWrapper
{
    private CharacterDataContainer data;

    public CharacterDataWrapper() {}

    public CharacterDataContainer getData()
    {
        return this.data;
    }

    public void setData(CharacterDataContainer data)
    {
        this.data = data;
    }
}
