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
import hr.foi.air.storknest.app.doctor.model.DoctorModel;
import hr.foi.air.storknest.app.vaccination.model.VaccinationModel;

public class VaccinationListAdapter extends ArrayAdapter<VaccinationModel> implements View.OnClickListener {

    private ArrayList<VaccinationModel> dataSet;
    private Context mContext;

    public VaccinationListAdapter(ArrayList<VaccinationModel> data, Context context) {
        super(context, R.layout.activity_vaccination_list_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        VaccinationModel vaccination = getItem(position);
        View listItem = convertView;

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_vaccination_list_item, parent, false);

        TextView nameSurname = listItem.findViewById(R.id.vaccination_name);
        nameSurname.setText(vaccination.vaccinationName);

        TextView createdAt = listItem.findViewById(R.id.created_time);
        createdAt.setText(vaccination.createdAt);

        return listItem;
    }
}
