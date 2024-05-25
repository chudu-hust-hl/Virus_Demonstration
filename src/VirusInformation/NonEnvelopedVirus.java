package VirusInformation;

public class NonEnvelopedVirus extends Virus {
    // Additional attributes or methods specific to non-enveloped viruses can be added here

    public NonEnvelopedVirus(String name, String geneticMaterialType, String capsidShape, 
                             String hostRange, String transmissionMode, int incubationPeriod, 
                             String severity, double mutationRate) {
        super(name, geneticMaterialType, capsidShape, hostRange, transmissionMode, 
              incubationPeriod, severity, mutationRate);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        // Additional information specific to non-enveloped viruses can be displayed here
    }
}
