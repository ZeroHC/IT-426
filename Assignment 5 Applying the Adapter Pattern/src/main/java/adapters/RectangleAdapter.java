package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Rectangle;

public class RectangleAdapter implements IShape
{
    private Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle)
    {
        this.rectangle = rectangle;
    }

    @Override
    public IShape setThickness(double value)
    {
        return (IShape) new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),
                rectangle.getHeight(), value, rectangle.getColor(), rectangle.isFill());
    }

    @Override
    public IShape setColor(Color value)
    {
        return (IShape) new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),
                rectangle.getHeight(), rectangle.getThickness(), value, rectangle.isFill());
    }

    @Override
    public IShape setFilled(boolean value)
    {
        return (IShape) new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),
                rectangle.getHeight(), rectangle.getThickness(), rectangle.getColor(), value);
    }

    @Override
    public double getX()
    {
        return rectangle.getX();
    }

    @Override
    public double getY()
    {
        return rectangle.getY();
    }

    @Override
    public double getThickness()
    {
        return rectangle.getThickness();
    }

    @Override
    public Color getColor()
    {
        return rectangle.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return rectangle.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setLineWidth(getThickness());
        graphics.setStroke(getColor());
        if (getFilled())
        {
            graphics.setFill(getColor());
            graphics.fillRect(getX(), getY(), rectangle.getWidth(), rectangle.getHeight());
        }
        else graphics.strokeRect(getX(), getY(), rectangle.getWidth(), rectangle.getHeight());
    }
}