package hr.foi.air.storknest.app.hygiene.presenter;

import android.widget.CheckBox;


public interface INewHygienePresenter {
    void onSaveHygiene(String user, CheckBox body, CheckBox hair, CheckBox belly);
}
