package com.example.firebaseassigment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.contactViewHolder> {

    private List<Contact> mContacts;

    public ContactAdapter(List<Contact> Contacts) {
        this.mContacts = Contacts;
    }

    @NonNull
    @Override
    public contactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new contactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull contactViewHolder holder, int position) {
        holder.onBind(mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }


    public class contactViewHolder extends RecyclerView.ViewHolder {
        TextView textViewname ;
        TextView textViewNumber ;
        TextView textViewAddress  ;


        public contactViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAddress = itemView.findViewById(R.id.text_address);
            textViewname = itemView.findViewById(R.id.text_name);
            textViewNumber = itemView.findViewById(R.id.text_number);


        }

        public void onBind(Contact item) {
            textViewname.setText(item.getName());
            textViewNumber.setText(item.getNumber());
            textViewAddress.setText(item.getAddress());
        }
    }
}
