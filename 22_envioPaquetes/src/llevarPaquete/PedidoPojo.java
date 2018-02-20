package llevarPaquete;

public class PedidoPojo {

	int idEnvio;
	/**
	 * @return the idEnvio
	 */
	public int getIdEnvio() {
		return idEnvio;
	}
	/**
	 * @param idEnvio the idEnvio to set
	 */
	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}
	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}
	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	/**
	 * @return the tamano
	 */
	public String getTamano() {
		return tamano;
	}
	/**
	 * @param tamano the tamano to set
	 */
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	String origen;
	String destino;
	String tamano;
	String fecha;
}
