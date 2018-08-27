package hr.foi.air.storknest.app.vaccination.view;

import java.util.ArrayList;

import hr.foi.air.storknest.app.vaccination.model.VaccinationModel;

public interface IVaccinationListView {
    void onVaccinationList(ArrayList<VaccinationModel> vaccination);
}
