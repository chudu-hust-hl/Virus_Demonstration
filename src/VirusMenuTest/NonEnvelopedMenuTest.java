package VirusMenuTest;

import VirusInformation.NonEnvelopedVirus;
import VirusMenu.NonEnvelopedVirusMenu;

public class NonEnvelopedMenuTest {

	public static void main(String[] args) {
		NonEnvelopedVirusMenu menu = new NonEnvelopedVirusMenu();

		NonEnvelopedVirus poliovirus = new NonEnvelopedVirus(
	            "Poliovirus", "RNA", "icosahedral", "humans", 
	            "fecal-oral", 7, "severe", 0.002
	        );
		
		menu.addNonEnvelopedVirus(poliovirus);
	}

}
