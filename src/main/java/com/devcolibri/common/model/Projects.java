package com.devcolibri.common.model;

/**
 * Created by s on 24.11.16.
 */
public class Projects {
    private int projectId;
    private String projectName;
    private String projectDescription;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Projects projects = (Projects) o;

        if (projectId != projects.projectId) return false;
        if (projectName != null ? !projectName.equals(projects.projectName) : projects.projectName != null)
            return false;
        if (projectDescription != null ? !projectDescription.equals(projects.projectDescription) : projects.projectDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectId;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (projectDescription != null ? projectDescription.hashCode() : 0);
        return result;
    }
}
