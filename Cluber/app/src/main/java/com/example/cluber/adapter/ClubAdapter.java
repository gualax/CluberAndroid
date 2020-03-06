package com.example.cluber.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cluber.R;
import com.example.cluber.models.Club;
import com.example.cluber.view.ClubInformationFragment;
import com.example.cluber.view.ClubListFragment;
import com.example.cluber.view.ClubListFragmentDirections;

import java.util.ArrayList;

import static androidx.navigation.Navigation.findNavController;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolderData> {

    //Tipo de datosp
    ArrayList<Club> clubList;
    View mView;
    final static String TAG = "ClubAdapter";

    public ClubAdapter(ArrayList<Club> clubList) {
        this.clubList = clubList;
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

            Glide.with(itemView)
                    .load(club.getImgUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .fallback(R.drawable.ic_launcher_background)
                    .override(400, 400)
                    .into(clubImg);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ADAPTER","IM CLICKING" + clubItem.getName());
                    String clubString = clubItem.stringFromObject();
                    Log.e(TAG, clubString);
                    findNavController(v).navigate(ClubListFragmentDirections.actionClubsFragmentToClubInformationFragment(clubString));
                }
            });

        }
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

    public void setAdapter(ArrayList<Club> clubList){
        this.clubList = clubList;
        notifyDataSetChanged();
    }


}
