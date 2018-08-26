package hr.foi.air.storknest.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;

import java.util.ArrayList;
import java.util.List;

import hr.foi.air.storknest.R;
import hr.foi.air.storknest.app.diaper.DiaperListActivity;
import hr.foi.air.storknest.app.diaper.NewDiaperActivity;
import hr.foi.air.storknest.app.doctor.DoctorListActivity;
import hr.foi.air.storknest.app.doctor.NewDoctorActivity;
import hr.foi.air.storknest.app.feed.FeedListActivity;
import hr.foi.air.storknest.app.feed.NewFeedActivity;
import hr.foi.air.storknest.app.hygiene.HygieneListActivity;
import hr.foi.air.storknest.app.hygiene.NewHygieneActivity;
import hr.foi.air.storknest.app.measure.MeasureListActivity;
import hr.foi.air.storknest.app.measure.NewMeasureActivity;
import hr.foi.air.storknest.app.vaccination.NewVaccinationActivity;
import hr.foi.air.storknest.app.vaccination.VaccinationListActivity;

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
                .setResId(R.drawable.ic_check_white_48dp)
                .setIconNormalColor(Color.BLUE)
                .setWrapper(0)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Diaper")
                .setResId(R.drawable.ic_check_white_48dp)
                .setIconNormalColor(Color.BLUE)
                .setWrapper(1)
        );

        items.add(new RFACLabelItem<Integer>()
                .setLabel("Hygiene")
                .setResId(R.drawable.ic_check_white_48dp)
                .setIconNormalColor(Color.BLUE)
                .setWrapper(2)
        );

        items.add(new RFACLabelItem<Integer>()
                .setLabel("Measure")
                .setResId(R.drawable.ic_check_white_48dp)
                .setIconNormalColor(Color.BLUE)
                .setWrapper(3)
        );

        items.add(new RFACLabelItem<Integer>()
                .setLabel("Doctor")
                .setResId(R.drawable.ic_check_white_48dp)
                .setIconNormalColor(Color.BLUE)
                .setWrapper(4)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Vaccination")
                .setResId(R.drawable.ic_check_white_48dp)
                .setIconNormalColor(Color.BLUE)
                .setWrapper(5)
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
        final Context ctx = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupPlusButton();

        Button openListOfFeeds = findViewById(R.id.open_feeds_list);
        openListOfFeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, FeedListActivity.class));
            }
        });

        Button openListOfDiapers = findViewById(R.id.open_diaper_list);
        openListOfDiapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DiaperListActivity.class));
            }
        });

        Button openListOfMeasures = findViewById(R.id.open_measure_list);
        openListOfMeasures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, MeasureListActivity.class));
            }
        });

        Button openListOfHygienes = findViewById(R.id.open_hygiene_list);
        openListOfHygienes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, HygieneListActivity.class));
            }
        });

        Button openListOfDoctors = findViewById(R.id.open_doctors_list);
        openListOfDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DoctorListActivity.class));
            }
        });

        Button openListOfVaccins = findViewById(R.id.open_vaccination_list);
        openListOfVaccins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, VaccinationListActivity.class));
            }
        });
    }

    private void handlePlusItemClick(int position, RFACLabelItem item) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, NewFeedActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, NewDiaperActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, NewHygieneActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, NewMeasureActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, NewDoctorActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, NewVaccinationActivity.class));
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
