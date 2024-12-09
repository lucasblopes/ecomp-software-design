package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String cpf;
    private String rg;
    private String email;
    private String phone;
    private String position;
    private String department;
    private String course;
    private LocalDate birthDate;

    // Construtor protegido para instanciar apenas via builder
    protected Member(String name, String cpf, String rg, String email, String phone, String position, 
                     String department, String course, LocalDate birthDate) {
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.department = department;
        this.course = course;
        this.birthDate = birthDate;
    }

    // Getters
    public String getName() {
        return name;
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

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getCourse() {
        return course;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Método de validação dos campos com feedback detalhado
    public List<String> validateFields() {
        List<String> errors = new ArrayList<>();

        if (name == null || name.isEmpty()) {
            errors.add("Nome não pode ser vazio.");
        }
        if (cpf == null || cpf.isEmpty() || !cpf.matches("\\d{11}")) {
            errors.add("CPF inválido ou vazio.");
        }
        if (rg == null || rg.isEmpty()) {
            errors.add("RG não pode ser vazio.");
        }
        if (email == null || email.isEmpty() || !email.contains("@")) {
            errors.add("Email inválido.");
        }
        if (phone == null || phone.isEmpty() || !phone.matches("\\d+")) {
            errors.add("Telefone inválido.");
        }
        if (position == null || position.isEmpty()) {
            errors.add("Cargo não pode ser vazio.");
        }
        if (department == null || department.isEmpty()) {
            errors.add("Diretoria não pode ser vazia.");
        }
        if (course == null || course.isEmpty()) {
            errors.add("Curso não pode ser vazio.");
        }
        if (birthDate == null) {
            errors.add("Data de Nascimento não pode ser vazia.");
        }

        return errors;
    }

    // Método para exibir os detalhes do membro
    public void printMember() {
        System.out.println("Nome: " + this.name);
        System.out.println("CPF: " + this.cpf);
        System.out.println("RG: " + this.rg);
        System.out.println("Email: " + this.email);
        System.out.println("Telefone: " + this.phone);
        System.out.println("Cargo: " + this.position);
        System.out.println("Diretoria: " + this.department);
        System.out.println("Curso: " + this.course);
        System.out.println("Data de Nascimento: " + this.birthDate);
    }

    // Método para acessar o construtor através do MemberBuilder
    public static MemberBuilder builder() {
        return new MemberBuilder();
    }
}

