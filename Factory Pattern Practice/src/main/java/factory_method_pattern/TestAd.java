package factory_method_pattern;

public class TestAd
{
    public static void main(String[] args)
    {
        HawaiiAds generator = new HawaiiAds();
        Advertisement ad = generator.getAd();

        System.out.println(ad.getMessage());
    }
}
