package Decolamaisuml;

public class Compra {

    private Integer id;
    private String data_compra;
    private Usuarios usuarios;
    private Destinos destinos;
    protected Integer getId() {
        return this.id;
    }
    protected Integer setId(Integer id) {
        this.id = id;
    }
    protected String getData_compra() {
        return this.data_compra;
    }
    protected String setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }
    public float valor() {
        
        return null;
    }
    
    
}
