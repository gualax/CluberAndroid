package com.example.cluber.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cluber.R;
import com.example.cluber.models.Club;
import java.util.ArrayList;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolderData> {

    //Tipo de datos
    ArrayList<Club> clubList;
    View mView;

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
     TextView clubName,clubCity,clubAddress, clubCapacity;
     ImageView clubImg;

        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            clubName = (TextView) itemView.findViewById(R.id.club_name);
            clubCity = (TextView) itemView.findViewById(R.id.club_city);
            clubAddress = (TextView) itemView.findViewById(R.id.club_address);
            clubCapacity = (TextView) itemView.findViewById(R.id.club_capacity);
            clubImg = (ImageView) itemView.findViewById(R.id.club_image);
            mView = itemView;

        }

        public void assignData(final Club club) {
            final Club clubItem = club;
            Log.d("CLUBER","asignData***");
            int resourceId = mView.getResources().getIdentifier(club.getImageName(), "drawable", mView.getContext().getPackageName());
            clubName.setText(club.getName());
            clubCity.setText(club.getCity());
            clubAddress.setText(club.getAddress());
            clubCapacity.setText(String.valueOf(club.getCapacity()));
            clubImg.setImageResource(resourceId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ADAPTER","IM CLICKING" + clubItem.getName());
                }
            });

        }
    }
}
