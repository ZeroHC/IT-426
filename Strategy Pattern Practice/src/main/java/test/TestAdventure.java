package test;

import adventurers.Adventurer;
import adventurers.AdventurerType;
import adventurers.GearedAdventurer;
import behaviors.NobleBehavior;
import behaviors.TimidBehavior;
import tools.ArchaeologicalTool;
import tools.TrowelTool;

public class TestAdventure
{
    public static void main(String[] args)
    {
        //squire
        Adventurer squire = new Adventurer("Jeff", AdventurerType.SQUIRE, new TimidBehavior());

        squire.getBehavior().takeAction();

        //we can dynamically alter the behavior of our Adventurer class
        squire = new Adventurer("Lydia", AdventurerType.SQUIRE, new NobleBehavior());

        squire.getBehavior().takeAction();

        GearedAdventurer knight = new GearedAdventurer("Robyn", AdventurerType.KNIGHT, new TimidBehavior(), new TrowelTool());

        knight.takeAction();
        knight.useTool();

        knight = new GearedAdventurer("Brianne", AdventurerType.KNIGHT, new TimidBehavior(), new ArchaeologicalTool());

        knight.takeAction();
        knight.useTool();
    }
}
