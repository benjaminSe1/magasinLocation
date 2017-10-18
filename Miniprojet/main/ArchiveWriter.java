package main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ArchiveWriter {

    public ArchiveWriter() {
    }

    public void writeIntoFile(String filePath, String text) throws IOException {
        try {
            System.out.println("coucou");
            byte[] tab = text.getBytes();
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8"));
            for (byte b : tab) {
                writer.write(b);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

