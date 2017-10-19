package main;

import java.io.*;
import java.util.Calendar;
import java.util.LinkedList;

public class ArchiveWriter {

    public ArchiveWriter() {
    }

    public void writeIntoFile(Location loc) {
        //Enregistrement dans le fichier du mois de restitution la location
        //On recherche si le fichier du mois à été crée si oui on écris dedans sinon on en créer un nouveau
        Calendar cal = Calendar.getInstance();
        cal.setTime(loc.getDateFin());
        int moisRest = cal.get(Calendar.MONTH);
        int anneeRest = cal.get(Calendar.YEAR);
        moisRest++;
        String file_path = "test";
        if(moisRest < 10) file_path = "Miniprojet/ArchiveLoc/" + anneeRest + "0" + moisRest + ".txt";
        else file_path = "Miniprojet/ArchiveLoc/" + anneeRest + moisRest + ".txt";
        File fichier = new File(file_path);
        //Si le fichier n'existe pas on en créer un nouveau
        if (!fichier.exists()) {
            try {
                fichier.createNewFile();
            } catch (IOException e) {
                System.out.println("Ce fichier existe déjà.\n");
                e.printStackTrace();
            }
        }

        try {
            //Récupération des anciennes locations
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

