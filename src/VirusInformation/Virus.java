package VirusInformation;

public class Virus {
    // Attributes
    private String name;
    private String geneticMaterialType;
    private String capsidShape;
    private String hostRange;
    private String transmissionMode;
    private int incubationPeriod; // in days
    private String severity;
    private double mutationRate; // mutations per replication cycle

    // Constructor
    public Virus(String name, String geneticMaterialType, String capsidShape, 
                 String hostRange, String transmissionMode, int incubationPeriod, 
                 String severity, double mutationRate) {
        this.name = name;
        this.geneticMaterialType = geneticMaterialType;
        this.capsidShape = capsidShape;
        this.hostRange = hostRange;
        this.transmissionMode = transmissionMode;
        this.incubationPeriod = incubationPeriod;
        this.severity = severity;
        this.mutationRate = mutationRate;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getGeneticMaterialType() {
        return geneticMaterialType;
    }

    public String getCapsidShape() {
        return capsidShape;
    }

    public String getHostRange() {
        return hostRange;
    }

    public String getTransmissionMode() {
        return transmissionMode;
    }

    public int getIncubationPeriod() {
        return incubationPeriod;
    }

    public String getSeverity() {
        return severity;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    // Method to display virus information
    public void displayInfo() {
        System.out.println("Virus Name: " + name);
        System.out.println("Genetic Material Type: " + geneticMaterialType);
        System.out.println("Capsid Shape: " + capsidShape);
        System.out.println("Host Range: " + hostRange);
        System.out.println("Transmission Mode: " + transmissionMode);
        System.out.println("Incubation Period: " + incubationPeriod + " days");
        System.out.println("Severity: " + severity);
        System.out.println("Mutation Rate: " + mutationRate + " mutations per cycle");
    }
}
