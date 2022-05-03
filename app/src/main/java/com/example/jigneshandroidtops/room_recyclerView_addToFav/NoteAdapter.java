package com.example.jigneshandroidtops.room_recyclerView_addToFav;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jigneshandroidtops.databinding.NoteRowItemBinding;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> list;

    NoteAdapter(List<Note> list){

        this.list = list;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NoteRowItemBinding binding = NoteRowItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new NoteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note=list.get(position);
        holder.binding.setObj(note);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        NoteRowItemBinding binding;
        public NoteViewHolder(@NonNull NoteRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
