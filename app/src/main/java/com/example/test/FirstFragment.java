package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.test.databinding.FragmentFirstBinding;

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
        binding.counterInputNumber.setText(String.valueOf(0));

        binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValueOnInput(1);
            }
        });

        binding.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValueOnInput(-1);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     *
     * @param view view where the click come from
     */
    public void increment(@NonNull View view) {
        setValueOnInput(1);
    }

    /**
     *
     * @param view view where the click come from
     */
    public void decrement(@NonNull View view) {
        setValueOnInput(-1);
    }

    private void setValueOnInput(int value) {
        int inputText = Integer.parseInt(binding.counterInputNumber.getText().toString());
        inputText = inputText + value;
        binding.counterInputNumber.setText(String.valueOf(inputText));
    }

}