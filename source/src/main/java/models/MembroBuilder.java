package models;

import java.time.LocalDate;
import java.util.List;

public class MembroBuilder {
	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private String telefone;
	private String cargo;
	private String diretoria;
	private String curso;
	private LocalDate dataNascimento;

	public MembroBuilder() {
		// Inicializa os valores caso necessário
	}

	public MembroBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}

	public MembroBuilder cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public MembroBuilder rg(String rg) {
		this.rg = rg;
		return this;
	}

	public MembroBuilder email(String email) {
		this.email = email;
		return this;
	}

	public MembroBuilder telefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public MembroBuilder cargo(String cargo) {
		this.cargo = cargo;
		return this;
	}

	public MembroBuilder diretoria(String diretoria) {
		this.diretoria = diretoria;
		return this;
	}

	public MembroBuilder curso(String curso) {
		this.curso = curso;
		return this;
	}

	public MembroBuilder dataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

	// Método para construir o objeto Membro
	public Membro build() {
		Membro membro = new Membro(nome, cpf, rg, email, telefone, cargo, diretoria, curso, dataNascimento);

		// Valida os campos do membro
		List<String> erros = membro.validarCampos();
		if (!erros.isEmpty()) {
			System.out.println("Erro de validação: " + String.join(", ", erros));
			return null;
		}

		return membro;
	}
}
