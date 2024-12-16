package views;

import java.util.*;
import models.Activity;
import repositories.MemberRepository;

public class RegisterActivityView extends GenericView {

    public RegisterActivityView() {
        super();
    }

    public void showTitle() {
        System.out.println("=== Cadastrar Nova Atividade ===");
    }

	public String getName() {
		System.out.print("Nome: ");
		return getInput();
	}

	public int getDurationMinutes() {
		int durationMinutes;

		while (true) {
			System.out.print("Duração (em minutos): ");
			durationMinutes = getInputInt();
			if (durationMinutes > 0) {
				break;
			}
		}
		return durationMinutes;
	}

	public String getLocation() {
        System.out.print("Localização: ");
		return getInput();
	}

	public List<String> getParticipants(MemberRepository memberRepo) {
		List<String> participants = new ArrayList<>();
		String name;

        System.out.println("Insira o nome dos participantes (deixe em branco para terminar):");
        while (true) {
            System.out.print("Participante: ");
            name = getInput();

            if (name.trim().isEmpty()) {
				break;
            }

			if (memberRepo.findMember(name).isPresent()) {
				participants.add(name);
			} else {
				showError(String.format("'%s' não é um membro da equipe.", name));
			}
        }

        return participants;
	}

	public String getGoal() {
        System.out.print("Objetivo: ");
		return getInput();
	}

	public String getSummary() {
        System.out.print("Resumo: ");
		return getInput();
	}

	public void printActivity(Activity activity) {
		System.out.println(activity.toString());
		showContinue();
	}
}
