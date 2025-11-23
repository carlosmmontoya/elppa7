package com.example.elppa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class MainActivity10 extends AppCompatActivity {
    public String nombrenegocio=Gloval.nombrenegocio;
    Button btnBuscar, btnSubir;
    public String imagencodigo="";
public Button botonalerta;

    ImageView iv;
    EditText et;
    TextView alerta;
    TextView alta;
    Bitmap bitmap=null;
    int PICK_IMAGE_REQUEST = 1;

    String UPLOAD_URL = "https://"+nombrenegocio+"UploadUser.php";

    String KEY_IMAGE = "foto";

    String KEY_SNAME="nombre";
    String KEY_SMAIL="mail";
    String KEY_HASH="hash";



    String valor="";
    String UserMail;
    String pass;

    EditText name;
    EditText email;
    EditText hash;

    String Sname ;
    String Semail;
    String Shash ;

    public TextView camposobligatorios;
    public TextView seleccionaimagenalta;

    public TextView  imagendealta;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main10);







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        ///    UserMail = getIntent().getStringExtra("usermail");
        ///    pass = getIntent().getStringExtra("pass");
        ///    valor = getIntent().getExtras().getString("id");
/*

    alerta.setVisibility(View.GONE);
    camposobligatorios.setVisibility(View.GONE);
    seleccionaimagenalta.setVisibility(View.GONE);
    imagendealta.setVisibility(View.GONE);

    botonalerta
 */

        botonalerta=(Button) findViewById(R.id.botonalerta);

        botonalerta.setVisibility(View.GONE);
        alerta=(TextView) findViewById(R.id.alerta);
        alerta.setVisibility(View.GONE);
        alta=(TextView) findViewById(R.id.alta);
        seleccionaimagenalta=(TextView)findViewById(R.id.seleccionaimagenalta);
        camposobligatorios=(TextView)findViewById(R.id.camposobligatorios);

        imagendealta=(TextView)findViewById(R.id.imagendealta);
        name = (EditText) findViewById(R.id.name);

        email = (EditText)  findViewById(R.id.email);
        hash = (EditText)  findViewById(R.id.hash);
        iv =(ImageView) findViewById(R.id.imageView);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnSubir = findViewById(R.id.btnSubir);

        botonalerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                invisiblelostextos2();
            }
        });
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });

        btnSubir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(imagencodigo.equals("")){
                    invisiblelostextos();

                }else{
                    uploadImage();
                }


            }
        });



    }
public void invisiblelostextos(){

    alta.setVisibility(View.GONE);
    btnSubir.setVisibility(View.GONE);
    ////    viewHolder.val2.setVisibility(View.GONE);
    iv.setVisibility(View.GONE);
    camposobligatorios.setVisibility(View.GONE);
    seleccionaimagenalta.setVisibility(View.GONE);
    imagendealta.setVisibility(View.GONE);
    btnBuscar.setVisibility(View.GONE);

    /////  viewHolder.headerCode.setVisibility(View.GONE);  name
    name.setVisibility(View.GONE);
    email.setVisibility(View.GONE);
    hash.setVisibility(View.GONE);

    alerta.setVisibility(View.VISIBLE);
    botonalerta.setVisibility(View.VISIBLE);







    ///  imageView




}
    public void invisiblelostextos2(){

        name.setVisibility(View.VISIBLE);
        alta.setVisibility(View.VISIBLE);
        btnSubir.setVisibility(View.VISIBLE);
        ////    viewHolder.val2.setVisibility(View.GONE);
        iv.setVisibility(View.VISIBLE);
        camposobligatorios.setVisibility(View.VISIBLE);
        seleccionaimagenalta.setVisibility(View.VISIBLE);
        imagendealta.setVisibility(View.VISIBLE);
        btnBuscar.setVisibility(View.VISIBLE);

        /////  viewHolder.headerCode.setVisibility(View.GONE);
        email.setVisibility(View.VISIBLE);
        hash.setVisibility(View.VISIBLE);

        alerta.setVisibility(View.GONE);
        botonalerta.setVisibility(View.GONE);








        ///  imageView





    }
    public String getStringImagen(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public void uploadImage() {
        final ProgressDialog loading = ProgressDialog.show(this, "Subiendo intagram florccrosa...", "Espere por favor");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();


                        ////  Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                ////    Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                String imagen = getStringImagen(bitmap);
                ///  String nombre = Sname;
                ///    String email = Semail;
                ///    String hash= Shash;
                String nombre = Sname;
                String email = Semail;
                String hash= Shash;


                Map<String, String> params = new Hashtable<String, String>();
                params.put(KEY_IMAGE, imagen);
                params.put(KEY_SNAME, nombre);
                params.put(KEY_SMAIL, email);
                params.put(KEY_HASH,hash);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        Intent intente = new Intent(MainActivity10.this,MainActivity9.class);

        intente.putExtra("usermail",Semail);
        intente.putExtra("pass",Shash);


        startActivity(intente);

        Log.v("acti","funciona el click");
        ///   setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ///setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Seleciona imagen"), PICK_IMAGE_REQUEST);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {




                Sname = name.getText().toString();
                Semail =email.getText().toString();
                Shash =hash.getText().toString();





                //Cómo obtener el mapa de bits de la Galería
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imagencodigo = getStringImagen(bitmap);
                //Configuración del mapa de bits en ImageView
                iv.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}