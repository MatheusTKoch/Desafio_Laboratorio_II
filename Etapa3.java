import java.util.Stack;

public class Etapa3 {
    public boolean checkBrackets(Stack<Character> s1) {
        Stack<Character> auxStack = new Stack<>();
        Stack<Character> tempStack = new Stack<>();
        
        int openCount = 0;
        
        while (!s1.isEmpty()) {
            char c = s1.pop();
            tempStack.push(c);
        }
        
        while (!tempStack.isEmpty()) {
            char c = tempStack.pop();
            s1.push(c);
            
            if (c == '(') {
                openCount++;
                auxStack.push(c);
            } 
            else if (c == ')') {
                openCount--;
                if (openCount < 0) {
                    return false;
                }
            }
        }
        
        return openCount == 0;
    }
}
