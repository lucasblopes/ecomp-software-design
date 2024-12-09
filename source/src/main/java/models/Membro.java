package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Membro {
	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private String telefone;
	private String cargo;
	private String diretoria;
	private String curso;
	private LocalDate dataNascimento;

	// Construtor protegido para instanciar apenas via builder
	protected Membro(String nome, String cpf, String rg, String email, String telefone, String cargo, String diretoria,
			String curso, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.telefone = telefone;
		this.cargo = cargo;
		this.diretoria = diretoria;
		this.curso = curso;
		this.dataNascimento = dataNascimento;
	}

	// Getters
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCargo() {
		return cargo;
	}

	public String getDiretoria() {
		return diretoria;
	}

	public String getCurso() {
		return curso;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	// Método de validação dos campos com feedback detalhado
	public List<String> validarCampos() {
		List<String> erros = new ArrayList<>();

		if (nome == null || nome.isEmpty()) {
			erros.add("Nome não pode ser vazio.");
		}
		if (cpf == null || cpf.isEmpty() || !cpf.matches("\\d{11}")) {
			erros.add("CPF inválido ou vazio.");
		}
		if (rg == null || rg.isEmpty()) {
			erros.add("RG não pode ser vazio.");
		}
		if (email == null || email.isEmpty() || !email.contains("@")) {
			erros.add("Email inválido.");
		}
		if (telefone == null || telefone.isEmpty() || !telefone.matches("\\d+")) {
			erros.add("Telefone inválido.");
		}
		if (cargo == null || cargo.isEmpty()) {
			erros.add("Cargo não pode ser vazio.");
		}
		if (diretoria == null || diretoria.isEmpty()) {
			erros.add("Diretoria não pode ser vazia.");
		}
		if (curso == null || curso.isEmpty()) {
			erros.add("Curso não pode ser vazio.");
		}
		if (dataNascimento == null) {
			erros.add("Data de Nascimento não pode ser vazia.");
		}

		return erros;
	}

	// Método para exibir os detalhes do membro
	public void printaMembro() {
		System.out.println("Nome: " + this.nome);
		System.out.println("CPF: " + this.cpf);
		System.out.println("RG: " + this.rg);
		System.out.println("Email: " + this.email);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("Cargo: " + this.cargo);
		System.out.println("Diretoria: " + this.diretoria);
		System.out.println("Cargo: " + this.cargo);
		System.out.println("Diretoria: " + this.diretoria);
		System.out.println("Curso: " + this.curso);
		System.out.println("Data de Nascimento: " + this.dataNascimento);
	}

	// Método para acessar o construtor através do MembroBuilder
	public static MembroBuilder builder() {
		return new MembroBuilder();
	}
}
