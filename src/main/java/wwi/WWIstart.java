package wwi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class WWIstart {
	static String spec = "--ok";

	public static void main(String[] args) {
		boolean ok = false;
		if (args.length == 0) {
			throw new IllegalArgumentException("Не введен аркумент " + spec);
		} else if (args.length > 1) {
			throw new IllegalArgumentException("введено больше 1 аргумента");
		} else if (args.length == 1) {
			if (args[0].equals(spec)) {
				ok = true;
			} else {
				throw new IllegalArgumentException("введено не " + spec);
			}
		}
		if (ok) {
			try {
				final Robot robot = new Robot();

				Thread loop = new Thread(() -> {
					do {
						robot.keyPress(KeyEvent.VK_W);
						// robot.keyRelease(KeyEvent.VK_W);
					} while (true);
				});

				Thread loopEnter = new Thread(() -> {
					do {
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						try {
							Thread.sleep(35000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} while (true);
				});
				Thread shutdownThread = new Thread(() -> {
					int h5 = 4 * 60 * 60 * 1000;
					try {
						Thread.sleep(h5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						Runtime.getRuntime().exec("shutdown.exe /s");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});

				loop.start();
				loopEnter.start();
				shutdownThread.start();

				loop.join();
				loopEnter.join();
			} catch (AWTException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
