package com.example.tabby.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.example.tabby.Models.Person;
import com.example.tabby.R;

import java.util.List;

public class PersonAdapter extends BaseAdapter {


    private Context context;
    private int layout;
    private List<Person> persons;


    public PersonAdapter(Context context, int layout, List<Person> persons) {
        this.context = context;
        this.layout = layout;
        this.persons = persons;
    }



    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewPersonName);
            holder.country = (TextView) convertView.findViewById(R.id.textViewPersonCountry);
            holder.image = (ImageView) convertView.findViewById(R.id.imageViewFlag);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Person currentPerson = getItem(position);

        holder.name.setText(currentPerson.getName());
        holder.country.setText(currentPerson.getCountry().getName());
        String url = currentPerson.getCountry().getFlagURL();

        if(currentPerson.getCountry().getCountryCode().equals("AR")){
            Picasso.get().load(R.drawable.ar).fit().into(holder.image);
        }else if (currentPerson.getCountry().getCountryCode().equals("ES")){
            Picasso.get().load(R.drawable.es).fit().into(holder.image);
        }else if (currentPerson.getCountry().getCountryCode().equals("BO")){
            Picasso.get().load(R.drawable.bo).fit().into(holder.image);
        }else if (currentPerson.getCountry().getCountryCode().equals("CL")){
            Picasso.get().load(R.drawable.cl).fit().into(holder.image);
        }else if (currentPerson.getCountry().getCountryCode().equals("CO")){
            Picasso.get().load(R.drawable.co).fit().into(holder.image);
        }else if (currentPerson.getCountry().getCountryCode().equals("EC")){
            Picasso.get().load(R.drawable.ec).fit().into(holder.image);
        }else if (currentPerson.getCountry().getCountryCode().equals("MX")){
            Picasso.get().load(R.drawable.mx).fit().into(holder.image);
        }else if (currentPerson.getCountry().getCountryCode().equals("PE")){
            Picasso.get().load(R.drawable.pe).fit().into(holder.image);
        }else if (currentPerson.getCountry().getCountryCode().equals("UY")){
            Picasso.get().load(R.drawable.uy).fit().into(holder.image);
        }else if (currentPerson.getCountry().getCountryCode().equals("VE")){
            Picasso.get().load(R.drawable.ve).fit().into(holder.image);
        }

        return convertView;
    }

    static class ViewHolder {
        private TextView name;
        private TextView country;
        private ImageView image;
    }


}