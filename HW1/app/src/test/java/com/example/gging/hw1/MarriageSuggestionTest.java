package com.example.gging.hw1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gging on 2018/3/26.
 */

public class MarriageSuggestionTest {
    private MarriageSuggestion mar;

    @Before
    public void setUp(){
       mar = new MarriageSuggestion();
    }

    @After
    public void tearDown(){
        mar = null;
    }

    @Test
    public void getSuggestion() {
        assertEquals("建議：還不急",mar.getSuggestion("male",1,100));
        assertEquals("建議：還不急",mar.getSuggestion("male",2,200));
        assertEquals("建議：還不急",mar.getSuggestion("female",1,300));
        assertEquals("建議：還不急",mar.getSuggestion("female",2,400));
        assertEquals("建議：開始找對象", mar.getSuggestion("male", 2, 7));
        assertEquals("建議：開始找對象", mar.getSuggestion("male", 3, 0));
        assertEquals("建議：開始找對象", mar.getSuggestion("male", 3, 30));
        assertEquals("建議：開始找對象", mar.getSuggestion("female", 2, 8));
        assertEquals("建議：開始找對象", mar.getSuggestion("female", 3, 3));
        assertEquals("建議：開始找對象", mar.getSuggestion("female", 3, 300));
        assertEquals("建議：趕快結婚", mar.getSuggestion("male", 1, 3));
        assertEquals("建議：趕快結婚", mar.getSuggestion("male", 1, 7));
        assertEquals("建議：趕快結婚", mar.getSuggestion("male", 2, 2));
        assertEquals("建議：趕快結婚", mar.getSuggestion("male", 3, 8));
        assertEquals("建議：趕快結婚", mar.getSuggestion("female", 1, 3));
        assertEquals("建議：趕快結婚", mar.getSuggestion("female", 1, 9));
        assertEquals("建議：趕快結婚", mar.getSuggestion("female", 2, 1));
        assertEquals("建議：趕快結婚", mar.getSuggestion("female", 3, 10));
        assertEquals(mar.getSuggestion("male",1,12),"建議：還不急");
        assertEquals(mar.getSuggestion("male",2,5),"建議：開始找對象");
        assertEquals(mar.getSuggestion("male",3,3),"建議：開始找對象");
        assertEquals(mar.getSuggestion("female",1,3),"建議：趕快結婚");
        assertEquals(mar.getSuggestion("female",2,5),"建議：開始找對象");
        assertEquals(mar.getSuggestion("female",3,8),"建議：趕快結婚");
    }
}
