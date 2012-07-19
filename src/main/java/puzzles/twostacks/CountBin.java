package puzzles.twostacks;
public class CountBin {

	public static int count(int[] arr, int n) {
		return count(arr.length - 1, arr, n, false);
	}

	public static int count(int index, int[] arr, int n, boolean canflip) {
		int ret = 0;
		if (index < n - 1 || index < 0) {
			return 0;
		}
		int val = arr[index];
		if (index == 0 && n == 1 && canflip) {
			ret = 1;
		} else if (index == 0 && n == 1 && !canflip) {
			return val == 1 ? 1 : 0;
		} else if (index == 0 && n == 0) {
			return 1;
		} else {
			if (canflip) {
				ret = count(index - 1, arr, n, true)
						+ count(index - 1, arr, n - 1, true);
			} else if (val == 0 && !canflip) {
				ret = count(index - 1, arr, n, false);
			} else if (val == 1 && !canflip) {
				ret = count(index - 1, arr, n, true)
						+ count(index - 1, arr, n - 1, false);
			}
		}
		return ret;
	}
	public static int count2(int[] arr, int n) {
		int number = 0;
		int mul = 1;
		for (int i = 0; i < arr.length; i++) {
			number = arr[i] * mul + number;
			mul *= 2;
		}
		return getCount2(number, n);
	}

	public static int getCount2(int b, int n) {
		int result = 0;
		for (int i = 0; i <= b; i++) {
			if (Integer.bitCount(i) == n) {
				result++;
			}
		}
		return result;
	}
	
	public static int[] getArr(int num) {
		int mul = 1;
		int[] arr= new int[32];
		for(int i=0; i < 32;i++) {
			arr[i]= (num & mul) == 0 ? 0:1;
			mul *=2;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 0, 1, 1, 1 };
		int counter = count(arr, 2);
		for (int i = 0; i < Math.pow(2, 10); i++){
			int[] arr2 = getArr(i); 
			if(!(count2(arr2, 3) == count(arr2, 3))){
				System.out.println("DIff");
			}
		}
		
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	public static int countStairs(int left) {
		if (left <= 0) {
			return 0;
		}
		if (left == 1) {
			return 1;
		} else if (left == 2) {
			return 2;
		} else {
			return countStairs(left - 2) + countStairs(left - 1);
		}
	}
}
