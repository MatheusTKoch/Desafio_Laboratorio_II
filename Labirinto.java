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

    public static void main(String[] args) {
        char[][] lab = criaLabirinto("labirinto.txt");
        Labirinto novoLabirinto = new Labirinto(lab);
        
        for (char[] linha : novoLabirinto.labirinto) {
            System.out.println(new String(linha));
        }
    }
}