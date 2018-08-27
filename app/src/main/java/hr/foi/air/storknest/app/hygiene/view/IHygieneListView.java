package hr.foi.air.storknest.app.hygiene.view;

import java.util.ArrayList;

import hr.foi.air.storknest.app.hygiene.model.HygieneModel;

public interface IHygieneListView {
    void onHygieneList(ArrayList<HygieneModel> hygiene);
}
