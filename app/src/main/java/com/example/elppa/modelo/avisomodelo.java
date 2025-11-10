package com.example.elppa.modelo;

public class avisomodelo {

    /*

    $formatoJonson = '[{"emisor":"'.$emisor.'","reseptor":"'.$resepror.'","fecha":"'.$fecha.'"}]';
     */

    public String emisor;
    public String reseptor;
    public String fecha;

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReseptor() {
        return reseptor;
    }

    public void setReseptor(String reseptor) {
        this.reseptor = reseptor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
