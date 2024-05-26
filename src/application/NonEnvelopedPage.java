package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import VirusInformation.NonEnvelopedVirus;
import VirusMenu.NonEnvelopedVirusMenu;
import javafx.application.HostServices;


public class NonEnvelopedPage extends JFrame {
    private NonEnvelopedVirusMenu menu;
    private final MainPage mainPage;
    private final HostServices hostServices;

    public NonEnvelopedPage(MainPage mainPage, NonEnvelopedVirusMenu menu, HostServices hostServices) {
        this.mainPage = new MainPage();
		this.menu = menu;
		this.hostServices = null;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("NonEnveloped Virus");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createHeader());
        north.add(createSearchAndReturnBox());
        return north;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("NonEnveloped Virus");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createSearchAndReturnBox() {
    	JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());

        // Create the search box
        JTextField searchBox = new JTextField();
        searchBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        // Create the search button
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchVirus(searchBox.getText()));

        // Create the return to main button
        JButton returnButton = new JButton("Return to Main");
        returnButton.addActionListener(e -> returnToMain());

        // Add components to the search panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(returnButton);

        searchPanel.add(searchBox, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.LINE_END);
        searchPanel.add(buttonPanel, BorderLayout.PAGE_END);

        // Set the preferred width of the search panel to one-third of the page width
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int searchPanelWidth = screenWidth / 3;
        searchPanel.setPreferredSize(new Dimension(searchPanelWidth, 50));

        return searchPanel;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3, 2, 2)); // Dynamically set rows, fixed 3 columns

        for (NonEnvelopedVirus virus : menu.virusInMenu) {
        	String VirusLabel = virus.getName();
            JLabel label = new JLabel(VirusLabel);
            label.setOpaque(true);
            label.setBackground(Color.LIGHT_GRAY);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            center.add(label);
        }

        JScrollPane scrollPane = new JScrollPane(center);
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        return centerPanel;
    }

    private void searchVirus(String virusName) {
        System.out.println("Searching for virus: " + virusName);
        // Implement your search logic here
    }
    
    private void returnToMain() {
        // Hide or close the current frame
        dispose(); // For closing

        // Show the main page again
        //mainPage.returnToMainPage();
    }

	public HostServices getHostServices() {
		return hostServices;
	}
}
