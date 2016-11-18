package com.luccas.semiseed.customview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lfo on 15/11/2016.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;

    private List<GradeItemView> items = new ArrayList<GradeItemView>();

    public GridViewAdapter(Context context) {
        mContext = context;

        //For testing: Initialize item arraylist
        for(int i = 0; i < 4; i++) {
            GradeItemView gradeItemView = new GradeItemView(context);
            gradeItemView.setCropText("Hello World " + i);
            items.add(gradeItemView);
        }
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        GradeItemView grade;
        grade = items.get(i);
        return grade;
    }

    public void addGradeView(GradeItemView g) {
        items.add(g);
    }
}
