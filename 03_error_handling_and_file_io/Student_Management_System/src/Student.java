/**The Student class represents a student with a name and age.
 */
public class Student {
    private String name; // The student's name
    private int age; // The student's age
    /**
     Constructs a Student object with the given name and age.
     *
     @param name The name of the student.
     @param age  The age of the student.
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /**
     Retrieves the student's name.
     *
     @return The name of the student.
     */
    public String getName() {
        return name;
    }
    /**
     Retrieves the student's age.
     *
     @return The age of the student.
     */
    public int getAge() {
        return age;
    }
}






