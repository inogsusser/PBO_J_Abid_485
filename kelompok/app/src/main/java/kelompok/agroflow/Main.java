package kelompok.agroflow;

public class Main {
    public static void main(String[] args) {
        // Explicit init
        Agroflow.Init_agroflow();

        // Create farms
        Farm myfarm_1 = new Farm(6.5, "26°C", "low", "medium", "medium");
        Farm myfarm_2 = new Farm(5.9, "28°C", "high", "medium", "high");

        System.out.println("Farm 1 compatible plants:");
        for (String p : myfarm_1.suggestPlants()) {
            System.out.println("- " + p);
        }

        System.out.println("\nFarm 2 compatible plants:");
        for (String p : myfarm_2.suggestPlants()) {
            System.out.println("- " + p);
        }

        // Add plant at runtime
        Settings.registerPlant("lettuce", new Plant(
            "Lettuce", "leafy", false,
            new String[]{"carrot", "onion"},
            70, "medium",
            new SoilRequirement(6.0, 7.0, "10-25°C", "low", "medium", "medium"),
            new MarketData(0.95, "up")
        ));
        
        // prints all plants
        Agroflow.listAllPlants();
        Agroflow.getInfo("lettuce");

        System.out.println("\nFarm 1 after adding 'lettuce':");
        for (String p : myfarm_1.suggestPlants()) {
            System.out.println("- " + p);
        }
    }
}
