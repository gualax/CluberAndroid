package com.example.cluber.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cluber.R;
import com.example.cluber.models.Club;

import java.util.ArrayList;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolderData> {

    //Tipo de datos
    ArrayList<Club> clubList;


    public ClubAdapter(ArrayList<Club> clubList) {
        this.clubList = clubList;
    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_item_list,null,false);
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
        holder.assignData(clubList.get(position));
    }

    @Override
    public int getItemCount() {
        return clubList.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {
     TextView clubName;

        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            clubName = (TextView) itemView.findViewById(R.id.club_name);
        }

        public void assignData(Club club) {
            Log.d("CLUBER","asignData***");
            Log.d("CLUBER",club.getName());
            clubName.setText(club.getName());
        }
    }
}
