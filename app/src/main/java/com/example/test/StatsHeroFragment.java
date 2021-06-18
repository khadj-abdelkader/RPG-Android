package com.example.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.databinding.FragmentHeroBattleBinding;
import com.example.test.databinding.FragmentStatsHeroBinding;

import rpg.heros.Hero;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 *
 */
public class StatsHeroFragment extends Fragment {

    private FragmentStatsHeroBinding binding;

    private Hero hero;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStatsHeroBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            this.hero = (Hero) bundle.getSerializable(SecondFragment.HERO);
        }

        Log.i("Dans stats", "onViewCreated: " + hero.toString());
    }
}