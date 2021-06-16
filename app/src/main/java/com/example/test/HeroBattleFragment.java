package com.example.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.databinding.FragmentHeroBattleBinding;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import rpg.Race;
import rpg.heros.Hero;

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
        if (bundle != null) {
//            String heroName = (String) bundle.get(SecondFragment.HERO_NAME);
//            Log.i("Form data", heroName);
//            Race heroRace = Race.valueOf((String) bundle.get(SecondFragment.HERO_RACE));
//            String heroClass = (String) bundle.get(SecondFragment.HERO_CLASS);
//            // Log.i : information ; Log.w : warning ; Log.e : error ; Log.d : debug ; Log.v : verbose
//            Log.i("Form data", heroName + " - " + heroRace + " - " + heroClass);
//            Hero hero = createHeroFromInfos(heroName, heroRace, heroClass);
//            Log.i("Heroes creation", hero.toString());
//            binding.textViewName.setText(heroName);
//            binding.textViewRace.setText(heroRace.toString());
//            binding.textViewClass.setText(heroClass);
        }
    }

    private Hero createHeroFromInfos(String name, Race race, String heroClass) {
        Hero hero = null;
        try {
            Class classe = Class.forName("rpg.heros." + heroClass);
            Constructor constructor = classe.getConstructor(Class.forName("java.lang.String"), Class.forName("rpg.Race"));
            hero = (Hero) constructor.newInstance(name, race);
            hero.setLevel(60);
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