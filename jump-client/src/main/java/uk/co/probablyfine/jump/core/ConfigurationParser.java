package uk.co.probablyfine.jump.core;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Class to parse JSON based configuration file
 */

/*
    {
        "services" : [
            {"name": "apache2", "state": "enabled"},
            {"name": "sshd", "state": "disabled"}
        ]
    }
 */

public class ConfigurationParser {

    private LinkedList<ServiceState> serviceStates;

    /**
     * Parese the config file and call parseServicesArray
     * @param fileName
     * @throws IOException
     */
    public ConfigurationParser(String fileName) throws IOException {
        String json = "";
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = br.readLine()) != null) {
            json += line;
        }

        JsonObject root = (new JsonParser()).parse(json).getAsJsonObject();
        JsonArray services = root.getAsJsonArray("services");

        this.serviceStates = parseServicesArray(services);
    }

    /**
     * Generate a list of ServiceStates from the json in the file
     * @param services
     * @return
     */
    private LinkedList<ServiceState> parseServicesArray(JsonArray services) {
        LinkedList<ServiceState> serviceStates = new LinkedList<>();

        for (JsonElement service : services) {
            String name = service.getAsJsonObject().get("name").getAsString();
            String state = service.getAsJsonObject().get("status").getAsString();
            serviceStates.add(new ServiceState(name, state));
        }

        return serviceStates;
    }

    public LinkedList<ServiceState> getConfigServiceState() {
        return this.serviceStates;
    }



}
