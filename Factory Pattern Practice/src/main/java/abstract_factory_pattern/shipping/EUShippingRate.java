package abstract_factory_pattern.shipping;

public class EUShippingRate implements IShippingRate
{
    @Override
    public double rate(double weight)
    {
        //0.5 euros per kg
        return 0.5 * weight;
    }
}
