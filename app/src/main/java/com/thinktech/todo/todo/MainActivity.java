package com.thinktech.todo.todo;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.thinktech.todo.todo.utils.CollectionView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> todoList;

    public MainActivity() {

        this.todoList = new ArrayList<String>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCreateButton();
    }

    private void initCreateButton() {
        final Button createAnItemButton = (Button) findViewById(R.id.CreateAnItem);
        createAnItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder todoDialog = new AlertDialog.Builder(MainActivity.this);
                final View todoCreateDialog = getLayoutInflater().inflate(R.layout.dialog_create_todo, null);
                final EditText todoSubject = (EditText) todoCreateDialog.findViewById(R.id.todo_subject);
                Button createTodoButton = (Button) todoCreateDialog.findViewById(R.id.todo_create_button);

                todoDialog.setView(todoCreateDialog);
                final AlertDialog dialog = todoDialog.create();
                dialog.show();

                createTodoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String todoSubjectText = todoSubject.getText().toString();
                        if (!todoSubjectText.isEmpty()) {
                            todoList.add(todoSubjectText);
                            generateToDoListItems();
                            dialog.cancel();
                            Toast.makeText(MainActivity.this, R.string.todo_added_success_message, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, R.string.empty_todo_form_error_message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void generateToDoListItems() {
        CollectionView collectionView = new CollectionView();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.todo_item_list, R.id.item, collectionView.reverse(todoList));

        ListView toDoListView = (ListView) findViewById(R.id.ToDoItems);
        toDoListView.setAdapter(adapter);
    }
}
