package br.com.sistemarecomendacao;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

public class Recomendador {

	private FileDataModel getModelo(String path) throws IOException {
		File file = new File("src/main/resources/"+path);
		FileDataModel dataModel = new FileDataModel(file);
		return dataModel;
	}
	
	public DataModel getModeloProdutos() throws IOException {		
		return getModelo("dados.csv");
	}

	public DataModel getModelCursos() {
		try {
			return getModelo("cursos.csv");
		} catch (IOException e) {
			System.out.println("Erro ao tentar abrir o arquivo");
			e.printStackTrace();
			return null;
		}
	}

}
