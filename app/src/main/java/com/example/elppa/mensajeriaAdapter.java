package com.example.elppa;

import static androidx.recyclerview.widget.RecyclerView.Adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.elppa.mensajesheder;

import java.util.ArrayList;
import java.util.Objects;


public class mensajeriaAdapter extends Adapter<mensajeriaAdapter.ViewHolder> {

    private ArrayList<mensajesheder> localDataSet;


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {



        public TextView mensaje;
        public TextView  fecha;
        public  RecyclerView recyclerView;




        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View


            mensaje  = (TextView) view.findViewById(R.id.mensaje);


            fecha= (TextView) view.findViewById(R.id.fecha);
            ///recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);







        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public mensajeriaAdapter(ArrayList<mensajesheder> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mensajes, viewGroup, false);

        return new ViewHolder(view);
    }
    Integer idtranformaddint=0;
    Integer fotoideentero=0;
    String fotoide="";
    String fotoestring ="";
    Boolean stopPlay=true;

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        /// int itemCount = getItemCount();

// Desplazar el RecyclerView al último elemento  scrollToPosition
        /// desplazamiento lento   recyclerView.smoothScrollToPosition(itemCount - 1);



        /////////////////////////-----------onclick listener-------------------------------------



      /*  viewHolder.Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tt","clicvideo");
                ///  viewHolder.Video.setVisibility(View.GONE);
                ///   swi();
                ///  notifyDataSetChanged();
                if(stopPlay){
                    viewHolder.Video.pause();
                    stopPlay = false;
                }else {
                    viewHolder.Video.start();
                    stopPlay = true;
                }


            }
        });*/
/*        viewHolder.ss1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity3.class);
                intent.putExtra("id", fotoestring);
                v.getContext().startActivity(intent);
            }
        });

        viewHolder.ss2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(v.getContext(), MainActivity4.class);
                intent.putExtra("id", fotoestring);
                v.getContext().startActivity(intent);
            }
        });
        viewHolder.ss3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity5.class);
                intent.putExtra("id", fotoestring);
                v.getContext().startActivity(intent);
            }
        });
        viewHolder.ss4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity6.class);
                intent.putExtra("id", fotoestring);
                v.getContext().startActivity(intent);
            }
        });
           android:

 */
        /////////////////////////-----------onclick listener-------------------------------------
        ////  if(localDataSet.get(position).getNombre().equals("carlosmontoya170718@gmail.com")) {
        if(!Objects.equals(localDataSet.get(position).getNombre(), localDataSet.get(position).getColor())) {
          ///  Drawable Drawable;
           /// viewHolder.mensaje.setBackground(android.graphics.drawable.Drawable.createFromPath("@drawable/custom_button"));
         ///   viewHolder.mensaje.setBackgroundColor(Color.parseColor("#90ee90"));
viewHolder.mensaje.setBackgroundResource(R.drawable.custom_text_chat);
         ///  viewHolder.mensaje.setBackgroundColor(Color.parseColor("@drawable/custom_button"));
            viewHolder.mensaje.setText(localDataSet.get(position).getMensaje()+" "+localDataSet.get(position).getLeido());

        }else {


            viewHolder.mensaje.setText(localDataSet.get(position).getMensaje());
            //// viewHolder.mensaje.setText(localDataSet.get(position).getMensaje()+" "+localDataSet.get(position).getLeido());

        }
        viewHolder.fecha.setText(localDataSet.get(position).getFecha());


    }


    @Override
    public int getItemCount() {
        return localDataSet.size();

    }


}


