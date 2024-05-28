package DetailPage;

import VirusInformation.Virus;
import application.EnvelopedPage;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EnvelopedVirusInfo{
    private Virus virus;
    private final EnvelopedPage EVPage;
    private final Stage stage;
    private final HostServices hostServices;

    public EnvelopedVirusInfo(Virus virus, EnvelopedPage EVPage, HostServices hostServices) {
        this.virus = virus;
        this.EVPage = EVPage;
        this.hostServices = hostServices;
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
        infoGrid.add(new Label("Virus Name:"), 0, 0);
        infoGrid.add(new Label(virus.getName()), 1, 0);

        infoGrid.add(new Label("Genetic Material Type:"), 0, 1);
        infoGrid.add(new Label(virus.getGeneticMaterialType()), 1, 1);

        infoGrid.add(new Label("Capsid Shape:"), 0, 2);
        infoGrid.add(new Label(virus.getCapsidShape()), 1, 2);

        infoGrid.add(new Label("Host Range:"), 0, 3);
        infoGrid.add(new Label(virus.getHostRange()), 1, 3);

        infoGrid.add(new Label("Transmission Mode:"), 0, 4);
        infoGrid.add(new Label(virus.getTransmissionMode()), 1, 4);

        infoGrid.add(new Label("Incubation Period:"), 0, 5);
        infoGrid.add(new Label(virus.getIncubationPeriod() + " days"), 1, 5);

        infoGrid.add(new Label("Severity:"), 0, 6);
        infoGrid.add(new Label(virus.getSeverity()), 1, 6);

        infoGrid.add(new Label("Mutation Rate:"), 0, 7);
        infoGrid.add(new Label(virus.getMutationRate() + " mutations per cycle"), 1, 7);

        // Add a button to close the window
        Button returnButton = new Button("Return to Menu");
        returnButton.setOnAction(e -> {
        	EVPage.returnToMenu();
            stage.close();
        });

        root.setCenter(infoGrid);
        root.setBottom(returnButton);

        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

	public HostServices getHostServices() {
		return hostServices;
	}
}