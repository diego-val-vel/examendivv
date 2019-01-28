package com.divv.examendivv.repositories;

import java.util.List;
import com.divv.examendivv.models.Colaborator;
import com.divv.examendivv.models.Mcharacter;

public interface MarvelRepository
{
    public List<Colaborator> aggregateColaborator();
    public List<Mcharacter> aggregateMcharacter();
}
