package com.example.elppa;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity9 extends AppCompatActivity {
    public String nombrenegocio=Gloval.nombrenegocio;

    public TextView linkactualizar;
    EditText usuario;
    EditText pass;

    Button eviar;
    Button alta;

    private String UserMail;
    private String passAlta;



    public String directo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main9);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        UserMail = getIntent().getStringExtra("usermail");
        passAlta = getIntent().getStringExtra("pass");




        usuario = (EditText) findViewById(R.id.usuario);
        pass = (EditText) findViewById(R.id.pass);
        eviar = (Button) findViewById(R.id.enviar);
        alta = (Button) findViewById(R.id.alta);

        linkactualizar=(TextView) findViewById(R.id.linkactualizar);
        linkactualizar.setMovementMethod(LinkMovementMethod.getInstance());
        linkactualizar.setText(Html.fromHtml("<font color='#242424'><a href='https://www.nuevoclock.com/platsyplats/platsyplats.apk'>Actualizar</a></font>"));


        usuario.setText(UserMail);
        pass.setText(passAlta);

        alta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intente = new Intent(MainActivity9.this,MainActivity10.class);


                startActivity(intente);
            }
        });


        eviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directo="www.nuevoclock.com/nuevoclock/";
                getDatos();

            }
        });









    }

    public void getDatos(){


        Intent intent = new Intent(MainActivity9.this,MainActivity.class);
        intent.putExtra("usermail",usuario.getText().toString());
        intent.putExtra("pass",pass.getText().toString());
        intent.putExtra("vengodeM9","m9");
        intent.putExtra("directorio",directo);
        startActivity(intent);

    }
}

