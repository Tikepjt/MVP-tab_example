package com.kottodat.tdytfyt.tabscene;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kottodat.tdytfyt.R;
import com.kottodat.tdytfyt.databinding.FragmentFriendsBinding;

/**
 * Created by hanago on 2018. 8. 9..
 */

public class FriendsFragment extends Fragment
{
    FragmentFriendsBinding mBinding;
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState )
    {
        mBinding = DataBindingUtil.inflate( inflater, R.layout.fragment_friends, container, true );

        return mBinding.getRoot();
    }
}
