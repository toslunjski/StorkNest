package hr.foi.air.storknest.app.doctor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.adapters.DoctorListAdapter;
import hr.foi.air.storknest.app.doctor.model.DoctorModel;
import hr.foi.air.storknest.app.doctor.presenter.DoctorListPresenter;
import hr.foi.air.storknest.app.doctor.presenter.IDoctorListPresenter;
import hr.foi.air.storknest.app.doctor.view.IDoctorListView;


public class DoctorListActivity extends AppCompatActivity implements IDoctorListView {

    IDoctorListPresenter doctorListPresenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        doctorListPresenter = new DoctorListPresenter(this);
        doctorListPresenter.onGetDoctor();
    }

    @Override
    public void onDoctorList(ArrayList<DoctorModel> doctor) {
        listView = findViewById(R.id.list_view);
        ArrayAdapter<DoctorModel> adapter = new ArrayAdapter<>(this, R.layout.activity_doctor_list_item, doctor);
        listView.setAdapter(new DoctorListAdapter(doctor, this));
    }
}