package hr.foi.air.storknest.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;

import java.util.ArrayList;
import java.util.List;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.diper.NewDiperActivity;
import hr.foi.air.storknest.app.feed.NewFeedActivity;

public class MainScreenActivity extends AppCompatActivity implements RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener {

    private RapidFloatingActionLayout rfaLayout;
    private RapidFloatingActionButton rfaBtn;
    private RapidFloatingActionHelper rfabHelper;

    private void setupPlusButton() {

        rfaLayout = findViewById(R.id.activity_main_rfal);
        rfaBtn = findViewById(R.id.activity_main_rfab);

        RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(this);
        rfaContent.setOnRapidFloatingActionContentLabelListListener(this);
        List<RFACLabelItem> items = new ArrayList<>();

        items.add(new RFACLabelItem<Integer>()
                .setLabel("Feed")
                .setResId(R.drawable.common_google_signin_btn_text_dark_normal)
                .setIconNormalColor(Color.BLUE)
                .setWrapper(0)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Diper")
                .setResId(R.drawable.ic_check_white_48dp)
                .setIconNormalColor(Color.BLUE)
                .setWrapper(1)
        );

        rfaContent
                .setItems(items)
                .setIconShadowColor(0xff888888);

        rfabHelper = new RapidFloatingActionHelper(
                this,
                rfaLayout,
                rfaBtn,
                rfaContent
        ).build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupPlusButton();
    }

    private void handlePlusItemClick(int position, RFACLabelItem item) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, NewFeedActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, NewDiperActivity.class));
                break;
        }

        rfabHelper.toggleContent();
    }

    @Override
    public void onRFACItemLabelClick(int position, RFACLabelItem item) {
        handlePlusItemClick(position, item);
    }

    @Override
    public void onRFACItemIconClick(int position, RFACLabelItem item) {
        handlePlusItemClick(position, item);
    }
}
