package com.example.yhop.todolist.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import com.example.yhop.todolist.R;
import com.example.yhop.todolist.models.Category;

import java.util.ArrayList;

/**
 * Created by YHoP on 10/26/15.
 */
class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> mCategories;

    public MyAdapter(Context context, ArrayList<String> categories) {
        this.context = context;
        this.mCategories = categories;
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return mCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TwoLineListItem twoLineListItem;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            twoLineListItem = (TwoLineListItem) inflater.inflate(
                    android.R.layout.simple_list_item_2, null);
        } else {
            twoLineListItem = (TwoLineListItem) convertView;
        }

        TextView text1 = twoLineListItem.getText1();
        TextView text2 = twoLineListItem.getText2();

        Category newCategory = Category.find(mCategories.get(position));
        text1.setText(newCategory.getName());
        text2.setText("" + newCategory.getFormattedTime(context));

        return twoLineListItem;
    }
}
