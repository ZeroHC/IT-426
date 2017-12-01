package adapters;

import athletes.SoccerAthlete;
import sports_news.IAthlete;

import java.util.Map;

//adapter
public class SoccerAdapter implements IAthlete
{
    //adaptee
    private SoccerAthlete athlete;

    public SoccerAdapter(SoccerAthlete athlete)
    {
        this.athlete = athlete;
    }

    @Override
    public String getFullName()
    {
        return athlete.getFullName();
    }

    @Override
    public Map<String, Object> getStats()
    {
        return athlete.getStats();
    }
}
