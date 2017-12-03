package controller;

import javafx.scene.Scene;
import model.Todo;
import model.TodoModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TodoController
{
    private Scene scene;

    //models
    private TodoModel database = new TodoModel();
    private Todo todo;

    /**
     * This method is used to set the scene.
     *
     * @param scene Provides the value of the scene object that the field needs to be set to.
     */
    public void setView(Scene scene)
    {
        this.scene = scene;
    }

    /**
     * This method is used to update the scene.
     *
     * @return The method returns a scene object.
     */
    public Scene updateView()
    {
        return scene;
    }

    public int getDatabaseSize()
    {
        return database.getTodos().size();
    }

    public TodoModel getDatabase()
    {
        return database;
    }

    public ArrayList<String> getMessages()
    {
        ArrayList<String> messages = new ArrayList<>(getDatabaseSize());
        for (Todo tempTodo : database.getTodos())
        {
            messages.add(tempTodo.getMessage());
        }
        return messages;
    }

    public void removeFromDatabase(String message)
    {
        for (Todo tempTodo : database.getTodos())
        {
            if (tempTodo.getMessage().equals(message))
            {
                database.removeTodo(tempTodo);
            }
        }
    }
}