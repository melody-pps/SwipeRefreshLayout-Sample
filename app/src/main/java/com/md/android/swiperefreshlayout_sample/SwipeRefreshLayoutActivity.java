package com.md.android.swiperefreshlayout_sample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SwipeRefreshLayoutActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout      mSwipeRefreshLayout;
    private ListView                mListView;

    private ArrayAdapter<String>    mAdapter;

    private static final String[] HALL_OF_FRAME = { "Jacques Anquetil (FRA)", "Eddy Merckx (BEL)", "Bernard Hinault (FRA)",
            "Miguel Indurain (ESP)", "Philippe Thys (BEL)", "Louison Bobet (FRA)", "Greg LeMond (USA)", "Lucien Petit-Breton (FRA)",
            "Firmin Lambot (BEL)", "Ottavio Bottecchia (ITA)", "Nicolas Frantz (LUX)", "André Leducq (FRA)", "Antonin Magne (FRA)",
            "Sylvère Maes (BEL)", "Gino Bartali (ITA)", "Fausto Coppi (ITA)", "Bernard Thévenet (FRA)", "Laurent Fignon (FRA)", "Alberto Contador (ESP)",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);
        initial();
    }

    private void initial() {
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light,android.R.color.holo_red_light);

        mAdapter    = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, HALL_OF_FRAME);
        mListView   = (ListView)findViewById(R.id.listview);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                // Do some stuff.
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }
}
