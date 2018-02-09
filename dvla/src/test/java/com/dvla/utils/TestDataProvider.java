package com.dvla.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestDataProvider {

	public static LinkedHashMap<String, String> testdata = new LinkedHashMap<String, String>();

	// Part 1 - Exercise 1,2,3
	public static void scanDirectory(String folderpath) {
		try {
			File folder = new File(folderpath);
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					String MimeType = Files.probeContentType(listOfFiles[i].toPath());
					System.out.println("File Name: " + listOfFiles[i].getName() + " and File Extension:"
							+ getFileExtension(listOfFiles[i]) + " and File Size: " + listOfFiles[i].length()
							+ " and File MIME type:  " + MimeType);
					if (MimeType.contentEquals("text/csv") || MimeType.contentEquals("application/vnd.ms-excel")) {
						System.out.println("File Name:" + listOfFiles[i].getName() + " is supported Mime file type");
					} else {
						System.out
								.println("File Name:" + listOfFiles[i].getName() + " is not supported Mime file type");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String[][] readExcel(String filePath, String testCaseId) { // this
																				// will
																				// return
																				// LinkedList<String,String>

		try {
			testdata.clear();
			File inputWorkbook = new File(filePath);
			Workbook w;
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(0);
			String[][] data = new String[sheet.getRows()][sheet.getColumns()];

			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					data[i][j] = cell.getContents();

				}
			}
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void getTestData(String testCaseId) { 

		try {
			String filePath = "./testdata/TestInput.xls";
			testdata.clear();
			File inputWorkbook = new File(filePath);
			Sheet sheet = Workbook.getWorkbook(inputWorkbook).getSheet("Main");
			for (int row = 0; row < sheet.getRows(); row++) {
				Cell[] rowdata = sheet.getRow(row);
				if (rowdata[row].getContents().equalsIgnoreCase(testCaseId)) {
					for (int coldata = 0; coldata < sheet.getColumns(); coldata++) {
						testdata.put(sheet.getCell(coldata, 0).getContents(), sheet.getCell(coldata, row).getContents());
					}
				}
				if (testdata.size()>0) break; //Exiting Row loop if the data is loaded
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public static void main(String[] args) throws IOException {
		// String[][] data = readExcel ("C://DVLA//", "testdata.xls");
		getTestData("Vehicle_01"); // Get Excel from PropertyFiles
		System.out.println(testdata);
		// System.out.println(data[0][1]);
		// System.out.println(data[0][2]);
		// System.out.println(data[0][3]);

	}

}
