package VirusMenuTest;

import VirusInformation.EnvelopedVirus;
import VirusMenu.EnvelopedVirusMenu;
import java.util.Arrays;

public class EnvelopedMenuTest {
    public static void main(String[] args) {
        EnvelopedVirusMenu menu = new EnvelopedVirusMenu();

        EnvelopedVirus herpesSimplexVirus = new EnvelopedVirus(
                "Herpes Simplex Virus", "DNA", "icosahedral", 
                Arrays.asList("Human"), "contact", 2, "mild to severe", 0.001, 
                "lipid envelope with glycoprotein spikes (gB, gD, gH, gL)"
        );
        menu.addEnvelopedVirus(herpesSimplexVirus);

        EnvelopedVirus influenzaVirus = new EnvelopedVirus(
                "Influenza Virus", "RNA", "segmented", 
                Arrays.asList("Human", "Bird"), "airborne", 1, "moderate to severe", 0.01, 
                "lipid envelope with hemagglutinin (HA) and neuraminidase (NA)"
        );
        menu.addEnvelopedVirus(influenzaVirus);

        EnvelopedVirus hiv = new EnvelopedVirus(
                "HIV", "RNA", "complex", 
                Arrays.asList("Human", "Primate"), "contact", 14, "severe", 0.003, 
                "lipid envelope with glycoprotein spikes (gp120, gp41)"
        );
        menu.addEnvelopedVirus(hiv);

        EnvelopedVirus hepatitisB = new EnvelopedVirus(
                "Hepatitis B Virus", "DNA", "icosahedral", 
                Arrays.asList("Human"), "contact", 30, "mild to severe", 0.001, 
                "lipid envelope with surface antigen proteins"
        );
        menu.addEnvelopedVirus(hepatitisB);

        EnvelopedVirus varicellaZoster = new EnvelopedVirus(
                "Varicella-Zoster Virus", "DNA", "icosahedral", 
                Arrays.asList("Human"), "contact", 14, "mild to moderate", 0.001, 
                "lipid envelope with glycoprotein spikes (gC, gE, gH/gL)"
        );
        menu.addEnvelopedVirus(varicellaZoster);

        EnvelopedVirus hepatitisC = new EnvelopedVirus(
                "Hepatitis C Virus", "RNA", "icosahedral", 
                Arrays.asList("Human"), "contact", 56, "moderate to severe", 0.0005, 
                "lipid envelope with glycoprotein spikes (E1, E2)"
        );
        menu.addEnvelopedVirus(hepatitisC);

        EnvelopedVirus ebolaVirus = new EnvelopedVirus(
                "Ebola Virus", "RNA", "helical", 
                Arrays.asList("Human", "Bat"), "contact", 21, "severe", 0.002, 
                "lipid envelope with glycoprotein spikes (GP1,2)"
        );
        menu.addEnvelopedVirus(ebolaVirus);

        EnvelopedVirus dengueVirus = new EnvelopedVirus(
                "Dengue Virus", "RNA", "icosahedral", 
                Arrays.asList("Human", "Mosquito"), "vector-borne", 7, "moderate to severe", 0.0001, 
                "lipid envelope with glycoprotein spikes"
        );
        menu.addEnvelopedVirus(dengueVirus);

        EnvelopedVirus sarsCov2 = new EnvelopedVirus(
                "SARS-CoV-2", "RNA", "helical", 
                Arrays.asList("Human"), "airborne", 5, "moderate to severe", 0.01, 
                "lipid envelope with spike glycoproteins (S proteins)"
        );
        menu.addEnvelopedVirus(sarsCov2);

        EnvelopedVirus measlesVirus = new EnvelopedVirus(
                "Measles Virus", "RNA", "helical", 
                Arrays.asList("Human"), "airborne", 10, "severe", 0.002, 
                "lipid envelope with hemagglutinin (H) and fusion (F) proteins"
        );
        menu.addEnvelopedVirus(measlesVirus);

        // Display all viruses
        menu.displayAllEnvelopedViruses();
    }
}
