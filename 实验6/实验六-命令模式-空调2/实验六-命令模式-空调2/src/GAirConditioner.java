import java.awt.*;
import javax.swing.*;

import java.util.Timer;
import java.util.TimerTask;

public class GAirConditioner extends Canvas {
	JPanel panel = null;
	static final int DELAY = 50;
	int OPEN = 1, CLOSED = -1, state = 0;
	int w_inset, h_inset, leftEdge, rightEdge, top, bottom, thickness;
	int width, height;
	int x, y;

	public GAirConditioner(JPanel panel) {
		this.panel = panel;
		setSize(450, 130);

		w_inset = getWidth() / 10;
		h_inset = getHeight() / 10;
		width = getWidth() - 2 * w_inset;
		height = getHeight() - 2 * h_inset;

		thickness = height / 20;
		top = h_inset;
		bottom = height + h_inset - thickness;
		leftEdge = w_inset;
		rightEdge = width + w_inset;
		x = 0;
		y = 0;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		g2.setColor(Color.gray);

		g2.fill3DRect(leftEdge, top, width, thickness, true); // upper window edge
		g2.fill3DRect(leftEdge, bottom, width, thickness, true); // lower window edge
		g2.fill3DRect(leftEdge, top, thickness, height, true); // left window edge
		g2.fill3DRect(rightEdge, top, thickness, height, true); // right window edge

		if (state == OPEN) {
			g2.setColor(Color.pink);
			g2.fill3DRect(leftEdge + thickness, x + top + thickness, width - thickness, height - 2 * thickness - x,
					true);
			g2.setColor(Color.blue);
			g2.fill3DRect(leftEdge + thickness, top + thickness, width - thickness, x, true);
		}
		if (state == CLOSED) {
			g2.setColor(Color.pink);
			g2.fill3DRect(leftEdge + thickness, top + thickness, width - thickness, y, true);
		}
	}

	public void keepRunning() {
		TimerTask task = new TimerTask() {
			public void run() {
				if (state == OPEN && x <= height - 2 * thickness) {
					x++;
					repaint();
				} else if (state == CLOSED && y <= height - 2 * thickness) {
					y++;
					repaint();
				}
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 0, DELAY);
	}

	public void open() {
		state = OPEN;
		keepRunning();
		panel.add(this);
	}

	public void close() {
		state = CLOSED;
		keepRunning();
		panel.add(this);
	}
}