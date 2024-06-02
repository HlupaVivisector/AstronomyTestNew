package com.example.astronomytest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class T_RecyclerViewAdapter extends RecyclerView.Adapter<T_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<ThemeModel> themeModels;

    public T_RecyclerViewAdapter(Context context, ArrayList<ThemeModel> themeModels, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.themeModels = themeModels;
        this.recyclerViewInterface = recyclerViewInterface;

    }


    @NonNull
    @Override
    public T_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new T_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull T_RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.tvName.setText(themeModels.get(position).getThemeNames());
        holder.imageView.setImageResource(themeModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return themeModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName;

        ConstraintLayout cardView;


        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(androidx.constraintlayout.widget.R.id.constraint);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }
}
