package controllers;

import views.RegisterActivityView;
import models.Activity;
import java.util.List;

public class RegisterActivityCtrl {

	// TODO: checar se o usuário está autenticado no sistema antes de registrar
	// atividade.
	public void registerActivity() {
		Activity activity = new Activity();
		RegisterActivityView view = new RegisterActivityView();

		view.showTitle();
		int durationMinutes = view.getDurationMinutes();
		String location = view.getLocation();
		List<String> participants = view.getParticipants();
		String goal = view.getGoal();
		String summary = view.getSummary();

		activity.setDurationMinutes(durationMinutes);
		activity.setLocation(location);
		activity.setParticipants(participants);
		activity.setGoal(goal);
		activity.setSummary(summary);

		view.showSuccess("Atividade cadastrada com sucesso!");
		view.showActivity(activity);
	}
}
