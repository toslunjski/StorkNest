package hr.foi.air.storknest.app.measure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.measure.presenter.INewMeasurePresenter;
import hr.foi.air.storknest.app.measure.presenter.NewMeasurePresenter;
import hr.foi.air.storknest.app.measure.view.INewMeasureView;

public class NewMeasureActivity extends AppCompatActivity implements INewMeasureView {

    private INewMeasurePresenter measurePresenter;
    private String user, height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_measure);

        measurePresenter = new NewMeasurePresenter(this);

        final Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = FirebaseAuth.getInstance().getCurrentUser().getUid();
                EditText checkWeight = (EditText) findViewById(R.id.editText_weight);
                weight = checkWeight.getText().toString();
                EditText checkHeight = (EditText) findViewById(R.id.editText_height);
                height = checkHeight.getText().toString();
                measurePresenter.onSaveMeasure(user, weight, height);
            }
        });
    }

    @Override
    public void onMeasureSaved() {
        Toast.makeText(this, "Measure saved", Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }
}
