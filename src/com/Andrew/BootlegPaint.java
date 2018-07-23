package com.Andrew;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
//import javax.swing.JTextField;

public class BootlegPaint extends JPanel implements MouseListener, MouseMotionListener {

	public static final int EXTRA_SMALL = 10;
	public static final int SMALL = 25;
	public static final int MEDIUM = 50;
	public static final int LARGE = 75;
	public static final int EXTRA_LARGE = 100;
	public static final String EX_SMALL = "ex small";
	public static final String SMAL = "small";
	public static final String MED = "medium";
	public static final String LARG = "large";
	public static final String EX_LARGE = "ex large";
	public static final String NO_SHAPE = "none";
	public static final String CIRCLE = "circle";
	public static final String SQUARE = "square";
	public static final String TRIANGLE = "triangle";
	public static final String RECTANGLE = "rectangle";
	public static final String TEXT = "text";
	public static final String[] shapeNames = { NO_SHAPE, CIRCLE, SQUARE, TRIANGLE, RECTANGLE, TEXT };
	public static final String[] sizes = { EX_SMALL, SMAL, MED, LARG, EX_LARGE };

	private int xStart = 0, yStart = 0;
	protected int size;
	private Color color;
	protected String shape;

	public BootlegPaint() {
		setBackground(Color.WHITE);
		color = Color.BLACK;
		size = SMALL;
		shape = NO_SHAPE;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	private void drawShape(int x, int y) {

		int[] xPoints = { x - size, x, x + size };
		int[] yPoints = { y + size, (y - size) - 10, y + size };
		Graphics2D g = (Graphics2D) getGraphics();
		g.setColor(color);
		switch (shape) {
		case CIRCLE:
			g.drawOval(x - size / 2, y - size / 2, size, size);
			break;
		case SQUARE:
			g.drawRect(x - size / 2, y - size / 2, size, size);
			break;
		case TRIANGLE:
			g.drawPolygon(xPoints, yPoints, 3);
			break;
		case RECTANGLE:
			g.drawRect(x - ((size / 2) * 2), y - size / 2, size * 2, size);
			break;
		default:
			shape = NO_SHAPE;
			size = SMALL;
			g.setStroke(new BasicStroke(size / 8));
			g.drawLine(x, y, x, y);
		}
		g.dispose();
	}

	protected void record(int x, int y) {
		xStart = x;
		yStart = y;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		drawShape(x, y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		record(e.getX(), e.getY()); // store the x,y
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// int xEnd = e.getX();
		// int yEnd = e.getY();
		// Graphics g = getGraphics();
		// g.setColor(color);
		// g.drawLine(xStart, yStart, xEnd, yEnd);
		// g.dispose();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		requestFocus();
		record(e.getX(), e.getY());
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int xEnd = e.getX();
		int yEnd = e.getY();

		Graphics2D g = (Graphics2D) getGraphics();
		g.setStroke(new BasicStroke(size / 14));
		g.setColor(color);
		g.drawLine(xStart, yStart, xEnd, yEnd);
		g.dispose();
		record(xEnd, yEnd); // store the x,y
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	public Color getColor() {
		return color;
	}

	protected void setColor(Color c) {
		color = c;
	}

	protected int getDrawingSize() {
		return size;
	}

	protected void setSize(String theSize) {

		if (theSize.equalsIgnoreCase(EX_SMALL)) {
			size = EXTRA_SMALL;
		} else if (theSize.equalsIgnoreCase(SMAL)) {
			size = SMALL;
		} else if (theSize.equalsIgnoreCase(MED)) {
			size = MEDIUM;
		} else if (theSize.equalsIgnoreCase(LARG)) {
			size = LARGE;
		} else if (theSize.equalsIgnoreCase(EX_LARGE)) {
			size = EXTRA_LARGE;
		} else {
			size = SMALL;
			System.out.println("invalid size was entered " + theSize);
		}
	}

	protected void setShape(String theShape) {
		if (theShape.equalsIgnoreCase(CIRCLE)) {
			shape = CIRCLE;
		} else if (theShape.equalsIgnoreCase(SQUARE)) {
			shape = SQUARE;
		} else if (theShape.equalsIgnoreCase(TRIANGLE)) {
			shape = TRIANGLE;
		} else if (theShape.equalsIgnoreCase(RECTANGLE)) {
			shape = RECTANGLE;
		} else if (theShape.equalsIgnoreCase(TEXT)) {
			shape = TEXT;
		} else {

			shape = NO_SHAPE;
			System.out.println("invalid shape was entered " + theShape);
		}
	}

	public int getLatestX() {
		return xStart;
	}

	public int getLatestY() {
		return yStart;
	}

}
