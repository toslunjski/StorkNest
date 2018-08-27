package hr.foi.air.storknest.app.diaper.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import hr.foi.air.storknest.app.diaper.model.DiaperModel;
import hr.foi.air.storknest.app.diaper.view.IDiaperListView;

public class DiaperListPresenter implements IDiaperListPresenter {

    private FirebaseDatabase mDatabase;
    private IDiaperListView diaperListView;

    public DiaperListPresenter(IDiaperListView diaperListView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.diaperListView = diaperListView;
    }

    @Override
    public void onGetDiapers() {
        mDatabase.getReference().child("diapers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<DiaperModel> diapers = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    diapers.add(new DiaperModel().deserialize(snapshot));
                }

                diaperListView.onDiaperList(diapers);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
