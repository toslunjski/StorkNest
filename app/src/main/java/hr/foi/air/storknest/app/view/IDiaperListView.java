package hr.foi.air.storknest.app.view;

import java.util.ArrayList;

import hr.foi.air.storknest.app.model.DiaperModel;
import hr.foi.air.storknest.app.model.FeedModel;

public interface IDiaperListView {
    void onDiaperList(ArrayList<DiaperModel> diapers);
}
