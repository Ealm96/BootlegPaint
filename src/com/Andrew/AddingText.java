package com.Andrew;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JEditorPane;

public class AddingText extends BootlegPaint implements KeyListener {

	private Font font;
	private FontMetrics fm;
	private int fontSize;
	private static final String FONT_NAME = "Monospaced";
	public static final int FONT_STYLE = Font.ROMAN_BASELINE;

	public AddingText() {

		super();
		// font = new Font(FONT_NAME, FONT_STYLE, fontSize);
		// fm = getFontMetrics(font);
		addKeyListener(this);

	}

	@Override
	public void keyTyped(KeyEvent e) {

		String s = String.valueOf(e.getKeyChar());
		Graphics2D g = (Graphics2D) getGraphics();
		font = new Font(FONT_NAME, FONT_STYLE, super.getDrawingSize());
		fm = getFontMetrics(font);
		g.setFont(font);
		g.getFontMetrics(font);
		g.setColor(getColor());
		if (shape.equalsIgnoreCase(super.TEXT)) {
			g.drawString(s, getLatestX() + fm.stringWidth(s), getLatestY());
			record(getLatestX() + fm.stringWidth(s), getLatestY());
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
