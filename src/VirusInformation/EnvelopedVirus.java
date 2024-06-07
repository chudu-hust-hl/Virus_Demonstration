package VirusInformation;

import java.util.List;

import javafx.scene.image.Image;

public class EnvelopedVirus extends NonEnvelopedVirus {
    private String envelopeComposition; // Additional attribute specific to enveloped viruses

    public EnvelopedVirus(String name, String family, String geneticMaterialType, String capsidShape, 
            List<String> hostRange, String transmissionMode, int incubationPeriod, 
            String severity, double mutationRate, Image strucImage, String infectVid, String envelopeComposition) {
        super(name, family, geneticMaterialType, capsidShape, hostRange, transmissionMode, 
              incubationPeriod, severity, mutationRate,strucImage, infectVid);
        this.envelopeComposition = envelopeComposition;
    }


	public String getEnvelopeComposition() {
        return envelopeComposition;
    }

    public void setEnvelopeComposition(String envelopeComposition) {
        this.envelopeComposition = envelopeComposition;
    }
}
