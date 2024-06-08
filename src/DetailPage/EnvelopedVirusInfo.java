package DetailPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import VirusInformation.EnvelopedVirus;
import VirusMenu.EnvelopedVirusMenu;
import application.EnvelopedPage;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class EnvelopedVirusInfo {
    private EnvelopedVirus virus;
    private final EnvelopedPage EVPage;
    private final Stage stage;
    private final HostServices hostServices;
    private final EnvelopedVirusMenu EVmenu;

    public EnvelopedVirusInfo(EnvelopedVirus virus, EnvelopedPage EVPage, HostServices hostServices, EnvelopedVirusMenu EVmenu) {
        this.virus = virus;
        this.EVPage = EVPage;
        this.hostServices = hostServices;
        this.EVmenu = EVmenu;
        this.stage = new Stage();
    }

    public void show() {
        stage.setTitle("Virus Information");

        BorderPane root = new BorderPane();

        // Create a grid pane to hold the virus information
        GridPane infoGrid = new GridPane();
        infoGrid.setPadding(new Insets(10));
        infoGrid.setHgap(10);
        infoGrid.setVgap(10);

        // Add labels for each attribute
        infoGrid.add(new Label("Virus Name and Family:"), 0, 0);
        infoGrid.add(new Label(virus.getName() + " (" + virus.getFamily() + ")"), 1, 0);

        infoGrid.add(new Label("Genetic Material Type:"), 0, 1);
        infoGrid.add(new Label(virus.getGeneticMaterialType()), 1, 1);

        infoGrid.add(new Label("Capsid Shape:"), 0, 2);
        infoGrid.add(new Label(virus.getCapsidShape()), 1, 2);

        infoGrid.add(new Label("Host Range:"), 0, 3);
        infoGrid.add(new Label(virus.getHostRange().toString()), 1, 3);

        infoGrid.add(new Label("Transmission Mode:"), 0, 4);
        infoGrid.add(new Label(virus.getTransmissionMode()), 1, 4);

        infoGrid.add(new Label("Incubation Period:"), 0, 5);
        infoGrid.add(new Label(virus.getIncubationPeriod() + " days"), 1, 5);

        infoGrid.add(new Label("Severity:"), 0, 6);
        infoGrid.add(new Label(virus.getSeverity()), 1, 6);

        infoGrid.add(new Label("Mutation Rate:"), 0, 7);
        infoGrid.add(new Label(virus.getMutationRate() + " mutations per cycle"), 1, 7);

        // Add envelope composition with wrapping
        infoGrid.add(new Label("Envelope Composition:"), 0, 8);
        Text envelopeText = new Text(virus.getEnvelopeComposition());
        TextFlow envelopeTextFlow = new TextFlow(envelopeText);
        envelopeTextFlow.setMaxWidth(230); // Adjust this width as necessary
        infoGrid.add(envelopeTextFlow, 1, 8);

        // Add image of the virus with zoom functionality
        ImageView virusImageView = new ImageView();
        if (virus.getStrucImage() != null) {
            virusImageView.setImage(virus.getStrucImage());
        }
        virusImageView.setFitHeight(250);
        virusImageView.setPreserveRatio(true);
        virusImageView.setSmooth(true);
        virusImageView.setCache(true);

        // Event handler for image click
        virusImageView.setOnMouseClicked(event -> showEnlargedImage(virus.getStrucImage()));

        VBox infoBox = new VBox();
        infoBox.getChildren().addAll(infoGrid, virusImageView);
        infoBox.setPadding(new Insets(10));
        infoBox.setSpacing(10);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(10));

        Button returnButton = new Button("Return to Menu");
        returnButton.setOnAction(e -> {
            EVPage.returnToMenu();
            stage.close();
        });

        Button compareButton = new Button("Compare to");
        compareButton.setOnAction(e -> compareVirus());

        buttonBox.getChildren().addAll(compareButton, returnButton);

        root.setTop(buttonBox);
        root.setLeft(infoBox);

        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void showEnlargedImage(Image image) {
        Stage imageStage = new Stage();
        BorderPane imageRoot = new BorderPane();
        ImageView enlargedImageView = new ImageView(image);
        enlargedImageView.setFitWidth(600); // Set enlarged fit width
        enlargedImageView.setPreserveRatio(true);

        imageRoot.setCenter(enlargedImageView);
        Scene imageScene = new Scene(imageRoot, 600, 600);
        imageStage.setScene(imageScene);
        imageStage.show();
    }

    private void compareVirus() {
        List<String> virusNames = new ArrayList<>();
        for (EnvelopedVirus virus : EVmenu.getVirusInMenu()) {
            virusNames.add(virus.getName());
        }

        ChoiceDialog<String> dialog = new ChoiceDialog<>(virusNames.get(0), virusNames);
        dialog.setTitle("Select Virus to Compare");
        dialog.setHeaderText("Choose a virus to compare with " + virus.getName());
        dialog.setContentText("Select Virus:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            EnvelopedVirus selectedVirus = EVmenu.getVirusByName(name);

            if (selectedVirus != null) {
                displayComparison(selectedVirus);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Virus Not Found");
                alert.setContentText("The virus name you selected does not exist in the menu.");
                alert.showAndWait();
            }
        });
    }

    private void displayComparison(EnvelopedVirus selectedVirus) {
        // Create a grid pane to hold the selected virus information
        GridPane comparisonGrid = new GridPane();
        comparisonGrid.setPadding(new Insets(10));
        comparisonGrid.setHgap(10);
        comparisonGrid.setVgap(10);

        // Add labels for each attribute
        comparisonGrid.add(new Label("Virus Name and family:"), 0, 0);
        comparisonGrid.add(new Label(selectedVirus.getName() + " (" + selectedVirus.getFamily() + ")"), 1, 0);

        comparisonGrid.add(new Label("Genetic Material Type:"), 0, 1);
        comparisonGrid.add(new Label(selectedVirus.getGeneticMaterialType()), 1, 1);

        comparisonGrid.add(new Label("Capsid Shape:"), 0, 2);
        comparisonGrid.add(new Label(selectedVirus.getCapsidShape()), 1, 2);

        comparisonGrid.add(new Label("Host Range:"), 0, 3);
        comparisonGrid.add(new Label(selectedVirus.getHostRange().toString()), 1, 3);

        comparisonGrid.add(new Label("Transmission Mode:"), 0, 4);
        comparisonGrid.add(new Label(selectedVirus.getTransmissionMode()), 1, 4);

        comparisonGrid.add(new Label("Incubation Period:"), 0, 5);
        comparisonGrid.add(new Label(selectedVirus.getIncubationPeriod() + " days"), 1, 5);

        comparisonGrid.add(new Label("Severity:"), 0, 6);
        comparisonGrid.add(new Label(selectedVirus.getSeverity()), 1, 6);

        comparisonGrid.add(new Label("Mutation Rate:"), 0, 7);
        comparisonGrid.add(new Label(selectedVirus.getMutationRate() + " mutations per cycle"), 1, 7);

        // Add envelope composition with wrapping
        comparisonGrid.add(new Label("Envelope Composition:"), 0, 8);
        Text envelopeText = new Text(selectedVirus.getEnvelopeComposition());
        TextFlow envelopeTextFlow = new TextFlow(envelopeText);
        envelopeTextFlow.setMaxWidth(230); // Adjust this width as necessary
        comparisonGrid.add(envelopeTextFlow, 1, 8);

        // Add image of the selected virus with zoom functionality
        ImageView selectedVirusImageView = new ImageView();
        if (selectedVirus.getStrucImage() != null) {
            selectedVirusImageView.setImage(selectedVirus.getStrucImage());
        }
        selectedVirusImageView.setFitHeight(250);
        selectedVirusImageView.setPreserveRatio(true);
        selectedVirusImageView.setSmooth(true);
        selectedVirusImageView.setCache(true);

        // Event handler for image click
        selectedVirusImageView.setOnMouseClicked(event -> showEnlargedImage(selectedVirus.getStrucImage()));

        VBox comparisonBox = new VBox();
        comparisonBox.getChildren().addAll(comparisonGrid, selectedVirusImageView);
        comparisonBox.setPadding(new Insets(10));
        comparisonBox.setSpacing(10);

        BorderPane root = (BorderPane) stage.getScene().getRoot();
        root.setRight(comparisonBox);
    }

    public HostServices getHostServices() {
        return hostServices;
    }
}
