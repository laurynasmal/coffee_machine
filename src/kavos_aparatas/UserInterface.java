package kavos_aparatas;

import java.util.Properties;
import java.util.Scanner;
import java.io.*;

public class UserInterface {
    static KavosAparatas coffeemashine;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        Properties props = new Properties();
//        InputStream input = null;
//        props.load(input);
        readFromProperties();
        //initCooffeMachine();
        printFullMenu();
        saveToProperties();


        scanner.close();
    }


    private static void initCooffeMachine() {
        coffeemashine = new KavosAparatas(10, 15, 12, 0);
    }

    private static void initCooffeMachineProperties() {
        coffeemashine = new KavosAparatas(0, 0, 0, 0);
    }

    private static void printFullMenu() {

        boolean status = true;
        while (status == true) {

            printStatus();
            print("Pasirinkite tinkama varianta:\n");
            for (int i = 0; i < KavosAparatas.recepies.length; i++) {
                print("Kava " + KavosAparatas.recepies[i].getName() + " - spauskite " + i + ";\n");
            }
            print("Atlikti aptarnavima - 8.\n");
            print("Isjungti kavos aparata spauskite - 9.\n");
            print("Iveskite savo pasirinkima");
            int z = -1;
            try {
                z = inputAndTest();
            } catch (Exception h) {
                print("Iveskite viena skaiciu\n\n");
                continue;
            }

            if (z == 9) {
                status = false;
                break;
            }
            if (z == 8) {
                doTheMaintainance();
                continue;
            }
            if (z >= KavosAparatas.recepies.length) {
                print("Ivestas netinkamas variantas\n\n");
                continue;
            }
            try {
                coffeemashine.canYouMakeCoffee(z);
                coffeemashine.makeCoffe(z);
                print("Kava pagaminta - paimkite\n");
            } catch (Exception e) {
                print("KLAIDA:" + e.getMessage() + "\n");
                doTheMaintainance();
            }
            print("\n\n");
        }

    }

    private static void printStatus() {
        print("Vandens kiekis aparate - " + coffeemashine.getWater() + "\n");
        if (coffeemashine.getWater() <= 4) {
            print("Jei galite papildykite vandens kieki\n");
        }
        print("Cukraus kiekis aparate - " + coffeemashine.getSugar() + "\n");
        if (coffeemashine.getSugar() <= 4) {
            print("Jei galite papildykite cukraus kieki\n");
        }
        print("Kavos pupeliu kiekis aparate - " + coffeemashine.getCoffeBeans() + "\n");
        if (coffeemashine.getCoffeBeans() <= 4) {
            print("Jei galite papildykite vandens kieki\n");
        }
        print("Padaryta kavu - " + coffeemashine.getCoffeeCounter() + ", liko padaryti - " + (KavosAparatas.coffeCounterMax - coffeemashine.getCoffeeCounter()) + ";" + "\n");


    }

    public static void print(String a) {
        System.out.print(a);
    }

    private static void printEnter() {
        System.out.print("\n");
    }

    private static void doTheMaintainance() {
        print("Pasirinkite kavos aparato aptarnavimo funkcija funkcija\n");
        print("1. Vandens pildymas;\n2. Cukraus Pildymas;\n3. Kavos Pupeliu Pildymas;\n4. Aparato Valymas;\n");
        boolean done = true;
        int maintainanceType;
        while (done == true) {
            maintainanceType = scanner.nextInt();
            switch (maintainanceType) {
                case 1:
                    coffeemashine.fillWater();
                    done = false;
                    break;
                case 2:
                    coffeemashine.fillSugar();
                    done = false;
                    break;
                case 3:
                    coffeemashine.fillCoffeeBeans();
                    done = false;
                    break;
                case 4:
                    coffeemashine.resetCounter();
                    done = false;
                    break;

                default:
                    System.out.println("netinkamas pasirinkimas, iveskite dar karta");
                    break;

            }
        }
        print("Aptarnavimas atliktas.\n");
    }

    private static int inputAndTest() {
        String testIfInt = scanner.next();
        int x = Integer.parseInt(testIfInt);
        return x;
    }

    private static void saveToProperties() {
        Properties props = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("config.properties");//sukurti pilna kelia
            props.setProperty("VandensKiekis", String.valueOf(coffeemashine.getWater()));
            props.setProperty("CukrausKiekis", String.valueOf(coffeemashine.getSugar()));
            props.setProperty("KavosPupeliuKiekis", String.valueOf(coffeemashine.getCoffeBeans()));
            props.setProperty("PagamintuKavuKiekis", String.valueOf(coffeemashine.getCoffeeCounter()));
            props.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private static void readFromProperties(){
        Properties props = new Properties();
        InputStream input = null;
        initCooffeMachine();
        try {

            input = new FileInputStream("config.properties");
            props.load(input);

            coffeemashine.setWater(Integer.parseInt(props.getProperty("VandensKiekis")));
            coffeemashine.setSugar(Integer.parseInt(props.getProperty("CukrausKiekis")));
            coffeemashine.setCoffeBeans(Integer.parseInt(props.getProperty("KavosPupeliuKiekis")));
            coffeemashine.setCoffeeCounter(Integer.parseInt(props.getProperty("PagamintuKavuKiekis")));
            System.out.println(props.getProperty("VandensKiekis"));
            System.out.println(props.getProperty("CukrausKiekis"));
            System.out.println(props.getProperty("KavosPupeliuKiekis"));
            System.out.println(props.getProperty("PagamintuKavuKiekis"));

        } catch (IOException ex) {
            //ex.printStackTrace();
            initCooffeMachine();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
