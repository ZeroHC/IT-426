package controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class Controls extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setScene(createLists());
        stage.setTitle("Practicing with controls");
        stage.show();
    }

    //buttons
    public Scene createButtons()
    {
        VBox vbox = new VBox();

        //create a button, style it
        Button button = new Button("Click Me!");
        button.setAlignment(Pos.CENTER_RIGHT);

        button.setPrefSize(150, 50);

        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                button.setText("You clicked me!");
            }
        });

        vbox.getChildren().add(button);
        vbox.setAlignment(Pos.CENTER);

        return new Scene(vbox, 300, 300);
    }

    //text, label, textfield, text area
    public Scene createText()
    {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

/*        Text header = TextBuilder.create().text("Enter Information")
                .font(Font.font("Century Gothic", FontWeight.MEDIUM, 30))
                .underline(true)
                .build();*/

        Text header = new Text("Enter information");
        header.setFont(Font.font("Century Gothic", FontWeight.MEDIUM, 30));
        header.setUnderline(true);

        vbox.getChildren().add(header);

        //add form controls
        HBox row1 = new HBox();
        row1.setSpacing(10);
        Label nameLabel = new Label("Name: ");
        nameLabel.setPrefWidth(70);
        nameLabel.setAlignment(Pos.CENTER_RIGHT);

        TextField field = new TextField();
        field.setPrefWidth(180);

        row1.getChildren().addAll(nameLabel, field);
        vbox.getChildren().add(row1);

        //add more form controls
        HBox row2 = new HBox();
        row2.setSpacing(10);

        Label bioLabel = new Label("Bio: ");
        bioLabel.setPrefWidth(70);
        bioLabel.setAlignment(Pos.CENTER_RIGHT);

        TextArea area = new TextArea();
        area.setPrefWidth(180);

        row2.getChildren().addAll(bioLabel, area);
        vbox.getChildren().add(row2);

        return new Scene(vbox, 300, 300);
    }

    //checkboxes
    public Scene createCheckBoxes()
    {
        String[] hobbies = {"Comic Collecting", "Drawing", "Video Games",
                            "Underwater Basket Weaving", "Kayaking", "Hiking"};

        CheckBox[] boxes = new CheckBox[hobbies.length];

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        //add our checkboxes
        for (int i = 0; i < hobbies.length; i++)
        {
            CheckBox box = new CheckBox(hobbies[i]);
            boxes[i] = box;
            box.setPrefWidth(200);
        }
        vbox.getChildren().addAll(boxes);

        //add event handlers
        for (int i = 0; i < boxes.length; i++)
        {
            final CheckBox box = boxes[i];
            final String hobby = hobbies[i];
            boxes[i].selectedProperty().addListener(new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable,
                                    Boolean oldValue, Boolean newValue)
                {
                    if (newValue == true)
                    {
                        //do something with the checkbox we are clicking on
                        box.setText("I'm Selected");
                    }
                    else
                    {
                        box.setText(hobby);
                    }
                }
            });
        }

        return new Scene(vbox, 300, 300);
    }

    //radio buttons, images

    //drop down list
    public Scene createDropDowns()
    {
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));

        ComboBox combo = new ComboBox();

        //add items to my dropdown
        ObservableList<String> options = FXCollections.observableArrayList(
                "blue", "green", "purple", "yellow", "pink");

        combo.getItems().addAll(options);

        vBox.getChildren().add(combo);

        //select a default
        combo.getSelectionModel().select(0);

        //respond to selection
        combo.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Alert alert = new Alert(AlertType.INFORMATION,
                        "You clicked " + combo.getValue());
                alert.show();
            }
        });

        //other types of dropdown lists
        DatePicker calendar = new DatePicker();
        vBox.getChildren().add(calendar);

        ColorPicker colors = new ColorPicker();
        vBox.getChildren().add(colors);

        return new Scene(vBox, 300, 300);
    }

    //list
    public Scene createLists()
    {
        //create a layout and control
        VBox vBox = new VBox();
        ListView view = new ListView();

        //add a few items
        ObservableList<String> items = FXCollections.observableArrayList(
                "Roby", "Five Finger Death Punch", "Slayer",
                "Weird Al", "Jungle", "William Hung");

        view.getItems().addAll(items);
        vBox.getChildren().add(view);

        return new Scene(vBox, 300, 300);
    }
}
