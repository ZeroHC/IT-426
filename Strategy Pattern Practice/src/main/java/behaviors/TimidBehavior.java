package behaviors;

public class TimidBehavior implements IBehavior
{
    @Override
    public void takeAction()
    {
        System.out.println("You act timid! Yikes!");
    }
}
