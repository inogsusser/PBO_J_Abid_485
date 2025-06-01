package kelompok.agroflow;

public class SoilRequirement {
    public double phMin;
    public double phMax;
    public String tempRange;
    public String nutrientN;
    public String nutrientP;
    public String nutrientK;

    public SoilRequirement(double phMin, double phMax, String tempRange, String n, String p, String k) {
        this.phMin = phMin;
        this.phMax = phMax;
        this.tempRange = tempRange;
        this.nutrientN = n;
        this.nutrientP = p;
        this.nutrientK = k;
    }
}
