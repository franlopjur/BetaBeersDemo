package com.franlopez.betabeersdemo.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.franlopez.betabeersdemo.ModelAndroidVersion;
import com.franlopez.betabeersdemo.R;
import com.franlopez.betabeersdemo.common.BBDConstants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class DetailActivity extends AppCompatActivity {

    private TextView mTVName, mTVVersionCode, mTVAPIVersion;
    private ImageView mIVImage;
    private LinearLayout mLLVibrant, mLLVibrantLight, mLLVibrantDark, mLLMuted, mLLMutedLight, mLLMutedDark;
    private Toolbar mToolbar;

    private ModelAndroidVersion mCurrentModelAndroidVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getViews();
        readArguments();
        init();
    }

    private void readArguments() {

        if (getIntent() == null || getIntent().getExtras() == null)
            return;

        mCurrentModelAndroidVersion = (ModelAndroidVersion) getIntent().getExtras().getSerializable(BBDConstants.Extras.EXTRA_MODEL);
    }

    private void getViews() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mTVName = (TextView) findViewById(R.id.activity_detail__name);
        mTVVersionCode = (TextView) findViewById(R.id.activity_detail__version_code);
        mTVAPIVersion = (TextView) findViewById(R.id.activity_detail__api_version);
        mIVImage = (ImageView) findViewById(R.id.activity_detail__image);

        mLLVibrant = (LinearLayout) findViewById(R.id.activity_detail__vibrant);
        mLLVibrantLight = (LinearLayout) findViewById(R.id.activity_detail__vibrant_light);
        mLLVibrantDark = (LinearLayout) findViewById(R.id.activity_detail__vibrant_dark);
        mLLMuted = (LinearLayout) findViewById(R.id.activity_detail__muted);
        mLLMutedLight = (LinearLayout) findViewById(R.id.activity_detail__muted_light);
        mLLMutedDark = (LinearLayout) findViewById(R.id.activity_detail__muted_dark);
    }

    private void init() {

        setSupportActionBar(mToolbar);

        //- Es necesario para que aparezca la flecha de retroceder
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setUpViewsByModel();
    }

    private void setUpViewsByModel() {
        if (mCurrentModelAndroidVersion == null)
            return;

        mTVName.setText(mCurrentModelAndroidVersion.getName());
        mTVVersionCode.setText(mCurrentModelAndroidVersion.getVersionCode());
        mTVAPIVersion.setText(mCurrentModelAndroidVersion.getAPIVersion());

        Picasso.with(this).load(mCurrentModelAndroidVersion.getUrl()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                mIVImage.setImageBitmap(bitmap);
                Palette palette = Palette.from(bitmap).generate();
                int defaultColor = 0x000000;
                mLLVibrant.setBackgroundColor(palette.getVibrantColor(defaultColor));
                mLLVibrantDark.setBackgroundColor(palette.getDarkVibrantColor(defaultColor));
                mLLVibrantLight.setBackgroundColor(palette.getLightVibrantColor(defaultColor));
                mLLMuted.setBackgroundColor(palette.getMutedColor(defaultColor));
                mLLMutedDark.setBackgroundColor(palette.getDarkMutedColor(defaultColor));
                mLLMutedLight.setBackgroundColor(palette.getLightMutedColor(defaultColor));
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
