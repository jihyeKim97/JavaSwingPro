package template.Application.controller;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	public static final String DEF_NAME = "no_name.png";
	public Image bgImg;
	public String imgFilename;
	public int width;
	public int height;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.bgImg != null) {
			g.drawImage(bgImg, 0, 0, this);
		}
	}

	public ImagePanel() {
	}

	public ImagePanel(Image bgImg) {
		this(bgImg, DEF_NAME);
	}

	public ImagePanel(Image bgImg, String imgFilename) {
		super();
		this.bgImg = bgImg;
		this.imgFilename = imgFilename;
		this.width = this.bgImg.getWidth(this); 
		this.height = this.bgImg.getHeight(this);
	}

	public ImagePanel(Image bgImg, String imgFilename, int width, int height) {
		super();
		this.bgImg = bgImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		this.imgFilename = imgFilename;
		this.width = width;
		this.height = height;
	}

	public Image getBgImg() {
		return bgImg;
	}

	public void setBgImg(Image bgImg) {
		this.bgImg = bgImg;
	}

	public String getImgFilename() {
		return imgFilename;
	}

	public void setImgFilename(String imgFilename) {
		this.imgFilename = imgFilename;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}