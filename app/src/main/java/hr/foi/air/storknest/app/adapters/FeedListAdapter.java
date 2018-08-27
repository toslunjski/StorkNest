package hr.foi.air.storknest.app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.feed.model.FeedModel;

public class FeedListAdapter extends ArrayAdapter<FeedModel> implements View.OnClickListener {

    private ArrayList<FeedModel> dataSet;
    private Context mContext;

    public FeedListAdapter(ArrayList<FeedModel> data, Context context) {
        super(context, R.layout.activity_feed_list_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        FeedModel feed = getItem(position);
        View listItem = convertView;

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_feed_list_item, parent, false);

        TextView feedType = listItem.findViewById(R.id.feed_type);
        feedType.setText(feed.feedType);

        TextView feedAmount = listItem.findViewById(R.id.feed_amount);
        feedAmount.setText(feed.feedAmount);

        TextView createdAt = listItem.findViewById(R.id.created_time);
        createdAt.setText(feed.createdAt);

        return listItem;
    }
}
