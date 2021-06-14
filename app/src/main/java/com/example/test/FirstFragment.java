package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.test.databinding.FragmentFirstBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String initString = "Java vs PHP";
        binding.counterInputNumber.setText(initString);

        binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValueOnInput(0.5);
            }
        });

        binding.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValueOnInput(-0.5);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setValueOnInput(double value) {
        // Gestion des exceptions
        double inputText = 0.0;
        try {
            inputText = Double.parseDouble(binding.counterInputNumber.getText().toString());
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                // Je fais un traitement précis s'il m'a renvoyé un NPE (NullPointerException)
                inputText = 0.0;
            }
            // Affichage du message qui a déclenché l'exception
            // ignored.getMessage()
        }
        inputText = inputText + value;
        binding.counterInputNumber.setText(String.valueOf(inputText));
    }

}