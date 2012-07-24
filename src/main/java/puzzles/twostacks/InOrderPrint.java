package puzzles.twostacks;

public class InOrderPrint implements PrintMe{
	
	private void printToBuffer(BTree bTree, StringBuilder sb) {

			if (bTree == null) {
				return;
			}
			sb.append("(");
			printToBuffer(bTree.getLeft(),sb);
			sb.append(")");
			sb.append(bTree.getValue());
			sb.append("(");
			printToBuffer(bTree.getRight(), sb);
			sb.append(")");
	}
	
	public StringBuilder printAsString(BTree bTree) {
		StringBuilder sb = new StringBuilder();
		if (bTree == null) {
			sb.append("");
		} else {
			printToBuffer(bTree, sb);
		}
		return sb;
	}
	public void print(BTree bTree) {
		System.out.println(printAsString(bTree));
	}
	
	
	
}
