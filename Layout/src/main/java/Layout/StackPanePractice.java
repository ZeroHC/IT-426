package Layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class StackPanePractice extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setScene(getScene());
        stage.setTitle("Practicing with Stack Pane!");
        stage.show();
    }

    private Scene getScene()
    {
        StackPane pane = new StackPane();

        Circle first = new Circle(70);
        Circle second = new Circle(50);
        Circle third = new Circle(60);

        first.setFill(Color.BLANCHEDALMOND);
        second.setFill(Color.CORNSILK);
        third.setFill(Color.ALICEBLUE);

        pane.getChildren().addAll(first, second, third);

        //move stacked elements using a Pos value
        StackPane.setAlignment(first, Pos.TOP_LEFT);
        StackPane.setAlignment(second, Pos.CENTER);
        StackPane.setAlignment(third, Pos.BOTTOM_RIGHT);

        Button button = new Button("Click me!");
        button.setPrefWidth(100);
        button.setPrefHeight(40);
        pane.getChildren().add(button);
        StackPane.setAlignment(button, Pos.CENTER);

        button = new Button("Click me!");
        pane.getChildren().add(button);
        StackPane.setAlignment(button, Pos.CENTER);


        return new Scene(pane, 200, 200);
    }
}
