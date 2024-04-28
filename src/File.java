
/**
 * Class representing files in the file system.
 */
public class File implements FileSystemComponent {

    private final String name;

    /**
     * Constructor for creating a file with a specified name.
     *
     * @param name The name of the file.
     */
    public File(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the file.
     *
     * @return The name of the file.
     */
    public String getName() {
        return name;
    }

    /**
     * Creates and returns a copy of the file.
     *
     * @return A copy of the file.
     */
    public File clone() {
        return new File(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
