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

        EnvelopedVirus influenzaVirus = new EnvelopedVirus(
            "Influenza Virus", "RNA", "segmented", "humans", 
            "aerosol", 1, "mild to severe", 0.01, 
            "lipid envelope with glycoprotein spikes (hemagglutinin (HA) and neuraminidase (NA))"
        );
        menu.addEnvelopedVirus(influenzaVirus);

        EnvelopedVirus hiv = new EnvelopedVirus(
            "HIV (Human Immunodeficiency Virus)", "RNA", "complex", "humans", 
            "bodily fluids", 3, "severe", 0.02, 
            "lipid envelope with glycoprotein spikes (gp120 and gp41)"
        );
        menu.addEnvelopedVirus(hiv);

        EnvelopedVirus hepatitisB = new EnvelopedVirus(
            "Hepatitis B Virus", "DNA", "partially double-stranded", "humans", 
            "bodily fluids", 1, "mild to severe", 0.001, 
            "lipid envelope with surface antigen proteins"
        );
        menu.addEnvelopedVirus(hepatitisB);

        EnvelopedVirus varicellaZosterVirus = new EnvelopedVirus(
            "Varicella-Zoster Virus", "DNA", "icosahedral", "humans", 
            "contact", 2, "mild to severe", 0.001, 
            "lipid envelope with glycoprotein spikes (gC, gE, and gH/gL)"
        );
        menu.addEnvelopedVirus(varicellaZosterVirus);

        EnvelopedVirus hepatitisC = new EnvelopedVirus(
            "Hepatitis C Virus", "RNA", "single-stranded", "humans", 
            "blood contact", 2, "mild to severe", 0.02, 
            "lipid envelope with glycoprotein spikes (E1 and E2)"
        );
        menu.addEnvelopedVirus(hepatitisC);

        EnvelopedVirus ebolaVirus = new EnvelopedVirus(
            "Ebola Virus", "RNA", "helical", "humans and primates", 
            "bodily fluids", 2, "severe", 0.5, 
            "lipid envelope with glycoprotein spikes (GP1,2)"
        );
        menu.addEnvelopedVirus(ebolaVirus);

        EnvelopedVirus dengueVirus = new EnvelopedVirus(
            "Dengue Virus", "RNA", "single-stranded", "humans", 
            "mosquito bite", 4, "mild to severe", 0.03, 
            "lipid envelope with glycoprotein spikes"
        );
        menu.addEnvelopedVirus(dengueVirus);

        EnvelopedVirus sarsCov2 = new EnvelopedVirus(
            "SARS-CoV-2", "RNA", "helical", "humans", 
            "aerosol", 3, "mild to severe", 0.02, 
            "lipid envelope with spike glycoproteins (S proteins)"
        );
        menu.addEnvelopedVirus(sarsCov2);

        EnvelopedVirus measlesVirus = new EnvelopedVirus(
            "Measles Virus", "RNA", "helical", "humans", 
            "aerosol", 1, "mild to severe", 0.01, 
            "lipid envelope with glycoprotein spikes (hemagglutinin (H) and fusion (F) proteins)"
        );
        menu.addEnvelopedVirus(measlesVirus);

        // Display all enveloped viruses added to the menu
        menu.displayAllEnvelopedViruses();
    }
}
