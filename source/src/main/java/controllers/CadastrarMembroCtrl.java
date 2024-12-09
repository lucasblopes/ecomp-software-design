package controllers;

import models.Membro;
import repositories.MembroRepository;
import views.CadastrarMembroView;

import java.time.LocalDate;

public class CadastrarMembroCtrl {
	private CadastrarMembroView view;

	public CadastrarMembroCtrl() {
		this.view = new CadastrarMembroView();
	}

	public void cadastrarMembro(MembroRepository membros) {
		// Exibe a tela de cadastro de membro
		view.showCadastroMembroScreen();

		// Coletar titulo do membro (serve como identificador)
		String cpf = view.inputCpf();

		// Verifica se já existe um membro com o título fornecido
		if (membros.buscarMembro(cpf).isPresent()) {
			view.showError(
					"Já existe um membro com esse cpf '" + cpf + "'. Tente novamente com um cpf diferente.");
			return;
		}

		// Coletar dados do membro
		String nome = view.inputNome();
		String rg = view.inputRg();
		String email = view.inputEmail();
		String telefone = view.inputTelefone();
		String cargo = view.inputCargo();
		String diretoria = view.inputDiretoria();
		String curso = view.inputCurso();
		LocalDate dataNascimento = view.inputDataNascimento();

		view.confirmar();

		// Criação do Membro usando Builder Pattern
		Membro membro = Membro.builder()
			.nome(nome)
			.cpf(cpf)
			.rg(rg)
			.email(email)
			.telefone(telefone)
			.cargo(cargo)
			.diretoria(diretoria)
			.curso(curso)
			.dataNascimento(dataNascimento)
			.build();

		if (membro == null) {
			view.showError("Membro " + nome + " não foi cadastrado!");
			return;
		}

		// Adiciona o membro à lista
		membros.adicionarMembro(membro);

		view.showSuccess("Membro " + membro.getNome() + " cadastrado com sucesso!");
	}
}
