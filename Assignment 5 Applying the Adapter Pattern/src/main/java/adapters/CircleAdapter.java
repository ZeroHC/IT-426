package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;

public class CircleAdapter implements IShape
{
    private Circle circle;

    public CircleAdapter(Circle circle)
    {
        this.circle = circle;
    }

    @Override
    public IShape setThickness(double value)
    {
        return new CircleAdapter(new Circle(circle.getRadius(), circle.getX(), circle.getY(), value, circle.getColor(),
                circle.isFill()));
    }

    @Override
    public IShape setColor(Color value)
    {
        return new CircleAdapter(new Circle(circle.getRadius(), circle.getX(), circle.getY(), circle.getThickness(), value,
                circle.isFill()));
    }

    @Override
    public IShape setFilled(boolean value)
    {
        return new CircleAdapter(new Circle(circle.getRadius(), circle.getX(), circle.getY(), circle.getThickness(),
                circle.getColor(), value));
    }

    @Override
    public double getX()
    {
        return circle.getX();
    }

    @Override
    public double getY()
    {
        return circle.getY();
    }

    @Override
    public double getThickness()
    {
        return circle.getThickness();
    }

    @Override
    public Color getColor()
    {
        return circle.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return circle.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setLineWidth(getThickness());
        graphics.setStroke(getColor());
        if (getFilled())
        {
            graphics.setFill(getColor());
            graphics.fillOval(getX(), getY(), circle.getRadius(), circle.getRadius());
        }
        else graphics.strokeOval(getX(), getY(), circle.getRadius(), circle.getRadius());
    }
}
