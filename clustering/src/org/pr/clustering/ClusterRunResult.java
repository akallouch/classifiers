package org.pr.clustering;

import java.util.List;

public class ClusterRunResult {

	private ClusteringAlgorithm algorithm;  
	private List<Run> pointLists;
	
	public ClusterRunResult
		(ClusteringAlgorithm algorithm, List<Run> pointLists) {
		
		this.algorithm = algorithm;
		this.pointLists = pointLists;
	}

	public ClusteringAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(ClusteringAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public List<Run> getPointLists() {
		return pointLists;
	}

	public void setPointLists(List<Run> pointLists) {
		this.pointLists = pointLists;
	}
	
}
 