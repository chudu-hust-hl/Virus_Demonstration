package application;

import java.util.Arrays;

import javax.swing.JFrame;

import Host.HostList;
import VirusInformation.EnvelopedVirus;
import VirusInformation.NonEnvelopedVirus;
import VirusMenu.EnvelopedVirusMenu;
import VirusMenu.NonEnvelopedVirusMenu;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPage extends Application {

	private Stage primaryStage;
    private JFrame mainFrame; // Reference to the main Swing frame
    
    //Initialize the HostList
    public static HostList hostList = new HostList();

    // JavaFX version of setVisible method
    public void setVisible(boolean visible) {
        if (primaryStage != null) {
            if (visible) {
                primaryStage.show();
            } else {
                primaryStage.hide();
            }
        } else if (mainFrame != null) {
            mainFrame.setVisible(visible);
        } else {
            System.out.println("Error: Both primaryStage and mainFrame are null.");
        }
    }

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
        

        // Button actions
        envelopedVirusButton.setOnAction(e -> showEnvelopedPage());
        nonEnvelopedVirusButton.setOnAction(e -> showNonEnvelopedPage());
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
        HelpPage helpPage = new HelpPage(this, getHostServices());
        helpPage.show();
    }
    
    private void showEnvelopedPage() {
    	primaryStage.close(); // Close the main page
    	EnvelopedVirusMenu EVmenu = new EnvelopedVirusMenu(); 
    	EVmenuStore(EVmenu);
    	EnvelopedPage EVpage = new EnvelopedPage(this, EVmenu, hostList, getHostServices()); 
    	EVpage.show();
    }
    
    private void showNonEnvelopedPage() {
    	primaryStage.close(); // Close the main page
    	NonEnvelopedVirusMenu NEVmenu = new NonEnvelopedVirusMenu(); 
    	NEVmenuStore(NEVmenu);
    	NonEnvelopedPage NEVpage = new NonEnvelopedPage(this, NEVmenu, hostList, getHostServices()); 
    	NEVpage.show();
    }



    public void returnToMainPage() {
        primaryStage.show();
    }
    
    public static void EVmenuStore(EnvelopedVirusMenu EVmenu) {
        
    	EnvelopedVirus herpesSimplexVirus = new EnvelopedVirus(
                "Herpes Simplex Virus", "DNA", "icosahedral", 
                Arrays.asList("Human"), "contact", 2, "mild to severe", 0.001, 
                "lipid envelope with glycoprotein spikes (gB, gD, gH, gL)"
        );
        EVmenu.addEnvelopedVirus(herpesSimplexVirus);

        EnvelopedVirus influenzaVirus = new EnvelopedVirus(
                "Influenza Virus", "RNA", "segmented", 
                Arrays.asList("Human", "Bird"), "airborne", 1, "moderate to severe", 0.01, 
                "lipid envelope with hemagglutinin (HA) and neuraminidase (NA)"
        );
        EVmenu.addEnvelopedVirus(influenzaVirus);

        EnvelopedVirus hiv = new EnvelopedVirus(
                "HIV", "RNA", "complex", 
                Arrays.asList("Human", "Primate"), "contact", 14, "severe", 0.003, 
                "lipid envelope with glycoprotein spikes (gp120, gp41)"
        );
        EVmenu.addEnvelopedVirus(hiv);

        EnvelopedVirus hepatitisB = new EnvelopedVirus(
                "Hepatitis B Virus", "DNA", "icosahedral", 
                Arrays.asList("Human"), "contact", 30, "mild to severe", 0.001, 
                "lipid envelope with surface antigen proteins"
        );
        EVmenu.addEnvelopedVirus(hepatitisB);

        EnvelopedVirus varicellaZoster = new EnvelopedVirus(
                "Varicella-Zoster Virus", "DNA", "icosahedral", 
                Arrays.asList("Human"), "contact", 14, "mild to moderate", 0.001, 
                "lipid envelope with glycoprotein spikes (gC, gE, gH/gL)"
        );
        EVmenu.addEnvelopedVirus(varicellaZoster);

        EnvelopedVirus hepatitisC = new EnvelopedVirus(
                "Hepatitis C Virus", "RNA", "icosahedral", 
                Arrays.asList("Human"), "contact", 56, "moderate to severe", 0.0005, 
                "lipid envelope with glycoprotein spikes (E1, E2)"
        );
        EVmenu.addEnvelopedVirus(hepatitisC);

        EnvelopedVirus ebolaVirus = new EnvelopedVirus(
                "Ebola Virus", "RNA", "helical", 
                Arrays.asList("Human", "Bat"), "contact", 21, "severe", 0.002, 
                "lipid envelope with glycoprotein spikes (GP1,2)"
        );
        EVmenu.addEnvelopedVirus(ebolaVirus);

        EnvelopedVirus dengueVirus = new EnvelopedVirus(
                "Dengue Virus", "RNA", "icosahedral", 
                Arrays.asList("Human", "Mosquito"), "vector-borne", 7, "moderate to severe", 0.0001, 
                "lipid envelope with glycoprotein spikes"
        );
        EVmenu.addEnvelopedVirus(dengueVirus);

        EnvelopedVirus sarsCov2 = new EnvelopedVirus(
                "SARS-CoV-2", "RNA", "helical", 
                Arrays.asList("Human"), "airborne", 5, "moderate to severe", 0.01, 
                "lipid envelope with spike glycoproteins (S proteins)"
        );
        EVmenu.addEnvelopedVirus(sarsCov2);

        EnvelopedVirus measlesVirus = new EnvelopedVirus(
                "Measles Virus", "RNA", "helical", 
                Arrays.asList("Human"), "airborne", 10, "severe", 0.002, 
                "lipid envelope with hemagglutinin (H) and fusion (F) proteins"
        );
        EVmenu.addEnvelopedVirus(measlesVirus);
        
        for (EnvelopedVirus virus : EVmenu.getVirusInMenu()) {
        	EnvelopedVirus.addVirusToHost(virus.getName(), virus.getHostRange(), hostList);
        }
    }


	public static void NEVmenuStore(NonEnvelopedVirusMenu NEVmenu) {

		NonEnvelopedVirus poliovirus = new NonEnvelopedVirus(
	            "Poliovirus", "RNA", "icosahedral", Arrays.asList("Human"), 
	            "fecal-oral", 7, "severe", 0.002
	        );
		
		NEVmenu.addNonEnvelopedVirus(poliovirus);
		for (NonEnvelopedVirus virus : NEVmenu.getVirusInMenu()) {
        	EnvelopedVirus.addVirusToHost(virus.getName(), virus.getHostRange(), hostList);
        }
	}
    
    public static void main(String[] args) {
        launch(args);
    }
}