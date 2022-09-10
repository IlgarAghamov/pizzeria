import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Pizzeria {
    HashMap<String, String> hashMap = new HashMap<>();
    String choicePizzaForPay;
    static float pizzaPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizzeria pizzeria = (Pizzeria) o;
        return Objects.equals(hashMap, pizzeria.hashMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashMap);
    }

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public String toString() {
        return "Pizzeria{" +
                "hashMap=" + hashMap +
                '}';
    }

    public void PizzaMenu() {
        System.out.println("Do you want make order ?");
        System.out.println("Press 1 if yes and 2 if no");
        switch (MyScanner.scannerSystemFor2()) {
            case "1":
                System.out.println("Make Choice :");
                hashMap.put("Pizza with Chicken ", " 60 gr");
                hashMap.put("Pizza with Fish-Tuna ", " 50 gr");
                hashMap.put("Pizza with Salami ", " 100 gr");
                for (Map.Entry<String, String> p : hashMap.entrySet()) {
                    System.out.println(p);
                }
                System.out.println("1)If you want chicken enter     price : 12,5 ");
                System.out.println("2)If fish enter                 price : 15,5 ");
                System.out.println("3)If sausages enter             price : 14 ");
                pizzaPrice = 0;
                switch (MyScanner.scannerSystemFor3()) {
                    case "1":
                        System.out.println("Your choice is Chicken pizza");
                        pizzaPrice = 12.5F;
                        choicePizzaForPay = "Chicken pizza";
                        break;
                    case "2":
                        System.out.println("Your choice is Pizza with Fish ");
                        pizzaPrice = 15.5F;
                        choicePizzaForPay = "Pizza with Tuna";
                        break;
                    case "3":
                        System.out.println("Your choice is Pizza with sausages ");
                        pizzaPrice = 14.0F;
                        choicePizzaForPay = "Pizza with salami";
                        break;
                }
                System.out.println("Price : " + pizzaPrice);
                break;
            case "2":
                System.out.println("Thank you for visit us ");
                System.exit(1);
        }
    }

    public void extra() {
        System.out.println("Do you want some extra ?");
        System.out.println("Press 1 if yes and 2 if no");
        if (MyScanner.scannerSystemFor3().equals("1")) {
            System.out.println("What you want to order extra ?");
            System.out.println("1)Chicken    price : 2 ");
            System.out.println("2)Tuna       price : 3.5");
            System.out.println("3)Salami     price : 3");
            System.out.println("Your choice :  ");
            switch (MyScanner.scannerSystemFor3()) {
                case "1":
                    System.out.println(choicePizzaForPay);
                    System.out.println("+ Chicken 120 gr");
                    pizzaPrice = pizzaPrice + 2F;
                    break;
                case "2":
                    System.out.println(choicePizzaForPay);
                    System.out.println("+ Fish-Tuna  100 gr");
                    pizzaPrice = pizzaPrice + 3.5F;
                    break;
                case "3":
                    System.out.println(choicePizzaForPay);
                    System.out.println("+ Salami  150 gr");
                    pizzaPrice = pizzaPrice + 3F;
                    break;
            }
            System.out.println("Price : " + pizzaPrice);

        } else {
            System.out.println("Good");


        }
    }
}