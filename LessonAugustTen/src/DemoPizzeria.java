import java.util.*;

public class DemoPizzeria {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<User> usersList = new ArrayList<User>();

        while (true) {
            User user = new User();
            System.out.println("Are you registered?");
            System.out.println("If yes click 1 ,otherwise 2");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if (number == 2) {
                user.registration(usersList);
            } else {
                if (usersList.isEmpty()) {
                    System.out.println("The account does not exist in the database");
                    System.out.println("Please go through the registration");
                   user.registration(usersList);
                }
                System.out.println("Fine log in");
                user.verification(usersList);
                Pizzeria pizzeria = new Pizzeria();
                Payment payment=new Payment();
                pizzeria.PizzaMenu();
                pizzeria.extra();
                payment.paymentCard();
            }

        }
    }
}





