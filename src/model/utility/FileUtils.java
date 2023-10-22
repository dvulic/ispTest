package model.utility;

import model.Pitanje;
import model.Predmet;
import model.base.Server;

import java.io.*;

public class FileUtils {

    public static void UcitajPitanja(String imeFajla){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String tekstPitanja = null;
        String odgovor = null;
        String nazivPredmeta = null;
        String[] niz = null;

        try {
            fis = new FileInputStream(imeFajla);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            for(String linija = br.readLine(); linija != null && !linija.trim().equals(""); linija = br.readLine()){
                niz = linija.split(";");
                tekstPitanja = niz[0];
                odgovor = niz[1];
                nazivPredmeta = niz[2];
                boolean postoji = false;
                for (Predmet p: Server.SERVER.getPredmetset()
                     ) {
                    if(p.getNazivPredmeta().equals(nazivPredmeta)){
                        postoji = true;
                        Server.SERVER.getPitanjeSet().add(new Pitanje(odgovor, tekstPitanja, p));
                        break;
                    }
                }
                if(!postoji){
                    Predmet pr = new Predmet(nazivPredmeta);
                    Server.SERVER.getPredmetset().add(pr);
                    Server.SERVER.getPitanjeSet().add(new Pitanje(odgovor, tekstPitanja, pr));

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void SacuvajPitanja(String imeFajla){
        OutputStreamWriter writer = null;

        try {
            writer = new OutputStreamWriter(new FileOutputStream(imeFajla));
            for (Pitanje p:Server.SERVER.getPitanjeSet()
                 ) {
                writer.write(p.getPitanje()+";"+p.getOdgovor()+";"+p.getPredmet()+"\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private FileUtils(){

    }
}
