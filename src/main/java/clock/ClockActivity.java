/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package clock;

import ej.microui.MicroUI;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.wadapps.app.Activity;

/**
 *
 */
public class ClockActivity implements Activity {
	@Override
	public String getID() {
		return "Clock";
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		MicroUI.start();

		Desktop desktop = new Desktop();

		Panel panel = new Panel();
		panel.setWidget(new MainPage());
		panel.showFullScreen(desktop);

		desktop.show();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

	}

}
