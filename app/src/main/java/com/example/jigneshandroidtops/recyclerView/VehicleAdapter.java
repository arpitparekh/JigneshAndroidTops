package com.example.jigneshandroidtops.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jigneshandroidtops.databinding.VehicleRowItemBinding;

import java.util.ArrayList;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder> {

    private ArrayList<Vehicle> list;

    VehicleAdapter(ArrayList<Vehicle> list){
        this.list = list;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // give individual item layout

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        VehicleRowItemBinding binding = VehicleRowItemBinding.inflate(inflater,parent,false);
        VehicleViewHolder holder = new VehicleViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {

        // insert data into individual item

        Vehicle v =  list.get(position);
        holder.binding.setObj(v);

    }

    @Override
    public int getItemCount() {

        // return total items

        return list.size();
    }

    public class VehicleViewHolder extends RecyclerView.ViewHolder {

        private VehicleRowItemBinding binding;

        public VehicleViewHolder(@NonNull VehicleRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
