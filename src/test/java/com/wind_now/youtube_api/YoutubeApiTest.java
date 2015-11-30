package com.wind_now.youtube_api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.wind_now.youtube_api.beans.SearchResponse;
import com.wind_now.youtube_api.beans.SearchResponse.Item;
import com.wind_now.youtube_api.util.OnoLogger;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ono
 */
public class YoutubeApiTest {

    static final Logger logger = OnoLogger.getLogger();

    public YoutubeApiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void search() throws Exception {
        logger.info("search");
        String term = "吹奏楽";
        Search search = new Search();
        SearchResponse res = search.search(term);
        String actual = res.getKind();
        String expected = "youtube#searchListResponse";
        assertThat(actual, is(actual));
        logger.info(res.getItems().get(0).getSnippet().getThumbnails().get_default().getUrl());
        List<Item> items = res.getItems();
        items.forEach(item -> logger.info(item.toString()));
    }

}
