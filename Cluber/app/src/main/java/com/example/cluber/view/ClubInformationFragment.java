package com.example.cluber.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.cluber.R;
import com.example.cluber.models.Club;


public class ClubInformationFragment extends Fragment  {

    final static String TAG = "ClubInformationFragment";
     ImageView imgClub;
    TextView clubName, clubCity, clubAddress, clubCapacity ;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.club_info_fragment,container,false);
        ClubInformationFragmentArgs args = ClubInformationFragmentArgs.fromBundle(this.getArguments());
        Club club = Club.getObjectFromStrfroing(args.getClubString());
        Log.e(TAG,club.getName());

        clubName = rootView.findViewById(R.id.club_name);
        clubAddress = rootView.findViewById(R.id.club_address);
        clubCity = rootView.findViewById(R.id.club_city);
        clubCapacity = rootView.findViewById(R.id.club_capacity);
        imgClub = rootView.findViewById(R.id.club_image);


        clubName.setText(club.getName());
        clubAddress.setText(club.getAddress());
        clubCity.setText(club.getCity());
        clubCapacity.setText(String.valueOf(club.getCapacity()));

        Glide.with(rootView)
                .load(club.getImgUrl())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_background)
                .override(400, 400)
                .into(imgClub);

        return  rootView;
    }

}
