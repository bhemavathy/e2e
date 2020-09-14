package com.employee.e2e.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReportGenerationUtils {

	public void createFile(String message) {
		try {

			String fileName = "testNg-report.html";
			File filename = new File(fileName);
			filename.createNewFile();

			WriteUtil write = new WriteUtil();
			write.writeHeader(filename, message);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ReportGenerationUtils reportGen = new ReportGenerationUtils();
		// reportGen.createFile();
	}

}
