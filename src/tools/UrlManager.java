package tools;

public class UrlManager {
	public static String getUrl(String section) {
		String fileName = "C:\\Users\\mchvz\\Documents\\Work\\Hexaware\\Training\\Selenium\\Framework_ex\\data\\urls.xlsx";
		String[] urls = ReadData.readData(fileName,section);
		String url = urls[0];
		return url;
	}
}
