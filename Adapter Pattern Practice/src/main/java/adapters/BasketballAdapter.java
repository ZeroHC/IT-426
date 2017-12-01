package adapters;

import athletes.BasketBallAthlete;
import athletes.BasketBallAthlete.Stat;
import sports_news.IAthlete;

import java.util.HashMap;
import java.util.Map;

public class BasketballAdapter implements IAthlete
{
    private BasketBallAthlete athlete;

    public BasketballAdapter(BasketBallAthlete athlete)
    {
        this.athlete = athlete;
    }

    @Override
    public String getFullName()
    {
        return athlete.getFname() + " " + athlete.getLname();
    }

    @Override
    public Map<String, Object> getStats()
    {
        Map<String, Object> result = new HashMap<>();

        for (Stat stat : athlete.getStats())
        {
            result.put(stat.getType(), stat.getType());
        }

        return result;
    }
}