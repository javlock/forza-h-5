package wwi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class StartBUSell {
	/**
	 * продажа авто на момент 22.11.2021
	 *
	 * @author javlock
	 * @throws InterruptedException
	 * @throws AWTException
	 *
	 */
	public static void main(String[] args) throws InterruptedException, AWTException {
		final Robot robot = new Robot();
		int sec = 1000;
		int secpoly = 1000;

		Thread.sleep(10 * sec);
		do {

			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_D);

			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			for (int i = 0; i < 19; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
			}

			for (int i = 0; i < 7; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_D);
			}
			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			for (int i = 0; i < 4; i++) {
				Thread.sleep(secpoly);
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S);
			}
			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);

			Thread.sleep(secpoly);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);

		} while (true);
	}

}
