package hr.foi.air.storknest.app.vaccination;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.vaccination.presenter.INewVaccinationPresenter;
import hr.foi.air.storknest.app.vaccination.presenter.NewVaccinationPresenter;
import hr.foi.air.storknest.app.vaccination.view.INewVaccinationView;

public class NewVaccinationActivity extends AppCompatActivity implements INewVaccinationView {

    private INewVaccinationPresenter vaccinationPresenter;
    private String user, vaccinationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vaccination);

        vaccinationPresenter = new NewVaccinationPresenter(this);

        final Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user = FirebaseAuth.getInstance().getCurrentUser().getUid();
                EditText checkVaccinationName = (EditText) findViewById(R.id.editText_vaccinationName);
                vaccinationName = checkVaccinationName.getText().toString();
                vaccinationPresenter.onSaveVaccination(user, vaccinationName);
            }
        });
    }

    @Override
    public void onVaccinationSaved() {
        Toast.makeText(this, "Vaccination saved", Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }
}
