package kelompok.agroflow;

import java.util.*;

public class Farm {
    public double ph;
    public String temperature; // e.g., "25°C"
    public String nutrientN;
    public String nutrientP;
    public String nutrientK;

    public Farm(double ph, String temperature, String n, String p, String k) {
        this.ph = ph;
        this.temperature = temperature;
        this.nutrientN = n;
        this.nutrientP = p;
        this.nutrientK = k;
    }

    public boolean isCompatible(String plantId) {
        Plant plant = Settings.getPlant(plantId);
        if (plant == null) return false;

        SoilRequirement s = plant.soil;

        boolean ph_Ok = ph >= s.phMin && ph <= s.phMax;
        boolean n_Ok = s.nutrientN.equalsIgnoreCase(nutrientN);
        boolean p_Ok = s.nutrientP.equalsIgnoreCase(nutrientP);
        boolean k_Ok = s.nutrientK.equalsIgnoreCase(nutrientK);
        // Simple temp check (just string matching)
        boolean temp_Ok = temperatureInRange(temperature, s.tempRange);

        return ph_Ok && n_Ok && p_Ok && k_Ok && temp_Ok;
    }

    public List<String> suggestPlants() {
        List<String> matches = new ArrayList<>();
        for (String id : Settings.getAllPlantIds()) {
            if (isCompatible(id)) {
                matches.add(id);
            }
        }
        return matches;
    }

    private boolean temperatureInRange(String current, String range) {
        try {
            int cur = Integer.parseInt(current.replace("°C", "").trim());
            String[] parts = range.replace("°C", "").split("-");
            int min = Integer.parseInt(parts[0].trim());
            int max = Integer.parseInt(parts[1].trim());
            return cur >= min && cur <= max;
        } catch (Exception e) {
            return false;
        }
    }
}
