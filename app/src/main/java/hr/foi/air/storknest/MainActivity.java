package hr.foi.air.storknest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import es.dmoral.toasty.Toasty;
import hr.foi.air.storknest.Presenter.ILoginPresenter;
import hr.foi.air.storknest.Presenter.LoginPresenter;
import hr.foi.air.storknest.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText edt_email, edt_password;
    Button btnLogin, btnRegister;
    FirebaseAuth firebaseAuth;
    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INIT View
        btnLogin = (Button)findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);
        edt_email = (EditText) findViewById(R.id.edit_email);
        edt_password = (EditText) findViewById(R.id.edit_password);

        //INIT
        loginPresenter = new LoginPresenter(this);

        //EVENT
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(edt_email.getText().toString(), edt_password.getText().toString());
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onRegister(edt_email.getText().toString(), edt_password.getText().toString());
            }
        });

    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onRegisterSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }



}
