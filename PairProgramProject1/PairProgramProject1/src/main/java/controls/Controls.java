package controls;

/*
 * Java FX Controls pair programming
 * Dan, Zero
 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class Controls extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        //stage.setScene(createButtons());
        stage.setScene(selectImage());
        stage.setTitle("Select an Image");
        stage.show();
    }

    public Scene selectImage()
    {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        HBox hBox = new HBox();
        hBox.setSpacing(10);

        RadioButton button1 = new RadioButton("Bear");
        RadioButton button2 = new RadioButton("Cat");
        RadioButton button3 = new RadioButton("Owl");
        RadioButton button4 = new RadioButton("Parrot");

        ToggleGroup group = new ToggleGroup();
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);
        button3.setToggleGroup(group);
        button4.setToggleGroup(group);

        HBox image = new HBox();
        ImageView myImageView = new ImageView();
        image.setPrefSize(350, 350);
        myImageView.setFitHeight(300);
        myImageView.setFitWidth(300);

        button1.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                try
                {
                    Image image = new Image(new File("images/bear.jpg")
                            .toURI().toURL().toString(), true);
                    myImageView.setImage(image);
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
        });

        button2.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                try
                {
                    Image image = new Image(new File("images/cat.jpg")
                            .toURI().toURL().toString(), true);
                    myImageView.setImage(image);
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
        });

        button3.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                try
                {
                    Image image = new Image(new File("images/owl.jpg")
                            .toURI().toURL().toString(), true);
                    myImageView.setImage(image);
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
        });

        button4.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                try
                {
                    Image image = new Image(new File("images/parrot.jpg")
                            .toURI().toURL().toString(), true);
                    myImageView.setImage(image);
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
        });

        hBox.getChildren().addAll(button1, button2, button3, button4);
        image.getChildren().add(myImageView);
        vBox.getChildren().addAll(hBox, image);

        return new Scene(vBox, 375, 375);
    }
}
