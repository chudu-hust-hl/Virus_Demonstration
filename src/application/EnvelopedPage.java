package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.application.HostServices;
import javafx.beans.binding.Bindings;

public class EnvelopedPage {

    private final MainPage mainPage;
    private final Stage stage;
    private final HostServices hostServices;
    private TextArea mainBox;
    private TextFlow textFlow;

    public EnvelopedPage(MainPage mainPage, HostServices hostServices) {
        this.mainPage = mainPage;
        this.stage = new Stage();
        this.hostServices = hostServices;
        this.mainBox = new TextArea();
        this.textFlow = new TextFlow();
    }

    public void show() {
        BorderPane root = new BorderPane();

        // Create left sidebar
        VBox sidebar = new VBox();
        sidebar.setSpacing(10);
        sidebar.setPadding(new Insets(10));
        sidebar.setAlignment(Pos.TOP_LEFT);

        // Set the preferred width of the sidebar to be 0.25 of the page width
        sidebar.prefWidthProperty().bind(Bindings.multiply(root.widthProperty(), 0.25));

        // Add title label
        Label titleLabel = new Label("Enveloped Virus");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Add search box
        TextField searchBox = new TextField();
        searchBox.setPromptText("Search for virus name...");

        // Add search button
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> searchVirus(searchBox.getText()));

        // Add components to the sidebar
        sidebar.getChildren().addAll(titleLabel, searchBox, searchButton);

        // Create main box to display the grid of viruses
        GridPane mainBox = new GridPane();
        mainBox.setPadding(new Insets(10));
        mainBox.setHgap(10);
        mainBox.setVgap(10);
        mainBox.setAlignment(Pos.CENTER);

        // Populate the mainBox with some example data
        populateGrid(mainBox);

        // Add sidebar to the left side of the root BorderPane
        root.setLeft(sidebar);

        // Add main box to the center of the root BorderPane
        root.setCenter(mainBox);

        // Create a scene
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.setTitle("Enveloped Virus Page");
        stage.show();
    }

    private void searchVirus(String virusName) {
        // Implement your search logic here
        System.out.println("Searching for virus: " + virusName);
        // Update the mainBox with search results
    }

    private void populateGrid(GridPane grid) {
        // Example data to populate the grid
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Label label = new Label("Virus " + (row * 3 + col + 1));
                label.setStyle("-fx-border-color: black; -fx-padding: 10px;");
                grid.add(label, col, row);
            }
        }
    }
}
