package com.luccas.semiseed.db;

/**
 * Created by lfo on 18/11/2016.
 */

public class Dicas {
    private int id;
    private String dicaTexto;
    private TipoPlanta tipoPlanta;

    public String getDicaTexto() {
        return dicaTexto;
    }

    public void setDicaTexto(String dicaTexto) {
        this.dicaTexto = dicaTexto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoPlanta getTipoPlanta() {
        return tipoPlanta;
    }

    public void setTipoPlanta(TipoPlanta tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
    }
}
