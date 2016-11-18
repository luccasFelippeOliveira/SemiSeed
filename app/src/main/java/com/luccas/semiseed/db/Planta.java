package com.luccas.semiseed.db;

/**
 * Created by lfo on 18/11/2016.
 */

public class Planta {
    private int id;
    private int agua;
    private int adubo;
    private String imagem;
    private TipoPlanta tipoPlanta;

    public int getAdubo() {
        return adubo;
    }

    public void setAdubo(int adubo) {
        this.adubo = adubo;
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public TipoPlanta getTipoPlanta() {
        return tipoPlanta;
    }

    public void setTipoPlanta(TipoPlanta tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
    }
}
