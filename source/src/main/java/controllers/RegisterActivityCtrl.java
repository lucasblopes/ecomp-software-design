package controllers;

import views.RegisterActivityView;
import repositories.MemberRepository;
import repositories.ActivityRepository;
import models.Activity;
import java.util.List;

public class RegisterActivityCtrl {

    private ActivityRepository activityRepo;
    private MemberRepository memberRepo;

    public RegisterActivityCtrl(ActivityRepository actRepo, MemberRepository memberRepo) {
        this.activityRepo = actRepo;
        this.memberRepo = memberRepo;
    }

	// TODO: checar se o usuário está autenticado no sistema antes de registrar
	// atividade.
	public void registerActivity() {
		Activity activity = new Activity();
		RegisterActivityView view = new RegisterActivityView();

		view.showTitle();
		int durationMinutes = view.getDurationMinutes();
		String location = view.getLocation();
		List<String> participants = view.getParticipants(memberRepo);
		String goal = view.getGoal();
		String summary = view.getSummary();

		activity.setDurationMinutes(durationMinutes);
		activity.setLocation(location);
		activity.setParticipants(participants);
		activity.setGoal(goal);
		activity.setSummary(summary);

		activityRepo.addActivity(activity);

		view.showTitle();
		view.showActivity(activity);
		view.showSuccess("Atividade cadastrada com sucesso!");
	}
}
