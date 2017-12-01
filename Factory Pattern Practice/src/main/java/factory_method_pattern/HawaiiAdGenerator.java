package factory_method_pattern;

import java.util.Arrays;
import java.util.List;

public class HawaiiAdGenerator implements IRegionalAdGenerator
{
    @Override
    public List<Advertisement> getAppropriateAds()
    {
        return Arrays.asList(new Advertisement("Aloha!"),
                new Advertisement("Mcdonald's is better here!"),
                new Advertisement("Blue ocean and bright beach"));
    }
}