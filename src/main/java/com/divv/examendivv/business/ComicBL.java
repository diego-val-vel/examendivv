package com.divv.examendivv.business;

import org.springframework.web.client.RestTemplate;
import java.util.List;
import com.divv.examendivv.utils.Util;
import com.divv.examendivv.models.ComicDataWrapper;
import com.divv.examendivv.models.Comic;

public class ComicBL
{
    // Get character's comics by id.
    public List<Comic> characterComicsById(String id)
    {
        // Get ts from Util.
        Long ts = Util.ts.incrementAndGet();

        // Get ComicDataWrapper from get response.
        RestTemplate restTemplate = new RestTemplate();
        ComicDataWrapper comicDataWrapper = null;

        try
        {
            comicDataWrapper = restTemplate.getForObject(Util.getURIComics(ts.toString(), id), ComicDataWrapper.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        List<Comic> listComic = comicDataWrapper.getData().getResults();

        return listComic;
    }
}
