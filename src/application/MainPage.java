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

import javax.swing.JFrame;

import VirusInformation.EnvelopedVirus;
import VirusInformation.NonEnvelopedVirus;
import VirusMenu.EnvelopedVirusMenu;
import VirusMenu.NonEnvelopedVirusMenu;

public class MainPage extends Application {

	private Stage primaryStage;
    private JFrame mainFrame; // Reference to the main Swing frame

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
    	javax.swing.SwingUtilities.invokeLater(() -> {
            new EnvelopedPage(this, EVmenu, getHostServices());
        });
    }
    
    private void showNonEnvelopedPage() {
    	primaryStage.close(); // Close the main page
    	NonEnvelopedVirusMenu NEVmenu = new NonEnvelopedVirusMenu(); 
    	NEVmenuStore(NEVmenu);
    	javax.swing.SwingUtilities.invokeLater(() -> {
            new NonEnvelopedPage(this, NEVmenu, getHostServices());
        });
    }



    public void returnToMainPage() {
        primaryStage.show();
    }
    
    public static void EVmenuStore(EnvelopedVirusMenu EVmenu) {
        
        EnvelopedVirus herpesSimplexVirus = new EnvelopedVirus(
            "Herpes Simplex Virus", "DNA", "icosahedral", "humans", 
            "contact", 2, "mild to severe", 0.001, 
            "lipid envelope with glycoprotein spikes (gB, gD, gH, gL)"
        );
        EVmenu.addEnvelopedVirus(herpesSimplexVirus);

        EnvelopedVirus influenzaVirus = new EnvelopedVirus(
            "Influenza Virus", "RNA", "segmented", "humans", 
            "aerosol", 1, "mild to severe", 0.01, 
            "lipid envelope with glycoprotein spikes (hemagglutinin (HA) and neuraminidase (NA))"
        );
        EVmenu.addEnvelopedVirus(influenzaVirus);

        EnvelopedVirus hiv = new EnvelopedVirus(
            "HIV (Human Immunodeficiency Virus)", "RNA", "complex", "humans", 
            "bodily fluids", 3, "severe", 0.02, 
            "lipid envelope with glycoprotein spikes (gp120 and gp41)"
        );
        EVmenu.addEnvelopedVirus(hiv);

        EnvelopedVirus hepatitisB = new EnvelopedVirus(
            "Hepatitis B Virus", "DNA", "partially double-stranded", "humans", 
            "bodily fluids", 1, "mild to severe", 0.001, 
            "lipid envelope with surface antigen proteins"
        );
        EVmenu.addEnvelopedVirus(hepatitisB);

        EnvelopedVirus varicellaZosterVirus = new EnvelopedVirus(
            "Varicella-Zoster Virus", "DNA", "icosahedral", "humans", 
            "contact", 2, "mild to severe", 0.001, 
            "lipid envelope with glycoprotein spikes (gC, gE, and gH/gL)"
        );
        EVmenu.addEnvelopedVirus(varicellaZosterVirus);

        EnvelopedVirus hepatitisC = new EnvelopedVirus(
            "Hepatitis C Virus", "RNA", "single-stranded", "humans", 
            "blood contact", 2, "mild to severe", 0.02, 
            "lipid envelope with glycoprotein spikes (E1 and E2)"
        );
        EVmenu.addEnvelopedVirus(hepatitisC);

        EnvelopedVirus ebolaVirus = new EnvelopedVirus(
            "Ebola Virus", "RNA", "helical", "humans and primates", 
            "bodily fluids", 2, "severe", 0.5, 
            "lipid envelope with glycoprotein spikes (GP1,2)"
        );
        EVmenu.addEnvelopedVirus(ebolaVirus);

        EnvelopedVirus dengueVirus = new EnvelopedVirus(
            "Dengue Virus", "RNA", "single-stranded", "humans", 
            "mosquito bite", 4, "mild to severe", 0.03, 
            "lipid envelope with glycoprotein spikes"
        );
        EVmenu.addEnvelopedVirus(dengueVirus);

        EnvelopedVirus sarsCov2 = new EnvelopedVirus(
            "SARS-CoV-2", "RNA", "helical", "humans", 
            "aerosol", 3, "mild to severe", 0.02, 
            "lipid envelope with spike glycoproteins (S proteins)"
        );
        EVmenu.addEnvelopedVirus(sarsCov2);

        EnvelopedVirus measlesVirus = new EnvelopedVirus(
            "Measles Virus", "RNA", "helical", "humans", 
            "aerosol", 1, "mild to severe", 0.01, 
            "lipid envelope with glycoprotein spikes (hemagglutinin (H) and fusion (F) proteins)"
        );
        EVmenu.addEnvelopedVirus(measlesVirus);
    }

    public static void NEVmenuStore(NonEnvelopedVirusMenu NEVmenu) {

		NonEnvelopedVirus poliovirus = new NonEnvelopedVirus(
	            "Poliovirus", "RNA", "icosahedral", "humans", 
	            "fecal-oral", 7, "severe", 0.002
	        );
		
		NEVmenu.addNonEnvelopedVirus(poliovirus);
	}
    
    public static void main(String[] args) {
        launch(args);
    }
}
