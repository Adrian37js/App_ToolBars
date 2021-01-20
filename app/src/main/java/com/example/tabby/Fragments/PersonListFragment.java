package com.example.tabby.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tabby.Adapters.PersonAdapter;
import com.example.tabby.Models.Person;
import com.example.tabby.R;

import java.util.ArrayList;
import java.util.List;

public class PersonListFragment extends Fragment {

    //Creamos las variables
    private List<Person> persons;
    private PersonAdapter adapter;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflamos la vista y le pasamos el list activity
        View view = inflater.inflate(R.layout.list_activity, container, false);

        //Creamos un list view y le pasamos el ListView del list activity
        listView = (ListView) view.findViewById(R.id.activityListView);

        //Creamos un array de Personas
        persons = new ArrayList<Person>();

        //Le pasamos al adaptador el array de personas y el layout
        adapter = new PersonAdapter(getContext(), R.layout.layout, persons);
        listView.setAdapter(adapter);

        return view;
    }

    //Metodo para añadir Personas
    public void AddPerson(Person person){
        persons.add(person);
        adapter.notifyDataSetChanged();
    }
}