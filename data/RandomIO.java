package data;

import java.io.*;
import java.util.*;

import business.*;

/**
 * ID: n01555914
 * Name: Wenhao Fang
 * 
 * This is a class represents IO controller that reads and writes file, and sends
 * response to UI.
 * 
 * @author Wenhao Fang
 */
public class RandomIO {

    // region Private members

    // The size for each record
    private final int SIZE = Person.SIZE_FIRST_NAME + 2// due to the use of .writeUTF(), additional 2 byte should be
                                                       // counted.
            + Person.SIZE_LAST_NAME + 2
            + Person.SIZE_PHONE + 2
            + Person.SIZE_ID
            + Person.SIZE_AGE;

    // Default path of file
    private final String PATH = "./data/";
    private final String FILE_NAME = "RandomFileData.dat";

    private File file;

    private String message;// a string message to be returned in response.

    // endregion

    // region Constructors

    /**
     * Default constructor, using the default path.
     */
    public RandomIO() {
        file = new File(PATH + FILE_NAME);
    }

    /**
     * Constructor with a parameter, using a given path.
     */
    public RandomIO(String path) {
        file = new File(path);
    }

    // endregion

    // region Functionalities

    /**
     * list all person information.s
     * 
     * @return An obj of RandomResponse that indicates signal, message, and possible
     *         person data.
     */
    public RandomResponse listPerson() {
        ArrayList<Person> result;
        try {
            result = readFile();// use readFile() without parameter to get a list of all person.

            message = "Success\tList all person.";// Message passing to UI
            return new RandomResponse(RadomSignal.SUCCESS, message, result);
        } catch (Exception ex) {
            result = new ArrayList<>();// If exception, return an empty list.
            ex.printStackTrace();

            message = String.format("Error\tlistPerson()\t%s", ex.getMessage());
            return new RandomResponse(RadomSignal.ERROR, message, result);
        }
    }

