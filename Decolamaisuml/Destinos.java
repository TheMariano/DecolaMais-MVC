package Decolamaisuml;

public class Destinos {
    
    private Integer id;
    private String cidade_destino;
    private String hotel_destino;
    private String dias_hotel_destino;
    private Compra compra;
    protected Integer getId() {
        return this.id;
    }
    protected Integer setId(Integer id) {
        this.id = id;
    }
    protected String getCidade_destino() {
        return this.cidade_destino;
    }
    protected String setCidade_destino(String cidade_destino) {
        this.cidade_destino = cidade_destino;
    }
    protected String getHotel_destino() {
        return this.hotel_destino;
    }
    protected String setHotel_destino(String hotel_destino) {
        this.hotel_destino = hotel_destino;
    }
    protected String getDias_hotel_destino() {
        return this.dias_hotel_destino;
    }
    protected String setDias_hotel_destino(String dias_hotel_destino) {
        this.dias_hotel_destino = dias_hotel_destino;
    }
    
}
