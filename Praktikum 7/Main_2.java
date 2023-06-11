import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Hint 1: Untuk mendapatkan input dari user, umumnya bisa dengan memasukkan
        // parameter System.in
        // ke dalam konstruktor Scanner.
        Scanner scan = new Scanner(System.in);
        String stremail = scan.nextLine();
        Email email = new Email(stremail);
        try {
            boolean valid = email.validateEmail();
            if (valid) {
                System.out.println("true");
                System.out.println("Email validated.");
            }
        } catch (InvalidEmailException e) {
            System.out.println(String.format("InvalidEmailException! %s", e.getMessage()));
            System.out.println("Email string error!");
        } catch (InvalidDomainException e) {
            System.out.println(String.format("InvalidDomainException! %s", e.getMessage()));
            System.out.println("Email string error!");
        } finally {
            System.out.println("Operation finished.");
        }
    }

}
