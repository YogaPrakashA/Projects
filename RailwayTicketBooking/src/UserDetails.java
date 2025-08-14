public class UserDetails {
    private int userId;
    private String name;
    private int age;
    private char gender;
    private String berth;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBerth() {
        return berth;
    }

    public void setBerth(String berth) {
        this.berth = berth;
    }

    public UserDetails(int userId, String name, int age, char gender, String berth) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berth = berth;
    }

    public UserDetails() {

    }
}
