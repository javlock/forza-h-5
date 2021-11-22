package wwi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PseRun {

	private static final String VK_A = "VK_A";
	private static final String KSTRING = "КЛАВИША";
	static int sec = 1000;

	private static String getValueAfter(String key, String cmdUC) {
		final String regex = "(" + key + "([0-9A-Za-z_]{1,})[\\ ]?)";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(cmdUC);

		while (matcher.find()) {
			return matcher.group(2);
		}
		return null;
	}

	public static void main(String[] args) throws IOException, AWTException, InterruptedException, NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		if (args.length == 0 || args.length > 1) {
			Logger.getGlobal().info("1 аргумент:файл");
			Runtime.getRuntime().exit(0);
		}
		File inFile = new File(args[0]);

		if (inFile.exists()) {
			// read
			List<String> lines = Files.readAllLines(inFile.toPath(), StandardCharsets.UTF_8);

			ArrayList<String> cmds = new ArrayList<>();
			ArrayList<KK> keys = new ArrayList<>();

			// add defaults + cmd
			for (String line : lines) {
				String lineTrim = line.trim();
				boolean empty = lineTrim.isEmpty();
				boolean comment = lineTrim.startsWith("#");
				if (!empty && !comment) {
					cmds.add(line);
				}
			}

			String kks = KK.DEFAULTSLEEP;
			int kkl = kks.length();

			// parse cmd
			for (String cmd : cmds) {
				String cmdUC = cmd.toUpperCase();

				if (cmdUC.trim().startsWith(kks)) {
					KK.DEFAULTSLEEPCount = Integer.parseInt(cmdUC.split("" + kks.charAt(kkl - 1))[1]);

					// DEBUG
					String dsString = Integer.toString(KK.DEFAULTSLEEPCount);
					Logger.getGlobal().info(dsString);
					continue;
				}

				KK kk = new KK();

				int count = 1;
				if (cmdUC.contains(KK.KKCOUNT)) {
					count = Integer.parseInt(getValueAfter(KK.KKCOUNT, cmdUC));
				}
				for (int i = 0; i < count; i++) {
					if (cmdUC.contains(KK.SLEEP)) {
						kk.sleepExist = true;
						kk.sleepPre = Integer.parseInt(getValueAfter(KK.SLEEP, cmdUC));
					} else {
						kk.sleepPre = KK.DEFAULTSLEEPCount;
					}
					if (cmdUC.contains(KK.KEYCMD)) {
						kk.keyExist = true;
						String val = getValueAfter(KK.KEYCMD, cmdUC);
						Field field = KeyEvent.class.getDeclaredField(val.trim());
						Class<?> t = field.getType();
						if (t == int.class) {
							kk.key = field.getInt(null);
						}
					}
					System.out.println("! " + kk);
					keys.add(kk);
				}
			}

			start(keys);
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append("#чтобы установить стандартное время задержки(перед всеми клавишами) ").append('\n');
			builder.append("#").append(KK.DEFAULTSLEEP).append(1500).append('\n');

			builder.append('\n');

			builder.append("#ФОРМАТ ДЛЯ КЛАВИШ:").append('\n');
			builder.append("#").append(KK.KEYCMD).append(KSTRING).append('\n');

			builder.append('\n');

			builder.append("#ФОРМАТ ДЛЯ КЛАВИШ с задержкой:").append('\n');
			builder.append("#").append(KK.SLEEP).append("ВРЕМЯ").append(" ").append(KK.KEYCMD).append(KSTRING)
					.append('\n');

			builder.append('\n');

			builder.append("#ДОСТУПНО УКАЗАНИЕ КОЛ-ВА:").append('\n');
			builder.append("#").append(KK.KEYCMD).append(KSTRING).append(" ").append(KK.KKCOUNT).append("кол-во")
					.append('\n');

			builder.append('\n');

			// КЛАВИШИ
			builder.append("#ДОСТУПНЫЕ КЛАВИШИ ниже").append('\n');
			ArrayList<String> ff = new ArrayList<>();
			Field[] fields = java.awt.event.KeyEvent.class.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				if (name.startsWith("VK_") && !name.contains("DEAD")) {
					ff.add(name);
				}
			}
			String[] fnames = new String[ff.size()];
			int index = 0;
			for (String f : ff) {
				fnames[index] = f;
				index++;
			}
			builder.append("#").append(Arrays.toString(fnames)).append('\n');
			// КЛАВИШИ

			builder.append('\n');

			builder.append("#Пример конфигурации ниже").append('\n');
			builder.append(KK.DEFAULTSLEEP).append(1000).append('\n');
			builder.append(KK.SLEEP).append(20000).append(" ").append(KK.KEYCMD).append(VK_A).append('\n');
			builder.append(KK.KEYCMD).append(VK_A).append('\n');
			builder.append(KK.KEYCMD).append(VK_A).append(" ").append(KK.KKCOUNT).append(19).append('\n');

			String msg = builder.toString();
			Logger.getGlobal().info(msg);

			if (!inFile.exists()) {
				Files.createFile(inFile.toPath());
			}
			Files.writeString(inFile.toPath(), msg, StandardOpenOption.TRUNCATE_EXISTING);
		}

	}

	private static void start(ArrayList<KK> keys) throws AWTException, InterruptedException {
		final Robot robot = new Robot();
		Thread.sleep(10 * sec);
		do {
			for (KK key : keys) {

				if (key.sleepExist) {
					Thread.sleep(key.sleepPre);
				} else {
					Thread.sleep(KK.DEFAULTSLEEPCount);
				}

				if (key.keyExist) {
					robot.keyPress(key.key);
					robot.keyRelease(key.key);
				}
			}
		} while (true);

	}

}
