package wwi;

public class KK {

	public static final String DEFAULTSLEEP = "DEFAULTSLEEP=";

	public static final String SLEEP = "SLEEP=";
	public static final String KEYCMD = "KEY=";

	public static final String KKCOUNT = "COUNT=";

	public static int DEFAULTSLEEPCount = 1000;

	boolean sleepExist;
	int sleepPre = 1000;

	boolean keyExist;
	int key;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("KK [sleepExist=");
		builder.append(sleepExist);
		builder.append(", sleepPre=");
		builder.append(sleepPre);
		builder.append(", keyExist=");
		builder.append(keyExist);
		builder.append(", key=");
		builder.append(key);
		builder.append("]");
		return builder.toString();
	}

}
