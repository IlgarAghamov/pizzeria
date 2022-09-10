import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class User {
    private String login;
    private String password;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void registration(ArrayList<User> registrated) {
        System.out.println("You want to register?");
        System.out.println("If yes click 1 ,otherwise 2");
        int numberForRegistration = 3;
        switch (MyScanner.scannerSystemFor2()) {
            case "1":
                Scanner sc = new Scanner(System.in);
                System.out.println("Let's start");
                counOfAttentions(numberForRegistration);
                System.out.println("Please enter login ");
                System.out.println("Login must not be more than 20 characters");
                boolean loginException = false;
                String login = sc.nextLine();
                while (!loginException) {
                    if (registrated.isEmpty()) {
                        loginException = true;
                    } else {
                        for (User user : registrated) {
                            if (login.equals(user.getLogin())) {
                                System.out.println("Login busy");
                                System.out.println("Please try again");
                                login = sc.nextLine();
                            } else {
                                loginException = true;
                            }
                        }
                    }
                }
                System.out.println("Enter password and confirm ");
                System.out.println("They must match");
                String password = sc.nextLine();
                String confirm = sc.nextLine();
                while (numberForRegistration > 0) {
                    Scanner s = new Scanner(System.in);
                    Scanner s1 = new Scanner(System.in);
                    if (login.length() > 20) {
                        numberForRegistration--;
                        if (numberForRegistration != 0) {
                            counOfAttentions(numberForRegistration);
                            System.out.println("Login must not be more than 20 characters");
                            System.out.println("Enter login again");
                            login = s1.nextLine();
                        }
                    } else if (!password.equals(confirm)) {
                        numberForRegistration--;
                        if (numberForRegistration != 0) {
                            counOfAttentions(numberForRegistration);
                            System.out.println("Passwords do not match");
                            System.out.println("Enter pass and confirm again");
                            password = s.nextLine();
                            confirm = s.nextLine();
                        }
                    } else if (login.length() < 20) {
                        System.out.println("Ok, you are registered");
                        this.login = login;
                        this.password = password;
                        numberForRegistration = -1;
                        break;
                    }
                    systemExitCode(numberForRegistration);
                }
                break;
            case "2":
                System.out.println("Thanks for visiting us");
                System.exit(1);
                break;
        }
        registrated.add(this);
    }

    public void systemExitCode(int i) {
        if (i == 0) {
            System.out.println("You dont have attention");
            System.out.println("Please Try next time");
            System.exit(1);
        }
    }

    public void verification(ArrayList<User> usersList) {
        Scanner scannerVerification = new Scanner(System.in);
        int m = 3;
        System.out.println("Please enter login");
        boolean a1 = false;
        while (a1 != true) {
            counOfAttentions(m);
            String enteredLogin = scannerVerification.nextLine();
            for (User s1 : usersList) {
                if (s1.getLogin().equals(enteredLogin)) {
                    System.out.println("Login is true ");
                    System.out.println("Please enter password");
                    String enterPassword = scannerVerification.nextLine();
                    if (s1.getPassword().equals(enterPassword)) {
                        System.out.println("Password is true");
                        System.out.println("Welcome");
                        a1 = true;
                    } else {
                        if (m != 1) {
                            System.out.println("Password not true");
                            System.out.println("Please try again ");
                        }
                        m--;
                    }


                } else {
                    if (m != 1) {
                        System.out.println("Login not true");
                        System.out.println("Please enter login again");
                    }
                    m--;
                }
            }
            systemExitCode(m);
        }
    }

    private void counOfAttentions(int i) {
        System.out.println("You have ".concat(String.valueOf(i)).concat(" attentions"));

    }

}


