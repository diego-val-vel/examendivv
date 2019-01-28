package com.divv.examendivv.utils;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicLong;
import java.security.MessageDigest;

public class Util
{
    // Constants.
    private static final String schemeHttp = "http";
    private static final String host = "gateway.marvel.com";
    private static final String pathCharacters = "/v1/public/characters";
    private static final String pathComics = pathCharacters + "/%s/comics";
    private static final String apikeyPu = "8bb92377cb92a1c1f27aae9ceeaaa013";
    private static final String apikeyPr = "c455a24172faf7160d366b37dcb6fc8ddc19d68a";
    public static final String ironman = "Iron Man";
    public static final String capamerica = "Captain America";
    public static AtomicLong ts = new AtomicLong();

    // Constructor.
    public Util(){}

    // Character's name method.
    public static String getNameCharacter(String characterName)
    {
        String nameResult = "";

        if (characterName.equals("ironman"))
        {
            nameResult = ironman;
        }
        else if (characterName.equals("capamerica"))
        {
            nameResult = capamerica;
        }

        return nameResult;
    }

    // URI character method.
    public static String getURICharacter(String tsP, String name) throws Exception
    {
        UriComponents uriComponents = null;

        // Set full uri from get request.
        try
        {
            uriComponents = UriComponentsBuilder.newInstance()
            .scheme(schemeHttp)
            .host(host)
            .path(pathCharacters)
            .queryParam("apikey", apikeyPu)
            .queryParam("name", name)
            .queryParam("ts", tsP)
            .queryParam("hash", getMd5(tsP))
            .build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return uriComponents.toUriString();
    }

    // URI comics method.
    public static String getURIComics(String tsP, String id) throws Exception
    {
        UriComponents uriComponents = null;

        // Set full uri from get request.
        try
        {
            uriComponents = UriComponentsBuilder.newInstance()
            .scheme(schemeHttp)
            .host(host)
            .path(String.format(pathComics, id))
            .queryParam("apikey", apikeyPu)
            .queryParam("ts", tsP)
            .queryParam("hash", getMd5(tsP))
            .build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return uriComponents.toUriString();
    }

    // MD5 method.
    public static String getMd5(String tsP) throws Exception
    {
        StringBuilder sb= new StringBuilder();
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        try
        {
            md5.update(StandardCharsets.UTF_8.encode(sb.append(tsP).append(apikeyPr).append(apikeyPu).toString()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return String.format("%032x", new BigInteger(1, md5.digest()));
    }
}
