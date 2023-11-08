package crud;

import java.util.List;
import java.util.Scanner;
import dao.DestinosDao;
import modelos.Destinos;

public class DestinosCRUD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DestinosDao destinosDAO = new DestinosDao();

        int opcao = 0;

        do {
            System.out.println("\n============== DESTINOS ==============\n");
            System.out.println("1-CRIAR 2-CONSULTAR 0-SAIR");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a cidade do destino: ");
                    String cidade = scanner.next();
                    System.out.println("Digite o hotel do destino: ");
                    String hotel = scanner.next();
                    System.out.println("Digite a quantidade de dias no hotel: ");
                    String dias = scanner.next();

                    Destinos destino = new Destinos(null, cidade, hotel, dias);
                    destinosDAO.create(destino);
                    break;
                case 2:
                    List<Destinos> destinos = destinosDAO.read();
                    for (Destinos d : destinos) {
                        System.out.println(d.toString());
                    }
                    break;
                default:
                    break;
            }
        } while (opcao != 0);

        System.out.println("Até mais!");
        scanner.close();
    }
}
