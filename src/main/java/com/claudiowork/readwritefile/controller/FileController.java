package com.claudiowork.readwritefile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claudiowork.readwritefile.model.FileConfig;
import com.claudiowork.readwritefile.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	FileService fs;

	@GetMapping("/{nomeArquivo}")
	public String readFile(@PathVariable("nomeArquivo") String fileIn) {
		System.out.println(fileIn);
		return "teste";
	}

	@GetMapping("/readAllOneLine")
	public String readFileAllOneLine(@RequestBody FileConfig fileConfig) {
		String fullName = fileConfig.getDiretorioArquivo() + fileConfig.getNomeArquivo();
		return fs.readFileAllOneLine(fullName);
	}
	
	@GetMapping("/readAll")
	public List<String> readFileAll(@RequestBody FileConfig fileConfig) {
		String fullName = fileConfig.getDiretorioArquivo() + fileConfig.getNomeArquivo();
		return fs.readFileAll(fullName);
	}
}
