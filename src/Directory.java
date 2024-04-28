import java.util.List;
import java.util.ArrayList;

/**
 * Class representing directories in the file system.
 */
public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children;

    /**
     * Constructor for creating a Directory with a specified name.
     *
     * @param name The name of the directory.
     */
    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    /**
     * Gets the name of the directory.
     *
     * @return The name of the directory.
     */
    public String getName() {
        return name;
    }

    /**
     * Creates and returns a copy of the directory.
     */
    public void addComponent(FileSystemComponent component) {
        children.add(component);
    }

    /**
     * Displays the contents of the directory.
     */
    public void displayAll() {
        if (children.isEmpty()) {
            System.out.println(name);
        } else {
            System.out.println(name + " contains:");
            for (FileSystemComponent component : children) {
                System.out.println(component.toString());
                if (component instanceof Directory) {
                    ((Directory) component).display();
                }
            }
        }
    }


    private void display() {
        if (children.isEmpty()) {
            System.out.println(name);
        } else {
            for (FileSystemComponent component : children) {
                System.out.println("\t" + component.toString());
            }
        }
    }

    /**
     * Creates and returns a copy of the directory.
     *
     * @return A copy of the directory.
     */
    public Directory clone() {
        Directory clone = new Directory(name);
        for (FileSystemComponent component : children) {
            clone.addComponent(component.clone());
        }
        return clone;
    }

    @Override
    public String toString() {
        return name;
    }
}