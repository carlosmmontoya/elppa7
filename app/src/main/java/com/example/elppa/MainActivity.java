package com.example.elppa;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.elppa.interfas.msninterfas;
import com.example.elppa.modelo.msnmodelo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public String nombrenegocio=Gloval.nombrenegocio;
    msnAdapter holderadapter;
    String UserMail;
    String InputFile2;
    TextView nombrechat;

    String[] parts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


       //// UserMail = getIntent().getStringExtra("usermail");
        UserMail = "carlosmontoya170718@gmail.com";
      /////  InputFile2=getIntent().getStringExtra("InputFile2");
     /////   parts = InputFile2.split("|");


        nombrechat = (TextView) findViewById(R.id.nombrechat);
        nombrechat.setText(UserMail);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        getDatos();
        swi();
    }

    public void swi(){

        SwipeRefreshLayout swi = (SwipeRefreshLayout) findViewById(R.id.swip);
        swi.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override public void onRefresh() {
                        Log.i("tac","iris");

                        getDatos();
                        swi.setRefreshing(false);

                    }
                }

        );



    }
    public void getDatos(){

        ///   intent = new Intent(MainActivity.this,MainActivity.class);
        ////   startActivity(intent);
        ///   final ProgressDialog loading = ProgressDialog.show(this, "Subiendo intagram florccrosa...", "Espere por favor");

        ////
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://"+nombrenegocio+"")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        msninterfas interfass = retrofit.create(msninterfas.class);

        Call<List<msnmodelo>> call = interfass.getDatos();

        call.enqueue(new Callback<List<msnmodelo>>() {
            @Override
            public void onResponse(Call<List<msnmodelo>> call, Response<List<msnmodelo>> response) {
                List<msnmodelo> Pos = response.body();

                recyclerView.setLayoutManager(linearLayoutManager);
                ArrayList<msnheder> MyDatasset = new ArrayList<>();
                int  fotoideentero=0;
                int i =0;
                for(msnmodelo msnmodelo : Pos){
                    String content = "";
                    content += "Type "+ msnmodelo.getEmail()+ "\n";

                    MyDatasset.add(new msnheder(msnmodelo.getId(),msnmodelo.getName(),msnmodelo.getSurname(),msnmodelo.getEmail(),msnmodelo.getHash(),msnmodelo.getRoll(),msnmodelo.getToken(),msnmodelo.getUpdated_at(),UserMail));


                    holderadapter = new msnAdapter(MyDatasset);
                    recyclerView.setAdapter(holderadapter);


                }

            }

            @Override
            public void onFailure(Call<List<msnmodelo>> call, Throwable t) {

            }

        });





    }



}