package FileSystem;

/**
 * Interface for the prototype of a file system component.
 */
public interface FileSystemComponent extends Cloneable {
    FileSystemComponent clone();
    String getName();

}
