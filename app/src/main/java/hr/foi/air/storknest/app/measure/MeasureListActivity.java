package hr.foi.air.storknest.app.measure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.adapters.FeedListAdapter;
import hr.foi.air.storknest.app.model.FeedModel;
import hr.foi.air.storknest.app.presenter.FeedListPresenter;
import hr.foi.air.storknest.app.presenter.IFeedListPresenter;
import hr.foi.air.storknest.app.view.IFeedListView;

public class MeasureListActivity extends AppCompatActivity implements IFeedListView {

    IFeedListPresenter feedListPresenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_list);

        feedListPresenter = new FeedListPresenter(this);
        feedListPresenter.onGetFeeds();
    }

    @Override
    public void onFeedList(ArrayList<FeedModel> feeds) {
        listView = findViewById(R.id.list_view);
        ArrayAdapter<FeedModel> adapter = new ArrayAdapter<>(this, R.layout.activity_feed_list_item, feeds);
        listView.setAdapter(new FeedListAdapter(feeds, this));
    }
}