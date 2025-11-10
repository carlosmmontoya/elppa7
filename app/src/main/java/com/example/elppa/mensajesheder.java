package com.example.elppa;

public class mensajesheder {
    private String nombre;
    private String mensaje;
    private String fecha;
    private  String color;
    private  String leido;

    public mensajesheder(String nombre, String mensaje, String fecha, String color, String leido) {

        this.nombre = nombre;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.color = color;
        this.leido = leido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLeido() {
        return leido;
    }

    public void setLeido(String leido) {
        this.leido = leido;
    }
}
