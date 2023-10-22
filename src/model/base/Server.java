package model.base;

import model.Kviz;
import model.KvizPlayable;
import model.Pitanje;
import model.Predmet;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Server {
    public static Server SERVER = new Server();

    private Set<Pitanje> pitanjeSet = new LinkedHashSet<>();

    private Set<Predmet> predmetset = new LinkedHashSet<>();

    private ArrayList<Kviz> kvizLista = new ArrayList<>();

    private KvizPlayable KvizPlayable = null;

    public model.KvizPlayable getKvizPlayable() {
        return KvizPlayable;
    }

    public void setKvizPlayable(model.KvizPlayable kvizPlayable) {
        KvizPlayable = kvizPlayable;
    }

    public Set<Pitanje> getPitanjeSet() {
        return pitanjeSet;
    }

    public Set<Predmet> getPredmetset() {
        return predmetset;
    }

    public ArrayList<Kviz> getKvizLista() {
        return kvizLista;
    }
}
