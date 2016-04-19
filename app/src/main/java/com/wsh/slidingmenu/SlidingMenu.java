package com.wsh.slidingmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class SlidingMenu extends AppCompatActivity {

    private List<String> MenuList = Arrays.asList("LeftMenu1", "LeftMenu2", "LeftMenu3", "LeftMenu4");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View menu_layout=LayoutInflater.from(this).inflate(R.layout.menu_layout, null);
        ListView listView= (ListView) menu_layout.findViewById(R.id.id_lv);
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,MenuList);
        listView.setAdapter(arrayAdapter);

        // configure the SlidingMenu
        com.jeremyfeinstein.slidingmenu.lib.SlidingMenu menu = new com.jeremyfeinstein.slidingmenu.lib.SlidingMenu(this);
        //set the location of the slidingmenu such as LEFT, RIGHT or LEFT_RIGHT
        menu.setMode(com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.LEFT_RIGHT);
        // set the mode of touching the screen
        menu.setTouchModeAbove(com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.TOUCHMODE_FULLSCREEN);
        //set the width of the shadow
        menu.setShadowWidthRes(R.dimen.shadow_width);
        //set the effect of the shadow
        menu.setShadowDrawable(R.drawable.shadow);
        // set the width of the visible menu
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // set the value of the fade of coming and going
        menu.setFadeDegree(0.35f);
        menu.setBehindScrollScale(1.0f);

        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        //menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.attachToActivity(this, com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.SLIDING_WINDOW);
        //set the layout of the slidingmenu
        menu.setMenu(menu_layout);
        menu.setSecondaryMenu(R.layout.right_menu_layout);
        //menu.setSecondaryShadowDrawable(R.drawable.shadow);
    }



}
