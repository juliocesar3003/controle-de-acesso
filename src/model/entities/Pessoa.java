package model.entities;

import java.util.Objects;



public class Pessoa {

	// ATRIBUTO ESTADO MOSTRA SE A PESSOA ESTA FORA OU DENTRO DO CONDOMINIO TRUE = ESTA / FALSE = NÃO ESTA
	private Integer Id;
	private String name;
	private Integer cpf;
	private Integer Napartament;
	private String Nblock;
	private Boolean Estado;	
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public Integer getNapartament() {
		return Napartament;
	}
	public void setNapartament(Integer napartament) {
		Napartament = napartament;
	}
	public String  getNblock() {
		return Nblock;
	}
	public void setNblock(String nblock) {
		Nblock = nblock;
	}
	
	public Boolean getEstado() {
		return Estado;
	}
	public void setEstado(Boolean estado) {
		Estado = estado;
	}
	
	public Pessoa() {
		
	}
	public Pessoa(Integer Id, String name, Integer cpf, Integer napartament, String nblock, Boolean Estado) {
		
		this.Id = Id;
		this.name = name;
		this.cpf = cpf;
		this.Napartament = napartament;
		this.Nblock = nblock;
		this.Estado = Estado;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(Id, Napartament, Nblock, cpf, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(Napartament, other.Napartament)
				&& Objects.equals(Nblock, other.Nblock) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Pessoa [Id=" + Id + ", name=" + name + ", cpf=" + cpf + ", Napartament=" + Napartament + ", Nblock="
				+ Nblock + ", Estado=" + Estado + "]";
	}
	
	
}
