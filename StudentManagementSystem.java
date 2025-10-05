import java.util.*;

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

interface RecordActions {
    void addStudent();
    void displayStudent(int rollNo) throws StudentNotFoundException;
}

class Loader implements Runnable {
    private String message;

    public Loader(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.print(message);
        try {
            for (int i = 0; i < 5; i++) {
                System.out.print(".");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("\nLoading interrupted!");
        }
        System.out.println("\nLoading complete!\n");
    }
}

class Student {
    Integer rollNo;
    String name, email, course;
    Double marks;

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 75) return 'B';
        else if (marks >= 60) return 'C';
        else if (marks >= 40) return 'D';
        else return 'F';
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo +
               "\nName: " + name +
               "\nEmail: " + email +
               "\nCourse: " + course +
               "\nMarks: " + marks +
               "\nGrade: " + calculateGrade();
    }
}

class StudentManager implements RecordActions {
    private Map<Integer, Student> studentRecords = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void addStudent() {
        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer rollNo = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Course: ");
            String course = sc.nextLine();
            System.out.print("Enter Marks: ");
            Double marks = Double.parseDouble(sc.nextLine());

            if (name.isEmpty() || email.isEmpty() || course.isEmpty())
                throw new IllegalArgumentException("Fields cannot be empty!");
            if (marks < 0 || marks > 100)
                throw new IllegalArgumentException("Marks must be between 0 and 100!");

            Thread loaderThread = new Thread(new Loader("Loading"));
            loaderThread.start();
            loaderThread.join();

            studentRecords.put(rollNo, new Student(rollNo, name, email, course, marks));
            System.out.println("Student added successfully!\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numeric values where required.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        } finally {
            System.out.println("Operation completed.\n");
        }
    }

    @Override
    public void displayStudent(int rollNo) throws StudentNotFoundException {
        if (!studentRecords.containsKey(rollNo))
            throw new StudentNotFoundException("Student with roll number " + rollNo + " not found!");
        System.out.println(studentRecords.get(rollNo));
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1 -> manager.addStudent();
                case 2 -> {
                    System.out.print("Enter Roll No to View: ");
                    int rollNo = Integer.parseInt(sc.nextLine());
                    try {
                        manager.displayStudent(rollNo);
                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Program execution completed.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.\n");
            }
        }
    }
}
