/**
 * Interface for the prototype of a file system component.
 */
public interface FileSystemComponent extends Cloneable {
    /**
     * Creates and returns a copy of the object.
     *
     * @return A copy of the object.
     */
    FileSystemComponent clone();

    /**
     * Gets the name of the file system component.
     *
     * @return The name of the component.
     */
    String getName();

}
