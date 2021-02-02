package br.com.sistemarecomendacao;

import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class RecomendadorCursos {
	
	public static void main(String[] args) throws TasteException {
		
		DataModel modelCursos = new Recomendador().getModelCursos();
		Recommender recommender = new RecomendadorBuilder().buildRecommender(modelCursos);
		
		long usuarioId = 15;
		int quantidadeDeItens = 10;
		List<RecommendedItem> recommenders = recommender.recommend(usuarioId, quantidadeDeItens);
		
		recommenders.forEach(recomender -> {
			System.out.println(recomender);
		});
		
	}

}
