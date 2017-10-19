package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;

public class Archive {

    public Archive() {
    }

    /**
     * Méthode qui archive une location dans un fichier mensuel .loc
     * Si le fichier .loc est déja créé (i.e. si des locations ont déjà été archivé dans le mois), Nous récupérons le contenu du fichier éxistant, faisons un nouveau fichier avec ce contenu et rajoutons le nouveau à la fin
     *
     * @param loc La location à archiver
     */
    public void archiver(Location loc) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(loc.getDateFin());
        int moisFin = cal.get(Calendar.MONTH);
        int anneeFin = cal.get(Calendar.YEAR);
        moisFin++;
        String file_path = "test";
        if (moisFin < 10) {
            file_path = "Miniprojet/ArchiveLoc/" + anneeFin + "0" + moisFin + ".txt";
        } else {
            file_path = "Miniprojet/ArchiveLoc/" + anneeFin + moisFin + ".loc";
        }
        File fichier = new File(file_path);
        if (!fichier.exists()) {
            try {
                fichier.createNewFile();
            } catch (IOException e) {
                System.out.println("Ce fichier existe déjà.\n");
                e.printStackTrace();
            }
        }
        try {
            DataInputStream read_file = new DataInputStream(new FileInputStream(file_path));
            LinkedList<String> lines = new LinkedList<>();
            while (read_file.available() > 0) {
                lines.add(read_file.readUTF());
            }
            read_file.close();
            //Ecriture de la nouvelle location
            DataOutputStream write_file = new DataOutputStream(new FileOutputStream(file_path));
            lines.add(loc.toString() + "\n");
            for (String line : lines) {
                write_file.writeUTF(line);
            }
            write_file.close();
        } catch (IOException e) {
            System.out.println("Ce fichier n'existe pas ou il est impossible d'écrire à l'intérieur.\n");
            e.printStackTrace();
        }
    }
}

