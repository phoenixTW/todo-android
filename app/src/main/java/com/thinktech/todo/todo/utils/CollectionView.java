package com.thinktech.todo.todo.utils;

import java.util.ArrayList;
import java.util.List;

public class CollectionView {

    public List<String> reverse(List<String> todoList) {
        List<String> reversedToDoList = new ArrayList<>(todoList.size());
        for (int counter = 1; counter <= todoList.size(); counter++) {
            reversedToDoList.add(todoList.get(todoList.size() - counter));
        }

        return reversedToDoList;
    }
}
