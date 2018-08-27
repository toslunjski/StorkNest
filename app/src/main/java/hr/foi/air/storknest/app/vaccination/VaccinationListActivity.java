package hr.foi.air.storknest.app.vaccination;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.adapters.FeedListAdapter;
import hr.foi.air.storknest.app.adapters.VaccinationListAdapter;
import hr.foi.air.storknest.app.feed.model.FeedModel;
import hr.foi.air.storknest.app.feed.presenter.FeedListPresenter;
import hr.foi.air.storknest.app.feed.presenter.IFeedListPresenter;
import hr.foi.air.storknest.app.feed.view.IFeedListView;
import hr.foi.air.storknest.app.vaccination.model.VaccinationModel;
import hr.foi.air.storknest.app.vaccination.presenter.IVaccinationListPresenter;
import hr.foi.air.storknest.app.vaccination.presenter.VaccinationListPresenter;
import hr.foi.air.storknest.app.vaccination.view.IVaccinationListView;

public class VaccinationListActivity extends AppCompatActivity implements IVaccinationListView {

    IVaccinationListPresenter vaccinationListPresenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_list);

        vaccinationListPresenter = new VaccinationListPresenter(this);
        vaccinationListPresenter.onGetVaccination();
    }

    @Override
    public void onVaccinationList(ArrayList<VaccinationModel> Vaccination) {
        listView = findViewById(R.id.list_view);
        ArrayAdapter<VaccinationModel> adapter = new ArrayAdapter<>(this, R.layout.activity_vaccination_list_item, Vaccination);
        listView.setAdapter(new VaccinationListAdapter(Vaccination, this));
    }
}