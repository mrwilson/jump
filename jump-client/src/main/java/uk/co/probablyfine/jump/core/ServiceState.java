package uk.co.probablyfine.jump.core;

/**
 * A class to represent a service running on a system and its ideal state (running/disabled)
 */
public class ServiceState {
    public String name;
    public String status;

    public ServiceState(String name, String status) {
        this.name = name;
        this.status = status;
    }
}