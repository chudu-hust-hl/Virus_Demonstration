package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class HelpPage {

    private final MainPage mainPage;
    private final Stage stage;
    private TextArea mainBox;

    public HelpPage(MainPage mainPage) {
        this.mainPage = mainPage;
        this.stage = new Stage();
        this.mainBox = new TextArea();
    }

    public void show() {
        BorderPane root = new BorderPane();

        // Create left sidebar with clickable sections
        VBox sidebar = new VBox();
        sidebar.setSpacing(10);
        sidebar.setPadding(new Insets(10));
        sidebar.setAlignment(Pos.TOP_LEFT);

        // Set the preferred width of the sidebar to be 0.25 of the page width
        sidebar.prefWidthProperty().bind(Bindings.multiply(root.widthProperty(), 0.25));

        String[] sectionTitles = {"Instructions", "Features", "Virus Information", "Contact", "Resources"};
        String buttonStyle = "-fx-background-color: indigo; -fx-text-fill: white";
        for (String title : sectionTitles) {
            Button sectionButton = new Button(title);
            sectionButton.setStyle(buttonStyle);
            sectionButton.prefWidthProperty().bind(sidebar.widthProperty()); // Bind button width to sidebar width
            sectionButton.prefHeightProperty().bind(sidebar.heightProperty().divide(sectionTitles.length)); // Make buttons evenly spaced vertically
            sectionButton.setOnAction(e -> displaySection(title));
            sidebar.getChildren().add(sectionButton);
        }

        // Create return button
        Button returnButton = new Button("Return to Main Page");
        returnButton.setOnAction(e -> {
            mainPage.returnToMainPage();
            stage.close();
        });

        // Create main box on the right to display information
        StackPane mainBoxPane = new StackPane();

		// Set background color to transparent
		mainBoxPane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		
		Image backgroundImage = null;
		try {
		    backgroundImage = new Image("file:help_background.jpg");
		} catch (Exception e) {
		    System.err.println("Error loading background image: " + e.getMessage());
		}
	
		// Check if the background image was loaded successfully
		if (backgroundImage != null) {
		    // Create an ImageView to display the background image
		ImageView backgroundImageView = new ImageView(backgroundImage);
		backgroundImageView.fitWidthProperty().bind(mainBoxPane.widthProperty());
		backgroundImageView.fitHeightProperty().bind(mainBoxPane.heightProperty());
		
		 // Add the background image and mainBox to the StackPane
		mainBoxPane.getChildren().addAll(backgroundImageView, mainBox);
		} else {
		    // If the background image failed to load, just add the mainBox
			mainBoxPane.getChildren().add(mainBox);
		}

        // Create a VBox to hold the sidebar
        VBox sidebarBox = new VBox(sidebar);
        sidebarBox.setPadding(new Insets(10));

        // Add sidebar to the left side of the root BorderPane
        root.setLeft(sidebarBox);

        // Add main box to the center of the root BorderPane
        root.setCenter(mainBoxPane);

        // Add return button to the bottom of the root BorderPane
        root.setBottom(returnButton);

        // Create a scene
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.setTitle("Help Page");
        stage.show();

        // Display default section (Instructions)
        displaySection("Instructions");
    }


    private void displaySection(String sectionTitle) {
        // Logic to display the content of the selected section in the main box
        // Example text for each section
        String text = "";
        switch (sectionTitle) {
            case "Instructions":
                text = "Welcome to the Virus Demonstration Help Page. Here you can find instructions on how to navigate through the application and access different features.";
                break;
            case "Features":
                text = "The Virus Demonstration application allows users to explore the structures and behaviors of different types of viruses. You can choose between enveloped and non-enveloped viruses, and select specific viruses to learn more about.";
                break;
            case "Virus Information":
                text = "In this section, you can access detailed information about various viruses, including their structures, modes of transmission, and effects on the human body.";
                break;
            case "Contact":
                text = "If you have any questions or feedback about the Virus Demonstration application, feel free to contact us at support@virusdemonstration.com.";
                break;
            case "Resources":
                text = "Here you can find additional resources and references related to virology and infectious diseases, including books, articles, and online courses.";
                break;
        }
        mainBox.setText(text);
    }
}