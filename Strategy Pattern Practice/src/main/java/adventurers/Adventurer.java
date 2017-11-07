package adventurers;

import behaviors.IBehavior;

public class Adventurer implements IBehavior
{
    private String name;
    private AdventurerType type;

    //store a family behavior
    private IBehavior behavior;

    public Adventurer(String name, AdventurerType type, IBehavior behavior)
    {
        this.name = name;
        this.type = type;
        this.behavior = behavior;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public AdventurerType getType()
    {
        return type;
    }

    public void setType(AdventurerType type)
    {
        this.type = type;
    }

    public IBehavior getBehavior()
    {
        return behavior;
    }

    public void setBehavior(IBehavior behavior)
    {
        this.behavior = behavior;
    }

    @Override
    public void takeAction()
    {
        behavior.takeAction();
    }

    @Override
    public String toString()
    {
        return "Adventurer{" + "name='" + name + '\'' + ", type=" + type + '}';
    }
}
