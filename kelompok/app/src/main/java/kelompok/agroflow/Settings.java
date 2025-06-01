package kelompok.agroflow;

import java.util.*;

public class Settings {
    private static final Map<String, Plant> PLANTS = new HashMap<>();

    public static void registerPlant(String id, Plant plant) {
        PLANTS.put(id.toLowerCase(), plant);
    }

    public static Plant getPlant(String id) {
        return PLANTS.get(id.toLowerCase());
    }

    public static void removePlant(String id) {
        PLANTS.remove(id.toLowerCase());
    }

    public static Set<String> getAllPlantIds() {
        return PLANTS.keySet();
    }

    public static Collection<Plant> getAllPlants() {
        return PLANTS.values();
    }
}

