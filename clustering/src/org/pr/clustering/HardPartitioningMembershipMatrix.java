package org.pr.clustering;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * @author Ahmad
 */
public class HardPartitioningMembershipMatrix {

	int[] memerships;
	int n;
	int k;
	
	/**
	 * creates a MembershipMatrix and randomly initialize memberships
	 * 
	 * @param n number of patterns/observations
	 * @param k number of clusters/groups
	 */
	public HardPartitioningMembershipMatrix(int n, int k) {
		this.n = n;
		this.k = k;
		
		memerships = new int[n];
		
		Random random = new Random(Calendar.getInstance().getTimeInMillis());
		
		// for the first k patterns, assign them to k cluster
		// this way, we guarantee that every cluster has at least one pattern
		
		for (int i = 0; i < k; i++) {
			memerships[i] = i;
		}
		
		// for each pattern, randomly choose a cluster for it
		for (int i = k; i < n; i++) {
			int clusterIndex = random.nextInt(k);
			memerships[i] = clusterIndex;
		}
	}
	
	/**
	 * creates a MembershipMatrix using the specified matrix
	 */
	public HardPartitioningMembershipMatrix(int[] memerships) {
		this.memerships = memerships ;
	}
	
	public void movePattern(int patternIndex, int clusterIndex) {
		memerships[patternIndex] = clusterIndex;
	}
	
	public void moveAllPatterns(int[] clusterIndexes) {
		if (clusterIndexes.length != n)
			throw new IllegalArgumentException("clusterIndexes should be of the same size of the pattern set");
		
		for (int i = 0; i < n; i++) {
			memerships[i] = clusterIndexes[i];
		}
	}
	
	/**
	 * returns an arrays of length n, where the ith element represents
	 * the clusters index of the ith pattern.
	 * 
	 * note that this method returns a list so that we can then compare 
	 * two clusters configurations (arrays don't implements equals method)
	 */
	public List<Integer> getClusters() {
		List<Integer> clusters = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			clusters.add(memerships[i]);
		}
		
		return clusters;
	}
	
	/**
	 * Returns the index of the cluster this pattern belongs to
	 */
	public int getClusterForPattern(int patternIndex) {
		return memerships[patternIndex];
	}
	
	public int[] getPatternsForCluster(int cluster) {
		int n = memerships.length;
		List<Integer> patterns = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (memerships[i] == cluster) {
				patterns.add(i);
			}
		}
		
		int[] _patterns = new int[patterns.size()];
		for (int i = 0; i < _patterns.length; i++) {
			_patterns[i] = patterns.get(i);
		}
		
		return _patterns;
	}
	
	public static void main(String[] args) { 
		HardPartitioningMembershipMatrix mm = new HardPartitioningMembershipMatrix(5, 3);
		List<Integer> clusters = mm.getClusters();
		System.out.println("");
		
		int[] patterns0 = mm.getPatternsForCluster(0);
		int[] patterns1 = mm.getPatternsForCluster(1);
		int[] patterns2 = mm.getPatternsForCluster(2);
		
		System.out.println();
	}
}
