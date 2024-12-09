package views;

import java.time.LocalDate;
import utils.DateUtil;

public class CadastrarMembroView extends GenericView {

  public CadastrarMembroView() {
    super();
  }

  // Exibe o menu para cadastrar o membro
  public void showCadastroMembroScreen() {
    this.showTitle();
    System.out.println("Nome: ");
    System.out.println("CPF: ");
    System.out.println("RG: ");
    System.out.println("Email: ");
    System.out.println("Telefone: ");
    System.out.println("Cargo: ");
    System.out.println("Diretoria: ");
    System.out.println("Curso: ");
    System.out.println("Data de Nascimento: ");
    continuar();
  }

  public String inputNome() {
    this.showTitle();
    System.out.print("Nome: ");
    String nome = getInput();
    while (nome == null || nome.isEmpty()) {
      showError("Nome não pode ser vazio.");
      System.out.print("Nome: ");
      nome = getInput();
    }
    return nome;
  }

  public String inputCpf() {
    System.out.print("CPF (somente números): ");
    String cpf = getInput();
    while (cpf == null || cpf.isEmpty() || !cpf.matches("\\d{11}")) {
      showError("CPF inválido ou vazio. Deve conter 11 dígitos.");
      System.out.print("CPF (somente números): ");
      cpf = getInput();
    }
    return cpf;
  }

  public String inputRg() {
    System.out.print("RG: ");
    String rg = getInput();
    while (rg == null || rg.isEmpty()) {
      showError("RG não pode ser vazio.");
      System.out.print("RG: ");
      rg = getInput();
    }
    return rg;
  }

  public String inputEmail() {
    System.out.print("Email: ");
    String email = getInput();
    while (email == null || email.isEmpty() || !email.contains("@")) {
      showError("Email inválido ou vazio.");
      System.out.print("Email: ");
      email = getInput();
    }
    return email;
  }

  public String inputTelefone() {
    System.out.print("Telefone (somente números): ");
    String telefone = getInput();
    while (telefone == null || telefone.isEmpty() || !telefone.matches("\\d+")) {
      showError("Telefone inválido. Deve conter apenas números.");
      System.out.print("Telefone (somente números): ");
      telefone = getInput();
    }
    return telefone;
  }

  public String inputCargo() {
    System.out.print("Cargo: ");
    String cargo = getInput();
    while (cargo == null || cargo.isEmpty()) {
      showError("Cargo não pode ser vazio.");
      System.out.print("Cargo: ");
      cargo = getInput();
    }
    return cargo;
  }

  public String inputDiretoria() {
    System.out.print("Diretoria: ");
    String diretoria = getInput();
    while (diretoria == null || diretoria.isEmpty()) {
      showError("Diretoria não pode ser vazia.");
      System.out.print("Diretoria: ");
      diretoria = getInput();
    }
    return diretoria;
  }

  public String inputCurso() {
    System.out.print("Curso: ");
    String curso = getInput();
    while (curso == null || curso.isEmpty()) {
      showError("Curso não pode ser vazio.");
      System.out.print("Curso: ");
      curso = getInput();
    }
    return curso;
  }

  public LocalDate inputDataNascimento() {
    System.out.print("Data de Nascimento (dd/MM/yyyy): ");
    String data = getInput();
    LocalDate dataNascimento = null;
    while (dataNascimento == null) {
      try {
        dataNascimento = DateUtil.parseDate(data);
      } catch (IllegalArgumentException e) {
        showError(e.getMessage());
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        data = getInput();
      }
    }
    return dataNascimento;
  }

  @Override
  public void showTitle() {
    System.out.println("=== Cadastro de Membro ===");
  }
}
