package hr.foi.air.storknest.app.diaper.view;

import java.util.ArrayList;

import hr.foi.air.storknest.app.diaper.model.DiaperModel;

public interface IDiaperListView {
    void onDiaperList(ArrayList<DiaperModel> diapers);
}
