package com.example.gging.hw42;

public class WINorLOSE {

    public String getWINorLOSE(String Com, String Play) {

        if (Com.equals(Play)) return "判定輸贏：雙方平手";
        if (    (Com.equals("剪刀") && Play.equals("石頭")) ||
                (Com.equals("石頭") && Play.equals("布")) ||
                (Com.equals("布") && Play.equals("剪刀")))
            return "判定輸贏：恭喜，你贏了！";
        return "判定輸贏：很可惜，你輸了！";
    }
}