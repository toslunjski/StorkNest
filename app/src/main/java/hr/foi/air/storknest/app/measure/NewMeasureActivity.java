package hr.foi.air.storknest.app.measure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.feed.presenter.INewFeedPresenter;
import hr.foi.air.storknest.app.feed.presenter.NewFeedPresenter;
import hr.foi.air.storknest.app.feed.view.INewFeedView;
import hr.foi.air.storknest.app.measure.presenter.INewMeasurePresenter;
import hr.foi.air.storknest.app.measure.presenter.NewMeasurePresenter;
import hr.foi.air.storknest.app.measure.view.INewMeasureView;

public class NewMeasureActivity extends AppCompatActivity implements INewMeasureView {

    private INewMeasurePresenter measurePresenter;
    private String height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_measure);

        measurePresenter = new NewMeasurePresenter(this);

        final Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText checkWeight = (EditText) findViewById(R.id.editText_weight);
                weight = checkWeight.getText().toString();
                EditText checkHeight = (EditText) findViewById(R.id.editText_height);
                height = checkHeight.getText().toString();
                measurePresenter.onSaveMeasure(weight, height);
            }
        });
    }

    @Override
    public void onMeasureSaved() {
        Toast.makeText(this, "Measure saved", Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }
}
