package hr.foi.air.storknest.login.model;

public interface IUser {
    String getEmail();
    String getPassword();
    int isValidData();
}
