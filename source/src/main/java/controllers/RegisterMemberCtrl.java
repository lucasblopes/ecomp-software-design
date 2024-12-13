package controllers;

import models.Member;
import repositories.MemberRepository;
import views.RegisterMemberView;

import java.time.LocalDate;

public class RegisterMemberCtrl {

    private RegisterMemberView view;
    private MemberRepository memberRepo;

    public RegisterMemberCtrl(MemberRepository memberRepo) {
        this.view = new RegisterMemberView();
        this.memberRepo = memberRepo;
    }

    public void registerMember() {
        // Exibe a tela de cadastro de membro
        view.showMemberRegistrationScreen();

        view.showTitle();

        String name = view.getName();

        // Coletar o CPF do membro (serve como identificador)
        String cpf = view.getCPF();
        if (memberRepo.findMember(cpf).isPresent()) {
            view.showError("Já existe um membro com esse CPF '" + cpf + "'. Tente novamente com um CPF diferente.");
            return;
        }

        // Coletar dados do membro
        String rg = view.getRG();
        String email = view.getEmail();
        String phone = view.getPhone();
        String position = view.getPosition();
        String department = view.getDepartment();
        String course = view.getCourse();
        LocalDate birthDate = view.getBirthDate();

        view.showConfirmation();

        // Criação do Membro usando o Builder Pattern
        Member member = Member.builder()
            .name(name)
            .cpf(cpf)
            .rg(rg)
            .email(email)
            .phone(phone)
            .position(position)
            .department(department)
            .course(course)
            .birthDate(birthDate)
            .build();

        if (member == null) {
            view.showError("Membro " + name + " não foi cadastrado!");
            return;
        }

        // Adiciona o membro à lista
        memberRepo.addMember(member);

        view.showSuccess("Membro " + member.getName() + " cadastrado com sucesso!");
    }
}

