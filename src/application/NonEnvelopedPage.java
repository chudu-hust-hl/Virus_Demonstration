package application;

import java.util.ArrayList;

import DetailPage.NonEnvelopedVirusDemo;
import DetailPage.NonEnvelopedVirusInfo;
import DetailPage.NonEnvelopedVirusStatistics;
import Host.Host;
import Host.HostList;
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
import javafx.scene.image.ImageView;
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
    private final HostList hostList;
    private BorderPane root;

    public NonEnvelopedPage(MainPage mainPage, NonEnvelopedVirusMenu menu, HostList hostList, HostServices hostServices) {
        this.mainPage = mainPage;
        this.menu = menu;
        this.hostServices = hostServices;
        this.stage = new Stage();
        this.root = new BorderPane();
		this.hostList = hostList;
    }

    public void show() {
        root.setTop(createNorth());
        root.setCenter(createCenter(menu.virusInMenu));

        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("Enveloped Virus");
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

        Label title = new Label("Non-Enveloped Virus");
        title.setFont(new Font(30));
        title.setTextFill(Color.INDIGO);

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
        
        Button statButton = new Button("Virus Statistics");
        statButton.setOnAction(e -> {
            new NonEnvelopedVirusStatistics(this, getHostServices(), menu).show();
            stage.close(); // Hide the EnvelopedPage
        });;

        Button returnButton = new Button("Return to Main Page");
        returnButton.setOnAction(e -> returnToMain());

        searchPanel.getChildren().addAll(searchField, searchButton, statButton, returnButton);
        searchBox.getChildren().add(searchPanel);
        
        //Buttons to search for virus iffecting these
        HBox hostButtons = new HBox();
        hostButtons.setSpacing(10);
        hostButtons.setAlignment(Pos.CENTER_LEFT);

        for (Host host : hostList.getHostList()) {
            Button hostButton = new Button(host.getHostType());
            hostButton.setOnAction(e -> searchByHost(host.getHostType()));
            hostButtons.getChildren().add(hostButton);
        }

        searchBox.getChildren().add(hostButtons);
        
        //Buttons to search for DNA and RNA virus
        HBox NAButtons = new HBox();
        NAButtons.setSpacing(10);
        NAButtons.setAlignment(Pos.CENTER_LEFT);
        
        Button DNAButton = new Button("DNA");
        NAButtons.getChildren().add(DNAButton);
        DNAButton.setOnAction(e -> searchByGeneticType("DNA"));
        
        Button RNAButton = new Button("RNA");
        NAButtons.getChildren().add(RNAButton);
        RNAButton.setOnAction(e -> searchByGeneticType("RNA"));
        
        searchBox.getChildren().add(NAButtons);

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
            
            ImageView imageView = new ImageView(virus.getStrucImage());
            imageView.setFitHeight(100);
            imageView.setPreserveRatio(true);

            Button infoButton = new Button("Virus Information");
            infoButton.setMaxWidth(Double.MAX_VALUE);
            infoButton.setMaxHeight(Double.MAX_VALUE);
            infoButton.setOnAction(e -> {
                new NonEnvelopedVirusInfo(virus, this, getHostServices(), menu).show();
                stage.close(); // Hide the NonEnvelopedPage
            });

            Button demoButton = new Button("Virus Demonstration");
            demoButton.setMaxWidth(Double.MAX_VALUE);
            demoButton.setMaxHeight(Double.MAX_VALUE);
            demoButton.setOnAction(e -> {
            	new NonEnvelopedVirusDemo(virus, this, getHostServices()).show();
                stage.close(); // Hide the NonEnvelopedPage
            });

            cell.getChildren().addAll(nameLabel, imageView, infoButton, demoButton);
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
    
    
    private void searchByHost(String hostType) {
    	ArrayList<NonEnvelopedVirus> searchResults = menu.searchByHostType(hostType);
    	root.setCenter(createCenter(searchResults));
    }
    
    private void searchByGeneticType(String GenType) {
    	ArrayList<NonEnvelopedVirus> searchResults = menu.searchByGeneticMaterial(GenType);
    	root.setCenter(createCenter(searchResults));
    }
    
    
    private void returnToMain() {
        // Hide the current stage and show the main page again
        stage.hide();
        mainPage.returnToMainPage();
    }
    
    public void returnToMenu() {
        stage.show();
    }

    public HostServices getHostServices() {
        return hostServices;
    }
}
