package com.example.elppa;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class msnAdapter extends RecyclerView.Adapter<msnAdapter.ViewHolder> {

    private ArrayList<msnheder> localDataSet;


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {



        public TextView id;
        public TextView  name;
        private   LinearLayout  LinearLayout;
        /*
        public TextView  Surname;
        public TextView email;
        public TextView hash;
        public TextView roll;
        public TextView token;

         */

        public  TextView updated_at;









        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View


           id  = (TextView) view.findViewById(R.id.id);

            /////    headerCode.setMovementMethod(LinkMovementMethod.getInstance());
            name= (TextView) view.findViewById(R.id.name);
            LinearLayout= (LinearLayout) view.findViewById(R.id.lineartextofecha);
       /*    Surname= (TextView) view.findViewById(R.id.surname);
            email = (TextView) view.findViewById(R.id.email);
            hash= (TextView) view.findViewById(R.id.hash);

            roll = (TextView) view.findViewById(R.id.roll);
            token = (TextView) view.findViewById(R.id.token);

        */

            updated_at = (TextView) view.findViewById(R.id.updated_at);






        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public msnAdapter(ArrayList<msnheder> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_messenger, viewGroup, false);

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


        /////////////////////////-----------onclick listener-------------------------------------
      viewHolder.LinearLayout.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                Intent intente = null;

                 
                intente = new Intent(v.getContext(),MainActivity2.class);
                intente.putExtra("name", localDataSet.get(position).getEmail());
                intente.putExtra("usermail", localDataSet.get(position).getUsermail());
                intente.putExtra("nombrecomunica", localDataSet.get(position).getName());

                v.getContext().startActivity(intente);
                Log.v("tan","funciona el click");

            }




        });


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


 */
        /////////////////////////-----------onclick listener-------------------------------------
        viewHolder.id.setText(localDataSet.get(position).getId());
        viewHolder.name.setText(localDataSet.get(position).getEmail());
      ////////  viewHolder.Surname.setText(localDataSet.get(position).getSurname());
  //////    viewHolder.email.setText(localDataSet.get(position).getEmail());
    /////////    viewHolder.hash.setText(localDataSet.get(position).getHash());
   ///     viewHolder.roll.setText(localDataSet.get(position).getRoll());
    ///    viewHolder.token.setText(localDataSet.get(position).getToken());
        viewHolder.updated_at.setText(localDataSet.get(position).getUpdated_at());

       }


    @Override
    public int getItemCount() {
        return localDataSet.size();

    }


}

