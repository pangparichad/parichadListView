package com.example.admin.listview;

import com.example.admin.listview.Animal.Animal;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Admin on 29/10/2560.
 */

public class AnimalData {
    public static AnimalData sInstance;

    public ArrayList<Animal>animalsList;

    public static AnimalData getsInstance(){
        if(sInstance == null){
            sInstance = new AnimalData();
        }
        return sInstance;
    }
}
