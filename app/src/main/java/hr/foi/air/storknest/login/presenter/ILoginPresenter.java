package hr.foi.air.storknest.login.presenter;

public interface ILoginPresenter {
    void onLogin(String email, String password);
    void onRegister(String email, String password);
}
