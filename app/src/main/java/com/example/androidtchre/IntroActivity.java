package com.example.androidtchre;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.androidtchre.fragmenty.FirstFragment;
import com.example.androidtchre.fragmenty.SecondFragment;
import com.example.androidtchre.fragmenty.ThreeFragment;

public class IntroActivity extends AppCompatActivity {
    private static final int TOTAL_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mPager = (ViewPager) findViewById(R.id.intro_pager);
        mPager.setPageTransformer(true, new DepthPageTransformer());
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        getSupportActionBar().hide();
        final ImageView introIndicator1 = (ImageView) findViewById(R.id.intro1);
        final ImageView introIndicator2 = (ImageView) findViewById(R.id.intro2);
        final ImageView introIndicator3 = (ImageView) findViewById(R.id.intro3);
        final TextView btnIntroSkip = (TextView) findViewById(R.id.intro_skip);
        btnIntroSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code to skip intro section
            }
        });
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    introIndicator1.setImageResource(R.drawable.intro_dot_selected);
                    introIndicator2.setImageResource(R.drawable.intro_dot_default);
                    introIndicator3.setImageResource(R.drawable.intro_dot_default);
                } else if (position == 1) {
                    introIndicator1.setImageResource(R.drawable.intro_dot_default);
                    introIndicator2.setImageResource(R.drawable.intro_dot_selected);
                    introIndicator3.setImageResource(R.drawable.intro_dot_default);
                } else if (position == 2) {
                    introIndicator1.setImageResource(R.drawable.intro_dot_default);
                    introIndicator2.setImageResource(R.drawable.intro_dot_default);
                    introIndicator3.setImageResource(R.drawable.intro_dot_selected);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class IntroPagerAdapter extends FragmentStatePagerAdapter {
        public IntroPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FirstFragment();
                case 1:
                    return new SecondFragment();
                case 2:
                    return new ThreeFragment();
                default:
                    break;
            }
            return null;
        }
        @Override
        public int getCount() {
            return TOTAL_PAGES;
        }
    }

    private class ScreenSlidePagerAdapter extends PagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager supportFragmentManager) {

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
    }

    private class DepthPageTransformer implements ViewPager.PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {

        }
    }
}

