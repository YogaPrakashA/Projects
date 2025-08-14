import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RailwayApplication implements ApplicationProcess {

    int userIdGenerate = 0;

    int totalTickets = 3;
    int lowerBerth = 1;
    int upperBerth = 1;
    int middleBerth = 1;
    int racTickets = 1;
    int waitingTickets = 1;
    Scanner sc = new Scanner(System.in);
    List<PassengerDetails> bookedDetails = new ArrayList<>();
    List<PassengerDetails> racDetails = new ArrayList<>();
    List<PassengerDetails> waitingDetails = new ArrayList<>();

    @Override
    public void bookTicket() {
        InputValidation iv = new InputValidation();
        if (totalTickets == 0 && racTickets == 0 && waitingTickets == 0) {
            System.out.println("No tickets Available....");
            return;
        }

        System.out.println("Enter passenger Name : ");
        String name = sc.next();
        System.out.println("Enter passenger Age : ");
        int age = sc.nextInt();
        System.out.println("Enter passenger Gender (M/F/O) : ");
        char gender = sc.next().toUpperCase().charAt(0);
        System.out.println("Enter passenger Berth preference (lower/middle/upper): ");
        String berth = sc.next();

        if (!iv.passengerName(name) || name.length() >= 10) {
            System.err.println("Invalid name or maximum allowed 10 character... ");
            return;
        }

        if (!iv.passengerAge(age)) {
            System.err.println("Invalid Age..");
            return;
        }

        if (!iv.passengerGender(gender)) {
            System.err.println("Invalid Gender...");
            return;
        }

        if (age < 5) {
            bookedDetails.add(new PassengerDetails(userIdGenerate++, name, age, gender, berth));
            return;
        }

        if ((age >= 60 && lowerBerth > 0) || (middleBerth == 0 && upperBerth == 0)) {
            bookedDetails.add(new PassengerDetails(userIdGenerate++, name, age, gender, "Lower"));
            lowerBerth--;
            totalTickets--;
            return;
        }
        if (middleBerth > 0) {
            bookedDetails.add(new PassengerDetails(userIdGenerate++, name, age, gender, "middle"));
            middleBerth--;
            totalTickets--;
            return;
        }
        if (upperBerth > 0) {
            bookedDetails.add(new PassengerDetails(userIdGenerate++, name, age, gender, "Upper"));
            upperBerth--;
            totalTickets--;
            return;
        }

        if (racTickets > 0) {
            racDetails.add(new PassengerDetails(userIdGenerate++, name, age, gender, "RAC"));
            racTickets--;
            return;
        }

        if (waitingTickets > 0) {
            waitingDetails.add(new PassengerDetails(userIdGenerate++, name, age, gender, "WL"));
            waitingTickets--;
        }


    }

    @Override
    public void cancelTickets() {

        System.out.println("Enter User Id : ");
        int userId = sc.nextInt();
        for (int i = 0; i < bookedDetails.size(); i++) {
            if (bookedDetails.get(i).getUserId() == userId) {
                if (!racDetails.isEmpty()) {
                    bookedDetails.set(i, new PassengerDetails(racDetails.get(0).getUserId(), racDetails.get(0).getName(), racDetails.get(0).getAge(), racDetails.get(0).getGender(), bookedDetails.get(i).getBerth()));
                    if (!waitingDetails.isEmpty()) {
                        racDetails.add(new PassengerDetails(waitingDetails.get(0).getUserId(), waitingDetails.get(0).getName(), waitingDetails.get(0).getAge(), waitingDetails.get(0).getGender(), racDetails.get(0).getBerth()));
                        waitingDetails.remove(0);
                        waitingTickets++;
                    } else {
                        racTickets++;
                    }
                    racDetails.remove(0);
                } else {
                    if (bookedDetails.get(i).getAge() > 5) {
                        if (bookedDetails.get(i).getBerth().equalsIgnoreCase("lower") && racDetails.isEmpty())
                            lowerBerth++;
                        else if (bookedDetails.get(i).getBerth().equalsIgnoreCase("middle") && racDetails.isEmpty())
                            middleBerth++;
                        else if (bookedDetails.get(i).getBerth().equalsIgnoreCase("upper") && racDetails.isEmpty()) {
                            upperBerth++;
                        }
                    }
                    bookedDetails.remove(i);
                    totalTickets++;
                }
                break;
            }
        }

        System.out.println("cancellation successfully....");

    }

    @Override
    public void ticketAvailability() {
        System.out.println("Ticket Availability");
        System.out.println("---------------------");
        System.out.println("lowerBerth : " + lowerBerth);
        System.out.println("middleBerth : " + middleBerth);
        System.out.println("upperBerth : " + upperBerth);
        System.out.println("RAC  : " + racTickets);
        System.out.println("waiting : " + waitingTickets);
        System.out.println("TotalTickets : " + totalTickets);

    }

    @Override
    public void printAllTickets() {
        System.out.println("Booked Tickets details......");
        System.out.println("-----------------------------");

        if (bookedDetails.isEmpty()) {
            System.out.println("tickets not available");
            return;
        }


        for (PassengerDetails user : bookedDetails)
            System.out.println(user.getUserId() + " | " + user.getName() + " | " + user.getAge() + " | " + user.getGender() + " | " + user.getBerth());
        for (PassengerDetails user : racDetails)
            System.out.println(user.getUserId() + " | " + user.getName() + " | " + user.getAge() + " | " + user.getGender() + " | " + user.getBerth());
        for (PassengerDetails user : waitingDetails)
            System.out.println(user.getUserId() + " | " + user.getName() + " | " + user.getAge() + " | " + user.getGender() + " | " + user.getBerth());


    }


}
