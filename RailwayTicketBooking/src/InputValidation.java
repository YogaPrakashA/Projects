import java.util.regex.Pattern;

public class InputValidation {

    public boolean passengerName(String name) {

        return Pattern.matches("[a-zA-Z]*", name);
    }

    public boolean passengerAge(int age) {

        return age <= 99;
    }

    public boolean passengerGender(char gender) {

        return gender == 'M' || gender == 'F' || gender == 'O';
    }

}
