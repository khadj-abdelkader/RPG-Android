package com.example.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Trace;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.test.databinding.FragmentHeroBattleBinding;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rpg.Race;
import rpg.RpgEntity;
import rpg.heros.Hero;
import rpg.monsters.Dragon;
import rpg.monsters.Gobelin;
import rpg.monsters.Monsters;
import rpg.monsters.Ogre;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HeroBattleFragment extends Fragment {

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

        Hero finalHero = hero;
        binding.buttonDisplayHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(SecondFragment.HERO, finalHero);
                Navigation.findNavController(view).navigate(R.id.action_HeroBattleFragment_to_StatsHeroFragment, bundle);
            }
        });

        String[] monsters = new String[]{"Gobelin", "Ogre", "Dragon"};

        ArrayAdapter<String> adapterMonsters = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, monsters);
        adapterMonsters.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerMonsters.setAdapter(adapterMonsters);

        binding.buttonStarFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFight();
            }
        });

        binding.textViewBattleHero.setText(finalHero.toString());
    }

    private void startFight() {
        Monsters monster = createMonstersFromInfos(
                binding.spinnerMonsters.getSelectedItem().toString(),
                this.hero.getLevel()
        );

        Thread battle = new Thread(new Runnable() {
            @Override
            public void run() {
                int nbTurns = 1;
                List<RpgEntity> listProtagonist = new ArrayList<>();
                listProtagonist.add(hero);
                listProtagonist.add(monster);
                int index = getRandomBetweenNumber(0, 1);
                Log.i("Index 1er joueur", "run: " + index);
                RpgEntity firstFighter = listProtagonist.get(index);
                RpgEntity secondFighter = listProtagonist.get(Math.abs(index - 1));
                binding.textViewBattleHero.setText(firstFighter.toString());
                binding.textViewBattleMonster.setText(secondFighter.toString());
                while (!firstFighter.isDead() && !secondFighter.isDead()) {
                    String infoFirst = "1st : " + firstFighter.toString() + "\n" + secondFighter.attack(firstFighter);
                    String infoSecond = "2nd : " + secondFighter.toString() + "\n" + firstFighter.attack(secondFighter);
                    binding.textViewBattleHero.setText(infoFirst);
                    binding.textViewBattleMonster.setText(infoSecond);
                    try {
                        Thread.sleep(1600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    nbTurns++;
                }
                String battle = "Partie terminée en " + nbTurns + " rounds";
                String victor = ", victoire de " + firstFighter.getClass().getSimpleName();
                if (firstFighter.isDead()) {
                    victor = ", victoire de " + secondFighter.getClass().getSimpleName();
                    victor += addInfoVictor(secondFighter, firstFighter);
                    binding.textViewBattleHero.setText(secondFighter.toString());
                    binding.textViewBattleMonster.setText(firstFighter.toString());
                } else {
                    victor += addInfoVictor(firstFighter, secondFighter);
                    binding.textViewBattleHero.setText(firstFighter.toString());
                    binding.textViewBattleMonster.setText(secondFighter.toString());
                }
                battle += victor;
                binding.textViewBattleTurn.setText(battle);
            }
        });
        battle.start();
    }

    private String addInfoVictor(RpgEntity firstFighter, RpgEntity secondFighter) {
        String victor = "";
        if (firstFighter instanceof Hero) {
            Hero rpgHero = (Hero) firstFighter;
            Monsters rpgMonster = (Monsters) secondFighter;
            victor += "\n" + rpgHero.getClass().getSimpleName() + " a gagné " + rpgMonster.getGivenLevel() + " niveau(x)";
            rpgHero.addLevel(rpgMonster.getGivenLevel());
        }
        return victor;
    }

    private Monsters createMonstersFromInfos(String monsterClass, int level) {
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

    private int getRandomBetweenNumber(float fLow, float fHigh) {
        double low = Math.floor(fLow);
        double high = Math.ceil(fHigh);
        return (int)(low + (int)(Math.random() * ((high - low) + 1)));
    }

}