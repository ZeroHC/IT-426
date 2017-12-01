package abstract_factory_pattern.shipping;

public class USShippingRate implements IShippingRate
{
    @Override
    public double rate(double weight)
    {
        //less than 1 pound, $1
        if (weight < 1) return 1.0;

        //between 1 and 5 pound, $5
        else if (weight >= 1 && weight <= 5) return 5.0;

        //otherwise, $10
        else return 10.0;
    }
}
