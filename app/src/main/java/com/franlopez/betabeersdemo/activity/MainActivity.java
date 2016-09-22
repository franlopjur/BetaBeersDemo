package com.franlopez.betabeersdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.franlopez.betabeersdemo.ModelAndroidVersion;
import com.franlopez.betabeersdemo.R;
import com.franlopez.betabeersdemo.adapter.CustomAdapter;
import com.franlopez.betabeersdemo.common.BBDConstants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton mFAB;
    private RecyclerView mRVItems;
    private Toolbar mToolbar;

    private List<ModelAndroidVersion> mDataset = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();
        init();
    }

    private void getViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRVItems = (RecyclerView) findViewById(R.id.content_main__recycler);
        mFAB = (FloatingActionButton) findViewById(R.id.activity_main__fab);
    }

    private void init() {
        setSupportActionBar(mToolbar);

        generateDummyModels();
        setUpRecyclerView();

        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setUpRecyclerView() {
        mRVItems.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRVItems.setLayoutManager(mLayoutManager);

        mAdapter = new CustomAdapter(mDataset, new CustomAdapter.CustomItemClickListener() {
            @Override
            public void onItemClicked(ModelAndroidVersion itemClicked) {
                Intent intentDetail = new Intent(MainActivity.this, DetailActivity.class);
                intentDetail.putExtra(BBDConstants.Extras.EXTRA_MODEL, itemClicked);
                startActivity(intentDetail);
            }
        });

        mRVItems.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void generateDummyModels() {
        mDataset.clear();
        ModelAndroidVersion applePie = new ModelAndroidVersion("Apple Pie", "1", "1.0", "http://stelapps.com/android/wp-content/uploads/2014/02/android_1.0.png");
        ModelAndroidVersion bananaBread = new ModelAndroidVersion("Banana Bread", "2", "1.1", "http://www.mforum.ru/cmsbin/2014/50/andr-evol/08_full481x316.png");
        ModelAndroidVersion cupcake = new ModelAndroidVersion("Cupcake", "3", "1.5", "http://theinspirationroom.com/daily/design/2013/9/android-cupcake-logo.jpg");
        ModelAndroidVersion donut = new ModelAndroidVersion("Donut", "4", "1.6", "http://vignette2.wikia.nocookie.net/logopedia/images/c/c5/Android-1_6-donut.jpg/revision/latest?cb=20130520200422");
        ModelAndroidVersion eclair = new ModelAndroidVersion("Eclair", "5-7", "2.0-2.1", "http://2.bp.blogspot.com/-cMcJ2AiNVRE/UHhLJwjrwrI/AAAAAAAAABM/OiYfqKKK3LQ/s1600/2.0.png");
        ModelAndroidVersion froyo = new ModelAndroidVersion("Froyo", "8", "2.2-2.2.3", "http://i.computer-bild.de/imgs/2/9/9/1/4/6/4/Google-Android-2-2-Froyo-745x559-07d94a9101917cec.jpg");
        ModelAndroidVersion gingerbread = new ModelAndroidVersion("Gingerbread", "9-10", "2.3-2.3.7", "https://www.justin.my/wp-content/uploads/2011/08/Android-Gingerbread-Logo.jpg");
        ModelAndroidVersion honeycomb = new ModelAndroidVersion("Honeycomb", "11-13", "3.0-3.2.6", "http://www.androidhoy.com/wp-content/uploads/Android-Honeycomb-Logo.jpg");
        ModelAndroidVersion iceCreamSandwich = new ModelAndroidVersion("Ice Cream Sandwich", "14-15", "4.0-4.0.4", "http://i.huffpost.com/gen/275928/GOOGLE-ICE-CREAM-SANDWICH-LOGO-GOOGLE-IO.jpg");
        ModelAndroidVersion jellyBean = new ModelAndroidVersion("JellyBean", "16-18", "4.1-4.3.1", "http://vignette2.wikia.nocookie.net/logopedia/images/c/c3/Android-Jelly-Bean-Logo.jpg/revision/latest?cb=20150606125310");
        ModelAndroidVersion kitkat = new ModelAndroidVersion("Kitkat", "19-20", "4.4", "http://www.elandroidelibre.com/wp-content/uploads/2013/10/android-kitkat-660x413.jpg");
        ModelAndroidVersion lollipop = new ModelAndroidVersion("Lollipop", "21-22", "5.0-5.1.1", "http://media2.giga.de/2014/10/android-5-0-lollipop-logo-new.jpg");
        ModelAndroidVersion marshmallow = new ModelAndroidVersion("Marshmallow", "23", "6.0-6.0.1", "http://contenidos.enter.co/custom/uploads/2015/08/Android-6.0-Marshmallow.jpg");
        ModelAndroidVersion nougat = new ModelAndroidVersion("Nougat", "24", "7.0", "http://cdn02.androidauthority.net/wp-content/uploads/2016/06/Android-Nougat-logo.jpg");
        mDataset.add(applePie);
        mDataset.add(bananaBread);
        mDataset.add(cupcake);
        mDataset.add(donut);
        mDataset.add(eclair);
        mDataset.add(froyo);
        mDataset.add(gingerbread);
        mDataset.add(iceCreamSandwich);
        mDataset.add(jellyBean);
        mDataset.add(kitkat);
        mDataset.add(lollipop);
        mDataset.add(honeycomb);
        mDataset.add(marshmallow);
        mDataset.add(nougat);
    }
}
