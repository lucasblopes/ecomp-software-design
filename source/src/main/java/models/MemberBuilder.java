package models;

import java.time.LocalDate;
import java.util.List;

public class MemberBuilder {
	private String name;
	private String cpf;
	private String rg;
	private String email;
	private String phone;
	private String position;
	private String department;
	private String course;
	private LocalDate birthDate;

	// Construtor padrão que pode inicializar os valores, se necessário
	public MemberBuilder() {
	}

	// Define o nome do membro
	public MemberBuilder name(String name) {
		this.name = name;
		return this;
	}

	// Define o CPF do membro
	public MemberBuilder cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	// Define o RG do membro
	public MemberBuilder rg(String rg) {
		this.rg = rg;
		return this;
	}

	// Define o email do membro
	public MemberBuilder email(String email) {
		this.email = email;
		return this;
	}

	// Define o telefone do membro
	public MemberBuilder phone(String phone) {
		this.phone = phone;
		return this;
	}

	// Define o cargo do membro
	public MemberBuilder position(String position) {
		this.position = position;
		return this;
	}

	// Define a diretoria do membro
	public MemberBuilder department(String department) {
		this.department = department;
		return this;
	}

	// Define o curso do membro
	public MemberBuilder course(String course) {
		this.course = course;
		return this;
	}

	// Define a data de nascimento do membro
	public MemberBuilder birthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	// Método para construir o objeto Member
	public Member build() {
		Member member = new Member(name, cpf, rg, email, phone, position, department, course, birthDate);

		// Valida os campos do membro
		List<String> errors = member.validateFields();
		if (!errors.isEmpty()) {
			System.out.println("Erro de validação: " + String.join(", ", errors));
			return null;
		}

		return member;
	}
}

