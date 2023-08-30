package model.entities;

import java.time.LocalDateTime;
import java.util.Objects;


public class PessoaServiço extends Pessoa {

	private LocalDateTime HoraEntrada;
	private LocalDateTime HoraSaida;
	private String NomeEmpresa;
	private String NomeContratante;
	private String TipoTrabalho;
	
	

	public PessoaServiço(Integer Id, String name, Integer cpf, Integer napartament, String nblock, LocalDateTime horaEntrada,
			LocalDateTime horaSaida, String nomeEmpresa, String nomeContratante, String tipoTrabalho, Boolean Estado) {
		super(Id, name, cpf, napartament, nblock, Estado );
		HoraEntrada = horaEntrada;
		HoraSaida = horaSaida;
		NomeEmpresa = nomeEmpresa;
		NomeContratante = nomeContratante;
		TipoTrabalho = tipoTrabalho;
	}

	public LocalDateTime getHoraEntrada() {
		return HoraEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		HoraEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSaida() {
		return HoraSaida;
	}

	public void setHoraSaida(LocalDateTime horaSaida) {
		HoraSaida = horaSaida;
	}

	public String getNomeEmpresa() {
		return NomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		NomeEmpresa = nomeEmpresa;
	}

	public String getNomeContratante() {
		return NomeContratante;
	}

	public void setNomeContratante(String nomeContratante) {
		NomeContratante = nomeContratante;
	}

	public String getTipoTrabalho() {
		return TipoTrabalho;
	}

	public void setTipoTrabalho(String tipoTrabalho) {
		TipoTrabalho = tipoTrabalho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(HoraEntrada, HoraSaida, NomeContratante, NomeEmpresa, TipoTrabalho);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaServiço other = (PessoaServiço) obj;
		return Objects.equals(HoraEntrada, other.HoraEntrada) && Objects.equals(HoraSaida, other.HoraSaida)
				&& Objects.equals(NomeContratante, other.NomeContratante)
				&& Objects.equals(NomeEmpresa, other.NomeEmpresa) && Objects.equals(TipoTrabalho, other.TipoTrabalho);
	}

	@Override
	public String toString() {
		return "PersonWork [HoraEntrada=" + HoraEntrada + ", HoraSaida=" + HoraSaida + ", NomeEmpresa=" + NomeEmpresa
				+ ", NomeContratante=" + NomeContratante + ", TipoTrabalho=" + TipoTrabalho + "]";
	}
	
	
	
	
}
