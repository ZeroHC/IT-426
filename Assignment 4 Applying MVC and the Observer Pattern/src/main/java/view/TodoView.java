package view;

import controller.TodoController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class TodoView extends Application implements Observer
{
    //window's size
    private static final int WIDTH = 360;
    private static final int HEIGHT = 480;

    //scene names
    private static final String WELCOME = "Welcome";
    private static final String TASK = "Task";
    private static final String ADD_TASK = "Add Task";

    //A copy of the stage parameter in the start method.
    private Stage mainStage;

    //Scene object to hold current scene.
    private Scene currentScene = welcomeScene();

    //Controller to perform necessary actions.
    private TodoController controller = new TodoController();

    /**
     * Called when the Java FX application is about to launch.
     *
     * @param stage the stage to display screens upon
     */
    public void start(Stage stage)
    {
        mainStage = stage;

        stage.setTitle("Task List");

        try
        {
            stage.setScene(currentScene);
        }
        catch (Exception ex)
        {
            throw new RuntimeException("Something went wrong: " + ex.getMessage());
        }

        stage.show();
    }

    //Provides scene to be set by controller.
    private Scene sceneSelector(String sceneName)
    {

        //Scene to be returned.
        Scene scene = null;

        //Assigns the scene that is to be returned.
        switch (sceneName)
        {
            case WELCOME:
                scene = welcomeScene();
                break;

            case TASK:
                scene = taskScene();
                break;

            case ADD_TASK:
                scene = addTaskScene();
                break;
        }

        return scene;
    }

    private Scene welcomeScene()
    {
        //holds the elements of the scene
        VBox sceneContainer = new VBox();
        sceneContainer.setAlignment(Pos.CENTER);
        sceneContainer.setSpacing(30);

        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setPadding(new Insets(30));

        Text titleText = new Text(WELCOME);
        titleText.setFont(Font.font(40));

        titleContainer.getChildren().add(titleText);

        VBox contentContainer = new VBox();
        contentContainer.setAlignment(Pos.CENTER);
        contentContainer.setSpacing(20);

        Text taskReminder = new Text("You have " + controller.getDatabaseSize() + " unfinished tasks.");
        taskReminder.setFont(Font.font(20));

        Button viewButton = new Button("View");
        viewButton.setMinWidth(60);
        viewButton.setMinHeight(30);
        viewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                //Sets controller to hold the new scene.
                controller.setView(currentScene = sceneSelector(TASK));

                //Updates the current scene with the current set scene.
                mainStage.setScene(controller.updateView());
            }
        });

        contentContainer.getChildren().addAll(taskReminder, viewButton);

        sceneContainer.getChildren().addAll(titleContainer, contentContainer);

        return new Scene(sceneContainer, WIDTH, HEIGHT);
    }

    private Scene taskScene()
    {
        //holds the elements of the scene
        VBox sceneContainer = new VBox();
        sceneContainer.setAlignment(Pos.CENTER);
        sceneContainer.setSpacing(20);

        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setPadding(new Insets(20));

        Text titleText = new Text(TASK);
        titleText.setFont(Font.font(30));

        Button addButton = new Button("+");
        addButton.setMinWidth(60);
        addButton.setMinHeight(30);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                //Sets controller to hold the new scene.
                controller.setView(currentScene = sceneSelector(ADD_TASK));

                //Updates the current scene with the current set scene.
                mainStage.setScene(controller.updateView());
            }
        });

        titleContainer.getChildren().addAll(titleText, addButton);

        VBox contentContainer = new VBox();
        contentContainer.setAlignment(Pos.CENTER);
        contentContainer.setSpacing(20);

        if (controller.getDatabase() == null || controller.getDatabaseSize() == 0)
        {
            Text emptyTaskReminder = new Text("There are no tasks currently. Add a task by clicking the + button " +
                                              "above");
            emptyTaskReminder.setFont(Font.font(20));
            contentContainer.getChildren().add(emptyTaskReminder);
        }

        else
        {
            ArrayList<CheckBox> checkBoxes = new ArrayList<>(controller.getDatabaseSize());
            ArrayList<String> messages = controller.getMessages();

            for (int i = 0; i < controller.getDatabaseSize(); i++)
            {
                checkBoxes.add(new CheckBox(messages.get(i)));
                final int index = i;
                checkBoxes.get(i).selectedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                            Boolean newValue)
                    {
                        controller.removeFromDatabase(checkBoxes.get(index).getText());
                        checkBoxes.remove(index);
                    }
                });
            }
        }

        return null;
    }

    private Scene addTaskScene()
    {
        return null;
    }

    @Override
    public void update(Observable o, Object arg)
    {

    }
}