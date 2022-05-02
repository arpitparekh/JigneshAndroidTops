package com.example.jigneshandroidtops.recyclerView_serachView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jigneshandroidtops.databinding.DataRowItemBinding;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> implements Filterable {

    ArrayList<Data> list;
    ArrayList<Data> copyList;
    ArrayList<Data> filteredList = new ArrayList<>(); // empty

    DataAdapter(ArrayList<Data> list){
        this.list = list;
        copyList = list;

    }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DataRowItemBinding binding = DataRowItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new DataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Data d = list.get(position);
        holder.binding.setObj(d); // data binding
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                if(charSequence.toString().equals("")){

                    filteredList = copyList;

                }else{

                    filteredList = new ArrayList<>(); // empty the filterlist

                    for(Data d  : copyList){

                        if(d.name.toLowerCase().contains(charSequence.toString().toLowerCase())){

                            filteredList.add(d);

                        }

                    }

                }
                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                list = (ArrayList<Data>) filterResults.values;

                notifyDataSetChanged();

            }
        };
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        DataRowItemBinding binding;

        public DataViewHolder(@NonNull DataRowItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
