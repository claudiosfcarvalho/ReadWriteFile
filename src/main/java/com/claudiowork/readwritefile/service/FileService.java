package com.claudiowork.readwritefile.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class FileService {

	private FileReader fr;

	public void setFileReader(String nomeArq) throws FileNotFoundException {
		fr = new FileReader(nomeArq);
	}

	public String readFile(String file) {
		if (!file.isEmpty() && fr == null) {
			try {
				setFileReader(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return "Erro ao carregar o arquivo - " + e1.getMessage();
			}
		}
		BufferedReader objReader = null;
		StringBuilder sb = new StringBuilder();
		try {
			String strCurrentLine;

			objReader = new BufferedReader(fr);

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
}
