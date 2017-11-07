package adventurers;

import behaviors.IBehavior;
import tools.ITool;

public class GearedAdventurer extends Adventurer implements ITool
{
    private ITool tool;

    public GearedAdventurer(String name, AdventurerType type, IBehavior behavior, ITool tool)
    {
        super(name, type, behavior);

        this.tool = tool;
    }

    public ITool getTool()
    {
        return tool;
    }

    public void setTool(ITool tool)
    {
        this.tool = tool;
    }

    @Override
    public void useTool()
    {
        tool.useTool();
    }

    @Override
    public String toString()
    {
        return "GearedAdventurer{" + "tool=" + tool + '}';
    }
}
