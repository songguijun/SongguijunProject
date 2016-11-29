package com.example.dllo.project_a_section.Cata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.project_a_section.Cata.CateRaidersFragment;
import com.example.dllo.project_a_section.Cata.CateSingleProductFragment;
import com.example.dllo.project_a_section.Cata.TabCataAdapter;
import com.example.dllo.project_a_section.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class CategoryFragment extends Fragment {
    private TabLayout tabLayout ;
    private ViewPager viewPager;
    private ArrayList<Fragment>data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cata_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = (TabLayout) view.findViewById(R.id.cata_tb);
        viewPager = (ViewPager) view.findViewById(R.id.cata_vp);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        data = new ArrayList<>();
        data.add(new CateRaidersFragment());
        data.add(new CateSingleProductFragment());
        TabCataAdapter adapter = new TabCataAdapter(getChildFragmentManager(),data);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
