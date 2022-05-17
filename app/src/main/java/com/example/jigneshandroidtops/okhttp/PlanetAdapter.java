package com.example.jigneshandroidtops.okhttp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.PlanetRowItemBinding;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {

    ArrayList<Planet> list;
    Context context;

    PlanetAdapter(ArrayList<Planet> list){
        this.list = list;
    }
    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        PlanetRowItemBinding binding = PlanetRowItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PlanetViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        Planet planet = list.get(position);
        holder.binding.setObj(planet);

        Glide.with(context)
                .load(planet.img)
                .centerCrop()
                .into(holder.binding.ivPlanet);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PlanetViewHolder extends RecyclerView.ViewHolder {
        PlanetRowItemBinding binding;
        public PlanetViewHolder(@NonNull PlanetRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
