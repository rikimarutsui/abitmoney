package com.filter;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.filter.custom.CustomActivity;

/**
 * The Activity MainActivity is the Main screen of the app. It simply shows a
 * dummy image with some filter options. You need to write actual code image
 * processing and filtering.
 * 
 */
public class MainActivity extends CustomActivity
{

	/** The selected filter icon. */
	private View selected;

	/** The actual imageview. */
	private ImageView img;

	/* (non-Javadoc)
	 * @see com.newsfeeder.custom.CustomActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setTouchNClick(R.id.cross);
		setTouchNClick(R.id.check);
		selected = setTouchNClick(R.id.eff1);
		setTouchNClick(R.id.eff2);
		setTouchNClick(R.id.eff3);
		setTouchNClick(R.id.eff4);

		img = (ImageView) setTouchNClick(R.id.img);
		setupActionBar();
	}

	/**
	 * This method will setup the top title bar (Action bar) content and display
	 * values. It will also setup the custom background theme for ActionBar. You
	 * can override this method to change the behavior of ActionBar for
	 * particular Activity
	 */
	protected void setupActionBar()
	{
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayUseLogoEnabled(true);
		actionBar.setLogo(R.drawable.icon);
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setHomeButtonEnabled(false);
	}

	/* (non-Javadoc)
	 * @see com.activity.custom.CustomActivity#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v)
	{
		super.onClick(v);
		if (v.getId() == R.id.eff1 || v.getId() == R.id.eff2
				|| v.getId() == R.id.eff3 || v.getId() == R.id.eff4)
		{
			selected.setBackgroundResource(0);
			selected = v;
			selected.setBackgroundColor(getResources().getColor(
					R.color.main_pink));

			if (v.getId() == R.id.eff1)
				img.setImageResource(R.drawable.img1);
			else if (v.getId() == R.id.eff2)
				img.setImageResource(R.drawable.img2);
			else if (v.getId() == R.id.eff3)
				img.setImageResource(R.drawable.img3);
			else if (v.getId() == R.id.eff4)
				img.setImageResource(R.drawable.img4);
		}
		else if (v.getId() == R.id.check || v == img)
		{
			startActivity(new Intent(this, Edit.class));
		}
	}

}
