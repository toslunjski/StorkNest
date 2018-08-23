package hr.foi.air.storknest.View;

public interface ILoginView {
    void onLoginSuccess(String message);

    void onLoginError(String message);

    void onRegisterSuccess(String message);

    void onRegisterError(String message);

}
