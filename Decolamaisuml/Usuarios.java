package Decolamaisuml;

public class Usuarios {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;
    private Compra compra;
    protected Integer getId() {
        return this.id;
    }
    protected Integer setId(Integer id) {
        this.id = id;
    }
    protected String getNome() {
        return this.nome;
    }
    protected String setNome(String nome) {
        this.nome = nome;
    }
    protected String getEmail() {
        return this.email;
    }
    protected String setEmail(String email) {
        this.email = email;
    }
    protected String getSenha() {
        return this.senha;
    }
    protected String setSenha(String senha) {
        this.senha = senha;
    }
    protected String getTelefone() {
        return this.telefone;
    }
    protected String setTelefone(String telefone) {
        this.telefone = telefone;
    }
    protected String getEndereco() {
        return this.endereco;
    }
    protected String setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
