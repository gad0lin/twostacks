package puzzles.twostacks;

public class FindDiameter {
	
	public  int findDemeter(BTree tree) {
		return findDiameterRec(tree).diameter;
	}
	
	private Result findDiameterRec(BTree tree) {
		if (tree == null) {
			return new Result(-1,-1);
		}
		Result left = findDiameterRec(tree.getLeft());
		Result right = findDiameterRec(tree.getRight());
		int maxDiameter = getMaxDiameter(left,right);
		int depth =  getMaxDepth(left,right) + 1;
		return new Result(maxDiameter, depth);
		
	}

	private int getMaxDepth(Result left, Result right) {
		return  Math.max(left.maxDepth,right.maxDepth);
	}

	private int getMaxDiameter(Result left, Result right) {
		int maxChildDiameter = Math.max(left.diameter,right.diameter);
		int nodeDiameter = left.maxDepth + right.maxDepth + 2;
		return Math.max(maxChildDiameter, nodeDiameter);
	}





	private class Result {
		public Result(int diameter, int maxDepth) {
			super();
			this.diameter = diameter;
			this.maxDepth = maxDepth;
		}
		int diameter;
		int maxDepth;
	}
	
}
