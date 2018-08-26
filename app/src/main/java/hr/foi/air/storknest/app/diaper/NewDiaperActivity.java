package hr.foi.air.storknest.app.diaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.presenter.INewDiaperPresenter;
import hr.foi.air.storknest.app.presenter.NewDiaperPresenter;
import hr.foi.air.storknest.app.view.INewDiaperView;

public class NewDiaperActivity extends AppCompatActivity implements INewDiaperView {

    private INewDiaperPresenter diaperPresenter;
    private CheckBox checkPee, checkPoo, checkPeeValue, checkPooValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_diaper);

        checkPee= findViewById(R.id.checkBox_pee);
        checkPoo = findViewById(R.id.checkBox_poo);

        diaperPresenter = new NewDiaperPresenter(this);

        final Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPeeValue = (CheckBox) findViewById(checkPee.getId());
                checkPooValue = (CheckBox) findViewById(checkPoo.getId());
                diaperPresenter.onSaveDiaper(checkPeeValue, checkPooValue);
            }
        });
    }

    public void onDiaperSaved() {
        Toast.makeText(this, "Diaper saved", Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }
}
