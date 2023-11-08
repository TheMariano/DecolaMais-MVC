package modelos;

public class Destinos {
    private Integer id;
    private String cidade_destino;
    private String hotel_destino;
    private String dias_hotel_destino;
    
	public Destinos() {
		
	}

	public Destinos(Integer id, String cidade_destino, String hotel_destino, String dias_hotel_destino) {
		super();
		this.id = id;
		this.cidade_destino = cidade_destino;
		this.hotel_destino = hotel_destino;
		this.dias_hotel_destino = dias_hotel_destino;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCidade_destino() {
		return cidade_destino;
	}

	public void setCidade_destino(String cidade_destino) {
		this.cidade_destino = cidade_destino;
	}

	public String getHotel_destino() {
		return hotel_destino;
	}

	public void setHotel_destino(String hotel_destino) {
		this.hotel_destino = hotel_destino;
	}

	public String getDias_hotel_destino() {
		return dias_hotel_destino;
	}

	public void setDias_hotel_destino(String dias_hotel_destino) {
		this.dias_hotel_destino = dias_hotel_destino;
	}

	@Override
	public String toString() {
		return "Destinos [id=" + id + ", cidade_destino=" + cidade_destino + ", hotel_destino=" + hotel_destino
				+ ", dias_hotel_destino=" + dias_hotel_destino + "]";
	}
    
}
