package modelos;

public class Compras {
    private Integer id;
    private String data_compra;
    
    Usuarios usuarios;
    Destinos destinos;
    
	public Compras() {
	}

	public Compras(Integer id, String data_compra, Usuarios usuarios, Destinos destinos) {
		super();
		this.id = id;
		this.data_compra = data_compra;
		this.usuarios = usuarios;
		this.destinos = destinos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}

	@Override
	public String toString() {
		return "Compras [id=" + id + ", data_compra=" + data_compra + ", usuarios=" + usuarios + ", destinos="
				+ destinos + "]";
	}
    
}
