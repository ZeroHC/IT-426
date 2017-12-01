package personality;

public class ScoobyDoo extends AbstractPerson
{
    public ScoobyDoo(String name)
    {
        super(name);
    }

    @Override
    public IPersonality getPersonality()
    {
        return new IPersonality()
        {
            @Override
            public void say(String message)
            {
                System.out.print("Ruh, Roh, " + message);
            }

            @Override
            public void endSentence()
            {
                System.out.println("!!!");
            }
        };
    }
}
