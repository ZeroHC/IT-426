package adapter_pattern;

import adapters.BaseballAdapter;
import adapters.BasketballAdapter;
import adapters.SoccerAdapter;
import athletes.BaseballAthlete;
import athletes.BasketBallAthlete;
import athletes.BasketBallAthlete.Stat;
import athletes.SoccerAthlete;
import sports_news.OnlineNews;

public class TestAthlete
{
    public static void main(String[] args)
    {
        SoccerAthlete mia = new SoccerAthlete("Mia Hamm");
        mia.addStatLine("goal", 4);
        mia.addStatLine("assists", 3);

        BaseballAthlete ken = new BaseballAthlete("George", "Kenneth", "Griffey");
        ken.addStat("home run - 30");
        ken.addStat("batting avg. - .350");

        BasketBallAthlete shawn = new BasketBallAthlete("Shawn", "Kemp");
        shawn.addANewStat(new Stat("avg. rebounds", 3));
        shawn.addANewStat(new Stat("points per game", 21));

        //create a news object and try to use our athletes
        OnlineNews news = new OnlineNews("ESPN", new SoccerAdapter(mia), new BaseballAdapter(ken), new BasketballAdapter(shawn));

        news.printNews();
    }
}
