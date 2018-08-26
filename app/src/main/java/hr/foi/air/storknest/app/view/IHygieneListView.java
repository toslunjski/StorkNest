package hr.foi.air.storknest.app.view;

import java.util.ArrayList;

import hr.foi.air.storknest.app.model.DiaperModel;
import hr.foi.air.storknest.app.model.HygieneModel;

public interface IHygieneListView {
    void onHygieneList(ArrayList<HygieneModel> hygiene);
}
