package controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

public class Controls extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setScene(createText());
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


    //radio buttons, images

    //...
}
