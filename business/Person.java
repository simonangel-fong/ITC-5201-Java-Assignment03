package business;

/**
 * This is a class that represents a person.
 */
public class Person {

    // region public members
    // • Define public constants for the size of each string field and record
    final public static int SIZE_FIRST_NAME = 20;// • First name, string type, max size 20 characters
    final public static int SIZE_LAST_NAME = 25;// • Last name, string type, max size 25 characters
    final public static int SIZE_PHONE = 10;// • Phone, string type, max size 10 characters
    final public static int SIZE_AGE = 4;
    final public static int SIZE_ID = 4;
    // endregion

    // region private members
    private int id;// person id
    private String firstName;// • First name, string type,
    private String lastName;// • Last name, string type
    private String phone;// • Phone, string type
    private int age;// • Age, int type

    // endregion

    // region Constructors

    public Person() {
        this.id = -1;// default value = -1;
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
        this.age = 0;
    }

    public Person(int id, String firstName, String lastName, String phone, int age) {
        this.id = id;
        this.firstName = padString(firstName, SIZE_FIRST_NAME);
        this.lastName = padString(lastName, SIZE_LAST_NAME);
        this.phone = padString(phone, SIZE_PHONE);
        this.age = age;
    }

    // endregion

    // region Setters and getters for each field

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = padString(firstName, SIZE_FIRST_NAME);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = padString(lastName, SIZE_LAST_NAME);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = padString(phone, SIZE_PHONE);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // endregion

    @Override
    public String toString() {

        return String.format("%s %s\t%d\t%s",
                firstName, lastName, age, phone);
    }

    private String padString(String str, int num) {
        String result = str;

        if (result.length() < (num - 1)) {
            for (int i = result.length(); i < num; i++) {
                result += " ";
            }
        } else {
            result = str.substring(0, num);
        }

        return result;
    }
}
