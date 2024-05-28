package VirusInformation;

import java.util.List;

public class EnvelopedVirus extends Virus {
    private String envelopeComposition; // Additional attribute specific to enveloped viruses

    public EnvelopedVirus(String name, String geneticMaterialType, String capsidShape, 
                          List<String> hostRange, String transmissionMode, int incubationPeriod, 
                          String severity, double mutationRate, String envelopeComposition) {
        super(name, geneticMaterialType, capsidShape, hostRange, transmissionMode, 
              incubationPeriod, severity, mutationRate);
        this.envelopeComposition = envelopeComposition;
    }


	public String getEnvelopeComposition() {
        return envelopeComposition;
    }

    public void setEnvelopeComposition(String envelopeComposition) {
        this.envelopeComposition = envelopeComposition;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Envelope Composition: " + envelopeComposition);
    }
}
