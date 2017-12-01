package abstract_factory_pattern.factories;

import abstract_factory_pattern.sales_tax.ISalesTax;
import abstract_factory_pattern.shipping.IShippingRate;

//this interface provides access to a family of factory classes
public interface IOrderFactory
{
    public ISalesTax salesTaxCalculator();
    public IShippingRate shippingRateCalculator();
}
