package VirusInformation;

import java.util.List;

import Host.Host;
import Host.HostList;

public class NonEnvelopedVirus{
    // Additional attributes or methods specific to non-enveloped viruses can be added here

	private String name;
    private String geneticMaterialType;
    private String capsidShape;
    private List<String> hostRange; // Changed to a list of host types
    private String transmissionMode;
    private int incubationPeriod; // in days
    private String severity;
    private double mutationRate; // mutations per replication cycle

    // Constructor
    public NonEnvelopedVirus(String name, String geneticMaterialType, String capsidShape, 
                 List<String> hostRange, String transmissionMode, int incubationPeriod, 
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
    
    public static void addVirusToHost(String virusName, List<String> hostRange, HostList hostList) {
        for (String hostType : hostRange) {
            boolean hostExists = false;
            for (Host host : hostList.getHostList()) {
                if (host.getHostType().equals(hostType)) {
                    host.addSusceptibleVirus(virusName);
                    hostExists = true;
                    break;
                }
            }
            if (!hostExists) {
                Host newHost = new Host(hostType);
                newHost.addSusceptibleVirus(virusName);
                hostList.getHostList().add(newHost);
            }
        }
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

    public List<String> getHostRange() {
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
}
