package utils;

import FileSystem.Directory;
import FileSystem.FileSystemComponent;

/**
 * A utility class to print the file system.
 */
public class FileSystemPrinter {
    /**
     * Prints the file system.
     *
     * @param component The root of the file system.
     */
    public static void printFileSystem(FileSystemComponent component) {
        printFileSystem(component, 0);
    }

    private static void printFileSystem(FileSystemComponent component, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("    ");
        }
        sb.append(component.getName());
        if (component instanceof Directory) {
            sb.append("/");
        }
        System.out.println(sb);

        if (component instanceof Directory) {
            for (FileSystemComponent child : ((Directory) component).getChildren()) {
                printFileSystem(child, indent + 1);
            }
        }
    }
}

