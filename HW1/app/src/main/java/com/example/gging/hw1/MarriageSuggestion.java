package com.example.gging.hw1;

import android.content.res.Resources;

/**
 * Created by gging on 2018/3/26.
 */

public class MarriageSuggestion {

    public String getSuggestion(String strSex,int AgeR,int numFamily) {

        String strSug ="建議：";

        if (strSex.equals("male")) {
            switch (AgeR) {
                case 1:
                    if (numFamily > 10)
                        strSug += "還不急";
                    else
                        strSug += "趕快結婚";
                    break;
                case 2:
                    if (numFamily < 4)
                        strSug += "趕快結婚";
                    else if (numFamily >= 4 && numFamily <= 10)
                        strSug += "開始找對象";
                    else
                        strSug += "還不急";
                    break;
                case 3:
                    if (numFamily >= 4 && numFamily <= 10)
                        strSug += "趕快結婚";
                    else
                        strSug += "開始找對象";
                    break;
            }
        } else {
            switch (AgeR) {
                case 1:
                    if (numFamily > 10)
                        strSug += "還不急";
                    else
                        strSug += "趕快結婚";
                    break;
                case 2:
                    if (numFamily < 4)
                        strSug += "趕快結婚";
                    else if (numFamily >= 4 && numFamily <= 10)
                        strSug += "開始找對象";
                    else
                        strSug += "還不急";
                    break;
                case 3:
                    if (numFamily >= 4 && numFamily <= 10)
                        strSug += "趕快結婚";
                    else
                        strSug += "開始找對象";
                    break;
            }
        }
        return strSug;
    }
}
