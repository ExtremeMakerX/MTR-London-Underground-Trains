import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;

public class JSONChanger {

    public void disableLUComplementaryReimagined() throws IOException {
        String fileName = "common/src/main/resources/assets/mtr/mtr_custom_resources.json";

        // Read the JSON file
        File file = new File(fileName);

        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(file);

            JsonNode customTrains = jsonNode.get("custom_trains");

            String[] londonUndergroundList = new String[]{"lu_1992_refit", "lu_1992_refit_old", "lu_1992_old", "lu_1992_wc1", "lu_1992_wc2"};
            String[] britishRailClass482List = new String[]{"british_rail_class_482_wc2", "british_rail_class_482_wc2_no_logo"};

            updateJsonNode(customTrains, londonUndergroundList, "mtr:custom_directory/london_underground_1992.json");
            updateJsonNode(customTrains, britishRailClass482List, "mtr:custom_directory/british_rail_class_482.json");

            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(file, jsonNode);
        } else {
            System.out.println("File does not exist: " + fileName);
        }
    }

    public void enableLUComplementaryReimagined() throws IOException {
        String fileName = "common/src/main/resources/assets/mtr/mtr_custom_resources.json";

        // Read the JSON file
        File file = new File(fileName);

        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(file);

            JsonNode customTrains = jsonNode.get("custom_trains");

            String[] londonUndergroundList = new String[]{"lu_1992_refit", "lu_1992_refit_old", "lu_1992_old", "lu_1992_wc1", "lu_1992_wc2"};
            String[] britishRailClass482List = new String[]{"british_rail_class_482_wc2", "british_rail_class_482_wc2_no_logo"};

            updateJsonNode(customTrains, londonUndergroundList, "mtr:custom_directory/london_underground_1992_cr.json");
            updateJsonNode(customTrains, britishRailClass482List, "mtr:custom_directory/british_rail_class_482_cr.json");

            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(file, jsonNode);
        } else {
            System.out.println("File does not exist: " + fileName);
        }
    }

    public static void updateJsonNode(JsonNode customTrains, String[] array, String newValue) {
        for (String str : array) {
            JsonNode node = customTrains.get(str);
            if (node != null && node.isObject()) {
                System.out.println("Updating node: " + node);
                ((ObjectNode) node).put("model_properties", newValue);
                System.out.println("Updated node: " + node);
            }
        }
    }
}
