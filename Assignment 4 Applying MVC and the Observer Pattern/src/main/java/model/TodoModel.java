package model;

import java.util.*;

/*
 * Hanchen (Zero) Liu
 * 11/29/2017
 * TodoModel.java
 *
 * This class creates a database for storing todo tasks
 */

/**
 * This class creates a database for storing todo tasks
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 */
public class TodoModel extends Observable
{
    private Collection<Todo> todos;

    /**
     * instantiate a database
     */
    public TodoModel()
    {
        todos = new ArrayList<>();
    }

    /**
     * this method adds one todo task to the database
     *
     * @param todo car part waiting to be added to the database
     */
    public void addTodo(Todo todo)
    {
        todos.add(todo);
    }

    /**
     * this method removes one todo task to the database
     *
     * @param todo car part waiting to be removed from the database
     */
    public void removeTodo(Todo todo)
    {
        todos.remove(todo);
    }

    /**
     * this method updates a specific todo task
     *
     * @param message the message of the todo task that needs to be updated
     * @param newMessage a new message that is waiting to be updated
     */
    public void updateTodo(String message, String newMessage)
    {
        for (Todo todo : todos)
        {
            if (todo.getMessage().equals(message))
            {
                todo.setMessage(newMessage);
            }
        }
    }

    /**
     * this method clears out the entire database
     */
    public void clearTodos()
    {
        todos.clear();
    }

    /**
     * this method retrieves all the todo tasks from the database
     *
     * @return a collection of todo tasks
     */
    public Collection<Todo> getTodos()
    {
        return Collections.unmodifiableCollection(todos);
    }
}