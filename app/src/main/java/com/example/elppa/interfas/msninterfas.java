package com.example.elppa.interfas;

import com.example.elppa.modelo.msnmodelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface msninterfas {

    @GET("conectar3.php")
    Call<List<msnmodelo>> getDatos();


}
