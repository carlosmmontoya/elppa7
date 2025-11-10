package com.example.elppa.interfas;

import com.example.elppa.modelo.mensajeriamodelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface mensajeinterfas {





    @GET("mensajesJson.php")
    Call<List<mensajeriamodelo>> getDatos();
}
