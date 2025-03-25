import java.io.*;

public class FileManager {

    // 1️⃣ Créer un fichier et écrire du contenu dedans
    public static void createFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }

    // 2️⃣ Lire le contenu d'un fichier et le retourner
    public static String getContentFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString(); // Supprime le dernier \n pour correspondre à l'exemple
    }

    // 3️⃣ Supprimer un fichier
    public static void deleteFile(String fileName) {
        new File(fileName).delete();
    }
}
