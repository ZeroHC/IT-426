package gui;

import io.exporting.JSONExporter;
import io.exporting.JavaExporter;
import io.exporting.XMLExporter;
import io.importing.JSONImporter;
import io.importing.JavaImporter;
import io.importing.XMLImporter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Generates a new user interface for a Parts Database
 *
 * @author Josh Archer
 * @version 1.0
 */
public class PartsDatabaseUI extends Application
{
    private static final int SCENE_WIDTH = 500;
    private static final int SCENE_HEIGHT = 220;
    private static final String MISSING_INPUT_ERROR = "One or more input fields are missing!";
    private static final String DATABASE_EMPTY_ERROR = "Database is empty";
    private static final String FILE_NOT_EXIST = "File does not exist!";
    private static final String FILE_TYPE_JAVA = "Java";
    private static final String FILE_TYPE_JSON = "JSON";
    private static final String FILE_TYPE_XML = "XML";

    //model classes
    private PartsDatabase data;
    private CarPart part;

    //entry fields
    private TextField partId;
    private TextField manufacturer;
    private TextField listPrice;
    private TextField categories;

    private ToggleGroup exportToggle;
    private ToggleGroup importToggle;

    /**
     * Creates a new user interface object.
     */
    public PartsDatabaseUI()
    {
        data = new PartsDatabase();
    }

    /**
     * Called when the Java FX application is about to launch.
     *
     * @param stage the stage to display screens upon
     */
    public void start(Stage stage)
    {
        stage.setTitle("Parts Database");

        try
        {
            stage.setScene(getScene());
        }
        catch (Exception ex)
        {
            throw new RuntimeException("Something went wrong: " + ex.getMessage());
        }

        stage.show();
    }

    //retrieves the primary scene for the parts database
    private Scene getScene() throws MalformedURLException
    {
        //two primary panes on the left and right
        GridPane left = getLeftPane();
        VBox right = getRightPane();

        //arrange the panes using a parent grid pane
        GridPane parent = new GridPane();
        parent.setHgap(10);
        parent.setVgap(10);
        parent.setPadding(new Insets(10,10,10,10));

        //set the width of each side
        ColumnConstraints columnLeft = new ColumnConstraints();
        ColumnConstraints columnRight = new ColumnConstraints();
        columnLeft.setPercentWidth(50);
        columnRight.setPercentWidth(50);

        parent.getColumnConstraints().add(columnLeft);
        parent.getColumnConstraints().add(columnRight);

        //add the child controls
        parent.add(left, 0, 1);
        parent.add(right, 1, 1);

        //prepare the scenes to run and return
        Scene scene = new Scene(parent, SCENE_WIDTH, SCENE_HEIGHT);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(new File("src/styles/styles.css").toURI().toURL().toExternalForm());

        return scene;
    }

    //generates the left side of the user interface
    private GridPane getLeftPane()
    {
        //organize elements with a grid pane
        GridPane left = new GridPane();
        left.setVgap(4);
        left.setHgap(4);
        left.setPadding(new Insets(4, 4, 4,4));

        //enforce certain widths on the columns
        ColumnConstraints columnLeft = new ColumnConstraints();
        ColumnConstraints columnRight = new ColumnConstraints();
        columnLeft.setPercentWidth(40);
        columnRight.setPercentWidth(60);

        left.getColumnConstraints().add(columnLeft);
        left.getColumnConstraints().add(columnRight);

        //add text entry fields
        partId = addTextControl("Part Id #", "partId", 0, left);
        manufacturer = addTextControl("Manufacturer", "manufacturer", 1, left);
        listPrice = addTextControl("List Price", "listPrice", 2, left);
        categories = addTextControl("Categories", "categories", 3, left);

        //button for adding a new part record
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);

        Button add = new Button("Add Part");
        add.setPadding(new Insets(4,30,4,30));
        hbox.getChildren().add(add);
        hbox.getStyleClass().add("border-top");

