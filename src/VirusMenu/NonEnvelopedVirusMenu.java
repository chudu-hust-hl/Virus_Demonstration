package VirusMenu;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import VirusInformation.EnvelopedVirus;
import VirusInformation.NonEnvelopedVirus;

public class NonEnvelopedVirusMenu {
	private static final int MAX_ITEMS_IN_MENU = 50;
	public ArrayList<NonEnvelopedVirus> virusInMenu = new ArrayList<>();
	
	public void addNonEnvelopedVirus(NonEnvelopedVirus virus) {
		if (getVirusInMenu().size() >= MAX_ITEMS_IN_MENU) {
			 JOptionPane.showMessageDialog(null, "The menu is full!", "Menu update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			getVirusInMenu().add(virus);
			//JOptionPane.showMessageDialog(null, "The virus has been added", "Menu update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void addNonEnvelopedVirus(NonEnvelopedVirus[] virusList) {
		if (getVirusInMenu().size()+virusList.length>= MAX_ITEMS_IN_MENU) {
			 JOptionPane.showMessageDialog(null, "The menu is full!", "Menu update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(int j=0; j<virusList.length;j++) {
				addNonEnvelopedVirus(virusList[j]);
			}
			//JOptionPane.showMessageDialog(null, "The virus list has been added", "Menu update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public ArrayList<NonEnvelopedVirus> searchByName(String phrase) {
        ArrayList<NonEnvelopedVirus> matchingViruses = new ArrayList<>();
        for (NonEnvelopedVirus virus : virusInMenu) {
            if (virus.getName().toLowerCase().contains(phrase.toLowerCase())) {
                matchingViruses.add(virus);
            }
        }
        return matchingViruses;
    }
	
	
	
	
	public ArrayList<NonEnvelopedVirus> getVirusInMenu() {
		return virusInMenu;
	}

	public void setVirusInMenu(ArrayList<NonEnvelopedVirus> virusInMenu) {
		this.virusInMenu = virusInMenu;
	}
}
