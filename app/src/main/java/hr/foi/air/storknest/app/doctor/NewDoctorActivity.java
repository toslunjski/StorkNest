package hr.foi.air.storknest.app.doctor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.doctor.presenter.INewDoctorPresenter;
import hr.foi.air.storknest.app.doctor.presenter.NewDoctorPresenter;
import hr.foi.air.storknest.app.doctor.view.INewDoctorView;
import hr.foi.air.storknest.app.feed.presenter.INewFeedPresenter;
import hr.foi.air.storknest.app.feed.presenter.NewFeedPresenter;
import hr.foi.air.storknest.app.feed.view.INewFeedView;
import hr.foi.air.storknest.app.measure.presenter.NewMeasurePresenter;

public class NewDoctorActivity extends AppCompatActivity implements INewDoctorView {

    private INewDoctorPresenter doctorPresenter;
    private String nameSurname, doctorType, workingHoursFrom, workingHoursTo, telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_doctor);

        doctorPresenter = new NewDoctorPresenter(this);

        final Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText checkNameSurname = (EditText) findViewById(R.id.editText_nameSurname);
                nameSurname = checkNameSurname.getText().toString();
                EditText checkDoctorType = (EditText) findViewById(R.id.editText_doctorType);
                doctorType = checkDoctorType.getText().toString();
                EditText checkWorkingHoursFrom = (EditText) findViewById(R.id.editText_workingHoursFrom);
                workingHoursFrom = checkWorkingHoursFrom.getText().toString();
                EditText checkWorkingHoursTo = (EditText) findViewById(R.id.editText_workingHoursTo);
                workingHoursTo = checkWorkingHoursTo.getText().toString();
                EditText checkTelephone = (EditText) findViewById(R.id.editText_telephone);
                telephone = checkTelephone.getText().toString();
                doctorPresenter.onSaveDoctor(nameSurname, doctorType, workingHoursFrom, workingHoursTo, telephone);
            }
        });
    }

    @Override
    public void onDoctorSaved() {
        Toast.makeText(this, "Doctor saved", Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }
}
