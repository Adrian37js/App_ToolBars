package com.example.tabby.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tabby.Interfaces.OnPersonCreated;
import com.example.tabby.Models.Country;
import com.example.tabby.Models.Person;
import com.example.tabby.R;
import com.example.tabby.Utils.Util;

import java.util.ArrayList;
import java.util.List;


public class PersonFormFragment extends Fragment {

    //DECLARAMOS LAS VARIABLES
    private Spinner spinnerCountry;
    private Button btnCreate;
    private EditText editTextName;
    private Country country;
    private String code;
    private List<Country> countries;
    private OnPersonCreated onPersonCreated;

    public PersonFormFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form_activity, container, false);
        //Cogemos los ID de form_activity.xml
        editTextName = (EditText) view.findViewById(R.id.editTextName);
        spinnerCountry = (Spinner) view.findViewById(R.id.spinnerCiudades);
        btnCreate = (Button) view.findViewById(R.id.btnCreatePerson);

        //Cogemos los paises de UTIL
        countries = Util.getCountries();
        spinnerCountry.setAdapter(new ArrayAdapter<Country>(getContext(), android.R.layout.simple_spinner_dropdown_item, countries));

        //Lo pasamos al adapter
        ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(getContext(), android.R.layout.simple_spinner_dropdown_item, countries);
        spinnerCountry.setAdapter(adapter);

        //Funcionalidad del boton
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Buscamos el Codigo de Pais y si coincide con el clikado lo guardamos en la variable code
                for(int i=0; countries.size() > i; i++ ){
                    if(spinnerCountry.getSelectedItem().toString().equals(countries.get(i).getName())){
                        code = countries.get(i).getCountryCode();
                    }
                }
                //Creamnos el pais
                country = new Country (spinnerCountry.getSelectedItem().toString(), code);
                Person person = new Person(editTextName.getText().toString(), country);
                //mediante la interfaz creamos el pais y la persona
                onPersonCreated.createPerson(person);
            }
        });
        return view;
    }

    // Eventos para enlazar el listener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPersonCreated)
            onPersonCreated = (OnPersonCreated) context;
        else
            throw new RuntimeException(context.toString() + " debe implementarse OnPersonCreated");
    }

    // Eventos para desenlazar el listener
    @Override
    public void onDetach() {
        super.onDetach();
        onPersonCreated = null;
    }
}