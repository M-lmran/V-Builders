package v_builders;
import javax.swing.*;
import java.awt.*;


class CircularProgressPanel extends JPanel{
/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private int progress = 0;
	
	public CircularProgressPanel() {
	    setPreferredSize(new Dimension(150, 150)); // Set preferred size for layout purposes
	}
	
	public int getProgress() {
	    return progress;
	}
	
	public void setProgress(int progress) {
	    this.progress = progress;
	    repaint(); // Repaint the panel to reflect the updated progress
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	
	    // Enable smooth rendering
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	    // Draw the background circle
	    g2d.setColor(Color.black);
	    g2d.fillOval(25, 25, 100, 100); // Draw a gray circle
	
	    // Draw the progress arc
	    g2d.setColor(new Color(255, 255, 134));
	    g2d.fillArc(25, 25, 100, 100, 90, - (int) (360 * (progress / 100.0))); // Progress arc
	
	    // Draw the progress text in the center
	    g2d.setColor(Color.black);
	    g2d.setFont(new Font("Arial", Font.BOLD, 14));
	    String progressText = progress + "%";
	    FontMetrics fm = g2d.getFontMetrics();
	    int textX = getWidth() / 2 - fm.stringWidth(progressText) / 2;
	    int textY = getHeight() / 2 + fm.getAscent() / 2 - 10;
	    g2d.drawString(progressText, textX, textY);
}
}


