package hr.foi.air.storknest.app.diaper.presenter;

import android.widget.CheckBox;


public interface INewDiaperPresenter {
    void onSaveDiaper(String user, CheckBox checkPeeValue, CheckBox checkPooValue);
}
