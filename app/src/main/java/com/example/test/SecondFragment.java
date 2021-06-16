package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import com.example.test.databinding.FragmentSecondBinding;

import rpg.Race;

public class SecondFragment extends Fragment {

    public static final String HERO_NAME = "heroName";
    public static final String HERO_RACE = "heroRace";
    public static final String HERO_CLASS = "heroClass";

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
                bundle.putString(SecondFragment.HERO_NAME, heroName);
                bundle.putString(SecondFragment.HERO_RACE, race.toString());
                bundle.putString(SecondFragment.HERO_CLASS, selectedClass);
                HeroBattleFragment hbf = new HeroBattleFragment();
                hbf.setArguments(bundle);

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_HeroBattleFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}