import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Payment {

    private int cash;
    private int card;
    public static float cashPayment;

    public float getCashPayment() {
        return cashPayment;
    }


    public int getCard() {
        return card;}
    public void setCard(int card) {
        this.card = card;}
    public int getCash() {
        return cash;}
    public void setCash(int cash) {
        this.cash = cash;}

    public void paymentCard() throws InterruptedException {
        System.out.println("Please choose to pay  : ");
        System.out.println("1)Card");
        System.out.println("2)Cash");
        Payment p=new Payment();
        switch (MyScanner.scannerSystemFor2()) {
            case "1":
                System.out.println("Please choice your card: ");
                System.out.println("1)Mastercard");
                System.out.println("2)Visa (Discount 15%)");
                switch (MyScanner.scannerSystemFor2()) {
                    case "1":
                        System.out.println("Your Card is Mastercard");
                        break;
                    case "2":
                        System.out.println(" Your Card is Visa");
                        Pizza.pizzaPrice= Pizza.pizzaPrice-((Pizza.pizzaPrice*15)/100);
                        break;
                }
                boolean cardWhile=false;
                while (!cardWhile) {
                System.out.println("Please enter your card number :");
                boolean cardOperation=false;
                    while (!cardOperation) {
                        String cardNumber=examinationOfCard();
                            System.out.println("Please enter CVC code :");
                        String cvcNumber=examinationOfCardCVC();
                                System.out.println("Please enter card expiration date");
                                System.out.println("For example : 12/21");
                        String cdeNumber=examinationOfCardCDE();
                                    System.out.println("Your Card information: ");
                                    System.out.println("Card number : " + cardNumber);
                                    System.out.println("CVC code    : " + cvcNumber);
                                    System.out.println("CED         : " + cdeNumber);
                                    System.out.println("To pay :"+ Pizza.pizzaPrice);
                                    cardOperation = true;
                                    cardWhile=true;
                                }
                            }
                System.out.println("Please wait");
                Payment.print();
                System.out.println("Thanks for visiting us");
                System.out.println("Have a goode day");
                System.exit(1);
                break;
            case "2":
                System.out.println("Your choice is cash");
                Scanner scannerCash=new Scanner(System.in);
                System.out.println("How much will you pay? ");
                boolean cashWarning=false;
                while (!cashWarning){
                    cashPayment=scannerCash.nextFloat();
                if(cashPayment< Pizza.pizzaPrice){
                    System.out.println("Insufficient funds");
                    System.out.println("Please try again");
                    p.paymentCard();
                }else {
                    cashWarning=true;
                }
                }
                Payment.print();
                System.out.println("Your change   :"+ (cashPayment- Pizza.pizzaPrice));
                System.out.println("Thanks for visiting us");
                System.out.println("Have a good day");
                System.exit(1);

        }

    }
    public static void print() throws InterruptedException {
        Thread.sleep(9000);
        System.out.println("Payment was successful");
    }
    public static String examinationOfCard() {
        while (true) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        String regex = "\\d{16}";
        Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(numbers);
            if (!matcher.matches()) {
                System.out.println("Invalid card number");
                System.out.println("Try again");
            }else{
                return numbers;
            }
        }
    }
    public static String examinationOfCardCVC() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String numbers = scanner.nextLine();
            String regex = "\\d{3}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(numbers);
            if (!matcher.matches()) {
                System.out.println("Invalid CVC code");
                System.out.println("Try again");
            }else{
                return numbers;
            }
        }
    }
    public static String examinationOfCardCDE() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String numbers = scanner.nextLine();
            String regex = "(0[1-9]|1[012])[/]([2-9][0-9])";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(numbers);
            if (!matcher.matches()) {
                System.out.println("Invalid date");
                System.out.println("Try again");
            }else{
                return numbers;
            }
        }
    }


}


