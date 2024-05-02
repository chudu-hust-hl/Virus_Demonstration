package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainPage extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        BorderPane root = new BorderPane();

        // Create background image
        Image backgroundImage = new Image("file:main_background.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(backgroundImageView);

        // Create title label
        Label titleLabel = new Label("VIRUS DEMONSTRATION");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white; -fx-pref-height: 50px;");

        // Create buttons
        Button envelopedVirusButton = new Button("Enveloped Virus");
        Button nonEnvelopedVirusButton = new Button("Non-Enveloped Virus");
        Button helpButton = new Button("Help");

        // Set button styles
        String buttonStyle = "-fx-background-color: indigo; -fx-text-fill: white; -fx-pref-width: 200px; -fx-pref-height: 50px;";
        envelopedVirusButton.setStyle(buttonStyle);
        nonEnvelopedVirusButton.setStyle(buttonStyle);
        helpButton.setStyle(buttonStyle);

        // Create sections (placeholders)
        VBox envelopedVirusSection = new VBox();
        envelopedVirusSection.setPadding(new Insets(10));
        envelopedVirusSection.setStyle("-fx-background-color: lightblue;");
        envelopedVirusSection.getChildren().add(new Rectangle(200, 200, Color.RED)); // Placeholder content

        VBox nonEnvelopedVirusSection = new VBox();
        nonEnvelopedVirusSection.setPadding(new Insets(10));
        nonEnvelopedVirusSection.setStyle("-fx-background-color: lightgreen;");
        nonEnvelopedVirusSection.getChildren().add(new Rectangle(200, 200, Color.GREEN)); // Placeholder content

        // Button actions
        envelopedVirusButton.setOnAction(e -> root.setCenter(envelopedVirusSection));
        nonEnvelopedVirusButton.setOnAction(e -> root.setCenter(nonEnvelopedVirusSection));
        helpButton.setOnAction(e -> showHelpPage());

        // Add components to a VBox
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titleLabel, envelopedVirusButton, nonEnvelopedVirusButton, helpButton);
        root.setCenter(vbox); // Place VBox in the center

        Scene scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Page");
        primaryStage.show();
    }

    private void showHelpPage() {
        primaryStage.close(); // Close the main page
        HelpPage helpPage = new HelpPage(this);
        helpPage.show();
    }


    public void returnToMainPage() {
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
