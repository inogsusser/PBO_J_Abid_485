package kelompok.agroflow;

public class Agroflow {

    private static boolean initialized = false;

    public static void Init_agroflow() {
        if (initialized) {
            return;
        }

        Settings.registerPlant("corn", new Plant(
                "Corn", "cereal", false,
                new String[]{"beans", "squash"},
                100, "high",
                new SoilRequirement(5.8, 7.0, "18-35°C", "high", "medium", "high"),
                new MarketData(0.65, "up")
        ));

        Settings.registerPlant("soybeans", new Plant(
                "Soybeans", "legume", true,
                new String[]{"corn", "sunflower"},
                90, "medium",
                new SoilRequirement(6.0, 6.8, "20-30°C", "low", "medium", "medium"),
                new MarketData(0.85, "stable")
        ));

        Settings.registerPlant("lettuce", new Plant(
                "Lettuce", "leafy", false,
                new String[]{"carrot", "onion"},
                70, "medium",
                new SoilRequirement(6.0, 7.0, "10-25°C", "low", "medium", "medium"),
                new MarketData(0.95, "up")
        ));

        Settings.registerPlant("tomato", new Plant(
                "Tomato", "fruit", false,
                new String[]{"basil", "carrot"},
                80, "high",
                new SoilRequirement(5.5, 7.5, "18-30°C", "medium", "high", "medium"),
                new MarketData(1.25, "down")
        ));

        Settings.registerPlant("carrot", new Plant(
                "Carrot", "root", false,
                new String[]{"lettuce", "onion"},
                75, "low",
                new SoilRequirement(6.0, 6.8, "10-20°C", "medium", "medium", "low"),
                new MarketData(0.55, "up")
        ));

        Settings.registerPlant("potato", new Plant(
                "Potato", "tuber", false,
                new String[]{"beans", "cabbage"},
                90, "medium",
                new SoilRequirement(5.0, 6.5, "15-20°C", "medium", "low", "high"),
                new MarketData(0.60, "stable")
        ));

        Settings.registerPlant("spinach", new Plant(
                "Spinach", "leafy", false,
                new String[]{"radish", "carrot"},
                45, "medium",
                new SoilRequirement(6.5, 7.5, "5-20°C", "low", "medium", "medium"),
                new MarketData(1.10, "up")
        ));

        Settings.registerPlant("sunflower", new Plant(
                "Sunflower", "flower", false,
                new String[]{"corn", "cucumber"},
                95, "high",
                new SoilRequirement(6.0, 7.5, "20-30°C", "medium", "medium", "high"),
                new MarketData(0.75, "up")
        ));

        Settings.registerPlant("peanut", new Plant(
                "Peanut", "legume", true,
                new String[]{"corn", "cotton"},
                110, "medium",
                new SoilRequirement(5.5, 7.0, "20-30°C", "low", "low", "medium"),
                new MarketData(0.90, "stable")
        ));

        Settings.registerPlant("cabbage", new Plant(
                "Cabbage", "leafy", false,
                new String[]{"carrot", "onion"},
                85, "medium",
                new SoilRequirement(6.0, 7.5, "10-25°C", "medium", "medium", "medium"),
                new MarketData(0.70, "down")
        ));

        initialized = true;
    }

    public static Plant getPlant(String id) {
        return Settings.getPlant(id);
    }

    public static void getInfo(String plantId) {
        Plant p = getPlant(plantId);
        if (p == null) {
            System.out.println("[!] Plant not found: " + plantId);
            return;
        }

        System.out.println("== Info for Plant: " + plantId + " ==");
        System.out.println("Name         : " + p.name);
        System.out.println("Type         : " + p.type);
        System.out.println("Nitrogen Fix : " + (p.nitrogenFixing ? "Yes" : "No"));
        System.out.println("Growth Days  : " + p.growthDays);
        System.out.println("Water Needs  : " + p.waterNeeds);
        System.out.println("Companions   : " + String.join(", ", p.companions));
        System.out.println("Market Price : $" + p.market.pricePerKg + "/kg (trend: " + p.market.trend + ")");
        System.out.println("Soil pH      : " + p.soil.phMin + " - " + p.soil.phMax);
        System.out.println("Temperature  : " + p.soil.tempRange);
        System.out.println("Nutrients    : N=" + p.soil.nutrientN + ", P=" + p.soil.nutrientP + ", K=" + p.soil.nutrientK);
        System.out.println("-------------------------------------------");
    }

    public static void listAllPlants() {
        System.out.println("List of avalible plants");
        for (String id : Settings.getAllPlantIds()) {
            System.out.println("- " + id);
        }
    }
}
