package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Triangle;

public class TriangleAdapter implements IShape
{
    private static final int N_POINTS = 3;

    private Triangle triangle;

    public TriangleAdapter(Triangle triangle)
    {
        this.triangle = triangle;
    }

    @Override
    public IShape setThickness(double value)
    {
        return (IShape) new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(), triangle.getHeight(),
                value, triangle.getColor(), triangle.isFill());
    }

    @Override
    public IShape setColor(Color value)
    {
        return (IShape) new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(), triangle.getHeight(),
                triangle.getThickness(), value, triangle.isFill());
    }

    @Override
    public IShape setFilled(boolean value)
    {
        return (IShape) new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(), triangle.getHeight(),
                triangle.getThickness(), triangle.getColor(), value);
    }

    @Override
    public double getX()
    {
        return triangle.getX();
    }

    @Override
    public double getY()
    {
        return triangle.getY();
    }

    @Override
    public double getThickness()
    {
        return triangle.getThickness();
    }

    @Override
    public Color getColor()
    {
        return triangle.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return triangle.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setLineWidth(getThickness());
        graphics.setStroke(getColor());
        if (getFilled())
        {
            graphics.setFill(getColor());
            graphics.fillPolygon(new double[]{getX(), getX() - triangle.getWidth(), getX() + triangle.getWidth()},
                    new double[]{getY(), getY() + triangle.getHeight(), getY() + triangle.getHeight()}, N_POINTS);
        }
        else graphics.strokePolygon(new double[]{getX(), getX() - triangle.getWidth(), getX() + triangle.getWidth()},
                new double[]{getY(), getY() + triangle.getHeight(), getY() + triangle.getHeight()}, N_POINTS);
    }
}