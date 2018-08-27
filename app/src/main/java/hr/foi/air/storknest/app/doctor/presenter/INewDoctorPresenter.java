package hr.foi.air.storknest.app.doctor.presenter;


public interface INewDoctorPresenter {
    void onSaveDoctor(String nameSurname, String doctorType, String workingHoursFrom, String workingHoursTo, String telephone);
}
