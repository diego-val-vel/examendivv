package com.divv.examendivv.services;

import java.util.List;
import com.divv.examendivv.models.Colaborator;
import com.divv.examendivv.models.Mcharacter;

public interface ComicService
{
    public List<Colaborator> aggregateColaborator(String characterName);
    public List<Mcharacter> aggregateMcharacter(String characterName);
}
