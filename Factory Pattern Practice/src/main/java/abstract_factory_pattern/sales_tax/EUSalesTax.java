package abstract_factory_pattern.sales_tax;

public class EUSalesTax extends SalesTax
{
    private String region;

    public EUSalesTax(String region)
    {
        super(region);
    }

    @Override
    public void loadRates()
    {
        //load map - lazily
        if (regionToRates.isEmpty())
        {
            regionToRates.put("Germany", 0.9);
            regionToRates.put("Spain", 0.85);
            //...
        }
    }
}