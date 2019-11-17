import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static int width = 1440;
	public static int height = 720;
	public static int ratioWidth = width / height;

	public static double power = 2;
	public static double powerIncrease = 2;
	public static double increasing = 0.001;

	public static int maxIteration = 100;
	public static int breakPoint = 16;

	public static Point2D center = new Point2D.Double(-0.5, 0);
	public static double size = 1.25;

	public static BufferedImage multibrot = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	public static void main(String[] args) {
		for (int frame = 0; frame < powerIncrease / increasing; frame++) {
			int f = frame + 1;
			System.out.print(
					"Frame: " + f + " / " + (powerIncrease / increasing) + " with power of " + power + " started!");
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					double a = map(i, 0, width, center.getX() - size * ratioWidth, center.getX() + size * ratioWidth);
					double b = map(j, 0, height, center.getY() - size, center.getY() + size);
					double ca = a;
					double cb = b;

					int n = 0;
					while (n <= maxIteration) {
						double na = Math.pow(Math.sqrt(a * a + b * b), power) * Math.cos(power * Math.atan2(b, a));
						double nb = Math.pow(Math.sqrt(a * a + b * b), power) * Math.sin(power * Math.atan2(b, a));
						if (Math.sqrt(a * a + b * b) > breakPoint)
							break;
						a = na + ca;
						b = nb + cb;

						n++;
					}

					int color;
					if (n == maxIteration) {
						color = Color.BLACK.getRGB();
					} else {
						color = (int) map(n, 0, maxIteration, 0, 255);
					}
					multibrot.setRGB(i, j, color);
				}
			}
			File outputfile = new File(".\\timelapse\\multibrot_" + frame + ".png");
			try {
				ImageIO.write(multibrot, "png", outputfile);
				System.out.println(" -- Done!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			power += increasing;
		}
	}

	public static double map(double value, double istart, double istop, double ostart, double ostop) {
		return ostart + (ostop - ostart) * ((value - istart) / (istop - istart));
	}

	public static double constrain(double value, double low, double high) {
		return Math.max(Math.min(value, high), low);
	}

}
