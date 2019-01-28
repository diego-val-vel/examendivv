package com.divv.examendivv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.divv.examendivv.models.Colaborator;
import com.divv.examendivv.models.Mcharacter;
import com.divv.examendivv.services.ComicService;
import java.util.List;

@RestController
@RequestMapping(path = "/marvel/")
public class MarvelController
{
    @Autowired
    private ComicService comicService;

    @GetMapping("/colaborators/{characterName}")
    public ResponseEntity<List<Colaborator>> getColaborators(@PathVariable String characterName)
    {
        return ResponseEntity.ok(this.comicService.aggregateColaborator(characterName));
    }

    @GetMapping("/characters/{characterName}")
    public ResponseEntity<List<Mcharacter>> getCharacters(@PathVariable String characterName)
    {
        return ResponseEntity.ok(this.comicService.aggregateMcharacter(characterName));
    }
}
