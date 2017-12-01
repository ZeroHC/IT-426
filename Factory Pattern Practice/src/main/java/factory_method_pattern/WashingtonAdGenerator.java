package factory_method_pattern;

import java.util.Arrays;
import java.util.List;

public class WashingtonAdGenerator implements IRegionalAdGenerator
{
    @Override
    public List<Advertisement> getAppropriateAds()
    {
        return Arrays.asList(new Advertisement("Umbrellas? What?!?!"),
                new Advertisement("Come visit the Space Needle"),
                new Advertisement("Starbucks for you"));
    }
}
