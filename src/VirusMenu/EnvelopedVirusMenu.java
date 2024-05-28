package VirusMenu;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import VirusInformation.EnvelopedVirus;

public class EnvelopedVirusMenu {
	private static final int MAX_ITEMS_IN_MENU = 50;
	public ArrayList<EnvelopedVirus> virusInMenu = new ArrayList<>();
	
	public void addEnvelopedVirus(EnvelopedVirus virus) {
		if (getVirusInMenu().size() >= MAX_ITEMS_IN_MENU) {
			 JOptionPane.showMessageDialog(null, "The menu is full!", "Menu update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			getVirusInMenu().add(virus);
			//JOptionPane.showMessageDialog(null, "The virus has been added", "Menu update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void addEnvelopedVirus(EnvelopedVirus[] virusList) {
		if (getVirusInMenu().size()+virusList.length>= MAX_ITEMS_IN_MENU) {
			 JOptionPane.showMessageDialog(null, "The menu is full!", "Menu update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(int j=0; j<virusList.length;j++) {
				addEnvelopedVirus(virusList[j]);
			}
			//JOptionPane.showMessageDialog(null, "The virus list has been added", "Menu update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void displayAllEnvelopedViruses() {
        for (EnvelopedVirus virus : virusInMenu) {
        	System.out.println("Virus Name: " + virus.getName());
            System.out.println("Genetic Material Type: " + virus.getGeneticMaterialType());
            System.out.println("Capsid Shape: " + virus.getCapsidShape());
            System.out.println("Host Range: " + virus.getHostRange());
            System.out.println("Transmission Mode: " + virus.getTransmissionMode());
            System.out.println("Incubation Period: " + virus.getIncubationPeriod() + " days");
            System.out.println("Severity: " + virus.getSeverity());
            System.out.println("Mutation Rate: " + virus.getMutationRate() + " mutations per cycle");
        }
    }
	
	public ArrayList<EnvelopedVirus> searchByName(String phrase) {
        ArrayList<EnvelopedVirus> matchingViruses = new ArrayList<>();
        for (EnvelopedVirus virus : virusInMenu) {
            if (virus.getName().toLowerCase().contains(phrase.toLowerCase())) {
                matchingViruses.add(virus);
            }
        }
        return matchingViruses;
    }
	
	public ArrayList<EnvelopedVirus> searchByHostType(String hostType) {
        ArrayList<EnvelopedVirus> searchResults = new ArrayList<>();
        for (EnvelopedVirus virus : virusInMenu) {
            if (virus.getHostRange().contains(hostType)) {
                searchResults.add(virus);
            }
        }
        return searchResults;
    }
	
	public ArrayList<EnvelopedVirus> searchByGeneticMaterial(String geneticMaterialType) {
        ArrayList<EnvelopedVirus> searchResults = new ArrayList<>();
        for (EnvelopedVirus virus : virusInMenu) {
            if (virus.getGeneticMaterialType().equalsIgnoreCase(geneticMaterialType)) {
                searchResults.add(virus);
            }
        }
        return searchResults;
    }
	
	
	
	
	public ArrayList<EnvelopedVirus> getVirusInMenu() {
		return virusInMenu;
	}

	public void setVirusInMenu(ArrayList<EnvelopedVirus> virusInMenu) {
		this.virusInMenu = virusInMenu;
	}
}
