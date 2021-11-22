package wwi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * покупка авто и улучшения на момент 22.11.2021
 *
 * @author javlock
 *
 */
public class StartBU {

	public static void main(String[] args) throws InterruptedException, AWTException {
		final Robot robot = new Robot();
		int sec = 1000;
		int secpoly = sec + sec / 2;
		int sec8 = 8 * sec;
		int min = 60 * sec;

		Thread.sleep(10 * sec);
		do {
			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);

			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			for (int i = 0; i < 19; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
			}
			for (int i = 0; i < 5; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_D);
			}
			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(sec8);
			robot.keyPress(KeyEvent.VK_Y);
			robot.keyRelease(KeyEvent.VK_Y);

			for (int i = 0; i < 3; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			}
			Thread.sleep(min);

			for (int i = 0; i < 2; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
			}
			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);

			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			for (int i = 0; i < 2; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_D);
			}
			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);

			for (int i = 0; i < 2; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			}
			for (int i = 0; i < 2; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_D);

				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			}

			for (int i = 0; i < 2; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_W);

				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			}
			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);

			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_D);

			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			for (int i = 0; i < 2; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
			}
		} while (true);
	}

}
