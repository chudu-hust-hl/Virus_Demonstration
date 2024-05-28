package application;

import java.util.ArrayList;

import VirusInformation.EnvelopedVirus;
import VirusInformation.NonEnvelopedVirus;
import VirusMenu.NonEnvelopedVirusMenu;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class NonEnvelopedPage {

    private final MainPage mainPage;
    private final Stage stage;
    private final HostServices hostServices;
    private final NonEnvelopedVirusMenu menu;
    private BorderPane root;

    public NonEnvelopedPage(MainPage mainPage, NonEnvelopedVirusMenu menu, HostServices hostServices) {
        this.mainPage = mainPage;
        this.menu = menu;
        this.hostServices = hostServices;
        this.stage = new Stage();
        this.root = new BorderPane();
    }

    public void show() {
        root.setTop(createNorth());
        root.setCenter(createCenter(menu.virusInMenu));

        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("NonEnveloped Virus");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createNorth() {
        VBox north = new VBox();
        north.getChildren().addAll(createHeader(), createSearchAndReturnBox());
        return north;
    }

    private HBox createHeader() {
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10));

        Label title = new Label("NonEnveloped Virus");
        title.setFont(new Font(30));
        title.setTextFill(Color.CYAN);

        header.getChildren().add(title);
        return header;
    }

    private VBox createSearchAndReturnBox() {
        VBox searchBox = new VBox();
        searchBox.setPadding(new Insets(10));

        HBox searchPanel = new HBox();
        searchPanel.setSpacing(10);
        searchPanel.setAlignment(Pos.CENTER);

        TextField searchField = new TextField();
        searchField.setPromptText("Search...");
        HBox.setHgrow(searchField, Priority.ALWAYS);

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> searchVirus(searchField.getText()));

        Button returnButton = new Button("Return to Main");
        returnButton.setOnAction(e -> returnToMain());

        searchPanel.getChildren().addAll(searchField, searchButton, returnButton);
        searchBox.getChildren().add(searchPanel);

        return searchBox;
    }

    private ScrollPane createCenter(ArrayList<NonEnvelopedVirus> virusList) {
        GridPane centerGrid = new GridPane();
        centerGrid.setHgap(10);
        centerGrid.setVgap(10);
        centerGrid.setPadding(new Insets(10));
        centerGrid.setAlignment(Pos.TOP_CENTER);
        
        for (int i = 0; i < 3; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / 3);  // Equal width for 3 columns
            centerGrid.getColumnConstraints().add(colConst);
        }

        int col = 0, row = 0;
        for (NonEnvelopedVirus virus : virusList) {
            VBox cell = new VBox();
            cell.setSpacing(10);
            cell.setAlignment(Pos.CENTER);
            cell.setStyle("-fx-background-color: lightgray; -fx-padding: 10;");

            Label nameLabel = new Label(virus.getName());
            nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            Button infoButton = new Button("Virus Information");
            infoButton.setMaxWidth(Double.MAX_VALUE);
            infoButton.setMaxHeight(Double.MAX_VALUE);

            Button demoButton = new Button("Virus Demonstration");
            demoButton.setMaxWidth(Double.MAX_VALUE);
            demoButton.setMaxHeight(Double.MAX_VALUE);

            cell.getChildren().addAll(nameLabel, infoButton, demoButton);
            centerGrid.add(cell, col, row);
            GridPane.setHgrow(cell, Priority.ALWAYS);
            GridPane.setVgrow(cell, Priority.ALWAYS);

            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }

        ScrollPane scrollPane = new ScrollPane(centerGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setPadding(new Insets(10));
        scrollPane.setFitToHeight(true);
        return scrollPane;
    }


    private void searchVirus(String virusName) {
    	ArrayList<NonEnvelopedVirus> searchResults = menu.searchByName(virusName);
        root.setCenter(createCenter(searchResults));
    }

    private void returnToMain() {
        // Hide the current stage and show the main page again
        stage.hide();
        mainPage.returnToMainPage();
    }

    public HostServices getHostServices() {
        return hostServices;
    }
}
