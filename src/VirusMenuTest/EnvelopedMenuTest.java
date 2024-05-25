package VirusMenuTest;

import VirusInformation.EnvelopedVirus;
import VirusMenu.EnvelopedVirusMenu;

public class EnvelopedMenuTest {
	public static void main(String[] args) {
		EnvelopedVirusMenu menu = new EnvelopedVirusMenu();
		
		EnvelopedVirus herpesSimplexVirus = new EnvelopedVirus(
	            "Herpes Simplex Virus", "DNA", "icosahedral", "humans", 
	            "contact", 2, "mild to severe", 0.001, 
	            "lipid envelope with glycoprotein spikes (gB, gD, gH, gL)"
	        );
		menu.addEnvelopedVirus(herpesSimplexVirus);
	}
}
