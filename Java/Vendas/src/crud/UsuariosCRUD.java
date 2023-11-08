package crud;

import java.util.Scanner;
import dao.UsuarioDao;
import modelos.Usuarios;

public class UsuariosCRUD {
    private UsuarioDao usuarioDAO;

    public UsuariosCRUD(UsuarioDao usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void iniciar() {
        Scanner s = new Scanner(System.in);

        int opcao = 0, id = 0;
        String nome = "", email = "", senha = "", telefone = "", endereco = "";

        do {
            System.out.println("\n============== USUARIOS ==============\n");
            System.out.println("1-CRIAR 2-CONSULTAR 3-ATUALIZAR 4-DELETAR 5-CONSULTAR POR ID 0-SAIR");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome: ");
                    nome = s.nextLine();
                    System.out.println("Digite o email: ");
                    email = s.nextLine();
                    System.out.println("Digite o senha: ");
                    senha = s.nextLine();
                    System.out.println("Digite o telefone: ");
                    telefone = s.nextLine();
                    System.out.println("Digite o endere�o: ");
                    endereco = s.nextLine();

                    Usuarios usuario = new Usuarios(id, nome, email, senha, telefone, endereco);
                    usuarioDAO.create(usuario);
                    break;
                case 2:
                    for (Usuarios u : usuarioDAO.read()) {
                        System.out.println(u.toString());
                    }
                    break;
                case 3:
                    System.out.println("Digite o ID do usu�rio que deseja atualizar: ");
                    id = s.nextInt();
                    s.nextLine();
                    System.out.println("Digite o novo nome: ");
                    nome = s.nextLine();
                    System.out.println("Digite o novo email: ");
                    email = s.nextLine();
                    System.out.println("Digite a nova senha: ");
                    senha = s.nextLine();
                    System.out.println("Digite o novo telefone: ");
                    telefone = s.nextLine();
                    System.out.println("Digite o novo endere�o: ");
                    endereco = s.nextLine();

                    Usuarios usuarioParaAtualizar = new Usuarios(id, nome, email, senha, telefone, endereco);
                    usuarioDAO.update(usuarioParaAtualizar);
                    break;
                case 4:
                    System.out.println("Digite o ID do usu�rio que deseja excluir: ");
                    id = s.nextInt();
                    s.nextLine();
                    usuarioDAO.delete(id);
                    break;
                case 5:
                    System.out.println("Digite o ID do usu�rio que deseja consultar: ");
                    id = s.nextInt();
                    s.nextLine();

                    Usuarios usuarioConsultado = usuarioDAO.readById(id);
                    if (usuarioConsultado != null) {
                        System.out.println("Usu�rio encontrado:");
                        System.out.println(usuarioConsultado.toString());
                    } else {
                        System.out.println("Usu�rio n�o encontrado.");
                    }
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
        System.out.println("At� mais!");
        s.close();
    }
}
