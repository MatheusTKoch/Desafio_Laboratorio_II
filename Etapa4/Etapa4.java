package Etapa4;

public class Etapa4 {
    public static void main(String[] args) {
        System.out.println("=== TESTE LINKEDSTACK ===");
        testarLinkedStack();
        
        System.out.println("\n=== TESTE LINKEDQUEUE ===");
        testarLinkedQueue();
    }
    
    private static void testarLinkedStack() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        
        try {
            stack.push(10);
            stack.push(20);
            System.out.println("1. Elemento no topo: " + stack.top());
            System.out.println("   Removido: " + stack.pop());
            
            stack.pop(); 
            System.out.println("2. Stack vazia: " + stack.isEmpty());
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void testarLinkedQueue() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        
        try {
            queue.enqueue("A");
            queue.enqueue("B");
            System.out.println("1. Primeiro elemento: " + queue.front());
            System.out.println("   Removido: " + queue.dequeue());
            
            queue.dequeue(); 
            System.out.println("2. Queue vazia: " + queue.isEmpty());
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}