package hr.foi.air.storknest.app.diaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.diaper.presenter.INewDiaperPresenter;
import hr.foi.air.storknest.app.diaper.presenter.NewDiaperPresenter;
import hr.foi.air.storknest.app.diaper.view.INewDiaperView;

public class NewDiaperActivity extends AppCompatActivity implements INewDiaperView {

    private INewDiaperPresenter diaperPresenter;
    private CheckBox checkPee, checkPoo, checkPeeValue, checkPooValue;
    private String user;

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
                user = FirebaseAuth.getInstance().getCurrentUser().getUid();
                checkPeeValue = (CheckBox) findViewById(checkPee.getId());
                checkPooValue = (CheckBox) findViewById(checkPoo.getId());
                diaperPresenter.onSaveDiaper(user, checkPeeValue, checkPooValue);
            }
        });
    }

    public void onDiaperSaved() {
        Toast.makeText(this, "Diaper saved", Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }
}
