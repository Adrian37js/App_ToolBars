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
    private List<Person> persons;
    private ListView listView;
    private PersonAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_activity, container, false);

        listView = (ListView) view.findViewById(R.id.activityListView);
        persons = new ArrayList<Person>();
        adapter = new PersonAdapter(getContext(), R.layout.layout, persons);

        listView.setAdapter(adapter);

        return view;

    }

    public void AddPerson(Person person){
        persons.add(person);
        adapter.notifyDataSetChanged();
    }
}