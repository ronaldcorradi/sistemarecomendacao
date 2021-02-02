package br.com.sistemarecomendacao;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecomendadorBuilder implements RecommenderBuilder {
	
	@Override
	public Recommender buildRecommender(DataModel model) throws TasteException {
		UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(model);	
		double threshold = 0.1;
		ThresholdUserNeighborhood neighborhood = new ThresholdUserNeighborhood(threshold , userSimilarity, model);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, userSimilarity);
		return recommender;
	}

}
