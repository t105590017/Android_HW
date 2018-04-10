package com.example.gging.hw42;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WINorLOSETest {


    private WINorLOSE WLtest;
    @Before
    public void setUP() { WLtest = new WINorLOSE(); }

    @After
    public void tearDow() { WLtest = null; }

    @Test
    public void getWINorLOSE() {
        assertEquals("判定輸贏：雙方平手",WLtest.getWINorLOSE("剪刀","剪刀"));
        assertEquals("判定輸贏：雙方平手",WLtest.getWINorLOSE("石頭","石頭"));
        assertEquals("判定輸贏：雙方平手",WLtest.getWINorLOSE("布","布"));
        assertEquals("判定輸贏：恭喜，你贏了！",WLtest.getWINorLOSE("剪刀","石頭"));
        assertEquals("判定輸贏：恭喜，你贏了！",WLtest.getWINorLOSE("石頭","布"));
        assertEquals("判定輸贏：恭喜，你贏了！",WLtest.getWINorLOSE("布","剪刀"));
        assertEquals("判定輸贏：很可惜，你輸了！",WLtest.getWINorLOSE("剪刀","布"));
        assertEquals("判定輸贏：很可惜，你輸了！",WLtest.getWINorLOSE("石頭","剪刀"));
        assertEquals("判定輸贏：很可惜，你輸了！",WLtest.getWINorLOSE("布","石頭"));
    }
}