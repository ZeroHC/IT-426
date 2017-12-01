package factory_method_pattern;

public class WashingtonAds extends AdGenerator
{
    @Override
    protected IRegionalAdGenerator getRegionalGenerator()
    {
        return new WashingtonAdGenerator();
    }
}
