package com.example.elppa.interfas;

import com.example.elppa.modelo.avisomodelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface avisomensajeinterfas {




        @GET("quienenlinea.php")
        Call<List<avisomodelo>> getDatosenlinea();

}
