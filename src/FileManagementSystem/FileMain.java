package FileManagementSystem;

public class FileMain {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        System.out.println("Running predefined file system commands...\n");

        // Predefined command executions
        runCommand(fs, "create /a");
        runCommand(fs, "create /a/b");
        runCommand(fs, "create /a/b/file1");
        runCommand(fs, "write /a/b/file1 HelloWorld");
        runCommand(fs, "read /a/b/file1");
        runCommand(fs, "display");
        runCommand(fs, "delete /a/b/file1");
        runCommand(fs, "display");
    }

    private static void runCommand(FileSystem fs, String input) {
        System.out.println("Command: " + input);
        String[] parts = input.trim().split("\\s+", 3);
        if (parts.length == 0) return;

        String command = parts[0].toLowerCase();

        try {
            switch (command) {
                case "create":
                    if (parts.length >= 2) {
                        boolean isCreated = fs.createPath(parts[1]);
                        System.out.println(isCreated ? "Path created successfully" : "Failed to create path");
                    } else {
                        System.out.println("Usage: create <path>");
                    }
                    break;
                case "write":
                    if (parts.length >= 3) {
                        boolean isWritten = fs.setFileContent(parts[1], parts[2]);
                        System.out.println(isWritten ? "Content written successfully" : "Failed to write content");
                    } else {
                        System.out.println("Usage: write <path> <content>");
                    }
                    break;
                case "read":
                    if (parts.length >= 2) {
                        String content = fs.getFileContent(parts[1]);
                        System.out.println(content != null ? "Content: " + content : "Failed to read content");
                    } else {
                        System.out.println("Usage: read <path>");
                    }
                    break;
                case "delete":
                    if (parts.length >= 2) {
                        boolean isDeleted = fs.deletePath(parts[1]);
                        System.out.println(isDeleted ? "Path deleted successfully" : "Failed to delete path");
                    } else {
                        System.out.println("Usage: delete <path>");
                    }
                    break;
                case "display":
                    System.out.println("\nFile System Structure:");
                    fs.display();
                    break;
                default:
                    System.out.println("Unknown command. Available: create, write, read, delete, display");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
    }
}