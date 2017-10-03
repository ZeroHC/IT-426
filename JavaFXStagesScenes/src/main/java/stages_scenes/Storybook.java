package stages_scenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Storybook extends Application
{
    private Stage stage;

    @Override
    public void start(Stage stage)
    {
        //save the stage for later
        this.stage = stage;

        //show the waiting screen
        stage.setScene(getWaitingScene());
        stage.show();

        //wait for 3 seconds, then show the first story screen
        KeyFrame frame = new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                stage.setScene(getIntermediateScene(
                        new String[] {"Once upon a time.",
                                "A giant bear-dog rambled by...",
                                "The bear met a seal and said \"hi\"...",
                                "Then he ate the seal..."}, 0));
            }
        });

        Timeline animation = new Timeline(frame);
        animation.play();
    }

    private Scene getWaitingScene()
    {
        VBox box = new VBox();

        //center our layout and add some padding
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));

        ProgressIndicator progress = new ProgressIndicator();
        Text text = new Text("Listen to my story!");

        box.getChildren().addAll(progress, text);

        return new Scene(box, 300, 300);
    }

    private Scene getIntermediateScene(String[] messages, int postion)
    {
        VBox box = new VBox();

        //center our layout and add some padding
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));

        Text text = new Text(messages[postion]);
        Button button = new Button("Next");

        //do something when the user clicks a button
        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (postion + 1 >= messages.length)
                {
                    stage.setScene(getFinalScene());
                }
                else
                {
                    stage.setScene(getIntermediateScene(messages, postion + 1));
                }
            }
        });

        box.getChildren().addAll(text, button);

        return new Scene(box, 300, 300);
    }

    /*private Scene getScene1()
    {
        VBox box = new VBox();

        //center our layout and add some padding
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));

        Text text = new Text("Once upon a time");
        Button button = new Button("Next");

        //do something when the user clicks a button
        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                stage.setScene(getScene2());
            }
        });

        box.getChildren().addAll(text, button);

        return new Scene(box, 300, 300);
    }

    private Scene getScene2()
    {
        VBox box = new VBox();

        //center our layout and add some padding
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));

        Text text = new Text("A giant bear-dog rambled down the road...");
        Button button = new Button("Next");

        //do something when the user clicks a button
        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                stage.setScene(getScene3());
            }
        });

        box.getChildren().addAll(text, button);

        return new Scene(box, 300, 300);
    }*/

    private Scene getFinalScene()
    {
        VBox box = new VBox();

        //center our layout and add some padding
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));

        Text text = new Text("The End!");
        box.getChildren().addAll(text);

        return new Scene(box, 300, 300);
    }
}
