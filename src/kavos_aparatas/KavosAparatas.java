package kavos_aparatas;

public class KavosAparatas {
    static Receptas[] recepies;
    int water;
    int sugar;
    int coffeBeans;
    int coffeeCounter;
    public static final int coffeCounterMax = 20;
    public static final int waterTank = 20;
    public static final int sugarTank=15;
    public static final int coffeBeansTank = 30;


    public KavosAparatas(int water, int sugar, int coffeBeans, int coffeeCounter) {
        this.water = water;
        this.sugar = sugar;
        this.coffeBeans = coffeBeans;
        this.coffeeCounter = coffeeCounter;

        initRecepies();
    }
//    public KavosAparatas() {
//             initRecepies();
//    }

    private void initRecepies(){
        recepies = new Receptas[3];
        recepies[0] = new Receptas("latte", 1, 1, 2);
        recepies[1] = new Receptas("black", 1, 0, 3);
        recepies[2] = new Receptas("amercan", 2, 1, 2);
    }

    public void makeCoffe(int i){
        water-=recepies[i].getWater();
        sugar-=recepies[i].getSugar();
        coffeBeans-=recepies[i].getCoffeBeans();
        coffeeCounter++;
        UserInterface.print("Gaminama kava - "+recepies[i].getName()+"\n");
    }

    public boolean canYouMakeCoffee(int i){
        if (water-recepies[i].getWater()==0){
            throw  new RuntimeException("papildyti vandeni");
        }
        if (sugar-recepies[i].getSugar()==0){
            throw  new RuntimeException("papildyti cukru");
        }
        if (coffeBeans-recepies[i].getCoffeBeans()==0){
            throw  new RuntimeException("papildyti kavos pupeles");
        }
        if (coffeeCounter>=coffeCounterMax){
            throw  new RuntimeException("Valyti aparata");
        }
        return true;
    }


    public void fillWater(){
        water=waterTank;
    }

    public void fillSugar(){
        sugar=sugarTank;
    }

    public void fillCoffeeBeans(){
        coffeBeans=coffeBeansTank;
    }

    public void resetCounter(){
        coffeeCounter=0;
    }

    public int getWater() {
        return water;
    }

    public int getSugar() {
        return sugar;
    }

    public int getCoffeBeans() {
        return coffeBeans;
    }

    public int getCoffeeCounter() {
        return coffeeCounter;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setCoffeBeans(int coffeBeans) {
        this.coffeBeans = coffeBeans;
    }

    public void setCoffeeCounter(int coffeeCounter) {
        this.coffeeCounter = coffeeCounter;
    }
}


