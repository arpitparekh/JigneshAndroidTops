package com.example.jigneshandroidtops.recyclerView_crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jigneshandroidtops.databinding.WeatherRowItemBinding;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    ArrayList<Weather> list;
    OnWeatherItemClickInterface listener;
    Context context;

    WeatherAdapter(ArrayList<Weather> list,OnWeatherItemClickInterface listener){

        this.list = list;
        this.listener = listener;

    }

    interface OnWeatherItemClickInterface{

        void onClick(int position);

    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        WeatherRowItemBinding binding = WeatherRowItemBinding.inflate(inflater,parent,false);
        WeatherViewHolder holder = new WeatherViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

        Weather w = list.get(position);

        holder.binding.setObj(w);

        holder.itemView.setOnClickListener(view -> {

            listener.onClick(position);

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        WeatherRowItemBinding binding;
        public WeatherViewHolder(@NonNull WeatherRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
