package com.example.yhop.todolist.models;

import android.content.Context;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.yhop.todolist.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by YHoP on 10/25/15.
 */

@Table(name = "categories", id = "_id")
public class Category extends Model{
    @Column(name = "name")
    public String mName;

    @Column(name = "CreatedAt")
    private long mCreatedAt;

    public Category(){
        super();
    }

    public Category(String name){
        super();
        mName = name;
        mCreatedAt = new Date().getTime();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public long getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(long createdAt) {
        mCreatedAt = createdAt;
    }

    public static List<Category> all(){
        return new Select().from(Category.class).execute();
    }

    public List<Task> tasks(){
        return getMany(Task.class, "Category");
    }

    public static Category find(String name) {
        return new Select()
                .from(Category.class)
                .where("Name = ?", name)
                .executeSingle();
    }

    public String getFormattedTime(Context context) {
        SimpleDateFormat formatter = new SimpleDateFormat(context.getString(R.string.formatted_time));
        formatter.setTimeZone(TimeZone.getTimeZone(context.getString(R.string.timezone)));
        return formatter.format(mCreatedAt);
    }
}
