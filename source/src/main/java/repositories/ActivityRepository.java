package repositories;

import java.util.*;
import models.Activity;

public class ActivityRepository {
    private List<Activity> activities;

    public ActivityRepository() {
        this.activities = new ArrayList<>();
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public Optional<Activity> findActivity(String name) {
    return activities.stream()
            .filter(p -> p.getName().equalsIgnoreCase(name))
            .findFirst();
    }
}
