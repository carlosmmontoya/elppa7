package com.example.elppa;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.elppa.interfas.mensajeinterfas;
import com.example.elppa.modelo.mensajeriamodelo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {
    public String nombrenegocio=Gloval.nombrenegocio;

    /*

    activity que tine que ver con el chat del cliente a la empresa
     */
    String ok ="";
    String leido ="";
    String[] partes ;
    String CorreoNombreUser="micropro@gmail.com";
    EditText texsent;
    Button enviarboton;
    String KEY_NOMBRE = "nombre";

    String KEY_ELOCUENTE = "elocuente";
    String KEY_ELOCUENTE2 = "elocuente";
    String KEY_MENSAJE = "mensaje";
    String KEY_FECHA = "fecha";
    ///// String UPLOAD_URL = "https://"+nombrenegocio+"/uploadmensaje.php";

    /////   String UPLOAD_URL2 = "https://"+nombrenegocio+"/UploadEnlinea.php";

    String UPLOAD_URL = "https://"+nombrenegocio+"uploadmensaje.php";

    String UPLOAD_URL2 = "https://"+nombrenegocio+"UploadEnlinea.php";
    String valor;

    String Useraces;

    TextView nombrechat;

    String nombrecomunica="enlinea";
    com.example.elppa.mensajeriaAdapter holderadapter;

    public String reseptor;
    public String emisor;
    public String mensajedeemisor;
    public   String UserMail="";
    private PendingIntent pendingIntent2;
    private static final String CHANEL_ID2 = "canal3";
    public String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        UserMail = getIntent().getStringExtra("usermail");
        pass = getIntent().getStringExtra("pass");
        texsent=(EditText) findViewById(R.id.texsent2);
        CorreoNombreUser = getIntent().getStringExtra("usermail");
        nombrecomunica = getIntent().getStringExtra("nombrecomunica");
        valor = getIntent().getStringExtra("name");

        nombrechat = (TextView) findViewById(R.id.nombrechat);
        nombrechat.setText(valor);

        nombrechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //////////////////////////////////////////////////
                Intent intente = new Intent(MainActivity2.this,MainActivity2.class);

                intente.putExtra("usermail",UserMail);
                intente.putExtra("pass",pass);
                intente.putExtra("vengodeM9","m9");


                startActivity(intente);

                ////////////////////////////////////////////////////
            }
        });

        enviarboton=(Button) findViewById(R.id.enviar);
        enviarboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadEnlinea();
                uploadImage();

            }
        });



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        getDatos();
    }


    public void getDatos(){

        ///   intent = new Intent(MainActivity.this,MainActivity.class);
        ////   startActivity(intent);giosaboutique
        ///   final ProgressDialog loading = ProgressDialog.show(this, "Subiendo intagram florccrosa...", "Espere por favor");

        ////
        RecyclerView recyclerView;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);


        ///    linearLayoutManager.setReverseLayout(true);
        ///    linearLayoutManager.setStackFromEnd(true);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://"+nombrenegocio+"")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//////https://www.nuevoclock.com/nuevoclock/motorHistori/mensajesJson.php

        mensajeinterfas interfass = retrofit.create(mensajeinterfas.class);

        Call<List<mensajeriamodelo>> call = interfass.getDatos();

        call.enqueue(new Callback<List<mensajeriamodelo>>() {
            @Override
            public void onResponse(Call<List<mensajeriamodelo>> call, Response<List<mensajeriamodelo>> response) {
                List<mensajeriamodelo> Pos = response.body();

                recyclerView.setLayoutManager(linearLayoutManager);
                ArrayList<mensajesheder> MyDatasset = new ArrayList<>();
                int  fotoideentero=0;
                String[] extracciondetexto;
                int i =0;
                int no=0;
                int si=0;
                for(mensajeriamodelo mensajeriamodelo : Pos){
                    String content = "";
                    content += "Type "+ mensajeriamodelo.getNombre()+ "\n";



                    String[] analicis ;
                    analicis = mensajeriamodelo.getMensaje().split(UserMail);
                    String[] analicis2;
                    analicis2 = mensajeriamodelo.getMensaje().split(valor);

////String analicis3 = mensajeriamodelo.getNombre();
                    int numeroanalicis=0;
                    int numeroanalicis2=0;

                    numeroanalicis = analicis.length;
                    numeroanalicis2= analicis2.length;

                    if(numeroanalicis>1) {
                        no=1;
                        si=2;
                    }else{


                    }

                    if(numeroanalicis2>1) {
                        si=2;

                    }else{


                    }



/*

para que se mostraran todas las converzaciones que tinene que ver . pero mensajesJson
muestra datos segun se le sumin

  if(analicis3.equals(UserMail)){
                        si=2;
                        no=1;
                    }
 */

                    //////////////////////////////////////-------mejor logica -----------
                    /*
                    tengo a usermail variable del que ha entrando y tnego a valor variable que define
                    a quien es el que monton la piblicidad . entonces solo estas dos identidades deven de tener ac
    acceso a la combersacion pero otra no por ende 2 variables yo y monto
    yo = usermail
    monto valor


    extracciondetexto1 = usermal
       extracciondetexto = mensajeriamodelo.getMensaje().split(valor )

       valor == extracciondetexto[0]
       resumen
       si ele user esta en el nombrfe o en el mensaje es la persona

        extracciondetexto = mensajeriamodelo.getMensaje().split(usermail )
        nombredellocutort = mensajeriamodelo.getnombre()

        if usermal ==extracciondetexto )
          ok = si
        else
        if usermail ==nombredellocutor
        ok = si






                     */



                    //////////////////////////////////////----------------------

                    if(no==1 && si==2 ){



                        partes = mensajeriamodelo.getMensaje().split("dice");
                        String mensajillo;
                        if(partes.length >1){
                            mensajillo=partes[1];
                        }else{

                            mensajillo=".";
                        }

                        MyDatasset.add(new mensajesheder(mensajeriamodelo.getNombre(), mensajillo, mensajeriamodelo.getFecha(),UserMail,leido));
                    }

                    holderadapter = new mensajeriaAdapter(MyDatasset);
                    recyclerView.setAdapter(holderadapter);
                    // Obtener la cantidad de elementos en tu adaptador
                }

                int itemCount = holderadapter.getItemCount();

// Desplazar el RecyclerView al último elemento  scrollToPosition
                /// desplazamiento lento   recyclerView.smoothScrollToPosition(itemCount - 1);
                recyclerView.scrollToPosition(itemCount - 1);

                /*
               MyViewHolder MyViewHolder2 = new MyViewHolder;

                MyViewHolder2.myTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        recyclerView.scrollToPosition(itemCount - 1);
                    }
                });
           MyAdapter.MyViewHolder MyViewHolder2 = null;
                MyViewHolder2.myTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        recyclerView.scrollToPosition(itemCount - 1);
                    }
                });


quito  conteodetiempomensajepedido2(); de aqui por que recarga el codigo mas lo voy a poner en la comprobacion
de que sea diferente el user del emisor de esta manera se ejecuta hace lo que tine que hace traer datos y para
                 */


            }

            @Override
            public void onFailure(Call<List<mensajeriamodelo>> call, Throwable t) {

            }

        });





    }
    public void uploadEnlinea() {
        ///   final ProgressDialog loading = ProgressDialog.show(this, "Doy como herencia este proyecto a Marlytt Montoya , Brenda Montoya y Erick Montoya", "Espere por favor");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL2,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ///        loading.dismiss();

                        ////  Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ///     loading.dismiss();
                ////    Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                String nombre = CorreoNombreUser;
                String elocuente = valor;


                ///     String nombre = valor;
                ///      String elocuente = CorreoNombreUser;

                Map<String, String> params = new Hashtable<String, String>();
                params.put(KEY_NOMBRE, nombre);
                params.put(KEY_ELOCUENTE2, elocuente);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        ///  Intent intente = new Intent(MainActivity8.this,MainActivity8.class);
        ////   intente.putExtra("name", valor);

        ////   startActivity(intente);

        Log.v("acti","funciona el click");
        ///   setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ///setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void uploadImage() {
        ///  final ProgressDialog loading = ProgressDialog.show(this, "Subiendo intagram..", "Espere por favor");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ///    loading.dismiss();

                        ////  Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ///    loading.dismiss();
                ////    Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                String nombre = CorreoNombreUser;
                String elocuente = valor;
                String mensaje = texsent.getText().toString().trim();
                String fecha = "2023-09-06 22:56:56";



                Map<String, String> params = new Hashtable<String, String>();
                params.put(KEY_NOMBRE, nombre);
                params.put(KEY_ELOCUENTE, elocuente);
                params.put(KEY_MENSAJE, mensaje);
                params.put(KEY_FECHA, fecha);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        Intent intente = new Intent(MainActivity2.this,MainActivity2.class);
        intente.putExtra("name", valor);

        intente.putExtra("usermail", CorreoNombreUser);

        intente.putExtra("nombrecomunica", nombrecomunica);


        intente.putExtra("pass",pass);

        startActivity(intente);

        Log.v("acti","funciona el click");
        ///   setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ///setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

}