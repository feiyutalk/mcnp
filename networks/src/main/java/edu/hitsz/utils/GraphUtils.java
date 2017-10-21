package edu.hitsz.utils;

import java.util.*;

public class GraphUtils {
	
	private GraphUtils(){
		
	}
	
	public static int getNodeDegree(ArrayList<ArrayList<String>> list, int index){
		ArrayList<String> row = list.get(index-1);
		int degree = 0;
		for(int i =0; i<row.size(); i++){
			if(row.get(i).equals("y"))
				degree++;
		}
		return degree;
	}
	
	public static ArrayList<Integer> getAllNodesDegree(ArrayList<ArrayList<String>> list){
		ArrayList<Integer> degrees = new ArrayList<Integer>();
		
		for(int i =0; i<list.size(); i++){
			ArrayList<String> row = list.get(i);
			int degree = 0;
			for(int j=0; j<row.size(); j++){
				if(row.get(j).equals("y"))
					degree++;
			}
			degrees.add(degree);
		}
		return degrees;
	}
	
	public static double getAverageDegree(ArrayList<ArrayList<String>> list){
		ArrayList<Integer> degrees = GraphUtils.getAllNodesDegree(list);
		int sumOfdegree = 0;
		for(int i=0; i<degrees.size(); i++){
			sumOfdegree+=degrees.get(i);
		}
		return 1.0*sumOfdegree/list.size();
	}

	public static double getAverageDegreeByDegrees(ArrayList<Integer> degrees){
		int sumOfdegree = 0;
		for(int i=0; i<degrees.size(); i++){
			sumOfdegree+=degrees.get(i);
		}
		return 1.0*sumOfdegree/degrees.size();
	}
	
	public static double getClusteringCoefficient(ArrayList<ArrayList<String>> list, int index){
		int existingEdgesOfNeighbors = GraphUtils.existingEdgesOfNeighbors(list, index);
		int possiblyEdgesOfNeighbors = GraphUtils.possiblyEdgesOfNeighbors(list, index);
		if(possiblyEdgesOfNeighbors == 0)
			return 0;
		return 1.0*existingEdgesOfNeighbors/possiblyEdgesOfNeighbors;
	}
	
	public static int getNumberOfNeighbors(ArrayList<ArrayList<String>> list, int index){
		int number = 0;
		ArrayList<String> row = list.get(index-1);
		for(int i=0; i<row.size(); i++){
			if(row.get(i).equals("y"))
				number++;
		}
		return number;
	}
	
	public static int existingEdgesOfNeighbors(ArrayList<ArrayList<String>> list, int index){
		List<Integer> neighbors = GraphUtils.getNeighbors(list, index);
		
		int existingEdges=0;
//		for(int i=0; i<neighbors.size()-1; i++){
//			int index1 = neighbors.get(i);
//			for(int j=i+1; j<neighbors.size(); j++){
//				int index2 = neighbors.get(j);
//				if(isNeighbor(list, index1, index2))
//					existingEdges++;
//			}
//		}
		
		for(int i =0; i<neighbors.size(); i++){
			for(int j=0; j<neighbors.size(); j++){
				int index1 = neighbors.get(i);
				int index2 = neighbors.get(j);
				if(isNeighbor(list, index1, index2))
					existingEdges++;
			}
		}
		
		return existingEdges/2;
	}
	
	public static double getAverageClusteringCoefficient(ArrayList<ArrayList<String>> list){
		double sumOfClusteringCoefficient = 0;
		for(int i =0; i<list.size(); i++){
			sumOfClusteringCoefficient+= GraphUtils.getClusteringCoefficient(list, i+1);
		}
		return sumOfClusteringCoefficient/list.size();
	}
	
	public static int possiblyEdgesOfNeighbors(ArrayList<ArrayList<String>> list, int index){
		int numberOfNeighbors = GraphUtils.getNumberOfNeighbors(list, index);
		return numberOfNeighbors*(numberOfNeighbors-1)/2;
	}
	
	public static List<Integer> getNeighbors(ArrayList<ArrayList<String>> list, int index){
		List<Integer> neighbors = new ArrayList<Integer>();
		ArrayList<String> row = list.get(index-1);
		for(int i =0; i<row.size(); i++){
			if(row.get(i).equals("y")){
				neighbors.add(i+1);
			}
		}
		return neighbors;
	}
	
