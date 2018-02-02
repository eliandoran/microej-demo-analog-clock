/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package clock;

import java.util.Calendar;
import java.util.Date;

import ej.bon.Timer;
import ej.bon.TimerTask;
import ej.widget.basic.Label;
import ej.widget.container.SimpleDock;

/**
 *
 */
public class MainPage extends SimpleDock {
	private final ClockWidget clock;
	private final Label clockLabel;

	public MainPage() {
		this.setHorizontal(false);

		this.clockLabel = new Label("");
		this.clock = new ClockWidget();
		this.clock.setTime(12, 30, 12);

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				System.out.println("Run");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date(System.currentTimeMillis()));

				MainPage.this.clock.setTime(calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE),
						calendar.get(Calendar.SECOND));

				MainPage.this.clockLabel.setText(calendar.getTime().toString());
			}
		}, 0, 500);

		this.setFirst(this.clockLabel);
		this.setCenter(this.clock);
	}
}
