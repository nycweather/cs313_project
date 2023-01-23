//Coulndnt get string method to work, copied from internet but still didnt work
//Student
package Project1;

public class Student {
    private String name;
    private String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", studentId=" + studentId + "]";
    }
}

//StudentRecord
package Project1;
import java.util.ArrayList;

public class StudentRecord {
    private Student student;
    private ArrayList<Course> courses;

    public StudentRecord(Student student) {
        this.student = student;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public boolean hasCourse(Course course) {
        return courses.contains(course);
    }

    public Student getStudent() {
        return student;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "StudentRecord [student=" + student + ", courses=" + courses + "]";
    }
}

//course
package Project1;

public class Course {
    private String name;
    private String courseId;

    public Course(String name, String courseId) {
        this.name = name;
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Course [name=" + name + ", courseId=" + courseId + "]";
    }
}

//course roster
package Project1;
import java.util.ArrayList;

public class CourseRoster {
    private Course course;
    private ArrayList<Student> students;

    public CourseRoster(Course course) {
        this.course = course;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "CourseRoster [course=" + course + ", students=" + students + "]";
    }
}


//BST
public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        private T data;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(T element) {
        root = add(root, element);
    }

    private Node add(Node node, T element) {
        if (node == null) {
            return new Node(element);
        }
        if (element.compareTo(node.data) < 0) {
            node.left = add(node.left, element);
        } else {
            node.right = add(node.right, element);
        }
        return node;
    }

    public boolean remove(T element) {
        root = remove(root, element);
        return true;
    }

    private Node remove(Node node, T element) {
        if (node == null) {
            return null;
        }
        if (element.compareTo(node.data) < 0) {
            node.left = remove(node.left, element);
        } else if (element.compareTo(node.data) > 0) {
            node.right = remove(node.right, element);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                node.data = findMin(node.right);
                node.right = remove(node.right, node.data);
            }
        }
        return node;
    }

    private T findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node node, T element) {
        if (node == null) {
            return false;
        }
        if (element.compareTo(node.data) < 0) {
            return contains(node.left, element);
        } else if (element.compareTo(node.data) > 0) {
            return contains(node.right, element);
        } else {
            return true;
        }
    }

    public int size() {
        return size(root);
    }

private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }

    private void toString(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        toString(node.left, sb);
        sb.append(node.data).append(" -> ");
        toString(node.right, sb);
    }
}

//reg
package Project1;
import Project1.*;
import java.util.Scanner;


public class Registration {
    private static BinarySearchTree<StudentRecord> studentRecords = new BinarySearchTree<>();
    private static BinarySearchTree<CourseRoster> courseRosters = new BinarySearchTree<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Add course");
            System.out.println("3. Register student for course");
            System.out.println("4. Drop course for student");
            System.out.println("5. Search for course in student record");
            System.out.println("6. Search for student in course roster");
            System.out.println("7. Display student record");
            System.out.println("8. Display course roster");
            System.out.println("9. Display master list of student records");
            System.out.println("10. Display master list of course rosters");
            System.out.println("11. Exit");
            System.out.print("Enter option: ");
            int option = sc.nextInt();
            sc.nextLine();
            if (option == 1) {
                addStudent(sc);
            } else if (option == 2) {
                addCourse(sc);
            } else if (option == 3) {
                registerStudentForCourse(sc);
            } else if (option == 4) {
                dropCourseForStudent(sc);
            } else if (option == 5) {
                searchForCourseInStudentRecord(sc);
            } else if (option == 6) {
                searchForStudentInCourseRoster(sc);
            } else if (option == 7) {
                displayStudentRecord(sc);
            } else if (option == 8) {
                displayCourseRoster(sc);
            } else if (option == 9) {
                displayMasterListOfStudentRecords();
            } else if (option == 10) {
                displayMasterListOfCourseRosters();
            } else if (option == 11) {
                break;
            }
        }
        sc.close();
    }

    private static void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        Student student = new Student(name, studentId);
        studentRecords.add(new StudentRecord(student));
    }

    private static void addCourse(Scanner sc) {
        System.out.print("Enter course name: ");
        String name = sc.nextLine();
        System.out.print("Enter course ID");
        String courseID = sc.nextLine();
        Course crs = new Course(name, courseID);
        Course.add(new Course(crs));
    } //not working
    
    private static void registerStudentForCourse(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        StudentRecord studentRecord = getStudentRecordByStudentId(studentId);
        if (studentRecord == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine();
        CourseRoster courseRoster = getCourseRosterByCourseId(courseId);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        if (studentRecord.hasCourse(courseRoster.getCourse())) {
            System.out.println("Student already registered for this course.");
            return;
        }
        studentRecord.addCourse(courseRoster.getCourse());
        courseRoster.addStudent(studentRecord.getStudent());
    }

    private static void dropCourseForStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        StudentRecord studentRecord = getStudentRecordByStudentId(studentId);
        if (studentRecord == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine();
        CourseRoster courseRoster = getCourseRosterByCourseId(courseId);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        if (!studentRecord.hasCourse(courseRoster.getCourse())) {
            System.out.println("Student not registered for this course.");
            return;
        }
        studentRecord.removeCourse(courseRoster.getCourse());
        courseRoster.removeStudent(studentRecord.getStudent());
    }

    private static void searchForCourseInStudentRecord(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        StudentRecord studentRecord = getStudentRecordByStudentId(studentId);
        if (studentRecord == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine();
        Course course = getCourseByCourseId(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        if (studentRecord.hasCourse(course)) {
            System.out.println("Student is registered for this course.");
        } else {
            System.out.println("Student is not registered for this course.");
        }
    }

    private static void searchForStudentInCourseRoster(Scanner sc) {
        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine();
        CourseRoster courseRoster = getCourseRosterByCourseId(courseId);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        Student student = getStudentByStudentId(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        if (courseRoster.hasStudent(student)) {
            System.out.println("Student is registered for this course.");
        } else {
            System.out.println("Student is not registered for this course.");
        }
    }

    private static void displayStudentRecord(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        StudentRecord studentRecord = getStudentRecordByStudentId(studentId);
        if (studentRecord == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println(studentRecord);
    }

    private static void displayCourseRoster(Scanner sc) {
        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine();
        CourseRoster courseRoster = getCourseRosterByCourseId(courseId);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.println(courseRoster);
    }

    private static void displayMasterListOfStudentRecords() {
        System.out.println(studentRecords);
    }

    private static void displayMasterListOfCourseRosters() {
        System.out.println(courseRosters);
    }

    private static StudentRecord getStudentRecordByStudentId(String studentId) {
        for (StudentRecord studentRecord : studentRecords) {
            if (studentRecord.getStudent().getStudentId().equals(studentId)) {
                return studentRecord;
            }
        }
        return null;
    }

    private static CourseRoster getCourseRosterByCourseId(String courseId) {
        for (CourseRoster courseRoster : courseRosters) {
            if (courseRoster.getCourse().getCourseId().equals(courseId)) {
                return courseRoster;
            }
        }
        return null;
    }

    private static Course getCourseByCourseId(String courseId) {
        for (CourseRoster courseRoster : courseRosters) {
            if (courseRoster.getCourse().getCourseId().equals(courseId)) {
                return courseRoster.getCourse();
            }
        }
        return null;
    }

    private static Student getStudentByStudentId(String studentId) {
        for (StudentRecord studentRecord : studentRecords) {
            if (studentRecord.getStudent().getStudentId().equals(studentId)) {
                return studentRecord.getStudent();
            }
        }
        return null;
    }
}


    
        