	public static boolean isNeighbor(ArrayList<ArrayList<String>> list, int index1, int index2){
		return list.get(index1-1).get(index2-1).equals("y");
	}
	
	public static int getGraphCoreness(ArrayList<ArrayList<String>> list){
		ArrayList<Integer> corenesses = getNodesCoreness(list);
		return Collections.max(corenesses);
	}
	
	public static int getNodeCoreness(ArrayList<ArrayList<String>> list, int index){
		ArrayList<Integer> corenesses = getNodesCoreness(list);
		return corenesses.get(index-1);
	}
	
	public static int getMaxCorenessNodeNumber(ArrayList<ArrayList<String>> list){
		ArrayList<Integer> corenesses = getNodesCoreness(list);
		int maxCoreness = Collections.max(corenesses);
		for(int i =0; i<list.size(); i++){
			if(!GraphUtils.isRemoved(list, i+1)){
				if(corenesses.get(i) == maxCoreness)
					return i+1;
			}
		}
		return 1;
	}
	
	public static ArrayList<Integer> getNodesCoreness(ArrayList<ArrayList<String>> list){
		ArrayList<Integer> corenesses = new ArrayList<Integer>();
		
		for(int i =0; i<list.size(); i++){
			corenesses.add(0);
		}
		
		int maxDegree = GraphUtils.getMaxDegree(list);
		ArrayList<ArrayList<String>> listClone = CommonUtils.cloneMyArray(list);
		
		boolean isMark ;
		for(int k = 0; k <= maxDegree; k++){
			ArrayList<Integer> degrees = GraphUtils.getAllNodesDegree(listClone);
			isMark = false;
			for(int i = 0; i<degrees.size(); i++){
				if(!(listClone.get(i).get(i).equals("x"))){
					if(degrees.get(i) < k){
						GraphUtils.markRemove(listClone, i+1);
						corenesses.set(i, k-1);
						isMark = true;
						break;
					}else{
						corenesses.set(i, k);
					}
				}
			}
			if(isMark)
				k--;
		}
		return corenesses;
	}
	
	public static int getMaxDegree(ArrayList<ArrayList<String>> list){
		ArrayList<Integer> degrees = GraphUtils.getAllNodesDegree(list);
		return Collections.max(degrees);
	}
	
	public static void markRemove(ArrayList<ArrayList<String>> list, int index){
		Collections.fill(list.get(index-1), "x");
		
		for(int i =0; i<list.size(); i++){
			list.get(i).set(index-1, "x");
		}
	}
	
	public static double getAverageShortestPath(ArrayList<ArrayList<String>> list){
		int sumOfPath = 0;
		int numberOfPah = 0;
		for(int i =0; i<list.size(); i++){
			ArrayList<Integer> paths = GraphUtils.widthSearch(list, i+1);
			for(int j = i+1; j<paths.size(); j++){
				if(paths.get(j)>0){
					sumOfPath+=paths.get(j);
					numberOfPah++;
				}
					
			}
		}
		if(numberOfPah==0)
			return 0;
		return 1.0*sumOfPath/numberOfPah;
	}
	
	public static ArrayList<Integer> widthSearch(ArrayList<ArrayList<String>> list, int start){
		ArrayList<Integer> paths = new ArrayList<Integer>();
		for(int i =0; i<list.size(); i++){
			paths.add(-1);
		}
		Node startNode = new Node(start-1, 0);
		ArrayList<Integer> visited = new ArrayList<Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		
		visited.add(startNode.number);
		paths.set(startNode.number, startNode.level);
		queue.offer(startNode);
		while(!queue.isEmpty()){
			Node currNode = queue.poll();
			for(int i=0; i<list.get(currNode.number).size(); i++){
				if(list.get(currNode.number).get(i).equals("y") && !visited.contains(i)){
					Node childNode = new Node(i, currNode.level+1);
					visited.add(childNode.number);
					paths.set(childNode.number, childNode.level);
					queue.offer(childNode);
				}
			}
		}
		
		return paths;
	}
	
	public static boolean isConnected(ArrayList<ArrayList<String>> list){
		ArrayList<Integer> paths = GraphUtils.widthSearch(list, 1);
		Iterator<Integer> iterator = paths.iterator();
		while(iterator.hasNext()){
			if(iterator.next() == -1)
				return false;
		}
		return true;
 	}
	
