package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.test.databinding.FragmentSecondBinding;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import rpg.Race;
import rpg.heros.Hero;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<Race> adapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, Race.values());
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerRace.setAdapter(adapter);

        String[] classes = new String[]{"Mage", "Warrior", "Rogue"};

        ArrayAdapter<String> adapterClasse = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, classes);
        adapterClasse.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerClasses.setAdapter(adapterClasse);

        binding.buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heroName = binding.editTextHeroName.getText().toString();
                long id = binding.spinnerRace.getSelectedItemId();
                Race race = (Race.values())[(int) id];
                String selectedClasse = binding.spinnerClasses.getSelectedItem().toString();

                try {
                    Class classe = Class.forName("rpg.heros." + selectedClasse);
                    Constructor constructor = classe.getConstructor(Class.forName("java.lang.String"), Class.forName("rpg.Race"));
                    Hero hero = (Hero) constructor.newInstance(heroName, race);
                    hero.setLevel(60);
                    binding.textViewHero.setText(hero.toString());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }

//                binding.textViewHero.setText(hero.toString());
//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}