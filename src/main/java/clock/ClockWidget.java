/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package clock;

import ej.microui.display.GraphicsContext;
import ej.style.Style;
import ej.style.container.Rectangle;
import ej.widget.StyledWidget;

/**
 *
 */
public class ClockWidget extends StyledWidget {
	private int hours = 0;
	private int minutes = 0;
	private int seconds = 0;

	public ClockWidget() {
	}

	@Override
	public void renderContent(GraphicsContext g, Style style, Rectangle bounds) {
		g.setColor(style.getBackgroundColor());
		g.fillRect(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());

		int minDimension = Math.min(bounds.getWidth(), bounds.getHeight());
		int diameter = (int) Math.round(minDimension / 1.25);

		g.setColor(style.getForegroundColor());
		g.drawCircle((bounds.getWidth() - diameter) / 2, (bounds.getHeight() - diameter) / 2, diameter);

		double hourAngle = 0.5 * (60 * this.hours + this.minutes);
		double minutesAngle = 6 * this.minutes;
		double secondsAngle = 6 * this.seconds;

		drawHand(g, bounds, (int) Math.round(diameter * 0.2), Math.toRadians(hourAngle));
		drawHand(g, bounds, (int) Math.round(diameter * 0.3), Math.toRadians(minutesAngle));
		drawHand(g, bounds, (int) Math.round(diameter * 0.4), Math.toRadians(secondsAngle));
	}

	private void drawHand(GraphicsContext g, Rectangle bounds, int width, double angle) {
		int x1 = bounds.getWidth() / 2;
		int y1 = bounds.getHeight() / 2;
		int x2 = x1;
		int y2 = y1 - width;
		double newX = ((x2 - x1) * Math.cos(angle) - (y2 - y1) * Math.sin(angle)) + x1;
		double newY = ((x2 - x1) * Math.sin(angle) + (y2 - y1) * Math.cos(angle)) + y1;

		g.drawLine(x1, y1, (int) Math.round(newX), (int) Math.round(newY));
	}

	public void setTime(int h, int m, int s) {
		if (h > 13) {
			h -= 12;
		} else if (h == 12) {
			h = 0;
		}

		if (this.hours != h || this.minutes != m || this.seconds != s) {
			this.repaint();
		}

		this.hours = h;
		this.minutes = m;
		this.seconds = s;
	}

	@Override
	public Rectangle validateContent(Style style, Rectangle bounds) {
		Rectangle rect = new Rectangle();
		rect.setSize(320, 200);
		return rect;
	}
}