	public static boolean isRemoved(ArrayList<ArrayList<String>> list, int index){
		return list.get(index-1).get(index-1).equals("x");
	}
	
	public static boolean isAllRemoved(ArrayList<ArrayList<String>> list){
		for(int i =0; i<list.size(); i++){
			if(!list.get(i).get(i).equals("x"))
				return false;
		}
		return true;
	}
	
	public static ArrayList<Integer> getSubgraph(ArrayList<ArrayList<String>> list){
		int firstNodeNumber = 1;
		for(int i=0; i<list.size(); i++){
			if(!isRemoved(list, i+1)){
				firstNodeNumber = i;
				break;
			}
		}
		
		ArrayList<Integer> visited = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visited.add(firstNodeNumber+1);
		queue.offer(firstNodeNumber+1);
		while(!queue.isEmpty()){
			Integer currNodeNum = queue.poll();
			for(int i=0; i<list.get(currNodeNum-1).size(); i++){
				if(list.get(currNodeNum-1).get(i).equals("y") && !visited.contains(i+1)){
					visited.add(i+1);
					queue.offer(i+1);
				}
			}
		}
		return visited;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubgraphs(ArrayList<ArrayList<String>> list){
		ArrayList<ArrayList<Integer>> subgraphs = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<String>> listclone = CommonUtils.cloneMyArray(list);
		while(!isAllRemoved(listclone)){
			ArrayList<Integer> subgraph = GraphUtils.getSubgraph(listclone);
			Iterator<Integer> iterator = subgraph.iterator();
			while(iterator.hasNext()){
				int nodeNum = iterator.next();
				GraphUtils.markRemove(listclone, nodeNum);
			}
			subgraphs.add(subgraph);
		}
		return subgraphs;
	}
	
	public static int getConnectedBranchNumber(ArrayList<ArrayList<String>> list){
		ArrayList<ArrayList<Integer>> subgraphs = GraphUtils.getSubgraphs(list);
		return subgraphs.size();
	}
	
	public static int sizeOfLargestSubgraph(ArrayList<ArrayList<String>> list){
		ArrayList<ArrayList<Integer>> subgraphs = GraphUtils.getSubgraphs(list);
		int maxSize = 0;
		for(int i =0; i<subgraphs.size(); i++){
			int size = subgraphs.get(i).size();
			if(size > maxSize)
				maxSize = size;
		}
		return maxSize;
	}
	
	public static int getNumberOfNodes(ArrayList<ArrayList<String>> list){
		int numberOfNodes = 0;
		for(int i =0; i<list.size(); i++){
				if(!GraphUtils.isRemoved(list, i+1))
					numberOfNodes++;
		}
		return numberOfNodes;
	}
	
	public static int getNumberOfEdges(ArrayList<ArrayList<String>> list){
		int numberOfEdges = 0;
		for(int i =0; i<list.size(); i++){
			if(!isRemoved(list, i+1)){
				for(int j=0; j<list.get(i).size(); j++){
					if(list.get(i).get(j).equals("y"))
						numberOfEdges++;
				}
			}
		}
		return numberOfEdges/2;
	}
	
	public static int getMaxDegreeNodeNumber(ArrayList<ArrayList<String>> list){
		int maxDegree = GraphUtils.getMaxDegree(list);
		for(int i =0; i<list.size(); i++){
			if(!GraphUtils.isRemoved(list, i+1)){
				int degree = 0;
				for(int j =0; j<list.get(i).size(); j++){
					if(list.get(i).get(j).equals("y"))
						degree++;
				}
				if(degree == maxDegree)
					return i+1;
			}
		}
		return 1;
	}
	
	public static int getAverageShortestPathLength(ArrayList<ArrayList<String>> list,
			int indexJ, int indexL){
		ArrayList<Integer> paths = GraphUtils.widthSearch(list, indexJ);
		return paths.get(indexL-1);
	}
	
	public static void randomAttack(ArrayList<ArrayList<String>> list, int randomNode){
		markRemove(list, randomNode);
	}
	
	public static void intentionalAttack(ArrayList<ArrayList<String>> list, int index){
		markRemove(list, index);
	}
	
	public static int getMaxNodeBetweennessNodeNumber(ArrayList<ArrayList<String>> list){
		double maxNodeBetweenness = Integer.MIN_VALUE;
		int maxNodeBetweennessNodeNumber = 0;
		for(int i=0; i<list.size(); i++){
			System.out.println(i);
			if(!isRemoved(list, i+1)){
				double nodeBetweenness = GraphUtils.getNodeBetweenness(list, i+1);
				if(nodeBetweenness > maxNodeBetweenness){
					maxNodeBetweenness = nodeBetweenness;
					maxNodeBetweennessNodeNumber = i+1;
				}
			}
		}
		return maxNodeBetweennessNodeNumber;
	}
	
	public static double getNodeBetweenness(ArrayList<ArrayList<String>> list, int nodeNum){
		double nodeBetweenness = 0;
		for(int i=0; i<list.size(); i++){
			for(int j = 0; j<list.size(); j++){
				if(i!=j && (i+1)!=nodeNum && (j+1)!= nodeNum){
					nodeBetweenness += getOneItemOfNodeBetweenness(list,
							nodeNum, i+1, j+1);
				}
			}
		}
		return nodeBetweenness/2;
	}
	
	public static double getOneItemOfNodeBetweenness(ArrayList<ArrayList<String>> list, int nodeNum,
			int indexJ, int indexL){
		int allExistingShortesPath = GraphUtils.getAllExistingShortestPath(list, indexJ, indexL);
		int allExistingShortesPathPassThroughNode = GraphUtils.getAllExistingShortestPathPassThroughNode(list,
				nodeNum, indexJ, indexL );
		if(allExistingShortesPath == 0) return 0;
		return 1.0*allExistingShortesPathPassThroughNode/allExistingShortesPath;
	}
	
	public static int getAllExistingShortestPath(ArrayList<ArrayList<String>> list,
			int indexJ, int indexL){
		ArrayList<ArrayList<Integer>> allShortestPaths = GraphUtils
				.findAllShortestPaths(list, indexJ, indexL);
		return allShortestPaths.size();
	}
	
	public static int getAllExistingShortestPathPassThroughNode(ArrayList<ArrayList<String>> list,
			 int nodeNum,int indexJ, int indexL){
		ArrayList<ArrayList<Integer>> allShortestPaths = GraphUtils
				.findAllShortestPaths(list, indexJ, indexL);
		int count = 0;
		for(int i=0; i<allShortestPaths.size(); i++){
			ArrayList<Integer> shortestPath = allShortestPaths.get(i);
			if(shortestPath.contains(nodeNum))
				count++;
		}
		return count;
	}
	
	public static ArrayList<ArrayList<Integer>> findAllShortestPaths(ArrayList<ArrayList<String>> list,
			int indexJ, int indexL){
		ArrayList<ArrayList<Integer>> allShortestPaths = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<ArrayList<Integer>> allPaths = new ArrayList<ArrayList<Integer>>();
		Stack<Integer> stack  = new Stack<Integer>();
		stack.add(indexJ);
		GraphUtils.dfsStack(list, indexL, stack, allPaths);
		
		if(allPaths.isEmpty())
			return allShortestPaths;
		
		
		int minLength = Integer.MAX_VALUE;
		
		for(int i=0; i<allPaths.size(); i++){
			if(allPaths.get(i).size() < minLength)
				minLength = allPaths.get(i).size();
		}
		
		
		for(int i=0; i<allPaths.size(); i++){
			if(allPaths.get(i).size() == minLength){
				allShortestPaths.add(allPaths.get(i));
			}
		}
		
		return allShortestPaths;
	}
	
	
	public static void dfsStack(ArrayList<ArrayList<String>> list, int goal, 
			Stack<Integer> stack,ArrayList<ArrayList<Integer>> paths){
		System.out.println("\nջԪ��:");
		System.out.println(stack);
		
		if(stack.isEmpty())
			return ;
		
		int peekValue = stack.peek();
		
		if(peekValue == goal)
			return ;
		
		for(int i=0; i<list.get(peekValue - 1).size(); i++){
			
			if(list.get(peekValue-1).get(i).equals("y") &&
					(peekValue-1) != i){
				
				if(stack.contains(i+1)){
					continue;
				}
				
				if((i+1) == goal){
					ArrayList<Integer> path = new ArrayList<Integer>();
					Iterator<Integer> iterator = stack.iterator();
					while(iterator.hasNext()){
						path.add(iterator.next());
					}
					path.add(goal);
					paths.add(path);					
					continue;
				}
				
				stack.push(i+1);
				dfsStack(list, goal, stack, paths);
			}
		}
		stack.pop();
	}
 	
}