    /**
     * Adds a new person.
     * Check the uniqueness of person id.
     * If true, then write to end of file; Otherwise, return a warning.
     * 
     * @param person An object of a new person.
     * @return An obj of RandomResponse that indicates signal, message, and possible
     *         person data.
     */
    public RandomResponse addPerson(Person person) {
        ArrayList<Person> result = new ArrayList<>();
        result.add(person);

        try {
            if (isUnique(person.getID())) {// check uniqueness
                writeFile(person);// if true, write new person.

                message = "Success\tAdd a new person with record number(%d).".formatted(person.getID());
                return new RandomResponse(RadomSignal.SUCCESS, message, result);
            } else {
                message = "Warning\tThe record number(%d) exists!".formatted(person.getID());
                return new RandomResponse(RadomSignal.WARNING, message, result);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            message = String.format("Error\taddPerson(%d)\t%s",
                    person.getID(), ex.getMessage());
            return new RandomResponse(RadomSignal.ERROR, message, result);
        }
    }

    /**
     * Finds a person for a specific record number.
     * 
     * @param recordNum The record number of this person.
     * @return An obj of RandomResponse that indicates signal, message, and possible
     *         person data.
     */
    public RandomResponse findPerson(int recordNum) {
        ArrayList<Person> result = new ArrayList<>();

        try {
            Person person = readFile(recordNum);

            if (person.getID() == recordNum) {
                result.add(person);// if exists, add the return person obj.

                message = "Success\tGet a person with record number(%d).".formatted(recordNum);
                return new RandomResponse(RadomSignal.SUCCESS, message, result);
            } else {
                message = "Warning\tNo person with record number(%d).".formatted(recordNum);
                return new RandomResponse(RadomSignal.WARNING, message, result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

            message = String.format("Error\tfindPersion(%d)\t%s",
                    recordNum, ex.getMessage());
            return new RandomResponse(RadomSignal.ERROR, message, new ArrayList<>());
        }
    }

    /**
     * Deletes all person.
     * 
     * @param recordNum The record number of this person.
     * @return An obj of RandomResponse that indicates signal, message, and possible
     *         person data.
     */
    public RandomResponse deleteAllPerson() {
        try {
            truncatFile();

            message = "Success\tDelete all rows.";
            return new RandomResponse(RadomSignal.SUCCESS, message, new ArrayList<>());
        } catch (Exception ex) {
            ex.printStackTrace();

            message = "Error\t%s.".formatted(ex.getMessage());
            return new RandomResponse(RadomSignal.ERROR, message, new ArrayList<>());
        }
    }

    // endregion

    // region Supportive functions

    /**
     * Write a person into the file, using RandomAccessFile class.
     * 
     * @param person An obj of person.
     * @throws Exception The exception raised while writing the file, including the
     *                   IOException, EOFexception, and any other Exception.
     */
    private void writeFile(Person person) throws Exception {

        try (RandomAccessFile accessor = new RandomAccessFile(file, "rw")) {

            accessor.seek(accessor.length()); // set pointer to the end of the file
            accessor.writeInt(person.getID());// 4
            accessor.writeUTF(person.getFirstName());// 26
            accessor.writeUTF(person.getLastName());// 53
            accessor.writeUTF(person.getPhone());// 65
            accessor.writeInt(person.getAge());// 69
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Reads the file then return a list of all person.
     * 
     * @return An ArrayList of person.
     * @throws Exception The exception raised while writing the file, including the
     *                   IOException, EOFexception, and any other Exception.
     */
    private ArrayList<Person> readFile() throws Exception {
        ArrayList<Person> result = new ArrayList<Person>();

        try (RandomAccessFile accessor = new RandomAccessFile(file, "r")) {

            int sizePerPerson = Person.SIZE_FIRST_NAME + 2 + Person.SIZE_LAST_NAME + 2 + Person.SIZE_PHONE + 2
                    + Person.SIZE_ID
                    + Person.SIZE_AGE;

            for (int i = 0; i < accessor.length(); i += sizePerPerson) {
                Person person = new Person();

                person.setID(accessor.readInt());
                person.setFirstName(accessor.readUTF());
                person.setLastName(accessor.readUTF());
                person.setPhone(accessor.readUTF());
                person.setAge(accessor.readInt());

                result.add(person);
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Reads the file then return a person with given id.
     * 
     * @return An obj of person.
     * @throws Exception The exception raised while writing the file, including the
     *                   IOException, EOFexception, and any other Exception.
     */
    private Person readFile(int recordNum) throws Exception {
        Person result = new Person();

        try (RandomAccessFile accessor = new RandomAccessFile(file, "r")) {

            for (int i = 0; i < accessor.length(); i += SIZE) {
                accessor.seek(i);// Set the current pointer for each iteration, to read the value of id properly.

                if (accessor.readInt() == recordNum) {// if matches, get the details.
                    result.setID(recordNum);
                    result.setFirstName(accessor.readUTF());
                    result.setLastName(accessor.readUTF());
                    result.setPhone(accessor.readUTF());
                    result.setAge(accessor.readInt());
                }
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Deletes all person data.
     * 
     * @throws Exception The exception raised while writing the file, including the
     *                   IOException, EOFexception, and any other Exception.
     */
    private void truncatFile() throws Exception {
        try (RandomAccessFile accessor = new RandomAccessFile(file, "rw")) {
            accessor.setLength(0);// Set the length of file to be zero, to rewrite file.
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Checks whether the given record number already exists in the file.
     * 
     * @param recordNum A given record number.
     * @return True if the given record number cannot be find in the file;
     *         Otherwise, false.
     * @throws Exception The exception raised while writing the file, including the
     *                   IOException, EOFexception, and any other Exception.
     */
    private boolean isUnique(int recordNum) throws Exception {
        boolean result = true;

        try (RandomAccessFile accessor = new RandomAccessFile(file, "r")) {
            for (int i = 0; i < accessor.length(); i += SIZE) {
                accessor.seek(i);// Set the current pointer for each iteration, to read the value of id properly.
                if (accessor.readInt() == recordNum) {
                    result = false;
                    // System.out.println("isUnique: " + result);
                    break; // if already exists, break the loop.
                }
            }
            return result;
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    // endregion
}