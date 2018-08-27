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
import hr.foi.air.storknest.app.hygiene.model.HygieneModel;

public class HygieneListAdapter extends ArrayAdapter<HygieneModel> implements View.OnClickListener {

    private ArrayList<HygieneModel> dataSet;
    private Context mContext;

    public HygieneListAdapter(ArrayList<HygieneModel> data, Context context) {
        super(context, R.layout.activity_hygiene_list_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HygieneModel hygiene = getItem(position);
        View listItem = convertView;

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_hygiene_list_item, parent, false);

        TextView body = listItem.findViewById(R.id.hygiene_body);
        body.setText(hygiene.hygieneBody);

        TextView hair = listItem.findViewById(R.id.hygiene_hair);
        hair.setText(hygiene.hygieneHair);

        TextView belly = listItem.findViewById(R.id.hygiene_belly);
        belly.setText(hygiene.hygieneBelly);

        TextView createdAt = listItem.findViewById(R.id.created_time);
        createdAt.setText(hygiene.createdAt);

        return listItem;
    }
}
