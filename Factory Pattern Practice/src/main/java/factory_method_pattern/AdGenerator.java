package factory_method_pattern;

import java.util.List;
import java.util.Random;

public abstract class AdGenerator
{
    private List<Advertisement> ads;

    public AdGenerator()
    {
        //do nothing...
    }

    protected abstract IRegionalAdGenerator getRegionalGenerator();

    public Advertisement getAd()
    {
        //lazy initialization pattern...
        if (ads.isEmpty())
        {
            //asking the child class for the ad generator
            ads = getRegionalGenerator().getAppropriateAds();
        }

        return ads.get(new Random().nextInt(ads.size()));
    }
}
