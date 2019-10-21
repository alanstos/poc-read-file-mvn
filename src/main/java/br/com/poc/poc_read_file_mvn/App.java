package br.com.poc.poc_read_file_mvn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {

	final static String directory = "/Users/alan/dev"; // System.getProperty("user.home");

	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		lerAndEscreve();
		
	}

	private static void lerAndEscreve() throws IOException {
		
		String fileNameOrigin = "meupdf.pdf";
		String fileNameDest = "outropdf.pdf";
		
		String absolutePath = directory + File.separator + fileNameOrigin;
		String absolutePathTarget = directory + File.separator + fileNameDest;
		
		InputStream initialStream = new FileInputStream(new File(absolutePath));
		File targetFile = new File(absolutePathTarget);
		OutputStream outStream = new FileOutputStream(targetFile);

		byte[] buffer = new byte[8 * 1024];
		int bytesRead;
		while ((bytesRead = initialStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		
		initialStream.close();
		outStream.close();
	}
}
