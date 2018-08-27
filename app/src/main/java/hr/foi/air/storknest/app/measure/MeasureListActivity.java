package hr.foi.air.storknest.app.measure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.adapters.MeasureListAdapter;
import hr.foi.air.storknest.app.measure.model.MeasureModel;
import hr.foi.air.storknest.app.measure.presenter.IMeasureListPresenter;
import hr.foi.air.storknest.app.measure.presenter.MeasureListPresenter;
import hr.foi.air.storknest.app.measure.view.IMeasureListView;

public class MeasureListActivity extends AppCompatActivity implements IMeasureListView {

    IMeasureListPresenter measureListPresenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure_list);

        measureListPresenter = new MeasureListPresenter(this);
        measureListPresenter.onGetMeasure();
    }

    @Override
    public void onMeasureList(ArrayList<MeasureModel> measure) {
        listView = findViewById(R.id.list_view);
        ArrayAdapter<MeasureModel> adapter = new ArrayAdapter<>(this, R.layout.activity_measure_list_item, measure);
        listView.setAdapter(new MeasureListAdapter(measure, this));
    }
}