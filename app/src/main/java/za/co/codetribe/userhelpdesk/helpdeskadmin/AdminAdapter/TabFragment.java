package za.co.codetribe.userhelpdesk.helpdeskadmin.AdminAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import za.co.codetribe.userhelpdesk.R;
import za.co.codetribe.userhelpdesk.helpdeskadmin.Admin_AssignmentTab;
import za.co.codetribe.userhelpdesk.helpdeskadmin.Admin_CallLogTab;
import za.co.codetribe.userhelpdesk.helpdeskadmin.Admin_ClientTab;
import za.co.codetribe.userhelpdesk.helpdeskadmin.Admin_TechnicianTab;
import za.co.codetribe.userhelpdesk.helpdeskadmin.Admin_UserTab;

/**
 * Created by Tshego Masilo on 6/1/2016.
 */
public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 5 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new Admin_AssignmentTab();
                case 1 : return new Admin_CallLogTab();
                case 2 : return new Admin_ClientTab();
                case 3 : return new Admin_TechnicianTab();
                case 4 : return new Admin_UserTab();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Assignment";
                case 1 :
                    return "Logged Calls";
                case 2 :
                    return "Clients";
                case 3 :
                    return "Technicians";
                case 4 :
                    return "Users";

            }
            return null;
        }
    }

}
