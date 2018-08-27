package hr.foi.air.storknest.app.hygiene;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.adapters.HygieneListAdapter;
import hr.foi.air.storknest.app.hygiene.model.HygieneModel;
import hr.foi.air.storknest.app.hygiene.presenter.HygieneListPresenter;
import hr.foi.air.storknest.app.hygiene.presenter.IHygieneListPresenter;
import hr.foi.air.storknest.app.hygiene.view.IHygieneListView;

public class HygieneListActivity extends AppCompatActivity implements IHygieneListView {

    IHygieneListPresenter hygieneListPresenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hygiene_list);

        hygieneListPresenter = new HygieneListPresenter(this);
        hygieneListPresenter.onGetHygiene();
    }

    @Override
    public void onHygieneList(ArrayList<HygieneModel> hygiene) {
        listView = findViewById(R.id.list_view);
        ArrayAdapter<HygieneModel> adapter = new ArrayAdapter<>(this, R.layout.activity_hygiene_list_item, hygiene);
        listView.setAdapter(new HygieneListAdapter(hygiene, this));
    }
}