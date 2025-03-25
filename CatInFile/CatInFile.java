import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        // Vérifier si un fichier de sortie est spécifié
        if (args.length != 1) {
            return; // Aucun fichier fourni, ne rien faire
        }

        String outputFile = args[0];

        // Lire depuis l'entrée standard et écrire dans le fichier
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            byte[] buffer = new byte[1024]; // Lire par blocs de 1024 octets
            int bytesRead;

            while ((bytesRead = System.in.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead); // Écrire les octets lus dans le fichier
            }
        }
    }
}
