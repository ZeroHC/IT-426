package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class FlowPanePractice extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setScene(getScene());
        stage.setTitle("Flow Pane Practice");
        stage.show();
    }

    private Scene getScene()
    {
        //create a flow pane and set spacing
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10));
        pane.setAlignment(Pos.CENTER_LEFT);
        pane.setVgap(10);
        pane.setHgap(10);

        //add a few random elements
        Random random = new Random();
        for (int i = 0; i < 42; i++)
        {
            Rectangle rect = new Rectangle();
            rect.setWidth(random.nextInt(91) + 10);//10-100
            rect.setHeight(random.nextInt(31) + 10);//10-40

            pane.getChildren().add(rect);
        }

        return new Scene(pane, 300, 300);
    }
}
