package ui;

import adapters.CircleAdapter;
import adapters.LineAdapter;
import adapters.RectangleAdapter;
import adapters.TriangleAdapter;
import drawing.SavedShapes;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import shapes.Circle;
import shapes.Line;
import shapes.Rectangle;
import shapes.Triangle;

import java.util.Random;

public class CanvasUI extends Application
{

    private static final Random RANDOM = new Random();

    private static final int WIDTH = 820;
    private static final int HEIGHT = 680;
    private static final int CANVAS_WIDTH = 820;
    private static final int CANVAS_HEIGHT = 600;
    private static final int MIN_THICKNESS_VALUE = 1;
    private static final int MAX_THICKNESS_VALUE = 10;
    private static final int CIRCLE_RADIUS = 20;
    private static final int RECTANGLE_WIDTH = 80;
    private static final int RECTANGLE_HEIGHT = 60;
    private static final int TRIANGLE_WIDTH = 30;
    private static final int TRIANGLE_LENGTH = 50;

    private double xPosition;
    private double yPosition;

    private Circle circle;
    private Rectangle rectangle;
    private Triangle triangle;
    private Line line;

    private CircleAdapter circleAdapter;
    private RectangleAdapter rectangleAdapter;
    private TriangleAdapter triangleAdapter;
    private LineAdapter lineAdapter;

    private SavedShapes savedShapes;

    private Color color;
    private boolean fillFlag;
    private double thicknessValue;

    private static final ToggleGroup SHAPE_SELECTORS = new ToggleGroup();

    public void start(Stage stage)
    {
        shapeInitializer();

        stage.setTitle("Doodle Pad");

        stage.setScene(mainScene());

        stage.show();
    }

    private Scene mainScene()
    {
        VBox mainContainer = new VBox();

        HBox functionsContainer = new HBox();
        functionsContainer.setId("functionsContainer");

        ToggleButton circleButton = new ToggleButton();
        circleButton.setUserData(circleAdapter);
        circleButton.setToggleGroup(SHAPE_SELECTORS);
        circleButton.setId("circleButton");

        ToggleButton rectangleButton = new ToggleButton();
        rectangleButton.setUserData(rectangleAdapter);
        rectangleButton.setToggleGroup(SHAPE_SELECTORS);
        rectangleButton.setId("rectangleButton");

        ToggleButton triangleButton = new ToggleButton();
        triangleButton.setUserData(triangleAdapter);
        triangleButton.setToggleGroup(SHAPE_SELECTORS);
        triangleButton.setId("triangleButton");

        ToggleButton lineButton = new ToggleButton();
        lineButton.setUserData(lineAdapter);
        lineButton.setToggleGroup(SHAPE_SELECTORS);
        lineButton.setId("lineButton");

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setId("colorPicker");


        CheckBox fillCheck = new CheckBox("Fill");
        fillCheck.setId("fillCheck");
        fillCheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                    Boolean newValue)
            {
                fillFlag = fillCheck.isSelected();
                shapeUpdater();
            }
        });

        Slider thicknessSlider = new Slider();
        thicknessSlider.setMin(MIN_THICKNESS_VALUE);
        thicknessSlider.setMax(MAX_THICKNESS_VALUE);
        thicknessSlider.setValue(MIN_THICKNESS_VALUE);
        thicknessSlider.setShowTickLabels(true);

        Text thickness = new Text("Thickness");
        TextField thicknessInputField = new TextField(Double.toString(thicknessSlider.getValue()));

        thicknessInputField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                thicknessValue = Double.parseDouble(thicknessInputField.getText());
                thicknessSlider.setValue(thicknessValue);

                shapeUpdater();
            }
        });

        thicknessSlider.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event)
            {
                thicknessValue = thicknessSlider.getValue();
                thicknessInputField.setText(Double.toString(thicknessValue));

                shapeUpdater();
            }
        });

        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                color = colorPicker.getValue();

                shapeUpdater();
            }
        });

        functionsContainer.getChildren().addAll(circleButton, rectangleButton, triangleButton, lineButton,
                colorPicker, fillCheck, thickness, thicknessInputField, thicknessSlider);

        VBox canvasContainer = new VBox();
        canvasContainer.setId("canvasContainer");

        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event)
            {
                //mouse position
                xPosition = event.getX();
                yPosition = event.getY();

                GraphicsContext graphics = canvas.getGraphicsContext2D();

                shapePrinter(graphics);
            }
        });

        canvasContainer.getChildren().add(canvas);

        mainContainer.getChildren().addAll(functionsContainer, canvasContainer);

        Scene mainScene = new Scene(mainContainer, WIDTH, HEIGHT);

        mainScene.getStylesheets().add("styles/MyStyles.css");

        return mainScene;
    }
    private void shapeUpdater()
    {
        if (SHAPE_SELECTORS.getSelectedToggle().getUserData() == circleAdapter)
        {
            savedShapes.update(circleAdapter, thicknessValue,
                    color, fillFlag);
        }
        else if (SHAPE_SELECTORS.getSelectedToggle().getUserData() == rectangleAdapter)
        {
            savedShapes.update(rectangleAdapter,  thicknessValue,
                    color, fillFlag);
        }
        else if (SHAPE_SELECTORS.getSelectedToggle().getUserData() == triangleAdapter)
        {
            savedShapes.update(triangleAdapter,  thicknessValue,
                    color, fillFlag);
        }
        else if (SHAPE_SELECTORS.getSelectedToggle().getUserData() == lineAdapter)
        {
            savedShapes.update(lineAdapter,  thicknessValue,
                    color, fillFlag);
        }
    }

    private void shapePrinter(GraphicsContext graphics)
    {
        if (SHAPE_SELECTORS.getSelectedToggle().getUserData() == circleAdapter)
        {
            circleAdapter.drawShape(graphics);
        }
        else if (SHAPE_SELECTORS.getSelectedToggle().getUserData() == rectangleAdapter)
        {
            rectangleAdapter.drawShape(graphics);
        }
        else if (SHAPE_SELECTORS.getSelectedToggle().getUserData() == triangleAdapter)
        {
            triangleAdapter.drawShape(graphics);
        }
        else if (SHAPE_SELECTORS.getSelectedToggle().getUserData() == lineAdapter)
        {
            lineAdapter.drawShape(graphics);
        }
    }

    private void shapeInitializer()
    {
        circleAdapter = new CircleAdapter(new Circle(CIRCLE_RADIUS, xPosition, yPosition, thicknessValue,
                color, fillFlag));
        rectangleAdapter = new RectangleAdapter(new Rectangle(xPosition, yPosition, RECTANGLE_WIDTH, RECTANGLE_HEIGHT,
                thicknessValue, color, fillFlag));
        triangleAdapter = new TriangleAdapter(new Triangle(xPosition, yPosition, TRIANGLE_WIDTH, TRIANGLE_LENGTH,
                thicknessValue, color, fillFlag));
        lineAdapter = new LineAdapter(new Line(xPosition, yPosition, xPosition + RANDOM.nextInt(100) - 50, yPosition + RANDOM.nextInt(100) - 50,
                thicknessValue, color, fillFlag));

        savedShapes = new SavedShapes();

        savedShapes.add(circleAdapter);
        savedShapes.add(rectangleAdapter);
        savedShapes.add(triangleAdapter);
        savedShapes.add(lineAdapter);
    }
}