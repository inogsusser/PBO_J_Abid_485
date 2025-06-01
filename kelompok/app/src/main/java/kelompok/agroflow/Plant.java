package kelompok.agroflow;

public class Plant {
    public String name;
    public String type;
    public boolean nitrogenFixing;
    public String[] companions;
    public int growthDays;
    public String waterNeeds;
    public SoilRequirement soil;
    public MarketData market;

    public Plant(String name, String type, boolean nitrogenFixing, String[] companions, int growthDays, String waterNeeds,
                 SoilRequirement soil, MarketData market) {
        this.name = name;
        this.type = type;
        this.nitrogenFixing = nitrogenFixing;
        this.companions = companions;
        this.growthDays = growthDays;
        this.waterNeeds = waterNeeds;
        this.soil = soil;
        this.market = market;
    }
}
