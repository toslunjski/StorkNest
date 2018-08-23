package hr.foi.air.storknest.Presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import hr.foi.air.storknest.Model.User;
import hr.foi.air.storknest.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    ILoginView loginView;

    private void firebaseLogin(User user) {
        Task<AuthResult> request = firebaseAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword());

        request.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("tomo", "logging in failed. error: " + e.getMessage());
                e.printStackTrace();
                loginView.onLoginError("Login unsuccessful! Error: " + e.getMessage());
            }
        });

        request.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Log.i("tomo", "success: " + authResult.getUser().getUid());
                loginView.onLoginSuccess("Login success!");
            }
        });
    }

    private void firebaseRegister(User user) {
        Task<AuthResult> request = firebaseAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword());

        request.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
                loginView.onRegisterError("Register unsuccessful! Error: " + e.getMessage());
            }
        });

        request.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Log.i("tomo", "success");
                loginView.onRegisterSuccess("Register success!");
            }
        });
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValidData();

        if (loginCode == 0) {
            loginView.onLoginError("Enter e-mail!");
        } else if (loginCode == 1) {
            loginView.onLoginError("Enter valid e-mail!");
        } else if (loginCode == 2) {
            loginView.onLoginError("Password length must be greater than 6!");
        }

        firebaseLogin(user);
    }

    @Override
    public void onRegister(String email, String password) {
        User user = new User(email, password);
        int registerCode = user.isValidData();


        if (registerCode == 0) {
            loginView.onRegisterError("Enter e-mail!");
        } else if (registerCode == 1) {
            loginView.onRegisterError("Enter valid e-mail!");
        } else if (registerCode == 2) {
            loginView.onRegisterError("Password length must be greater than 6!");
        }

        firebaseRegister(user);
    }
}
