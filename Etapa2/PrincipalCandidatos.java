package Etapa2;
import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {
    private static final String[] NOMES = {
        "João", "Maria", "José", "Ana", "Pedro", "Paulo", "Carlos", "Sandra",
        "Antonio", "Fernanda", "Ricardo", "Daniel", "Monica", "Julia"
    };
    
    private static final String[] PARTIDOS = {
        "PT", "PSL", "PL", "PP", "PSD", "MDB", "PSDB", "DEM", 
        "PSB", "PDT", "PODE", "PSOL"
    };

    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;
            
            while (j >= 0 && candidatos[j].getNome().compareTo(chave.getNome()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            candidatos[j + 1] = chave;
        }
    }

    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        for (int i = 0; i < candidatos.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < candidatos.length; j++) {
                if (candidatos[j].getIntencoes() > candidatos[maxIndex].getIntencoes()) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                Candidato temp = candidatos[i];
                candidatos[i] = candidatos[maxIndex];
                candidatos[maxIndex] = temp;
            }
        }
    }

    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;
            
            while (j >= 0 && candidatos[j].getPartido().compareTo(chave.getPartido()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            candidatos[j + 1] = chave;
        }
    }

    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int inicio = 0;
        int fim = candidatos.length - 1;
        
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = candidatos[meio].getNome().compareTo(nome);
            
            if (comparacao == 0) {
                while (meio > 0 && candidatos[meio - 1].getNome().equals(nome)) {
                    meio--;
                }
                return meio;
            }
            
            if (comparacao > 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        int tamanhoArray = random.nextInt(100) + 1;
        Candidato[] candidatos = new Candidato[tamanhoArray];
        
        for (int i = 0; i < candidatos.length; i++) {
            String nomeAleatorio = NOMES[random.nextInt(NOMES.length)];
            String partidoAleatorio = PARTIDOS[random.nextInt(PARTIDOS.length)];
            int intencoesVoto = random.nextInt(1000);
            
            candidatos[i] = new Candidato(nomeAleatorio, partidoAleatorio, intencoesVoto);
        }
        
        System.out.println("Total de candidatos gerados: " + tamanhoArray);
        System.out.println("\nLista original de candidatos:");
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
        
        ordenaCandidatosPorPartido(candidatos);
        ordenaCandidatosPorVotos(candidatos);
        ordenaCandidatosPorNome(candidatos);
        
        System.out.println("\nLista ordenada de candidatos:");
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }

        System.out.println("\nDigite o nome do candidato que deseja procurar:");
        String nomeProcurado = scanner.nextLine();
        
        int posicao = pesquisaBinariaCandidatos(candidatos, nomeProcurado);
        
        if (posicao != -1) {
            System.out.println("\nCandidato encontrado na posição " + (posicao + 1));
            System.out.println(candidatos[posicao]);
        } else {
            System.out.println("\nNenhum candidato encontrado com o nome: " + nomeProcurado);
        }
        
        scanner.close();
    }
}
