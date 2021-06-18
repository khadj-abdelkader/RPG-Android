package com.example.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.test.databinding.FragmentBestRecordsBinding;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;
import rpg.heros.HeroStorage;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class BestRecordsFragment extends Fragment {

    private FragmentBestRecordsBinding binding;
    private List<HeroStorage> heroesStorage;
    private ArrayAdapter<HeroStorage> arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBestRecordsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        HttpUtils.get(HttpUtils.URL_REGIONS, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for(int i = 0; i < response.length(); i++) {
                        // Convertion en JSONObject pour accéder aux "clés"
                        JSONObject object = (JSONObject) response.get(i);
                        // Récupération d'une clé
                        Log.i("API CALL", "onSuccess: " + object.getString("nom"));
                        // On peut recréer nos objets depuis le JSON
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });



//        heroesStorage = new ArrayList<>();

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
////                        AsyncTask.execute(new Runnable() {
////                            @Override
////                            public void run() {
////
////                            }
////                        }
////                        heroesStorage = AppDataBase.getInstance(getContext()).heroStorageDao().findBestScores();
////                        arrayAdapter = new ArrayAdapter<>(getContext(), 0, heroesStorage);
////                        binding.listViewBestRecords.setAdapter(arrayAdapter);
//                    }
//                });
//            }
//        });
//        thread.start();
    }
}