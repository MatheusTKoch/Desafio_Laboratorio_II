import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Labirinto {
    private char[][] labirinto = new char[][]{};

    public Labirinto(char[][] labirinto) {
        this.labirinto = labirinto;
    }

    public static void criaLabirinto(String filename) {
        try {
            File arquivo = new File(filename);
            Scanner leitura = new Scanner(arquivo);
            while (leitura.hasNextLine()) {
                String data = leitura.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e){
            System.out.println("Erro na leitura do arquivo: " + filename);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        criaLabirinto("labirinto.txt");
    }
}