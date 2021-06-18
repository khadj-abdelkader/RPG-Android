package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.test.R;

import java.util.List;

import rpg.heros.HeroStorage;

public class HeroAdapter extends ArrayAdapter<HeroStorage> {

    private LayoutInflater layoutInflater;

    public HeroAdapter(@NonNull Context context, int resource, @NonNull List<HeroStorage> objects) {
        super(context, 0, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(0, null);
            viewHolder = new ViewHolder();
        }
        return convertView;
    }

    static class ViewHolder {
        TextView nameView;
        TextView heroView;
        TextView raceView;
        TextView levelView;
    }
}
