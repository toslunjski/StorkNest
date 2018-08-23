package hr.foi.air.storknest.Presenter;

public interface ILoginPresenter {
    void onLogin(String email, String password);
    void onRegister(String email, String password);
}
