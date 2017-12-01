package adapters;

import athletes.BaseballAthlete;
import sports_news.IAthlete;

import java.util.HashMap;
import java.util.Map;

public class BaseballAdapter implements IAthlete
{
    private BaseballAthlete athlete;

    public BaseballAdapter(BaseballAthlete athlete)
    {
        this.athlete = athlete;
    }

    @Override
    public String getFullName()
    {
        return athlete.getFname() + " " + athlete.getMiddle() + " " + athlete.getLname();
    }

    @Override
    public Map<String, Object> getStats()
    {
        Map<String, Object> results = new HashMap<>();

        //loop over my list and convert the stats
        for (String stat : athlete.getStats())
        {
            String[] parts = stat.split(" - ");
            results.put(parts[0], parts[1]);
        }

        return results;
    }
}
