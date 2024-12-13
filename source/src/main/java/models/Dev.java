package models;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Dev {

    private String proj;
    private final Member member;
    private Map<String, Integer> issues;

    public Dev(Member member, String proj) { 
        this.member = member;
        this.proj   = proj;
        this.issues = new HashMap<>();
    }

    public void addIssue(String issue, int hours) {
        issues.put(issue, hours);
    }

    public void setIssues(Map<String, Integer> issues) {
        this.issues = issues;
    }

    public Member getMember() {
        return this.member;
    }

    public Map<String, Integer> getIssues() {
        return this.issues;
    }
}
