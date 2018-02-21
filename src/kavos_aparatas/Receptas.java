package kavos_aparatas;

public class Receptas {
    private String name;
    private int water;
    private int sugar;
    private int coffeBeans;

    public Receptas(String name, int water, int sugar, int coffeBeans) {
        this.name = name;
        this.water = water;
        this.sugar = sugar;
        this.coffeBeans = coffeBeans;
    }

    public int getWater() {
        return water;
    }

    public String getName() {
        return name;
    }

    public int getSugar() {
        return sugar;
    }

    public int getCoffeBeans() {
        return coffeBeans;
    }


}
