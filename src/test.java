
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

public class test {
	CompareFile compare = new CompareFile();

	@Test
	void testReadFile() throws IOException {
		String[] ex = { "1001", "1002", "1003" };
		List<String> expected = Arrays.asList(ex);
		List<String> actual;
		actual = compare.readFile("fileTestRead.txt");
		assertEquals(expected, actual);
	}

	@Test
	// File co ton tai
	void testIsExist1() {
		int expected = 1;
		int actual = compare.isExist("fileTestRead.txt");
		assertEquals(expected, actual);
	}

	@Test
	// File khong ton tai
	void testIsExist2() {
		int expected = 0;
		int actual = compare.isExist("TestRead.txt");
		assertEquals(expected, actual);
	}

	@Test
	void testCheckSize1() throws IOException {
		int expected = 3;
		int actual = compare.checkLine("fileTestRead.txt");
		assertEquals(expected, actual);
	}

	@Test
	void testCheckSize2() throws IOException {
		int expected = -1;
		int actual = compare.checkLine("fileTestRead2000.txt");
		assertEquals(expected, actual);
	}

	@Test
	void testCompareFiles() throws IOException {
		String[] ar1 = { "1", "2", "3", "4", "5" };
		String[] ar2 = { "6", "1", "7", "8", "3", "9", "5", "10" };
		List<String> arr1 = Arrays.asList(ar1);
		List<String> arr2 = Arrays.asList(ar2);
		compare.compareFiles("out2.txt", arr1, arr2);
		File actual = new File("out2.txt");
		File expected = new File("out.txt");
		assertEquals(true, FileUtils.contentEquals(actual, expected));
	}

}
