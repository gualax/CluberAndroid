package com.example.cluber.Firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.cluber.models.Club;
import com.example.cluber.presenter.ClubListPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class FirebaseStore {

    final static String TAG = "FirebaseStore";

    ClubListPresenter mClubListPresenter;
    final FirebaseFirestore firestore;

    public FirebaseStore(ClubListPresenter presenter) {
        firestore = FirebaseFirestore.getInstance();
        mClubListPresenter = presenter;
    }

    public FirebaseStore() {
        firestore = FirebaseFirestore.getInstance();
    }

    public void insertClub(Club club){
        Log.e(TAG, "INSERTING clubs");
        firestore.collection("clubs").document(club.getName()).set(club);
    }


    public void getAllClubs(){
        Log.e(TAG, "GETTING FORM FIREBASE ALL CLUBS");
        ArrayList<Club> clubs = new ArrayList<>();
        firestore.collection("clubs")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Club club = document.toObject(Club.class);
                                clubs.add(club);
                            }
                            mClubListPresenter.dataClubChanged(clubs);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

    }

}
