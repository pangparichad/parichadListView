package com.example.admin.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.listview.Animal.Animal;
import com.example.admin.listview.adapter.AnimalListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mlistview;
    //private ArrayList<Animal> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlistview = (ListView) findViewById(R.id.list_view);

       final AnimalData animalData = AnimalData.getsInstance();
        animalData.animalsList = new ArrayList<>();

        animalData.animalsList.add(new Animal("เเมว (Cat)",R.drawable.cat,R.string.details_cat));
        animalData.animalsList.add(new Animal("หมา (Dog)",R.drawable.dog,R.string.details_dog));
        animalData.animalsList.add(new Animal("โลมา (Dolphin)",R.drawable.dolphin,R.string.details_dolphin));
        animalData.animalsList.add(new Animal("โคอาลา (Koala)",R.drawable.koala,R.string.details_koala));
        animalData.animalsList.add(new Animal("นกฮูก (Owl)",R.drawable.owl,R.string.details_owl));
        animalData.animalsList.add(new Animal("กระต่าย (Rabbit)",R.drawable.rabbit,R.string.details_rabbit));
        animalData.animalsList.add(new Animal("เพนกวิน (Penguin)",R.drawable.penguin,R.string.details_penguin));
        animalData.animalsList.add(new Animal("เสือ (Tiger)",R.drawable.tiger,R.string.details_tiger));
        animalData.animalsList.add(new Animal("หมู (Pig)",R.drawable.pig,R.string.details_pig));
        animalData.animalsList.add(new Animal("สิงโต (Lion)",R.drawable.lion,R.string.details_lion));


        AnimalListAdapter adapter = new AnimalListAdapter(
            this,
            R.layout.item,
            animalData.animalsList
        );

        mlistview.setAdapter(adapter);
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Animal animal = animalData.animalsList.get(i);
                Toast.makeText(MainActivity.this, animal.name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,AnimalDetailsActivity.class);
                intent.putExtra("name",animal.name);
                intent.putExtra("picture",animal.picture);
                intent.putExtra("animalname",animal.info);
                intent.putExtra("position",i);
                startActivity(intent);
            }
        });
    }
}
