import java.util.ArrayList;
import java.util.HashMap;

public class StudentMasterByID {
    // ArrayList to store the student objects in alphabetical order
    private ArrayList<Student> studentList;

    // HashMap to store the student objects indexed by their ID number
    private HashMap<Integer, Student> studentMap;

    public StudentMasterByID() {
        this.studentList = new ArrayList<>();
        this.studentMap = new HashMap<>();
    }

    // Method to add a student to the StudentMasterByID
    public void addStudent(Student student) {
        // Add the student to the ArrayList in alphabetical order
        int index = 0;
        while (index < studentList.size() && studentList.get(index).getName().compareTo(student.getName()) < 0) {
            index++;
        }
        studentList.add(index, student);

        // Add the student to the HashMap indexed by their ID number
        studentMap.put(student.getID() % 100, student);
    }

    // Method to search for a student by name or ID
    public Student searchStudent(String name, int ID) {
        if (name != null) {
            // Search for the student by name in the ArrayList
            for (Student student : studentList) {
                if (student.getName().equals(name)) {
                    return student;
                }
            }
        } else if (ID != -1) {
            // Search for the student by ID in the HashMap
            return studentMap.get(ID % 100);
        }
        return null;
    }

    // Method to add a course to a student by name or ID
    public void addCourse(String name, int ID, Course course) {
        Student student = searchStudent(name, ID);
        if (student != null) {
            student.addCourse(course);
        }
    }

    // Method to drop a course from a student by name or ID
    public void dropCourse(String name, int ID, Course course) {
        Student student = searchStudent(name, ID);
        if (student != null) {
            student.dropCourse(course);
        }
    }
}
