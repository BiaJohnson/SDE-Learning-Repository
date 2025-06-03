/**
 * Represents a Subject with an ID and name.
 * This class provides basic functionality for managing subject information.
 */
public class Subject {
    /** The unique identifier for the subject */
    String id;

    /** The name of the subject */
    String name;

    /**
     * Constructs a new Subject with the specified ID and name.
     * @param id The unique identifier for the subject
     * @param name The name of the subject
     */
    public Subject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns a string representation of the Subject.
     * @return A string containing the subject's ID and name
     */
    public String toString(){
        return id + " " + name;
    }

    /**
     * Gets the subject's ID.
     * @return The subject's ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the subject's ID.
     * @param id The new ID to set
     */
    public void setId(String id) {

    }

    /**
     * Gets the subject's name.
     * @return The subject's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the subject's name.
     * @param name The new name to set
     */
    public void setName(String name) {

    }
}