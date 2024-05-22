import FileSystem.Directory;
import FileSystem.File;
import utils.FileSystemPrinter;

/*
 * Main class to test the prototype pattern.
 */
public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("Root");

        Directory dir1 = new Directory("Dir1");
        Directory dir2 = new Directory("Dir2");
        Directory dir3 = new Directory("Dir3");

        File file1 = new File("File1");
        File file2 = new File("File2");
        File file3 = new File("File3");
        File file4 = new File("File4");
        File file5 = new File("File5");
        File file6 = new File("File6");


        dir1.addComponent(file2);
        dir1.addComponent(file3);

        dir3.addComponent(file5);
        dir3.addComponent(file6);

        dir2.addComponent(dir3);
        dir2.addComponent(file4);


        root.addComponent(file1);
        root.addComponent(dir1);
        root.addComponent(dir2);


        Directory clonedRoot = root.clone(2);

        System.out.println("Original root: ");
        FileSystemPrinter.printFileSystem(root);
        System.out.println("\nCloned root: ");
        FileSystemPrinter.printFileSystem(clonedRoot);
    }
}
