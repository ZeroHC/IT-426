package Layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BorderPanePractice extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setScene(getScene());
        stage.setTitle("Border Pane Practice");
        stage.show();
    }

    private Scene getScene()
    {
        BorderPane parentPanel = new BorderPane();

        //buttons to the top
        HBox topPanel = new HBox();//nested panel
        topPanel.setAlignment(Pos.CENTER);
        parentPanel.setTop(topPanel);

        topPanel.getChildren().addAll(
                new Button("Click"), new Button("Me"), new Button("Now!"));

        //texts on the left
        VBox leftPanel = new VBox();
        parentPanel.setLeft(leftPanel);

        String[] sayings = {"If I don't push the limits!!!",
                "Lasagna, lasagna, lasagna...",
                "Don't let your dreams be dreams",
                "Some people dream of greatness, others wor hard for it!"};

        for (int i = 0; i < sayings.length; i++)
        {
            leftPanel.getChildren().addAll(getTextControl(sayings[i]));
        }

        //list on the right

        //image in the middle

        //paragraph on the bottom

        return new Scene(parentPanel, 400, 400);
    }

    private Text getTextControl(String message)
    {
        Text control = new Text(message);
        control.setWrappingWidth(120);
        return control;
    }
}
