package com.claudiowork.readwritefile.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FileService {

	private FileReader fr;
	private BufferedReader objReader;

	public void setFileReader(String nomeArq) throws FileNotFoundException {
		fr = new FileReader(nomeArq);
	}

	public String readFileAllOneLine(String file) {

		StringBuilder sb = new StringBuilder();
		try {
			String strCurrentLine;

			objReader = readFile(file);

			while ((strCurrentLine = objReader.readLine()) != null) {
				sb.append(strCurrentLine);
				System.out.println(strCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();
			return "Erro ao ler o arquivo - " + e.getMessage();

		} finally {

			try {
				if (objReader != null)
					objReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return sb.toString();
	}

	private BufferedReader readFile(String file) throws FileNotFoundException {
		if (!file.isEmpty() && fr == null) {
			setFileReader(file);
		}
		objReader = new BufferedReader(fr);
		return objReader;
	}

	public List<String> readFileAll(String file) {
		List<String> strList = new ArrayList<>();
		String strReaded = new String("");
		try {
			readFile(file);
			while ((strReaded = objReader.readLine()) != null) {
				strList.add(strReaded);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			strList.add("Erro ao carregar o arquivo - " + e1.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			strList.add("Erro ao ler o arquivo - " + e.getMessage());
		} finally {

			try {
				if (objReader != null)
					objReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return strList;
	}
}
