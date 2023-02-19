# ITC-5201-Java-Assignment03

- Semester: #02
- Course: ITC-5201-Java
- Assignment: #03 - Binary I/O and Random File Processing
- Group: #03
- Member:
  - Ansh Bhardwaj
  - Tsz Kit Cheung
  - Wenhao Fang

---

## Requirement

- Package `business`:
  - Person class
    - First name, string type, max size 20 characters
    - Last name, string type, max size 25 characters
    - Phone, string type, max size 10 characters
    - Age, int type
    - Define public constants for the size of each string field and record
    - Provide getters and setters for each field
- Package `presentation`:
  - GUI
    - Design
      ![sample](./img/gui_sample.png)
    - Validation
- Package `data`:

  - `RandomIO`class
    - Methods:
      1. add person to the binary file.
      2. find a person based on record number and return person

- Functionalities:
  1. add person to the file using the data entered in the fields of the GUI.
  2. ind a person using the record number and display its information in an appropriate control.

---

## Version 1.0

1. Create baseline file structure:

- `/`
  - RandomFile.java (main)
  - `business/`
    - Person.java
  - `presentation/`
    - RandomFileUI.java
  - `data/`
    - RandomIO.java

2. Synchronize file structure and requirement among group members.

3. Share common git command.

---

## Version 1.001

- `/`
  - RandomFile.java (main)
  - `business/`
    - **Person.java**
  - `presentation/`
    - RandomFileUI.java
  - `data/`
    - **RandomIO.java**
    - **RandomSignal.java**
    - **RandomResponse.java**

---

[TOP](#itc-5201-java-assignment03)
