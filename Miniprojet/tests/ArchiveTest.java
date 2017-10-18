package tests;

import java.io.IOException;

import main.ArchiveWriter;

public class ArchiveTest {

    public static void main(String[] args) throws IOException {
        ArchiveWriter archiveW = new ArchiveWriter();
        archiveW.writeIntoFile("magasinLocation/Miniprojet/ArchiveLoc/text.txt", "coucou");
    }
}
