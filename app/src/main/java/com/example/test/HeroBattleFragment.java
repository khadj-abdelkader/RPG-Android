package com.example.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.test.databinding.FragmentHeroBattleBinding;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import rpg.Race;
import rpg.heros.Hero;
import rpg.monsters.Dragon;
import rpg.monsters.Gobelin;
import rpg.monsters.Monsters;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HeroBattleFragment extends Fragment {

    public static final String MONSTER = "monster";

    private FragmentHeroBattleBinding binding;

    private Hero hero;

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
            this.hero = (Hero) bundle.getSerializable(SecondFragment.HERO);
        }

        String[] monsters = new String[]{"Dragon", "Gobelin", "Ogre"};

        ArrayAdapter<String> adapterMonsters = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, monsters);
        adapterMonsters.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerMonster.setAdapter(adapterMonsters);

        // Créer un bouton de start fight qui aura son action ajoutée ici
        binding.buttonFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFight();
            }
        });
    }

    private void startFight() {
        String selectedMonster = (String) binding.spinnerMonster.getSelectedItem();
        Monsters monster = createMonsterFromInfos(selectedMonster, this.hero.getLevel());

        binding.textViewClass.setText(hero.toString());
        binding.textViewRace.setText(monster.toString());

        while (hero.attack(monster) && monster.attack(hero)) {
            binding.textViewClass.setText(hero.toString());
            binding.textViewRace.setText(monster.toString());
        }

        binding.textViewClass.setText(hero.toString());
        binding.textViewRace.setText(monster.toString());
    }

    private Monsters createMonsterFromInfos(String monsterClass, int level) {
        Monsters monster = null;
        try {
            Class classe = Class.forName("rpg.monsters." + monsterClass);
            Constructor constructor = classe.getConstructor(int.class);
            monster = (Monsters) constructor.newInstance(level);
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
        return monster;
    }

}