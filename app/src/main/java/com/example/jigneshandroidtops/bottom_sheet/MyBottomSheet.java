package com.example.jigneshandroidtops.bottom_sheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jigneshandroidtops.databinding.MyBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyBottomSheet extends BottomSheetDialogFragment {

    MyBottomSheetBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MyBottomSheetBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnHello.setOnClickListener(view1 -> {

            Toast.makeText(getContext(), "Hello Student", Toast.LENGTH_SHORT).show();

        });

    }
}
