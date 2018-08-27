package hr.foi.air.storknest.app.measure.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


import hr.foi.air.storknest.app.measure.model.MeasureModel;
import hr.foi.air.storknest.app.measure.view.IMeasureListView;

public class MeasureListPresenter implements IMeasureListPresenter {

    private FirebaseDatabase mDatabase;
    private IMeasureListView measureListView;

    public MeasureListPresenter(IMeasureListView measureListView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.measureListView = measureListView;
    }

    @Override
    public void onGetMeasure() {
        mDatabase.getReference().child("measure").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<MeasureModel> measure = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    measure.add(new MeasureModel().deserialize(snapshot));
                }

                measureListView.onMeasureList(measure);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