        //adds a new part record
        add.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                //if any input field is missing, prompt a alert window to user
                if (partId.getText().isEmpty() || manufacturer.getText().isEmpty() || listPrice.getText().isEmpty()
                    || categories.getText().isEmpty())
                {
                    displayAlertWindow(MISSING_INPUT_ERROR);
                }
                //else create a car part with user's input, and add the part to the parts database
                //and then clear out all input fields for recycling
                else
                {
                    part = new CarPart();
                    part.setId(partId.getText());
                    part.setManufacturer(manufacturer.getText());
                    part.setListPrice(Double.parseDouble(listPrice.getText()));
                    part.setCategories(categories.getText().split(","));
                    data.addPart(part);
                    partId.setText("");
                    manufacturer.setText("");
                    listPrice.setText("");
                    categories.setText("");
                }
            }
        });

        //add the controls
        left.add(hbox, 0, 5, 2, 1);
        left.getStyleClass().add("panel");

        return left;
    }

    //generates a new label/textfield combination for form entries
    private TextField addTextControl(String labelText, String controlName, int row, GridPane parent)
    {
        //create the controls
        Label label = new Label(labelText);
        TextField textField = new TextField();

        //set a style
        textField.getStyleClass().add("text");

        //add to the parent element
        parent.add(label, 0, row);
        parent.add(textField, 1, row);

        return textField;
    }

    //generate the right pane of controls
    private VBox getRightPane()
    {
        VBox right = new VBox();

        //prepare export elements
        HBox exportHeader = new HBox();
        exportHeader.setAlignment(Pos.CENTER);
        exportHeader.setPadding(new Insets(6,0,0,0));

        Button exportButton = new Button("Export");
        exportHeader.getChildren().add(exportButton);

        //export all CarPart objects from the application
        exportButton.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                fileExporter();
            }
        });

        String[] options = {FILE_TYPE_JAVA, FILE_TYPE_JSON, FILE_TYPE_XML};
        exportToggle = new ToggleGroup();
        HBox exportRButtons = getRadioButtons(exportToggle, options);

        //prepare import elements
        HBox importHeader = new HBox();
        importHeader.setAlignment(Pos.CENTER);
        importHeader.setPadding(new Insets(6,0,0,0));

        Button importButton = new Button("Import");
        importHeader.getChildren().add(importButton);

        //imports all CarPart objects into the application
        importButton.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                fileImporter();
            }
        });

        importToggle = new ToggleGroup();
        HBox importRButtons = getRadioButtons(importToggle, options);

        //force a few style considerations
        exportButton.setMaxWidth(Double.MAX_VALUE);
        exportRButtons.setMaxWidth(Double.MAX_VALUE);
        importButton.setMaxWidth(Double.MAX_VALUE);
        importRButtons.setMaxWidth(Double.MAX_VALUE);

        //add our controls together
        right.getStyleClass().add("panel");
        right.getChildren().addAll(exportHeader, exportRButtons, importHeader, importRButtons);

        return right;
    }

    //generates a simple button with a style
    private Button getButton(String text)
    {
        Button button = new Button(text);
        button.getStyleClass().add("button");
        return button;
    }

    //generates a horizontal box of radio buttons with the associated group
    private HBox getRadioButtons(ToggleGroup group, String[] options)
    {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BOTTOM_CENTER);

        //add each option individually
        for (int i = 0; i < options.length; i++)
        {
            RadioButton rButton = new RadioButton();
            rButton.setText(options[i]);
            rButton.setPadding(new Insets(10, 10, 10,10));
            rButton.setToggleGroup(group);

            //select the first option
            if (i == 0)
            {
                rButton.setSelected(true);
            }

            hbox.getChildren().add(rButton);
        }

        return hbox;
    }

    //this method will write the values from database to different files based on user's choice
    private void fileExporter()
    {
        //create a temporary radio button to represent the selected radio button
        RadioButton temp = (RadioButton) exportToggle.getSelectedToggle();

        //use a switch statement to check which file type the user wants to write to
        switch (temp.getText())
        {
            case FILE_TYPE_JAVA:
                JavaExporter javaExporter = new JavaExporter(data);
                if (javaExporter.exportParts()) displayAlertWindow(DATABASE_EMPTY_ERROR);
                else javaExporter.javaFileWriter();
                break;

            case FILE_TYPE_JSON:
                JSONExporter jsonExporter = new JSONExporter(data);
                if (jsonExporter.exportParts()) displayAlertWindow(DATABASE_EMPTY_ERROR);
                else jsonExporter.jsonFileWriter();
                break;

            case FILE_TYPE_XML:
                XMLExporter xmlExporter = new XMLExporter(data);
                if (xmlExporter.exportParts()) displayAlertWindow(DATABASE_EMPTY_ERROR);
                else xmlExporter.xmlFileWriter();
                break;
        }
    }

    //this method will read the values from different files to the database based on user's choice
    private void fileImporter()
    {
        //create a temporary radio button to represent the selected radio button
        RadioButton temp = (RadioButton) importToggle.getSelectedToggle();

        //use a switch statement to check which file type the user wants to read from
        switch (temp.getText())
        {
            case FILE_TYPE_JAVA:
                JavaImporter javaImporter = new JavaImporter();
                if (!javaImporter.importParts()) displayAlertWindow(FILE_NOT_EXIST);
                else
                {
                    data = javaImporter.javaFileReader();
                }
                break;

            case FILE_TYPE_JSON:
                JSONImporter jsonImporter = new JSONImporter();
                if (!jsonImporter.importParts()) displayAlertWindow(FILE_NOT_EXIST);
                else
                {
                    data = jsonImporter.jsonFileReader();
                }
                break;

            case FILE_TYPE_XML:
                XMLImporter xmlImporter = new XMLImporter();
                if (!xmlImporter.importParts()) displayAlertWindow(FILE_NOT_EXIST);
                else
                {
                    data = xmlImporter.xmlFileReader();
                }
                break;
        }
    }

    //this method will display an alert window
    private void displayAlertWindow(String alertMessage)
    {
        //Makes an alert object.
        Alert alertWindow = new Alert(Alert.AlertType.INFORMATION);

        //Alert Title
        alertWindow.setTitle("Parts Database");

        //Removes the alert header
        alertWindow.setHeaderText(null);

        //Alert message
        alertWindow.setContentText(alertMessage);

        //Displays alert and awaits user action.
        alertWindow.showAndWait();
    }
}
