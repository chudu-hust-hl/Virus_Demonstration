package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.application.HostServices;

public class HelpPage {

    private final MainPage mainPage;
    private final Stage stage;
    private final HostServices hostServices;
    private TextArea mainBox;
    private TextFlow textFlow;

    public HelpPage(MainPage mainPage, HostServices hostServices) {
        this.mainPage = mainPage;
        this.stage = new Stage();
        this.hostServices = hostServices;
        this.mainBox = new TextArea();
        this.textFlow = new TextFlow();
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

        // Set margin and font size for mainBox
        mainBox.setPadding(new Insets(20)); // Set margin
        mainBox.setFont(new Font("Arial", 16)); // Set font size
        mainBox.setWrapText(true); // Enable text wrapping

        // Set margin and font size for textFlow
        textFlow.setPadding(new Insets(30)); // Set margin
        textFlow.setStyle("-fx-font-size: 16px; -fx-font-family: Arial;"); // Set font size and family
        
        // Add the mainBox and textFlow to the StackPane
        mainBoxPane.getChildren().addAll(mainBox, textFlow);

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
        textFlow.getChildren().clear();
        switch (sectionTitle) {
            case "Instructions":
                text = "Welcome to the Virus Demonstration Help Page. \n\n"
                		+ "This is a Java based application where you can find instructions on how to navigate through the application and access different features. \n"
                		+ "For further details, you can choose others options in the help page";
                mainBox.setText(text);
                mainBox.setVisible(true);
                mainBox.setEditable(false);
                mainBox.setWrapText(true);
                textFlow.setVisible(false);
                break;
            case "Features":
                text = "The Virus Demonstration application allows users to explore the structures and behaviors of different types of viruses.\n\n"
                		+ "To find the virus, users need to choose whether you want to investigate Enveloped virus or Non-enveloped virus"
                		+ "Then you can search for the virus you want or scroll the screen to find for you need \n\n"
                		+ "In the virus demonstration, you can find the \"INFECTING\" button to see the demonstration of infecting host cell progress";
                mainBox.setText(text);
                mainBox.setVisible(true);
                mainBox.setEditable(false);
                textFlow.setVisible(false);
                break;
            case "Virus Information":
                text = "A virus is a submicroscopic infectious agent that replicates only inside the living cells of an organism. Viruses infect all life forms, from animals and plants to microorganisms, including bacteria and archaea."
                		+ "Viruses are found in almost every ecosystem on Earth and are the most numerous type of biological entity. "
                		+ "Since Dmitri Ivanovsky's 1892 article describing a non-bacterial pathogen infecting tobacco plants and the discovery of the tobacco mosaic virus by Martinus Beijerinck in 1898, more than 11,000 of the millions of virus species have been described in detail. "
                		+ "The study of viruses is known as virology, a subspeciality of microbiology.\r\n"
                		+ "\r\n"
                		+ "When infected, a host cell is often forced to rapidly produce thousands of copies of the original virus. When not inside an infected cell or in the process of infecting a cell, viruses exist in the form of independent viral particles, or virions, consisting of "
                		+ "(i) genetic material, i.e., long molecules of DNA or RNA that encode the structure of the proteins by which the virus acts; "
                		+ "(ii) a protein coat, the capsid, which surrounds and protects the genetic material; and in some cases "
                		+ "(iii) an outside envelope of lipids. The shapes of these virus particles range from simple helical and icosahedral forms to more complex structures. Most virus species have virions too small to be seen with an optical microscope and are one-hundredth the size of most bacteria.";
                mainBox.setText(text);
                mainBox.setVisible(true);
                mainBox.setEditable(false);
                textFlow.setVisible(false);
                break;
            case "Contact":
            	text = "";
                Text contactText1 = new Text("If you have any questions or feedback about the Virus Demonstration application, feel free to contact us at our emails:");
                Text name1 =new Text("\r\nNguyen Trung Dung");
                textFlow.getChildren().add(new Text(text));
                Hyperlink emailLink1 = new Hyperlink("Dung.NT226030@sis.hust.edu.vn");
                emailLink1.setOnAction(e -> {
                    hostServices.showDocument("mailto: Dung.NT226030@sis.hust.edu.vn");
                });
                Text name2 =new Text("\r\nNguyen Ngoc Hung");
                textFlow.getChildren().add(new Text(text));
                Hyperlink emailLink2 = new Hyperlink("Hung.NN226044@sis.hust.edu.vn");
                emailLink2.setOnAction(e -> {
                    hostServices.showDocument("mailto: Hung.NN226044@sis.hust.edu.vn");
                });
                Text name3 =new Text("\r\nNguyen Phuong Anh");
                textFlow.getChildren().add(new Text(text));
                Hyperlink emailLink3 = new Hyperlink("Anh.NP226011@sis.hust.edu.vn");
                emailLink3.setOnAction(e -> {
                    hostServices.showDocument("mailto: Anh.NP226011@sis.hust.edu.vn");
                });
                Text name4 =new Text("\r\nNguyen Le Dang Khoa");
                textFlow.getChildren().add(new Text(text));
                Hyperlink emailLink4 = new Hyperlink("Khoa.NLD226049@sis.hust.edu.vn");
                emailLink4.setOnAction(e -> {
                    hostServices.showDocument("mailto: Khoa.NLD226049@sis.hust.edu.vn");
                });
                
                Text contactText2 = new Text("\r\n\nWe are students from 147839 OOP class in semester 20232\r\n"
                		+ "Supervisor: Mr. Tran The Hung");
                
                textFlow.getChildren().addAll(contactText1, name1, emailLink1, name2, emailLink2, name3, emailLink3, name4, emailLink4, contactText2);
                mainBox.setText(text);
                mainBox.setVisible(true);
                mainBox.setEditable(false);
                textFlow.setVisible(true);
                break;
            case "Resources":
            	text = "We have learnt from bla bla";
            	mainBox.setText(text);
                mainBox.setVisible(true);
                mainBox.setEditable(false);
                textFlow.setVisible(false);
                break;
            	
        }
        if (!text.isEmpty()) {
            textFlow.getChildren().setAll(new Text(text));
        }
    }
}