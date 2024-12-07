package views;

import java.util.*;

import models.Activity;

public class RegisterActivityView extends GenericView {

    public RegisterActivityView() {
        super();
    }

    @Override
    public void showTitle() {
        System.out.println("=== Cadaster Nova Atividade ===");
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

	// TODO: checar se é membro da equipe antes de adicionar.
	public List<String> getParticipants() {
		List<String> participants = new ArrayList<>();
        System.out.println("Insira o nome dos participantes (deixe em branco para terminar):");

        while (true) {
            System.out.print("Participante: ");
            String participant = getInput();

            // Verifica se a entrada está vazia (para parar o loop)
            if (participant.trim().isEmpty()) {
                break;
            }

            participants.add(participant);
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

	public void showActivity(Activity activity) {
		System.out.println(activity.toString());
		view.showContinue();
	}
}

