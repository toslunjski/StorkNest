package hr.foi.air.storknest.app.presenter;

import android.widget.CheckBox;


public interface INewHygienePresenter {
    void onSaveHygiene(CheckBox body, CheckBox hair, CheckBox belly);
}
