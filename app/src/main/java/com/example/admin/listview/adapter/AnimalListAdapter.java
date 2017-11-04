package com.example.admin.listview.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.listview.Animal.Animal;
import com.example.admin.listview.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 29/10/2560.
 */

public class AnimalListAdapter extends ArrayAdapter<Animal> {

    private Context mContext;
    private ArrayList<Animal>mAnimalsList;
    private int mLayoutResId;

    public AnimalListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Animal> objects) {
        super(context, resource, objects);

        this.mContext=context;
        this.mLayoutResId=resource;
        this.mAnimalsList=objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(mLayoutResId, null);

        ImageView iv = (ImageView) v.findViewById(R.id.imageView);
        TextView tv = (TextView) v.findViewById(R.id.textView);

        Animal animal = mAnimalsList.get(position);
        iv.setImageResource(animal.picture);
        tv.setText(animal.name);
        return  v;
    }
}
