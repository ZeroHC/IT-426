package model;

import java.util.UUID;

public class Todo
{
    private UUID id;
    private String message;

    public Todo(String message)
    {
        id = UUID.randomUUID();
        this.message = message;
    }

    public UUID getId()
    {
        return id;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}