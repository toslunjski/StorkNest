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
import hr.foi.air.storknest.app.measure.model.MeasureModel;

public class DoctorListAdapter extends ArrayAdapter<DoctorModel> implements View.OnClickListener {

    private ArrayList<DoctorModel> dataSet;
    private Context mContext;

    public DoctorListAdapter(ArrayList<DoctorModel> data, Context context) {
        super(context, R.layout.activity_doctor_list_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DoctorModel doctor = getItem(position);
        View listItem = convertView;

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_doctor_list_item, parent, false);

        TextView nameSurname = listItem.findViewById(R.id.doctor_nameSurname);
        nameSurname.setText(doctor.doctorNameSurname);

        TextView doctorType = listItem.findViewById(R.id.doctor_type);
        doctorType.setText(doctor.doctorType);

        TextView doctorWorkingHoursFrom = listItem.findViewById(R.id.doctor_workingHoursFrom);
        doctorWorkingHoursFrom.setText(doctor.doctorWorkingHoursFrom);

        TextView doctorWorkingHoursTo = listItem.findViewById(R.id.doctor_workingHoursTo);
        doctorWorkingHoursTo.setText(doctor.doctorWorkingHoursTo);

        TextView doctorTelephone = listItem.findViewById(R.id.doctor_telephone);
        doctorTelephone.setText(doctor.doctorTelephone);

        TextView createdAt = listItem.findViewById(R.id.created_time);
        createdAt.setText(doctor.createdAt);

        return listItem;
    }
}
