/*
 * Main class to test the prototype pattern.
 */
public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("Root");

        Directory dir1 = new Directory("Folder1");
        Directory dir2 = new Directory("Folder2");
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");

        root.addComponent(dir1);
        root.addComponent(dir2);
        dir1.addComponent(file1);
        dir2.addComponent(file2);

        Directory clonedRoot = root.clone();
        System.out.println("Original root name: " + root.getName());
        System.out.println("Cloned root name: " + clonedRoot.getName());
        System.out.println();

        System.out.println("Original root name: " + root.getName());
        root.displayAll();

        System.out.println();

        System.out.println("Cloned root name: " + clonedRoot.getName());
        clonedRoot.displayAll();
    }
}
