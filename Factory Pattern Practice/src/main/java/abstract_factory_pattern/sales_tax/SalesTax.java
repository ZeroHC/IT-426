package abstract_factory_pattern.sales_tax;

import java.util.HashMap;
import java.util.Map;

public abstract class SalesTax implements ISalesTax
{
    protected Map<Object, Double> regionToRates = new HashMap<>();
    private Object regionId;

    public SalesTax(Object regionId)
    {
        this.regionId = regionId;

        //load map
    }

    public abstract void loadRates();

    @Override
    public double tax(double total)
    {
        return regionToRates.get(regionId) * total;
    }
}
