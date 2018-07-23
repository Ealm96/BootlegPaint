package com.Andrew;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Frame extends JFrame {

	private AddingText drawingPanel1;
	private JMenuItem[] items;
	private JMenuItem[] items1;
	private JMenu menu = new JMenu("Shapes");
	private JMenu menu1 = new JMenu("Sizes");
	private JMenu menu2 = new JMenu("Color");

	public GUI_Frame() {

		setSize(500, 500);
		setTitle("BootlegPaint");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);

		ShapeSelectionPanel shapeSelectionPanel = new ShapeSelectionPanel();
		SizeSelectionPanel sizeSelectionPanel = new SizeSelectionPanel();
		ColorChooserPanel colorChooserJP = new ColorChooserPanel();

		JMenuBar mBar = new JMenuBar();
		mBar.add(menu);
		mBar.add(menu1);
		mBar.add(menu2);
		setJMenuBar(mBar);

		JPanel mainJP = new JPanel();
		mainJP.setLayout(new BorderLayout());
		drawingPanel1 = new AddingText();

		mainJP.add(drawingPanel1, BorderLayout.CENTER);
		add(mainJP);
	}

	private class ShapeSelectionPanel implements ActionListener {
		private final int NUM_SHAPES = BootlegPaint.shapeNames.length;

		public ShapeSelectionPanel() {
			items = new JMenuItem[NUM_SHAPES];

			for (int i = 0; i < items.length; i++) {

				items[i] = new JMenuItem(BootlegPaint.shapeNames[i]);
				items[i].setActionCommand(BootlegPaint.shapeNames[i]);
				items[i].addActionListener(this);
				menu.add(items[i]);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String actCmd = e.getActionCommand();
			drawingPanel1.setShape(actCmd);
		}
	}

	private class SizeSelectionPanel implements ActionListener {
		private final int NUM_SIZES = BootlegPaint.sizes.length;

		public SizeSelectionPanel() {

			items1 = new JMenuItem[NUM_SIZES];

			for (int i = 0; i < items1.length; i++) {

				items1[i] = new JMenuItem(BootlegPaint.sizes[i]);
				items1[i].setActionCommand(BootlegPaint.sizes[i]);
				items1[i].addActionListener(this);
				menu1.add(items1[i]);
			}

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String actCmd = e.getActionCommand();
			drawingPanel1.setSize(actCmd);
		}
	}

	private class ColorChooserPanel implements ActionListener {

		private JMenuItem item;
		private JColorChooser colChooser;

		public ColorChooserPanel() {

			colChooser = new JColorChooser();
			item = new JMenuItem("Choose a Color");
			item.addActionListener(this);
			menu2.add(item);

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Color chosenColor = colChooser.showDialog(null, "Choose Color", drawingPanel1.getColor());
			drawingPanel1.setColor(chosenColor);

		}
	}

}
