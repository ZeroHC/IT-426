package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Line;

public class LineAdapter implements IShape
{
    private Line line;

    public LineAdapter(Line line)
    {
        this.line = line;
    }

    @Override
    public IShape setThickness(double value)
    {
        return (IShape) new Line(line.getX(), line.getY(), line.getX2(), line.getY2(),
                value, line.getColor(), line.isFill());
    }

    @Override
    public IShape setColor(Color value)
    {
        return (IShape) new Line(line.getX(), line.getY(), line.getX2(), line.getY2(),
                line.getThickness(), value, line.isFill());
    }

    @Override
    public IShape setFilled(boolean value)
    {
        return (IShape) new Line(line.getX(), line.getY(), line.getX2(), line.getY2(),
                line.getThickness(), line.getColor(), value);
    }

    @Override
    public double getX()
    {
        return line.getX();
    }

    @Override
    public double getY()
    {
        return line.getY();
    }

    @Override
    public double getThickness()
    {
        return line.getThickness();
    }

    @Override
    public Color getColor()
    {
        return line.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return line.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setLineWidth(getThickness());
        graphics.setStroke(getColor());
        graphics.strokeLine(line.getX(), line.getY(), line.getX2(), line.getY2());
    }
}