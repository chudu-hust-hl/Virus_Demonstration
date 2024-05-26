package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import VirusInformation.EnvelopedVirus;
import VirusMenu.EnvelopedVirusMenu;
import javafx.application.HostServices;


public class EnvelopedPage extends JFrame {
    private EnvelopedVirusMenu menu;
    private final MainPage mainPage;
    private final HostServices hostServices;

    public EnvelopedPage(MainPage mainPage, EnvelopedVirusMenu menu, HostServices hostServices) {
        this.mainPage = new MainPage();
		this.menu = menu;
		this.hostServices = hostServices;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Enveloped Virus");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createHeader());
        north.add(createSearchBox());
        return north;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("Enveloped Virus");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createSearchBox() {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        JTextField searchBox = new JTextField();
        searchBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchVirus(searchBox.getText());
            }
        });
        searchPanel.add(searchBox);
        searchPanel.add(searchButton);
        return searchPanel;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3, 2, 2)); // Dynamically set rows, fixed 3 columns

        for (EnvelopedVirus virus : menu.virusInMenu) {
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
}
