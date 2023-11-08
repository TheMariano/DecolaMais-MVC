package crud;

import java.util.List;
import java.util.Scanner;

import dao.ComprasDao;
import modelos.Compras;
import modelos.Destinos;
import modelos.Usuarios;

public class ComprasCRUD {
    private ComprasDao comprasDao;

    public ComprasCRUD(ComprasDao comprasDao) {
        this.comprasDao = comprasDao;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        String dataCompra;
        int idUsuario, idDestino;

        do {
            System.out.println("\n============== COMPRAS ==============\n");
            System.out.println("1-CRIAR 2-CONSULTAR 3-ATUALIZAR 4-DELETAR 0-SAIR");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite a data da compra (YYYY-MM-DD): ");
                    dataCompra = scanner.nextLine();
                    System.out.println("Digite o ID do usuário: ");
                    idUsuario = scanner.nextInt();
                    System.out.println("Digite o ID do destino: ");
                    idDestino = scanner.nextInt();
                    Usuarios usuario = new Usuarios();
                    usuario.setId(idUsuario);
                    Destinos destino = new Destinos();
                    destino.setId(idDestino);
                    Compras compra = new Compras(null, dataCompra, usuario, destino);
                    comprasDao.create(compra);
                    System.out.println("Compra criada com sucesso!");
                    break;
                case 2:
                    List<Compras> compras = comprasDao.read();
                    for (Compras c : compras) {
                        System.out.println(c.toString());
                    }
                    break;
                case 3:
                    System.out.println("Digite o ID da compra que deseja atualizar: ");
                    int idCompra = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite a nova data da compra (YYYY-MM-DD): ");
                    dataCompra = scanner.nextLine();
                    System.out.println("Digite o novo ID do usuário: ");
                    idUsuario = scanner.nextInt();
                    System.out.println("Digite o novo ID do destino: ");
                    idDestino = scanner.nextInt();

                    Compras compraAtualizada = new Compras(idCompra, dataCompra, null, null);
                    comprasDao.update(compraAtualizada);
                    System.out.println("Compra atualizada com sucesso!");
                    break;
                case 4:
                    System.out.println("Digite o ID da compra que deseja excluir: ");
                    int idCompraExcluir = scanner.nextInt();
                    comprasDao.delete(idCompraExcluir);
                    System.out.println("Compra excluída com sucesso!");
                    break;
                default:
                    break;
            }
        } while (opcao != 0);

        System.out.println("Até mais!");
        scanner.close();
    }

    public static void main(String[] args) {
        ComprasDao comprasDao = new ComprasDao();
        ComprasCRUD comprasCRUD = new ComprasCRUD(comprasDao);
        comprasCRUD.iniciar();
    }
}
