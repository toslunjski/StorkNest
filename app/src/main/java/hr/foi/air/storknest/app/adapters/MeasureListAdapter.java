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
import hr.foi.air.storknest.app.measure.model.MeasureModel;

public class MeasureListAdapter extends ArrayAdapter<MeasureModel> implements View.OnClickListener {

    private ArrayList<MeasureModel> dataSet;
    private Context mContext;

    public MeasureListAdapter(ArrayList<MeasureModel> data, Context context) {
        super(context, R.layout.activity_measure_list_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MeasureModel measure = getItem(position);
        View listItem = convertView;

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_measure_list_item, parent, false);

        TextView weight = listItem.findViewById(R.id.measure_weight);
        weight.setText(measure.measureWeight);

        TextView height = listItem.findViewById(R.id.measure_height);
        height.setText(measure.measureHeight);

        TextView createdAt = listItem.findViewById(R.id.created_time);
        createdAt.setText(measure.createdAt);

        return listItem;
    }
}
