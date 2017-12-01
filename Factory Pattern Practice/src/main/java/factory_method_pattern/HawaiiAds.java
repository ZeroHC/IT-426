package factory_method_pattern;

public class HawaiiAds extends AdGenerator
{
    @Override
    protected IRegionalAdGenerator getRegionalGenerator()
    {
        return new HawaiiAdGenerator();
    }
}
