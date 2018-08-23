package hr.foi.air.storknest.app.feed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.adapters.FeedListAdapter;
import hr.foi.air.storknest.app.model.FeedModel;
import hr.foi.air.storknest.app.presenter.FeedListPresenter;
import hr.foi.air.storknest.app.presenter.IFeedListPresenter;
import hr.foi.air.storknest.app.presenter.NewFeedPresenter;
import hr.foi.air.storknest.app.view.IFeedListView;

public class FeedListActivity extends AppCompatActivity implements IFeedListView {

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