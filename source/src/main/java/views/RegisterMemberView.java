package views;

import java.time.LocalDate;
import utils.DateUtil;

public class RegisterMemberView extends GenericView {
	public RegisterMemberView() {
		super();
	}

	// Exibe o menu para cadastrar o membro
	public void showMemberRegistrationScreen() {
		showTitle();
		System.out.println("Nome: ");
		System.out.println("CPF: ");
		System.out.println("RG: ");
		System.out.println("Email: ");
		System.out.println("Telefone: ");
		System.out.println("Cargo: ");
		System.out.println("Diretoria: ");
		System.out.println("Curso: ");
		System.out.println("Data de Nascimento: ");
		showContinue();
	}

	public String getName() {
		System.out.print("Nome: ");
		String name = getInput();
		while (name == null || name.isEmpty()) {
			showError("Nome não pode ser vazio.");
			System.out.print("Nome: ");
			name = getInput();
		}
		return name;
	}

	public String getCPF() {
		System.out.print("CPF (somente números): ");
		String cpf = getInput();
		while (cpf == null || cpf.isEmpty() || !cpf.matches("\\d{11}")) {
			showError("CPF inválido ou vazio. Deve conter 11 dígitos.");
			System.out.print("CPF (somente números): ");
			cpf = getInput();
		}
		return cpf;
	}

	public String getRG() {
		System.out.print("RG: ");
		String rg = getInput();
		while (rg == null || rg.isEmpty()) {
			showError("RG não pode ser vazio.");
			System.out.print("RG: ");
			rg = getInput();
		}
		return rg;
	}

	public String getEmail() {
		System.out.print("Email: ");
		String email = getInput();
		while (email == null || email.isEmpty() || !email.contains("@")) {
			showError("Email inválido ou vazio.");
			System.out.print("Email: ");
			email = getInput();
		}
		return email;
	}

	public String getPhone() {
		System.out.print("Telefone (somente números): ");
		String phone = getInput();
		while (phone == null || phone.isEmpty() || !phone.matches("\\d+")) {
			showError("Telefone inválido. Deve conter apenas números.");
			System.out.print("Telefone (somente números): ");
			phone = getInput();
		}
		return phone;
	}

	public String getPosition() {
		System.out.print("Cargo: ");
		String position = getInput();
		while (position == null || position.isEmpty()) {
			showError("Cargo não pode ser vazio.");
			System.out.print("Cargo: ");
			position = getInput();
		}
		return position;
	}

	public String getDepartment() {
		System.out.print("Diretoria: ");
		String department = getInput();
		while (department == null || department.isEmpty()) {
			showError("Diretoria não pode ser vazia.");
			System.out.print("Diretoria: ");
			department = getInput();
		}
		return department;
	}

	public String getCourse() {
		System.out.print("Curso: ");
		String course = getInput();
		while (course == null || course.isEmpty()) {
			showError("Curso não pode ser vazio.");
			System.out.print("Curso: ");
			course = getInput();
		}
		return course;
	}
	
	public LocalDate getBirthDate() {
		System.out.print("Data de Nascimento (dd/MM/yyyy): ");
		String data = getInput();
		LocalDate birthDate = null;
		while (birthDate == null) {
			try {
				birthDate = DateUtil.parseDate(data);
			} catch (IllegalArgumentException e) {
				showError(e.getMessage());
				System.out.print("Data de Nascimento (dd/MM/yyyy): ");
				data = getInput();
			}
		}
		return birthDate;
	}

	public void showTitle() {
		System.out.println("=== Cadastro de Membro ===");
	}
}
