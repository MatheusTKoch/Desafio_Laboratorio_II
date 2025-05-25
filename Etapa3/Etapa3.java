package Etapa3;
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

    public static void main(String[] args) {
        Etapa3 teste = new Etapa3();
        
        Stack<Character> stack1 = new Stack<>();
        String expr1 = "(A + B)";
        for (char c : expr1.toCharArray()) {
            stack1.push(c);
        }
        System.out.println("Teste válido '" + expr1.toString() + "': " + teste.checkBrackets(stack1));
        
        Stack<Character> stack2 = new Stack<>();
        String expr2 = "((A(";
        for (char c : expr2.toCharArray()) {
            stack2.push(c);
        }
        System.out.println("Teste inválido '" + expr2.toString() + "': " + teste.checkBrackets(stack2));
    }
}
