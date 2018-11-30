
import java.io.*;
import java.util.*;

public class CompareFile {

	public static final int FILE_SIZE_ERROR = -1;
	public static String NEWLINE = System.getProperty("line.separator");

	public List<String> readFile(String fileName) {
		List<String> arr = new ArrayList<String>();
		String in = null;

		try {
			FileReader file = new FileReader(fileName);
			BufferedReader br = new BufferedReader(file);

			while ((in = br.readLine()) != null) {
				arr.add(in);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	public int isExist(String fileName) {
		File file = new File(fileName);
		int exist = 1;
		// Neu file ko ton tai, hoac file la folder
		if (!file.exists() || !file.isFile()) {
			System.out.println("File " + fileName + " khong ton tai!");
			exist = 0;
		}
		return exist;
	}

	public int checkLine(String fileName) throws IOException {
		int numberLines = 0;
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		while (br.readLine() != null) {
			numberLines++;
		}

		if (numberLines > 2000) {
			br.close();
			return FILE_SIZE_ERROR;
		}
		br.close();
		return numberLines;
	}

	public void compareFiles(String fileOut, List<String> arr1, List<String> arr2) throws IOException {
		FileWriter result = new FileWriter(fileOut);
		for (int i = 0; i < arr2.size(); i++) {
			if (!arr1.contains(arr2.get(i))) {
				result.append(arr2.get(i));
				result.append(NEWLINE);
			}
		}
		result.close();
	}

}
