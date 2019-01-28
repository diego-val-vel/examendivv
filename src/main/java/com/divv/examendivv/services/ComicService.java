package com.divv.examendivv.services;

import java.util.Map;

public interface ComicService
{
    public Map<String, Object> aggregateColaborator(String characterName);
    public Map<String, Object> aggregateMcharacter(String characterName);
}
