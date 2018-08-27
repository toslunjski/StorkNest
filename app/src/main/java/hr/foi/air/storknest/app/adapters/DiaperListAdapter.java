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
import hr.foi.air.storknest.app.diaper.model.DiaperModel;

public class DiaperListAdapter extends ArrayAdapter<DiaperModel> implements View.OnClickListener {

    private ArrayList<DiaperModel> dataSet;
    private Context mContext;

    public DiaperListAdapter(ArrayList<DiaperModel> data, Context context) {
        super(context, R.layout.activity_diaper_list_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DiaperModel diaper = getItem(position);
        View listItem = convertView;

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_diaper_list_item, parent, false);

        TextView pee = listItem.findViewById(R.id.diaper_pee);
        pee.setText(diaper.diaperPee);

        TextView poo = listItem.findViewById(R.id.diaper_poo);
        poo.setText(diaper.diaperPoo);

        TextView createdAt = listItem.findViewById(R.id.created_time);
        createdAt.setText(diaper.createdAt);

        return listItem;
    }
}
