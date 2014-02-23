package uk.co.probablyfine.jump.core;

import java.util.LinkedList;

/**
 * Query the services on the system and make sure they are in the correct state.
 */

public class SystemStatusMonitor {

    LinkedList<ServiceState> serviceStates;

    public SystemStatusMonitor(LinkedList<ServiceState> serviceStates) {
        this.serviceStates = serviceStates;
    }

    /**
     * Check if all the services that should be running are
     * @return
     */
    public boolean everythingOK() {
        for (ServiceState state : serviceStates) {
            if (state.status.equals("enabled")) {
                if (!Services.isRunning(state.name)) {
                    return false;
                }
            }
        }
        return true;
    }


}
