package com.example.alexandramolina.tarea3;

/**
 * Created by alexandramolina on 12/3/18.
 */

public class Musica {
    private String cancion;
    private String artista;
    private int num_cancion;

    public Musica(String cancion, String artista, int num_cancion) {
        this.cancion = cancion;
        this.artista = artista;
        this.num_cancion = num_cancion;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {

        this.cancion = cancion;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNum_cancion() {
        return num_cancion;
    }

    public void setNum_cancion(int num_cancion) {
        this.num_cancion = num_cancion;
    }
}
