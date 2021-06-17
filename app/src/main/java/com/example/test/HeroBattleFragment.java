package com.example.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.databinding.FragmentHeroBattleBinding;

import rpg.heros.Hero;
import rpg.monsters.Dragon;
import rpg.monsters.Gobelin;
import rpg.monsters.Monsters;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HeroBattleFragment extends Fragment {

    private FragmentHeroBattleBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentHeroBattleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();
        Hero hero = null;

        if (bundle != null) {
            hero = (Hero) bundle.getSerializable(SecondFragment.HERO);
        }

        Monsters tuktuk = new Dragon(60);

        binding.textViewClass.setText(hero.toString());
        binding.textViewRace.setText(tuktuk.toString());

        while (hero.attack(tuktuk) && tuktuk.attack(hero)) {
            binding.textViewClass.setText(hero.toString());
            binding.textViewRace.setText(tuktuk.toString());
        }

        binding.textViewClass.setText(hero.toString());
        binding.textViewRace.setText(tuktuk.toString());
    }

}