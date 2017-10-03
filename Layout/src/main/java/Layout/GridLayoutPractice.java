package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridLayoutPractice extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Practicing with GridPane!");
        stage.setScene(assemble());
        stage.show();
    }

    private Scene assemble()
    {
        //assemble our controls in a grid
        GridPane gridPane = new GridPane();

        //set spacing around elements
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        //define column and row constraints
        gridPane.getColumnConstraints().addAll(new ColumnConstraints(80),
                new ColumnConstraints(80), new ColumnConstraints(80));

        //create some dummy controls and add to the gird
        CheckBox box1 = new CheckBox("Fun!");
        CheckBox box2 = new CheckBox("Sadness!");
        CheckBox box3 = new CheckBox("Apathy!");

        //add controls by row & column
        gridPane.add(box1, 0, 0);
        gridPane.add(box2, 1, 0);
        gridPane.add(box3, 2, 0);

        //add a second row
        Button button = new Button("Click me!");
        button.setPrefWidth(Double.MAX_VALUE);//fill the width of the parent pane
        gridPane.add(button, 0, 1, 3, 1);

        //add a third row
        TextArea area = new TextArea("Type a lot of information here...");
        Text text = new Text("Lots of other information located here...");
        text.setWrappingWidth(80);//wrap text beyond the width of the column

        gridPane.add(area, 0, 2, 2, 2);
        gridPane.add(text, 2, 2);

        return new Scene(gridPane, 300, 280);
    }
}
