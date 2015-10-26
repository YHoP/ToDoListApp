package com.example.yhop.todolist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.yhop.todolist.R;

import java.util.ArrayList;

/**
 * Created by YHoP on 10/26/15.
 */
public class ListViewAdapter extends ArrayAdapter <String> {
    int mResource;
    String[] item_list;
    ArrayList<String> desc;
    Context mContext;

    public ListViewAdapter(Context context, int resource, int textViewResourceId, String[] item_list) {
        super(context, resource, textViewResourceId, item_list);
        this.mContext = context;
        mResource = resource;
        this.item_list = item_list;

    }

    static class ViewHolder {
        public TextView textview;
        public Button button;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        // Inflate the list_item.xml file if convertView is null
        if(rowView==null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView= inflater.inflate(mResource, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textview= (TextView) rowView.findViewById(R.id.listTextView);
            viewHolder.button= (Button) rowView.findViewById(R.id.deleteButton);
            rowView.setTag(viewHolder);

        }
        // Set text to each TextView of ListView item
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.textview.setText(item_list[position]);
        holder.button.setText(item_list[position]);
        return rowView;
    }

}
