package com.touchmenotapps.radialdemo;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.touchmenotapps.widget.radialmenu.menu.v1.RadialMenuItem;
import com.touchmenotapps.widget.radialmenu.menu.v1.RadialMenuWidget;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rikimarutsui on 3/26/15.
 */
public class ChestMenuActivity extends FragmentActivity {
    private RadialMenuWidget pieMenu;

    private FrameLayout mFragmentContainer;
    public RadialMenuItem v1MenuItem, v1MenuCloseItem, v1MenuExpandItem;

    public List<RadialMenuItem> v1Children;

    @SuppressWarnings("serial")
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        mFragmentContainer = (FrameLayout) findViewById(R.id.alt_fragment_container_chest);

        pieMenu = new RadialMenuWidget(this);

        v1MenuCloseItem = new RadialMenuItem(getString(R.string.close), null);
        v1MenuCloseItem.setDisplayIcon(android.R.drawable.ic_menu_close_clear_cancel);

        v1MenuItem = new RadialMenuItem(getString(R.string.normal), getString(R.string.normal));
        v1MenuItem.setOnMenuItemPressed(new RadialMenuItem.RadialMenuItemClickListener() {
            @Override
            public void execute() {
                pieMenu.dismiss();
            }
        });
        v1Children = new ArrayList<RadialMenuItem>();

        v1Children.add(new RadialMenuItem(getString(R.string.main_menu), getString(R.string.main_menu)));
        v1Children.get(0).setOnMenuItemPressed(new RadialMenuItem.RadialMenuItemClickListener() {
            @Override
            public void execute() {
                // Can edit based on preference. Also can add animations
                // here.
                getSupportFragmentManager().popBackStack(null,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(mFragmentContainer.getId(),
                                new RadialMenuMainFragment()).commit();
                pieMenu.dismiss();
            }
        });

        v1Children.add(new RadialMenuItem(getString(R.string.contact),
                getString(R.string.contact)));
        v1Children.get(1).setOnMenuItemPressed(new RadialMenuItem.RadialMenuItemClickListener() {
            @Override
            public void execute() {
                // Can edit based on preference. Also can add animations
                // here.
                getSupportFragmentManager().popBackStack(null,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(mFragmentContainer.getId(),
                                new RadialMenuContactFragment())
                        .commit();
                pieMenu.dismiss();
            }
        });

        v1Children.add(new RadialMenuItem(getString(R.string.about),
                getString(R.string.about)));
        v1Children.get(2).setOnMenuItemPressed(new RadialMenuItem.RadialMenuItemClickListener() {
            @Override
            public void execute() {
                // Can edit based on preference. Also can add animations
                // here.
                getSupportFragmentManager().popBackStack(null,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(mFragmentContainer.getId(),
                                new RadialMenuAboutFragment()).commit();
                pieMenu.dismiss();
            }
        });

        v1MenuExpandItem = new RadialMenuItem(getString(R.string.expandable),
                getString(R.string.expandable));
        v1MenuExpandItem.setMenuChildren(v1Children);

        v1MenuCloseItem.setOnMenuItemPressed(new RadialMenuItem.RadialMenuItemClickListener() {
            @Override
            public void execute() {
                // menuLayout.removeAllViews();
                pieMenu.dismiss();
            }
        });

        pieMenu.setAnimationSpeed(0L);
        pieMenu.setSourceLocation(200, 200);
        pieMenu.setIconSize(15, 30);
        pieMenu.setTextSize(13);
        pieMenu.setOutlineColor(Color.BLACK, 225);
        pieMenu.setInnerRingColor(0xAA66CC, 180);
        pieMenu.setOuterRingColor(0x0099CC, 180);
        //pieMenu.setHeader("Test Menu", 20);
        pieMenu.setCenterCircle(v1MenuCloseItem);

        pieMenu.addMenuEntry(new ArrayList<RadialMenuItem>() {
            {
                add(v1MenuExpandItem);
                add(v1MenuItem);
            }
        });

        Button testButton = (Button) this.findViewById(R.id.chest_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pieMenu.show(v);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Init with home fragment
        getSupportFragmentManager().popBackStack(null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(mFragmentContainer.getId(),
                        new RadialMenuMainFragment()).commit();

		/*findViewById(R.id.alt_fragment_container).post(new Runnable() {
			public void run() {
				pieMenu.show(findViewById(R.id.alt_fragment_container));
			}
		});*/
    }

}
