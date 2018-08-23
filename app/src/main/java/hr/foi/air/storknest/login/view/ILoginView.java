package hr.foi.air.storknest.login.view;

public interface ILoginView {
    void onLoginSuccess(String message);

    void onLoginError(String message);

    void onRegisterSuccess(String message);

    void onRegisterError(String message);

}
