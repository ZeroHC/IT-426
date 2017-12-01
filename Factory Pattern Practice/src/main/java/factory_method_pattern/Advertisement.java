package factory_method_pattern;

public class Advertisement
{
    private String message;

    public Advertisement(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    @Override
    public String toString()
    {
        return "Advertisement{" + "message='" + message + '\'' + '}';
    }
}
