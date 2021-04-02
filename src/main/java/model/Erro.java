package model;


public class Erro {
	
	private Integer status;
//	private String type; link da requisicao
	private String tittle;
	private String detail;

	public Erro(Integer status, String tittle, String detail) {
		this.status = status;
		this.tittle = tittle;
		this.detail = detail;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
