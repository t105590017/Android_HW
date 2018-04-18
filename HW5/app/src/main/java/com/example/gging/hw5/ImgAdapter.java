package com.example.gging.hw5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImgAdapter extends BaseAdapter{

    private Context mContext;
    private Integer[] mImgArr;

    public ImgAdapter(Context context, Integer[] imgArr){
        mContext = context;
        mImgArr = imgArr;
    }

    @Override
    public int getCount() {
        return mImgArr.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView v;

        if (convertView == null) {
            v = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            v.setLayoutParams(new GridLayout.LayoutParams(params));
            v.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            v.setPadding(10,10,10,10);
        }
        else
            v = (ImageView) convertView;

        v.setImageResource(mImgArr[position]);

        return v;
    }
}
