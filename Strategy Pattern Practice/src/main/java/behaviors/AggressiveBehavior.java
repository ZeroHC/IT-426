package behaviors;

public class AggressiveBehavior implements IBehavior
{
    @Override
    public void takeAction()
    {
        System.out.println("You act aggressive!");
    }
}
