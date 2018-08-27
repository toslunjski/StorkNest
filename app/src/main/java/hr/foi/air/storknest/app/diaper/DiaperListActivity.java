package hr.foi.air.storknest.app.diaper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.adapters.DiaperListAdapter;
import hr.foi.air.storknest.app.diaper.model.DiaperModel;
import hr.foi.air.storknest.app.diaper.presenter.DiaperListPresenter;
import hr.foi.air.storknest.app.diaper.presenter.IDiaperListPresenter;
import hr.foi.air.storknest.app.diaper.view.IDiaperListView;

public class DiaperListActivity extends AppCompatActivity implements IDiaperListView {

    IDiaperListPresenter diaperListPresenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaper_list);

        diaperListPresenter = new DiaperListPresenter(this);
        diaperListPresenter.onGetDiapers();
    }

    @Override
    public void onDiaperList(ArrayList<DiaperModel> diapers) {
        listView = findViewById(R.id.list_view);
        ArrayAdapter<DiaperModel> adapter = new ArrayAdapter<>(this, R.layout.activity_diaper_list_item, diapers);
        listView.setAdapter(new DiaperListAdapter(diapers, this));
    }
}