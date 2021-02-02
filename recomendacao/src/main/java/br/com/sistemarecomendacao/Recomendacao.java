package br.com.sistemarecomendacao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class Recomendacao {
	
	public static void main(String[] args) throws IOException, TasteException {
		
		DataModel modelProdutos = new Recomendador().getModeloProdutos();
		
		//Ler o arquivo de dados
		File file = new File("dados.csv");
		//Criar o modelo
		FileDataModel dataModel = new FileDataModel(file);
		
		/*
		 * Criação das funções auxiliares
		 *  baseada no usuário;
		 *  segunda na proximidade; 
		 *  depois disso criar o recomendador
		 * */
		
		UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
		ThresholdUserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, dataModel);		
		//UserBasedRecommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
		Recommender recommender = new RecomendadorBuilder().buildRecommender(dataModel);
		
		/*
		 * solicitação de 3 recomentações para o usuário 2 e 
		 * em um laço, imprimir que recomendações foram feitas.
		 * */
		List<RecommendedItem> recommenders = recommender.recommend(2,3);
		
		recommenders.forEach(rec -> System.out.println(rec));
	}

}
