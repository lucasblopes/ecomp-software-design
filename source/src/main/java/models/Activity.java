package models;

import java.util.List;
import com.google.gson.Gson;

public class Activity {

    private int durationMinutes;
    private String location;
    private List<String> participants;
    private String goal;
    private String summary;

    public Activity() {
    }

    public Activity(int durationMinutes, String location, List<String> participants, String goal, String summary) {
        this.durationMinutes = durationMinutes;
        this.location = location;
        this.participants = participants;
        this.goal = goal;
        this.summary = summary;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
		return new Gson().toJson(this);
    }
}
