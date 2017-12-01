package personality;

public abstract class AbstractPerson
{
    private String name;

    public AbstractPerson(String name)
    {
        this.name = name;
    }

    //force my child class to provide a personality
    //so this class can speak
    public abstract IPersonality getPersonality();

    public void speak()
    {
        //retrieved from child class
        IPersonality thisPersonality = getPersonality();

        thisPersonality.say("Hi my name is " + name);
        thisPersonality.endSentence();

        thisPersonality.say("Welcome to my program");
        thisPersonality.endSentence();
    }
}