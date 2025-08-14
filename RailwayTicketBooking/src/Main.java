import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RailwayApplication rp = new RailwayApplication();

        while (true) {
            System.out.println("choice the option : ");
            System.out.println("1. Book");
            System.out.println("2. Cancel");
            System.out.println("3. Print Booked tickets");
            System.out.println("4. Print Available tickets");
            System.out.println("5. exit");

            Scanner sc = new Scanner(System.in);
            Integer input = sc.nextInt();

            if (input.equals(1)) {
                rp.bookTicket();
            } else if (input.equals(2)) {
                rp.cancelTickets();
            } else if (input.equals(3)) {
                rp.printAllTickets();
            } else if (input.equals(4)) {
                rp.ticketAvailability();
            } else {
                System.exit(0);
            }

        }
    }
}