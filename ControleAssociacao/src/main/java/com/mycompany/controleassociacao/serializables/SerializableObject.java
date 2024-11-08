package com.mycompany.controleassociacao.serializables;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Karol
 */
public class SerializableObject {

    private String path;

    public SerializableObject(String fileName) {
        try {
            Path currentDir = Paths.get("").toAbsolutePath();
            Path targetDir = currentDir.getParent().resolve("files");

            Files.createDirectories(targetDir);

            Path filePath = targetDir.resolve(fileName);
            this.path = filePath.toString();

            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeObjects(List<?> objects) throws Exception {
        try (FileOutputStream fout = new FileOutputStream(this.path, false); ObjectOutputStream oos = new ObjectOutputStream(fout)) {

            oos.writeObject(objects);

        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<?> readObjects() throws Exception {
        try (FileInputStream fin = new FileInputStream(this.path); ObjectInputStream ois = new ObjectInputStream(fin)) {
            return (List<Object>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
