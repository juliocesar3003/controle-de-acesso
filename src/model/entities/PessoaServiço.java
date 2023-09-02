package model.entities;




import java.time.LocalTime;
import java.util.Objects;

import model.entities.Enum.TipoDataServiço;


public class PessoaServiço extends Pessoa {

	private LocalTime HoraEntrada;
	private LocalTime HoraSaida;
	private String NomeEmpresa;
	private String NomeContratante;
	private String TipoTrabalho;
	
	private TipoDataServiço DataServiço; // RETORNA UM ENUM MOSTRANDO SE O SERVIÇO VAI SER HORA/DIA/FIXA
	
	
	public PessoaServiço() {}
	
	public PessoaServiço(Integer Id, String name, Integer cpf, Integer napartament, String nblock, LocalTime horaEntrada,
						LocalTime horaSaida, String nomeEmpresa, String nomeContratante, 
						String tipoTrabalho,TipoDataServiço DataServiço, Boolean Estado) {
		super(Id, name, cpf, napartament, nblock, Estado );
		HoraEntrada = horaEntrada;
		HoraSaida = horaSaida;
		NomeEmpresa = nomeEmpresa;
		NomeContratante = nomeContratante;
		TipoTrabalho = tipoTrabalho;
		this.DataServiço = DataServiço;  
	}

	public LocalTime getHoraEntrada() {
		return HoraEntrada;
	}

	public void setHoraEntrada(LocalTime time) {
		HoraEntrada = time;
	}

	public LocalTime getHoraSaida() {
		return HoraSaida;
	}

	public void setHoraSaida(LocalTime horaSaida) {
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
	
	

	public TipoDataServiço getDataServiço() {
		return DataServiço;
	}

	public void setDataServiço(TipoDataServiço dataServiço) {
		DataServiço = dataServiço;
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
