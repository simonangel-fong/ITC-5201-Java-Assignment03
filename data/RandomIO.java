package data;

import java.io.*;
import java.util.*;

import business.*;

/**
 * This is a class represent IO controller that reads, writes, and sends
 * response to UI.
 */
public class RandomIO {

    private final String PATH = "./data/";
    private final String FILE_NAME = "RandomFileData.dat";

    private File file;

    private String message;
    private ArrayList<Person> personList;

    public RandomIO() {
        file = new File(PATH + FILE_NAME);

    }

    // region Functionalities
    public RandomResponse listPerson() {
        ArrayList<Person> result;
        try {
            result = readFile();
            message = "Success\tList all person.";
            return new RandomResponse(RadomSignal.SUCCESS, message, result);
        } catch (Exception ex) {
            result = new ArrayList<>();
            ex.printStackTrace();

            message = String.format("Error\tlistPerson()\t%s", ex.getMessage());
            return new RandomResponse(RadomSignal.ERROR, message, result);
        }
    }

    public RandomResponse addPerson(Person person) {
        ArrayList<Person> result = new ArrayList<>();
        result.add(person);

        try {
            writeFile(person);

            message = "Success\tAdd a new person with record number(%d).".formatted(person.getID());
            return new RandomResponse(RadomSignal.SUCCESS, message, result);
        } catch (Exception ex) {
            ex.printStackTrace();

            message = String.format("Error\taddPerson(%d)\t%s",
                    person.getID(), ex.getMessage());
            return new RandomResponse(RadomSignal.ERROR, message, result);
        }
    }

    public RandomResponse findPerson(int recordNum) {
        ArrayList<Person> result = new ArrayList<>();

        try {
            personList = readFile();

            for (Person p : personList) {
                if (p.getID() == recordNum) {
                    result.add(p);
                    message = "Success\tGet a person with record number(%d).".formatted(recordNum);
                    break;
                }
            }

            message = "Warning\tNo person with record number(%d).".formatted(recordNum);
            return new RandomResponse(RadomSignal.SUCCESS, message, result);
        } catch (Exception ex) {
            ex.printStackTrace();

            message = String.format("Error\tfindPersion(%d)\t%s",
                    recordNum, ex.getMessage());
            return new RandomResponse(RadomSignal.ERROR, message, new ArrayList<>());
        }
    }

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
    private void writeFile(Person person) throws Exception {

        try (RandomAccessFile accessor = new RandomAccessFile(file, "rw")) {
            // accessor.setLength(0);// rewrite file.

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

    private ArrayList<Person> readFile() throws Exception {
        ArrayList<Person> result = new ArrayList<Person>();

        try (RandomAccessFile accessor = new RandomAccessFile(file, "rw")) {

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

    private void truncatFile() throws Exception {
        try (RandomAccessFile accessor = new RandomAccessFile(file, "rw")) {
            accessor.setLength(0);// rewrite file.
            // System.out.println(accessor.length());
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    // endregion
}