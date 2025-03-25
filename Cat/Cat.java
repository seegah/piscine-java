import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        // Vérifier si un fichier est fourni
        if (args.length == 0) {
            return; // Aucun fichier fourni, ne rien afficher
        }

        String filename = args[0];

        // Lire et afficher le fichier en utilisant un buffer
        try (FileInputStream fis = new FileInputStream(filename);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            
            byte[] buffer = new byte[1024]; // Lecture par blocs de 1024 octets
            int bytesRead;
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead); // Écrire directement le contenu binaire
            }
        }
    }
}
