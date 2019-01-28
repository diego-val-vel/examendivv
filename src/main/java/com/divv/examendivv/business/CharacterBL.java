package com.divv.examendivv.business;

import org.springframework.web.client.RestTemplate;
import java.util.List;
import com.divv.examendivv.utils.Util;
import com.divv.examendivv.models.CharacterDataWrapper;
import com.divv.examendivv.models.Character;

public class CharacterBL
{
    // Get character's id by name.
    public String characterId(String name)
    {
        // Get ts from Util.
        Long ts = Util.ts.incrementAndGet();

        // Get CharacterDataWrapper from get response.
        RestTemplate restTemplate = new RestTemplate();
        CharacterDataWrapper characterDataWrapper = null;

        try
        {
            characterDataWrapper = restTemplate.getForObject(Util.getURICharacter(ts.toString(), name), CharacterDataWrapper.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // Get character from characterDataWrapper.
        List<Character> listCharacter = characterDataWrapper.getData().getResults();
        Character charResult = listCharacter.stream().findFirst().get();

        return charResult.getId();
    }
}
