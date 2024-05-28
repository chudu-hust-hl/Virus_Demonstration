package Host;

import java.util.ArrayList;

public class Host {
    private String hostType;
    private ArrayList<String> susceptibleViruses;

    public Host(String hostType) {
        this.hostType = hostType;
        this.susceptibleViruses = new ArrayList<>();
    }

    public void displayHostTypeInfo() {
        System.out.println("Host Type: " + hostType);
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

    public ArrayList<String> getSusceptibleViruses() {
        return susceptibleViruses;
    }

    public void setSusceptibleViruses(ArrayList<String> susceptibleViruses) {
        this.susceptibleViruses = susceptibleViruses;
    }

    
    
    /*public static void main(String[] args) {
        // Create instances of Host
        Host human = new Host("Human");
        Host bird = new Host("Bird");
        Host primate = new Host("Primate");
        Host mosquito = new Host("Mosquito");
        Host bat = new Host("Bat");

        // Display information
        human.displayHostTypeInfo();
        bird.displayHostTypeInfo();
        primate.displayHostTypeInfo();
        mosquito.displayHostTypeInfo();
        bat.displayHostTypeInfo();
    }*/


}
