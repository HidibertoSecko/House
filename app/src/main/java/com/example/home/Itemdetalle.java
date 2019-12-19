package com.example.home;

public class Itemdetalle {
    public String foto;

    public  int id;

    public Itemdetalle(String foto)
    {
        this.foto = foto;
    }

    public Itemdetalle(int i){

    }

    public void setFoto(String foto){
        this.foto = foto;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFoto() {
        return this.foto;
    }

    public int getId() {
        return this.id;
    }
}
