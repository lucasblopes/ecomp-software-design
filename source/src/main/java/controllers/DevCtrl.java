
package controllers;

import java.util.Optional;
import repositories.*;
import models.*;
import views.*;

public class DevCtrl {

    private final DevView           view;
    private final ProjectRepository projRepo;
    private final MemberRepository  memberRepo;
    private final DevRepository     devRepo;

    /*
     * DevCtrl()
     *
     * Initializes the controller with the required repositories and a
     * view.
     *
     * @projRepo: Repository to manage project data.
     * @memberRepo: Repository to manage member data.
     * @devRepo: Repository to manage developer data.
     */
    public DevCtrl(ProjectRepository projRepo, MemberRepository memberRepo, DevRepository devRepo) {
        this.view       = new DevView();
        this.projRepo   = projRepo;
        this.memberRepo = memberRepo;
        this.devRepo    = devRepo;
    }

    /*
     * manage()
     *
     * Displays the main screen for managing developers.  Depending on
     * the user input, it navigates to adding a developer to a project
     * or assigning an issue to a developer.
     */
    public void manage() {

        int option;
        this.view.showManageScreen();

        option = this.view.getInputInt();
        if(option == 1) {
            this.addDevToProject();
        } else {
            if(option == 2) {
                this.addIssueToDev();
            }
        }
    }

    /*
     * addDevToProject()
     *
     * Adds a developer (member) to a project. Ensures the project and
     * member exist and the member is not already a developer for the
     * project.
     *
     * @projName: Name of the project.
     * @memberName: Name of the member to be added as a developer.
     *
     * @throws IllegalArgumentException: If the project/member doesn't
     * exist or the member is already a developer.
     */
    private void addDevToProject(String projName, String memberName) throws IllegalArgumentException {

        boolean failed;

        Dev dev;
        Optional<Member> member;
        Optional<Project> proj;

        failed = true;
        proj = this.projRepo.findProject(projName);
        if(!proj.isEmpty()) {
            member = this.memberRepo.findMember(memberName);
            if(!member.isEmpty()) {
                /*
		         * If there's already a Dev, we don't need to add it
		         * again.  Otherwise, we create a new Dev object, save
		         * it to the repository, and link it to the project.
                 */
                if(this.devRepo.findDev(memberName).isEmpty()) {
                    dev = new Dev(member.get(), projName);
                    this.devRepo.addDev(dev);
                    proj.get().addDev(dev);
                    failed = false;
                }
            }
        }

        if(failed) {
            throw new IllegalArgumentException("Failed to add developer to project.");
        }
    }

    /*
     * addDevToProject()
     *
     * Orchestrates the addition of a developer to a project. This
     * method interacts with the user to collect the project name and
     * member name, then validates and attempts the operation.
     */
    private void addDevToProject() {

        String projName;
        String memberName;

        try {
            this.view.showAddDevToProjectScreen();
            memberName = this.view.getDevName();
            projName = this.view.getProjName();
            this.view.showConfirmation();
            this.addDevToProject(projName, memberName);

        } catch(IllegalArgumentException e) {
            this.view.showError(e.getMessage());
        }
    }

    /*
     * addIssueToDev()
     *
     * Assigns an issue to a developer. Ensures the developer exists
     * before adding the issue.
     *
     * @devName: Name of the developer.
     * @issue: Description of the issue to be added.
     * @hours: Number of hours allocated for the issue.
     *
     * @throws IllegalArgumentException: If the developer doesn't exist.
     */
    private void addIssueToDev(String devName, String issue, int hours) throws IllegalArgumentException {
        
        boolean failed;
        Optional<Dev> dev;

        failed = true;
        dev = this.devRepo.findDev(devName);
        if(!dev.isEmpty()) {
            dev.get().addIssue(issue, hours);
            failed = false;
        }

        if(failed) {
            throw new IllegalArgumentException("Failed to assign issue to developer.");
        }
    }

    /*
     * addIssueToDev()
     *
     * Orchestrates the process of assigning an issue to a developer.
     * It collects the necessary details from the user and performs
     * the operation.
     */
    private void addIssueToDev() {

        int hours;
        String devName;
        String issue;

        try {
            this.view.showAddIssueToDevScreen();
            devName = this.view.getDevName();
            issue = this.view.getIssue();
            hours = this.view.getHours();
            this.addIssueToDev(devName, issue, hours);

        } catch(IllegalArgumentException e) {
            this.view.showError(e.getMessage());
        }
    }
}
