import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Labirinto {
    private char[][] labirinto = new char[][]{};

    public Labirinto(char[][] labirinto) {
        this.labirinto = labirinto;
    }

    public static char[][] criaLabirinto(String filename) {
        char[][] novoLabirinto = null;
        try {
            File arquivo = new File(filename);
            Scanner contador = new Scanner(arquivo);
            int linhas = 0;
            int colunas = 0;
            
            while (contador.hasNextLine()) {
                String linha = contador.nextLine();
                colunas = Math.max(colunas, linha.length());
                linhas++;
            }
            contador.close();
            
            novoLabirinto = new char[linhas][colunas];
            
            Scanner leitura = new Scanner(arquivo);
            int linha = 0;
            while (leitura.hasNextLine()) {
                String data = leitura.nextLine();
                for (int coluna = 0; coluna < data.length(); coluna++) {
                    novoLabirinto[linha][coluna] = data.charAt(coluna);
                }
                linha++;
            }
            leitura.close();
        } catch (FileNotFoundException e){
            System.out.println("Erro na leitura do arquivo: " + filename);
            e.printStackTrace();
        }
        return novoLabirinto;
    }

    public boolean percorreLabirinto() {
        boolean[][] visitados = new boolean[labirinto.length][labirinto[0].length];
        int[] inicio = encontraPosicaoInicial();

        if (inicio == null) return false;
        
        return percorreLabirintoRecursivo(inicio[0], inicio[1], visitados);
    }

    private boolean percorreLabirintoRecursivo(int linha, int coluna, boolean[][] visitados) {
        if (linha < 0 || linha >= labirinto.length || 
            coluna < 0 || coluna >= labirinto[0].length || 
            visitados[linha][coluna] || 
            labirinto[linha][coluna] == 'X') {
            return false;
        }
        
        if (labirinto[linha][coluna] == 'D') {
            return true;
        }
        
        visitados[linha][coluna] = true;
        
        return percorreLabirintoRecursivo(linha - 1, coluna, visitados) ||  
               percorreLabirintoRecursivo(linha, coluna + 1, visitados) ||  
               percorreLabirintoRecursivo(linha + 1, coluna, visitados) ||  
               percorreLabirintoRecursivo(linha, coluna - 1, visitados);    
    }

    private int[] encontraPosicaoInicial() {
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                if (labirinto[i][j] == ' ') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        char[][] lab = criaLabirinto("labirinto.txt");
        Labirinto novoLabirinto = new Labirinto(lab);
        
        for (char[] linha : novoLabirinto.labirinto) {
            System.out.println(new String(linha));
        }

        boolean temSaida = novoLabirinto.percorreLabirinto();
        System.out.println("\nExiste caminho até a saída? " + 
            (temSaida ? "Sim" : "Não"));
    }
}