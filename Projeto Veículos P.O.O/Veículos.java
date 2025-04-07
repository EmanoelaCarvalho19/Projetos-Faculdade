package Pakage_Classes;

public abstract class Veiculos {
	
	public static int UltimoID = 0;
	
	private int ID;
	private String CorPredominante;
	private String Modelo;
	private String Marca;
	private int AnoFabricacao;
	private String Placa;
	private double Tara;
	private boolean VeiculoBaixado;
	
	public Veiculos()
	{
		this.ID = ++UltimoID;
		this.VeiculoBaixado = false;
	}
	
	public Veiculos(String corPredominante, String modelo, String marca, int anoFabricacao, String placa,
			double tara) {
		this.ID = ++UltimoID;
		this.VeiculoBaixado = false;
		
		this.CorPredominante = corPredominante;
		this.Modelo = modelo;
		this.Marca = marca;
		this.AnoFabricacao = anoFabricacao;
		this.Placa = placa;
		this.Tara = tara;
	}
	public String getCorPredominante() {
		return this.CorPredominante;
	}
	public void setCorPredominante(String corPredominante) {
		CorPredominante = corPredominante;
	}
	public String getModelo() {
		return this.Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getMarca() {
		return this.Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public int getAnoFabricacao() {
		return this.AnoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		AnoFabricacao = anoFabricacao;
	}
	public String getPlaca() {
		return this.Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public double getTara() {
		return this.Tara;
	}
	public void setTara(double tara) {
		Tara = tara;
	}

	public int getID() {
		return ID;
	}

	public boolean isVeiculoBaixado() {
		return VeiculoBaixado;
	}
	
	
}
