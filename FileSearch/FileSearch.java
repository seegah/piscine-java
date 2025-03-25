import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        File documentsDir = new File("documents");

        if (!documentsDir.exists() || !documentsDir.isDirectory()) {
            return null;
        }

        String relativePath = searchDirectory(documentsDir, fileName);

        return relativePath != null ? "documents/" + relativePath : null;
    }

    private static String searchDirectory(File directory, String fileName) {
        File[] files = directory.listFiles();

        if (files == null) {
            return null;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().equals(fileName)) {
                return file.getName();
            } else if (file.isDirectory()) {
                String result = searchDirectory(file, fileName);
                if (result != null) {
                    return file.getName() + "/" + result;
                }
            }
        }

        return null;
    }
}