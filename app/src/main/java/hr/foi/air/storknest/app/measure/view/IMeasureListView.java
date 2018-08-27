package hr.foi.air.storknest.app.measure.view;

import java.util.ArrayList;

import hr.foi.air.storknest.app.hygiene.model.HygieneModel;
import hr.foi.air.storknest.app.measure.model.MeasureModel;

public interface IMeasureListView {
    void onMeasureList(ArrayList<MeasureModel> measure);
}
