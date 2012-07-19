package puzzles.twostacks;

public class ArrayToBst {

	BTree getTree(int[] array){
		if (array == null) {
			return null;
		}
		return getTree(array, 0, array.length-1);
	}
	
	BTree getTree(int[] array, int left, int right){
		if(left == right) {
			return new BTree(array[left]);
		} else  if (left > right){
			return null;
		}
		 
		int pos = left + (right - left)/2;
		int value = array[pos];
		BTree leftChild = getTree(array, left, pos-1);
		BTree rightChild = getTree(array, pos+1, right);
		return new BTree(leftChild, rightChild,value);
	}
}
