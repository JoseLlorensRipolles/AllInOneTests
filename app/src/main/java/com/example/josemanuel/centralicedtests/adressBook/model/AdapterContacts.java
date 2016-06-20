package com.example.josemanuel.centralicedtests.adressBook.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.josemanuel.centralicedtests.R;

import java.util.ArrayList;

/**
 * Created by JoseManuel on 14/06/2016.
 */

 public class AdapterContacts extends RecyclerView.Adapter<AdapterContacts.ContactsViewHolder> implements View.OnClickListener {

    private ArrayList<Contact> contacts;
    private View.OnClickListener listener;

    public AdapterContacts(ArrayList<Contact> contacts){
        this.contacts=contacts;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listview_contacts_item, parent, false);

        itemView.setOnClickListener(this);

        ContactsViewHolder cvh = new ContactsViewHolder(itemView);
        return cvh;
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        Contact c = contacts.get(position);
        holder.bindContact(c);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTextView;
        private TextView phoneTextView;

        public ContactsViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView)itemView.findViewById(R.id.textViewContactName);
            phoneTextView = (TextView)itemView.findViewById(R.id.textViewContactPhone);


        }
        public void bindContact(Contact c){
            nameTextView.setText(c.getName());
            phoneTextView.setText(""+ c.getPhone()+"");
        }
    }
}
