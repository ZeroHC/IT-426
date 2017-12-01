package personality;

public class ValleyGirl extends AbstractPerson
{
    public ValleyGirl(String name)
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
                System.out.print("Like, totally " + message);
            }

            @Override
            public void endSentence()
            {
                System.out.println("...");
            }
        };
    }
}