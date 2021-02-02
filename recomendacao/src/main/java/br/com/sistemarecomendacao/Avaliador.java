package br.com.sistemarecomendacao;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.DataModelBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.common.RandomUtils;

public class Avaliador {

	public static void main(String[] args) throws TasteException, IOException {
		
		//Para evitar a aleatoriedade nos testes
		RandomUtils.useTestSeed();
		
		double trainingPercentage = 0.9;
		double evaluationPercentage = 1.0;
		DataModelBuilder dataModelBuilder = null;

		
		DataModel dataModel = new Recomendador().getModelCursos();

		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder recommenderBuilder = new RecomendadorBuilder();

		double erro = evaluator.evaluate(recommenderBuilder, 
				                         dataModelBuilder, 
				                         dataModel, 
				                         trainingPercentage, 
				                         evaluationPercentage);
		System.out.println(erro);
	}

}
