package FileSystem;

/**
 * Class representing files in the file system.
 */
public class File implements FileSystemComponent {

    private String name;
    private int depth;

    /**
     * Constructor for creating a file with a specified name.
     *
     * @param name The name of the file.
     */
    public File(String name) {
        this.name = name;
        this.depth = 0;
    }
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the depth of the file.
     *
     * @param depth The depth of the file.
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Creates and returns a copy of the file.
     *
     * @return A copy of the file.
     */
    public File clone() {
        File clonedFile = new File("cloned" + name);
        clonedFile.setDepth(this.depth);
        return clonedFile;
    }
}
