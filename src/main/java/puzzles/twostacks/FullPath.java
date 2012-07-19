package puzzles.twostacks;

import java.util.Stack;

public class FullPath {

	public String getFullPath(String input) {
		Stack<String> path = new Stack<>();

		input = input.replaceAll("//+", "/");
		String[] tokens = input.split("/");
		if (tokens.length == 0) {
			return input;
		}
		for (String token : tokens) {
			if (token.isEmpty()) {
				continue;
			}
			if (path.size() == 0 || path.peek() != "/") {
				path.push("/");
			}
			if (token.equals("..")) {
				if (path.size() > 1) {
					path.pop();
					path.pop();
				}
			} else if (!token.equals(".")) {
				path.push(token);
			}
		}
		return getFullPath(path);
	}

	private String getFullPath(Stack<String> pathElements) {
		if (pathElements.size() == 0) {
			return "";
		} else {
			String token = pathElements.pop();
			return getFullPath(pathElements) + token;
		}
	}
}
