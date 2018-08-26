package hr.foi.air.storknest.app.vaccination;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.presenter.INewFeedPresenter;
import hr.foi.air.storknest.app.presenter.NewFeedPresenter;
import hr.foi.air.storknest.app.view.INewFeedView;

public class NewVaccinationActivity extends AppCompatActivity implements INewFeedView {

    private INewFeedPresenter feedPresenter;
    private RadioGroup radioGroupType, radioGroupAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feed);

        radioGroupType= findViewById(R.id.feeding_type_group);
        radioGroupAmount = findViewById(R.id.feeding_amount_group);

        feedPresenter = new NewFeedPresenter(this);

        final Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton selectedRadioButtonType = (RadioButton) findViewById(radioGroupType.getCheckedRadioButtonId());
                RadioButton selectedRadioButtonAmount = (RadioButton) findViewById(radioGroupAmount.getCheckedRadioButtonId());
                feedPresenter.onSaveFeed(selectedRadioButtonType, selectedRadioButtonAmount);
            }
        });
    }

    @Override
    public void onFeedSaved() {
        Toast.makeText(this, "Feed saved", Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }
}
