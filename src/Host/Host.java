package Host;

import java.util.ArrayList;
import java.util.List;

public class Host {
    private String hostType;
    private String commonName;
    private List<String> susceptibleViruses;

    public Host(String hostType, String commonName) {
        this.hostType = hostType;
        this.commonName = commonName;
        this.susceptibleViruses = new ArrayList<>();
    }

    public void displayHostTypeInfo() {
        System.out.println("Host Type: " + hostType);
        System.out.println("Common Name: " + commonName);
        System.out.println("Susceptible Viruses: " + susceptibleViruses);
    }

    public void addSusceptibleVirus(String virusName) {
        if (!susceptibleViruses.contains(virusName)) {
            susceptibleViruses.add(virusName);
        }
    }

    public boolean isSusceptibleTo(String virusName) {
        return susceptibleViruses.contains(virusName);
    }

    // Getters and Setters

    public String getHostType() {
        return hostType;
    }

    public void setHostType(String hostType) {
        this.hostType = hostType;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public List<String> getSusceptibleViruses() {
        return susceptibleViruses;
    }

    public void setSusceptibleViruses(List<String> susceptibleViruses) {
        this.susceptibleViruses = susceptibleViruses;
    }
}
