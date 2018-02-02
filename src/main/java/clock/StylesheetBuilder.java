/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package clock;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.style.Stylesheet;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;

/**
 *
 */
public class StylesheetBuilder {
	private StylesheetBuilder() {
		// Prevent instantiation.
	}

	public static void initialize() {
		Stylesheet stylesheet = StyleHelper.getStylesheet();

		setDefaultStyle(stylesheet);
	}

	private static void setDefaultStyle(Stylesheet stylesheet) {
		EditableStyle style = new EditableStyle();

		style.setBackgroundColor(Colors.BLACK);
		style.setForegroundColor(Colors.RED);
		style.setAlignment(GraphicsContext.VCENTER | GraphicsContext.HCENTER);

		stylesheet.setDefaultStyle(style);
	}
}
