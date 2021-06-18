package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.test.databinding.FragmentSecondBinding;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import rpg.Race;
import rpg.heros.Hero;

public class SecondFragment extends Fragment {

    public static final String HERO = "hero";

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
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
                String selectedClass = binding.spinnerClasses.getSelectedItem().toString();

                Bundle bundle = new Bundle();
                bundle.putSerializable(SecondFragment.HERO, createHeroFromInfos(heroName, race, selectedClass));
                Navigation.findNavController(view).navigate(R.id.action_SecondFragment_to_HeroBattleFragment, bundle);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private Hero createHeroFromInfos(String name, Race race, String heroClass) {
        Hero hero = null;
        try {
            Class classe = Class.forName("rpg.heros." + heroClass);
            Constructor constructor = classe.getConstructor(Class.forName("java.lang.String"), Class.forName("rpg.Race"));
            hero = (Hero) constructor.newInstance(name, race);
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
        return hero;
    }

}