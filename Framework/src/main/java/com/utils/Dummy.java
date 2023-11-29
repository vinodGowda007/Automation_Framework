package com.utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.testng.mustache.Model;

public class Dummy {

	public static BufferedImage captureScreenshot() throws AWTException, IOException {
		Robot robot = new Robot();
		Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage image = robot.createScreenCapture(screenSize);
		return image;
	}

	public static Model returnModel(BufferedImage image) {
		// TODO: Implement this method to return a Model object from the given image.
		return null;
	}

	public static void main(String[] args) throws AWTException, IOException {
		BufferedImage image = captureScreenshot();
		Model model = returnModel(image);

	}
}
