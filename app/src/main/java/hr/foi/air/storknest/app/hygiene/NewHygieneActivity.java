package hr.foi.air.storknest.app.hygiene;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.hygiene.presenter.INewHygienePresenter;
import hr.foi.air.storknest.app.hygiene.presenter.NewHygienePresenter;
import hr.foi.air.storknest.app.hygiene.view.INewHygieneView;

public class NewHygieneActivity extends AppCompatActivity implements INewHygieneView {

    private INewHygienePresenter hygienePresenter;
    private CheckBox checkBody, checkHair, checkBelly, checkBodyValue, checkHairValue, checkBellyValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hygiene);

        checkBody= findViewById(R.id.checkBox_body);
        checkHair = findViewById(R.id.checkBox_hair);
        checkBelly = findViewById(R.id.checkBox_belly);

        hygienePresenter = new NewHygienePresenter(this);

        final Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBodyValue = (CheckBox) findViewById(checkBody.getId());
                checkHairValue = (CheckBox) findViewById(checkHair.getId());
                checkBellyValue = (CheckBox) findViewById(checkBelly.getId());
                hygienePresenter.onSaveHygiene(checkBodyValue, checkHairValue, checkBellyValue);
            }
        });
    }

    @Override
    public void onHygieneSaved() {
        Toast.makeText(this, "Hygiene saved", Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }
}
