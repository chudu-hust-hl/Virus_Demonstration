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
            System.out.println(virus.getName());
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
	
	
	
	
	public ArrayList<EnvelopedVirus> getVirusInMenu() {
		return virusInMenu;
	}

	public void setVirusInMenu(ArrayList<EnvelopedVirus> virusInMenu) {
		this.virusInMenu = virusInMenu;
	}
}
