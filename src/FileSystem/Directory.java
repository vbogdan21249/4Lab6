package FileSystem;

import java.util.List;
import java.util.ArrayList;

/**
 * Class representing directories in the file system.
 */
public class Directory implements FileSystemComponent {
    private String name;
    private int depth;
    private final List<FileSystemComponent> children;

    /**
     * Gets the name of the directory.
     *
     * @return The name of the directory.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the children of the directory.
     *
     * @return The children of the directory.
     */
    public List<FileSystemComponent> getChildren() {
        return children;
    }

    private void setDepth(int depth) {
        this.depth = depth;
        for (FileSystemComponent child : children) {
            if (child instanceof Directory) {
                ((Directory) child).setDepth(depth + 1);
            } else if (child instanceof File) {
                ((File) child).setDepth(depth + 1);
            }
        }
    }

    /**
     * Constructor for creating a FileSystem.Directory with a specified name.
     *
     * @param name The name of the directory.
     */
    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }


    /**
     * Adds a component to the directory.
     *
     * @param component The component to add.
     */
    public void addComponent(FileSystemComponent component) {
        if (component instanceof Directory) {
            ((Directory) component).setDepth(depth + 1);
        } else if (component instanceof File) {
            ((File) component).setDepth(this.depth + 1);
        }
        children.add(component);
    }

    /**
     * Creates and returns a copy of the directory.
     *
     * @return A copy of the directory.
     */
    @Override
    public Directory clone() {
        Directory clonedDirectory = new Directory("cloned" + name);
        clonedDirectory.setDepth(this.depth);
        return clonedDirectory;
    }

    /**
     * Creates and returns a copy of the directory with a specified depth.
     *
     * @param depth The depth of the copy.
     * @return A copy of the directory.
     */
    public Directory clone(int depth) {
        Directory clonedDirectory = new Directory("cloned" + name);
        clonedDirectory.setDepth(this.depth);

        if (depth > 0) {
            for (FileSystemComponent component : children) {
                if (component instanceof Directory) {
                    clonedDirectory.addComponent(((Directory) component).clone(depth - 1));
                } else if (component instanceof File) {
                    clonedDirectory.addComponent(component.clone());
                }
            }
        }
        return clonedDirectory;
    }
}