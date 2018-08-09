package com.kottodat.tdytfyt.tabscene;

import android.app.Fragment;
import android.app.FragmentManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kottodat.tdytfyt.R;
import com.kottodat.tdytfyt.databinding.ActivityTabTestBinding;

/**
 * Created by hanago on 2018. 8. 9..
 */

public class MyTabActivity extends AppCompatActivity
{

    ActivityTabTestBinding mBinding;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );

        mBinding = DataBindingUtil.setContentView( this, R.layout.activity_tab_test );


        mBinding.tabRequestLayout.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                mBinding.effectRequestView.setBackgroundColor( 0xffffffff );
                mBinding.effectFriendsView.setBackgroundColor( 0x00000000 );
                viewPager.setCurrentItem( 0 );
            }
        } );

        mBinding.tabFriendsLayout.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                mBinding.effectRequestView.setBackgroundColor( 0x00000000 );
                mBinding.effectFriendsView.setBackgroundColor( 0xffffffff );
                viewPager.setCurrentItem( 1 );
            }
        } );

        viewPager = (ViewPager) findViewById( R.id.friends_view_pager );
        adapter = new MyAdapter( getFragmentManager() );
        viewPager.setAdapter( new MyAdapter( getFragmentManager() ) );
        viewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled( int position, float positionOffset, int positionOffsetPixels )
            {
                if ( position == 0 )
                {
                    mBinding.effectRequestView.setBackgroundColor( 0xffffffff );
                    mBinding.effectFriendsView.setBackgroundColor( 0x00000000 );
                }
                else
                {
                    mBinding.effectRequestView.setBackgroundColor( 0x00000000 );
                    mBinding.effectFriendsView.setBackgroundColor( 0xffffffff );
                }
            }

            @Override
            public void onPageSelected( int position )
            {

            }

            @Override
            public void onPageScrollStateChanged( int state )
            {

            }
        } );

        setDefaultTab();
    }

    MyAdapter adapter;
    ViewPager viewPager;

    private void setDefaultTab()
    {
        viewPager.setCurrentItem( 0 );
        mBinding.effectRequestView.setBackgroundColor( 0xffffffff );
        mBinding.effectFriendsView.setBackgroundColor( 0x00000000 );
    }

    class MyAdapter extends FragmentPagerAdapter
    {


        public MyAdapter( FragmentManager fm )
        {
            super( fm );
        }

        @Override
        public Fragment getItem( int position )
        {
            Fragment fragment = null;
            switch ( position )
            {
                case 0:
                    fragment = new RequestFragment();
                    break;
                case 1:
                    fragment = new FriendsFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount()
        {
            return 2;
        }
    }


}
