package Host;

import java.util.ArrayList;

public class HostList {
    private ArrayList<Host> hostList;

    public HostList() {
        this.hostList = new ArrayList<>();
    }

    public void addHost(Host host) {
        hostList.add(host);
    }

    public Host getHostByType(String hostType) {
        for (Host host : hostList) {
            if (host.getHostType().equals(hostType)) {
                return host;
            }
        }
        return null; // Return null if host not found
    }

    // Other methods for manipulating the hostList, such as removing hosts, checking if a host exists, etc.

    public ArrayList<Host> getHostList() {
        return hostList;
    }

    public void setHostList(ArrayList<Host> hostList) {
        this.hostList = hostList;
    }
}
