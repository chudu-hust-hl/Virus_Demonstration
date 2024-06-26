package application;

import java.util.Arrays;
import java.util.Optional;

import javax.swing.JFrame;

import Host.HostList;
import VirusInformation.EnvelopedVirus;
import VirusInformation.NonEnvelopedVirus;
import VirusMenu.EnvelopedVirusMenu;
import VirusMenu.NonEnvelopedVirusMenu;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
        Button quitButton = new Button("Quit");

        // Set button styles
        String buttonStyle = "-fx-background-color: indigo; -fx-text-fill: white; -fx-pref-width: 200px; -fx-pref-height: 50px;";
        String quitStyle = "-fx-background-color: red; -fx-text-fill: white; -fx-pref-width: 200px; -fx-pref-height: 50px;";
        envelopedVirusButton.setStyle(buttonStyle);
        nonEnvelopedVirusButton.setStyle(buttonStyle);
        helpButton.setStyle(buttonStyle);
        quitButton.setStyle(quitStyle);
        

        // Button actions
        envelopedVirusButton.setOnAction(e -> showEnvelopedPage());
        nonEnvelopedVirusButton.setOnAction(e -> showNonEnvelopedPage());
        helpButton.setOnAction(e -> showHelpPage());
        quitButton.setOnAction(e -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirm Exit");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to quit?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                closeMainPage();
            }
        });

        // Add components to a VBox
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titleLabel, envelopedVirusButton, nonEnvelopedVirusButton, helpButton, quitButton);
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
    
    
    public void closeMainPage() {
    	primaryStage.close();
    }
    
    public static void EVmenuStore(EnvelopedVirusMenu EVmenu) {
        
    	EnvelopedVirus herpesSimplexVirus = new EnvelopedVirus(
		    "Herpes Simplex Virus", "Herpesviridae", "DNA", "icosahedral",
		    Arrays.asList("Human"), "contact", 2, "mild to severe", 0.001,
		    new Image("file:Enveloped/Herpes Simplex Virus (Herpesviridae).png"), 
		    "EnvelopedVideo\\Herpes Simplex Virus.mp4",
		    "lipid envelope with glycoprotein spikes (gB, gD, gH, gL)"
		);
		EVmenu.addEnvelopedVirus(herpesSimplexVirus);

		EnvelopedVirus influenzaVirus = new EnvelopedVirus(
		    "Influenza Virus", "Orthomyxoviridae", "RNA", "segmented",
		    Arrays.asList("Human", "Bird"), "airborne", 1, "moderate to severe", 0.01,
		    new Image("file:Enveloped\\Influena_virus.jpg"), 
		    "EnvelopedVideo\\Influenza Virus.mp4",
		    "lipid envelope with hemagglutinin (HA) and neuraminidase (NA)"
		);
		EVmenu.addEnvelopedVirus(influenzaVirus);

		EnvelopedVirus hiv = new EnvelopedVirus(
		    "HIV", "Retroviridae", "RNA", "complex",
		    Arrays.asList("Human", "Primate"), "contact", 14, "severe", 0.003,
		    new Image("file:Enveloped\\HIV (Retroviridae).png"), 
		    "EnvelopedVideo\\HIV.mp4",
		    "lipid envelope with glycoprotein spikes (gp120, gp41)"
		);
		EVmenu.addEnvelopedVirus(hiv);

		EnvelopedVirus hepatitisB = new EnvelopedVirus(
		    "Hepatitis B Virus", "Hepadnaviridae", "DNA", "icosahedral",
		    Arrays.asList("Human"), "contact", 30, "mild to severe", 0.001,
		    new Image("file:Enveloped\\Hepatitis B Virus (Hepadnaviridae).jpeg"), 
		    "EnvelopedVideo\\Hepatitis B.mp4",
		    "lipid envelope with surface antigen proteins"
		);
		EVmenu.addEnvelopedVirus(hepatitisB);

		EnvelopedVirus varicellaZoster = new EnvelopedVirus(
		    "Varicella-Zoster Virus", "Herpesviridae", "DNA", "icosahedral",
		    Arrays.asList("Human"), "contact", 14, "mild to moderate", 0.001,
		    new Image("file:Enveloped\\Varicella-Zoster Virus (Herpesviridae).jpg"), 
		    "EnvelopedVideo\\VZV.mp4",
		    "lipid envelope with glycoprotein spikes (gC, gE, gH/gL)"
		);
		EVmenu.addEnvelopedVirus(varicellaZoster);

		EnvelopedVirus hepatitisC = new EnvelopedVirus(
		    "Hepatitis C Virus", "Flaviviridae", "RNA", "icosahedral",
		    Arrays.asList("Human"), "contact", 56, "moderate to severe", 0.0005,
		    new Image("file:Enveloped\\Hepatitis C Virus (Flaviviridae).jpeg"), 
		    "EnvelopedVideo\\Hepatitis C.mp4",
		    "lipid envelope with glycoprotein spikes (E1, E2)"
		);
		EVmenu.addEnvelopedVirus(hepatitisC);

		EnvelopedVirus ebolaVirus = new EnvelopedVirus(
		    "Ebola Virus", "Filoviridae", "RNA", "helical",
		    Arrays.asList("Human", "Bat"), "contact", 21, "severe", 0.002,
		    new Image("file:Enveloped\\Ebola Virus.png"), 
		    "EnvelopedVideo\\Ebola.mp4",
		    "lipid envelope with glycoprotein spikes (GP1,2)"
		);
		EVmenu.addEnvelopedVirus(ebolaVirus);

		EnvelopedVirus dengueVirus = new EnvelopedVirus(
		    "Dengue Virus", "Flaviviridae", "RNA", "icosahedral",
		    Arrays.asList("Human", "Mosquito"), "vector-borne", 7, "moderate to severe", 0.0001,
		    new Image("file:Enveloped\\Dengue Virus (Flaviviridae).jpeg"), 
		    "file:D:/HUST ICT/VirusDemonstration/Virus_Demonstration/Enveloped/Dengue Virus (Flaviviridae).mp4",
		    "lipid envelope with glycoprotein spikes"
		);
		EVmenu.addEnvelopedVirus(dengueVirus);

		EnvelopedVirus sarsCov2 = new EnvelopedVirus(
		    "SARS-CoV-2", "Coronaviridae", "RNA", "helical",
		    Arrays.asList("Human"), "airborne", 5, "moderate to severe", 0.01,
		    new Image("file:Enveloped\\SARS-CoV-2 (Coronaviridae).jpeg"), 
		    "EnvelopedVideo\\Corona.mp4",
		    "lipid envelope with spike glycoproteins (S proteins)"
		);
		EVmenu.addEnvelopedVirus(sarsCov2);

		EnvelopedVirus measlesVirus = new EnvelopedVirus(
		    "Measles Virus", "Paramyxoviridae", "RNA", "helical",
		    Arrays.asList("Human"), "airborne", 10, "severe", 0.002,
		    new Image("file:Enveloped\\Measles Virus (Paramyxoviridae).jpeg"), 
		    "EnvelopedVideo\\Measles.mp4",
		    "lipid envelope with hemagglutinin (H) and fusion (F) proteins"
		);
		EVmenu.addEnvelopedVirus(measlesVirus);


        
        for (EnvelopedVirus virus : EVmenu.getVirusInMenu()) {
        	EnvelopedVirus.addVirusToHost(virus.getName(), virus.getHostRange(), hostList);
        }
        
        EVmenu.sortVirusesByName();
    }


    //This is the non-enveloped Virus
	public static void NEVmenuStore(NonEnvelopedVirusMenu NEVmenu) {

		NonEnvelopedVirus rhinovirus = new NonEnvelopedVirus(
	            "Rhinovirus", 
	            "Picornaviridae", 
	            "RNA", 
	            "icosahedral", 
	            Arrays.asList("Human"), 
	            "contact", 
	            2, 
	            "mild to severe", 
	            0.001, 
	            new Image("file:NonEnveloped\\Rhinovirus (Picornaviridae).png"), 
	            "NonEnvelopedVideo\\Rhino.mp4"
	        );
	        NEVmenu.addNonEnvelopedVirus(rhinovirus);

	        NonEnvelopedVirus poliovirus = new NonEnvelopedVirus(
	            "Poliovirus", 
	            "Picornaviridae", 
	            "RNA", 
	            "icosahedral", 
	            Arrays.asList("Human"), 
	            "contact", 
	            7, 
	            "severe", 
	            0.002, 
	            new Image("file:NonEnveloped\\poliovirus.png"), 
	            "D:\\HUST ICT\\VirusDemonstration\\Virus_Demonstration\\NonEnveloped\\Poliovirus.mp4"
	        );
	        NEVmenu.addNonEnvelopedVirus(poliovirus);

	        NonEnvelopedVirus adenovirus = new NonEnvelopedVirus(
	            "Adenovirus", 
	            "Adenoviridae", 
	            "DNA", 
	            "icosahedral", 
	            Arrays.asList("Human"), 
	            "airborne", 
	            5, 
	            "mild to severe", 
	            0.0005, 
	            new Image("file:NonEnveloped\\Adenovirus (Adenoviridae).jpeg"), 
	            "NonEnvelopedVideo\\Adenovirus.mp4"
	        );
	        NEVmenu.addNonEnvelopedVirus(adenovirus);

	        NonEnvelopedVirus norovirus = new NonEnvelopedVirus(
	            "Norovirus", 
	            "Caliciviridae", 
	            "RNA", 
	            "icosahedral", 
	            Arrays.asList("Human"), 
	            "contact", 
	            1, 
	            "moderate to severe", 
	            0.0007, 
	            new Image("file:NonEnveloped\\Norovirus (Caliciviridae).jpeg"), 
	            "NonEnvelopedVideo\\Norovirus.mp4\""
	        );
	        NEVmenu.addNonEnvelopedVirus(norovirus);

	        NonEnvelopedVirus rotavirus = new NonEnvelopedVirus(
	            "Rotavirus", 
	            "Reoviridae", 
	            "RNA", 
	            "icosahedral", 
	            Arrays.asList("Human"), 
	            "contact", 
	            2, 
	            "moderate to severe", 
	            0.0008, 
	            new Image("file:NonEnveloped\\Rotavirus (Reoviridae).jpeg"), 
	            "NonEnvelopedVideo\\Rota.mp4"
	        );
	        NEVmenu.addNonEnvelopedVirus(rotavirus);

	        NonEnvelopedVirus hepatitisA = new NonEnvelopedVirus(
	            "Hepatitis A Virus", 
	            "Picornaviridae", 
	            "RNA", 
	            "icosahedral", 
	            Arrays.asList("Human"), 
	            "contact", 
	            28, 
	            "mild to severe", 
	            0.0001, 
	            new Image("file:NonEnveloped\\Hepatitis A (Picornaviridae).PNG"), 
	            "NonEnvelopedVideo\\Hepatitis A.mp4"
	        );
	        NEVmenu.addNonEnvelopedVirus(hepatitisA);

	        NonEnvelopedVirus papillomavirus = new NonEnvelopedVirus(
	            "Papillomavirus", 
	            "Papillomaviridae", 
	            "DNA", 
	            "icosahedral", 
	            Arrays.asList("Human"), 
	            "contact", 
	            30, 
	            "mild to moderate", 
	            0.0002, 
	            new Image("file:NonEnveloped\\papiloma.png"), 
	            "D:\\HUST ICT\\VirusDemonstration\\Virus_Demonstration\\NonEnveloped\\Papillomavirus.mp4"
	        );
	        NEVmenu.addNonEnvelopedVirus(papillomavirus);

	        NonEnvelopedVirus hepatitisE = new NonEnvelopedVirus(
	            "Hepatitis E Virus", 
	            "Hepeviridae", 
	            "RNA", 
	            "icosahedral", 
	            Arrays.asList("Human"), 
	            "contact", 
	            40, 
	            "mild to severe", 
	            0.0003, 
	            new Image("file:NonEnveloped\\Hepatis E.jpg"), 
	            "D:\\HUST ICT\\VirusDemonstration\\Virus_Demonstration\\NonEnveloped\\Hepatitis E Virus.mp4"
	        );
	        NEVmenu.addNonEnvelopedVirus(hepatitisE);

	        NonEnvelopedVirus humanPapillomavirus = new NonEnvelopedVirus(
	            "Human Papillomavirus", 
	            "Papillomaviridae", 
	            "DNA", 
	            "icosahedral", 
	            Arrays.asList("Human"), 
	            "contact", 
	            25, 
	            "mild to moderate", 
	            0.0002, 
	            new Image("file:NonEnveloped\\Human Papillomavirus (Papillomaviridae).jpeg"), 
	            "NonEnvelopedVideo\\Human Papillomarvirus.mp4"
	        );
	        NEVmenu.addNonEnvelopedVirus(humanPapillomavirus);

	        NonEnvelopedVirus rabies = new NonEnvelopedVirus(
	            "Rabies Virus", 
	            "Rhabdoviridae", 
	            "RNA", 
	            "helical", 
	            Arrays.asList("Human", "Mammal"), 
	            "contact", 
	            60, 
	            "severe", 
	            0.0004, 
	            new Image("file:NonEnveloped\\Rabies Virus (Rhabdoviridae).jpeg"), 
	            "NonEnvelopedVideo\\Rabies.mp4"
	        );
	        NEVmenu.addNonEnvelopedVirus(rabies);
		for (NonEnvelopedVirus virus : NEVmenu.getVirusInMenu()) {
        	EnvelopedVirus.addVirusToHost(virus.getName(), virus.getHostRange(), hostList);
        }
		NEVmenu.sortVirusesByName();
	}
    
    public static void main(String[] args) {
        launch(args);
    }
}