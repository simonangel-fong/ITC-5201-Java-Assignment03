package business;

/**
 * ID: n01555914
 * Name: Wenhao Fang
 * This is a class representing a person.
 * 
 * @author Wenhao Fang
 */
public class Person {

    // region Public members

    // • Define public constants for the size of each string field and record
    final public static int SIZE_FIRST_NAME = 20;// • First name, string type, max size 20 characters
    final public static int SIZE_LAST_NAME = 25;// • Last name, string type, max size 25 characters
    final public static int SIZE_PHONE = 10;// • Phone, string type, max size 10 characters
    final public static int SIZE_AGE = 4;
    final public static int SIZE_ID = 4;
    // endregion

    // region Private members
    private int id;// person id
    private String firstName;// • First name, string type,
    private String lastName;// • Last name, string type
    private String phone;// • Phone, string type
    private int age;// • Age, int type

    // endregion

    // region Constructors

    /**
     * Default constructor.
     */
    public Person() {
        this.id = -1;// default value = -1;
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
        this.age = 0;
    }

    /**
     * Constructor with 5 parameters
     * 
     * @param id        The id of this person.
     * @param firstName The first name of this person.
     * @param lastName  The last name of this person.
     * @param phone     The phone of this person.
     * @param age       The age of this person.
     */
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

    /**
     * Sets the first name.
     * Check the length of string. If less than a specific length, then pad blank
     * spaces to the right. Otherwise, trim the string to a specific length.
     * 
     * @param firstName The first name of this person.
     */
    public void setFirstName(String firstName) {
        this.firstName = padString(firstName, SIZE_FIRST_NAME);
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     * Check the length of string. If less than a specific length, then pad blank
     * spaces to the right. Otherwise, trim the string to a specific length.
     * 
     * @param lastName The last name of this person.
     */
    public void setLastName(String lastName) {
        this.lastName = padString(lastName, SIZE_LAST_NAME);
    }

    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     * Check the length of string. If less than a specific length, then pad blank
     * spaces to the right. Otherwise, trim the string to a specific length.
     * 
     * @param lastName The phone of this person.
     */
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

    // region Supportive functions

    /**
     * Override the toString() mehod.
     * Print the person information
     */
    @Override
    public String toString() {
        return String.format("%d\t%s %s\t%d\t%s",
                id, firstName, lastName, age, phone);
    }

    /**
     * Check the length of string. If less than a specific length, then pad blank
     * spaces to the right. Otherwise, trim the string to a specific length.
     * 
     * @param str A string to be checked and paded.
     * @param num The target length of string.
     * @return A checked and paded string.
     */
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
    // endregion
}
