package abstract_factory_pattern.sales_tax;

public class USSalesTax extends SalesTax
{
    private int zipcodes;

    public USSalesTax(int zipcodes)
    {
        super(zipcodes);
    }

    @Override
    public void loadRates()
    {
        //load map - lazily
        if (regionToRates.isEmpty())
        {
            regionToRates.put(98374, 0.9);
            regionToRates.put(98388, 0.85);
            //...
        }
    }
}