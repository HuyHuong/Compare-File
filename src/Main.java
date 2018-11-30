
import java.lang.Exception;
import java.util.*;

public class Main {
	public static List<String> arr1, arr2;

	public static void main(String[] args) throws Exception {
		CompareFile compare = new CompareFile();

		if (args == null || args.length != 2) {
			System.out.println("Can 2 text file!");
			System.exit(0);
		}

		if (compare.isExist(args[0]) == 0 || compare.isExist(args[1]) == 0) {
			System.exit(0);
		}

		for (int i = 0; i < args.length; i++) {
			if (compare.checkLine(args[i]) == -1) {
				System.out.println("File qua 2000 dong!");
				System.exit(0);
			}
		}
		arr1 = compare.readFile(args[0]);
		arr2 = compare.readFile(args[1]);

		compare.compareFiles("result.txt", arr1, arr2);
		System.out.println("Da xong chuong trinh!");
	}
}
