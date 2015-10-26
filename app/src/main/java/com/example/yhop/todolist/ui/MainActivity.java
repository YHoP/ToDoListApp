package com.example.yhop.todolist.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.yhop.todolist.R;
import com.example.yhop.todolist.models.Category;
import com.example.yhop.todolist.models.Task;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private ArrayList<String> mCategories;
    private Button mNewCategoryButton;
    private EditText mNewCategoryText;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Task newTask = new Task();
        newTask.save();
        // newTask.delete();

        mNewCategoryButton = (Button) findViewById(R.id.categorySubmitButton);
        mNewCategoryText = (EditText) findViewById(R.id.newCategoryText);

        mCategories = new ArrayList<String>();
        for (Category category : Category.all() ) {
            mCategories.add(category.getName());
        }

        // mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mCategories);
        mAdapter = new ArrayAdapter<String>(this, R.layout.fragment_item_list, mCategories);
        setListAdapter(mAdapter);

        mNewCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCategory();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String thisCategoryName = mCategories.get(position);
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("categoryName", thisCategoryName);
        startActivity(intent);
    }

    private void addCategory() {
        String name =  mNewCategoryText.getText().toString();
        Category newCategory = new Category(name);
        newCategory.save();
        mCategories.add(name);
        mAdapter.notifyDataSetChanged();
    }

}
