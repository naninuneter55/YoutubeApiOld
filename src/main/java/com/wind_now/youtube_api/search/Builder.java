/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wind_now.youtube_api.search;

import com.google.gson.Gson;
import com.wind_now.youtube_api.util.OnoLogger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author ono
 */
public abstract class Builder {

    final String URL_SCHEME = "https";
    final String URL_HOST = "www.googleapis.com";
    final String URL_PATH = "/youtube/v3/search";
    static final Logger logger = OnoLogger.getLogger();

    public abstract URI getUri(String term);

    protected <T> T getResult(String url, Class<T> clazz) {
        T pi = null;
        try {
            String json = readUrl(url);
            Gson gson = new Gson();
            pi = gson.fromJson(json, clazz);
        } catch (Exception ex) {
            logger.severe(ex.toString());
        }
        return pi;
    }

    protected URI getUri(List<NameValuePair> params){
        URI uri;
        try{
            uri = new URIBuilder()
                    .setScheme(URL_SCHEME)
                    .setHost(URL_HOST)
                    .setPath(URL_PATH)
                    .setParameters(params)
                    .build();
            System.out.println(uri);
        }catch(URISyntaxException e){
            logger.severe(e.toString());
            uri = null;
        }
        return uri;
    }
    
    protected String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
