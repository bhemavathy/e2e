package com.employee.e2e.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WriteUtil {
	
	public static void writeHeader(File filename ,String output ) throws IOException{
		FileWriter fw = new FileWriter(filename.getAbsoluteFile(),true);
		//System.out.println("file abs path " +  filename.getAbsoluteFile());
		BufferedWriter bw = new  BufferedWriter(fw);
		bw.write("<b><p style=\"font-size:24px;font-family:Calibiri\">" + output + "</b></p>");
		bw.close();
		fw.close();
	}
}
