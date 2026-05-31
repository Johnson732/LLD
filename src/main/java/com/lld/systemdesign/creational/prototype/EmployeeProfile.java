package com.lld.systemdesign.creational.prototype;

/**
 * Real-world idea:
 * HR systems often create employee profiles from existing templates.
 * Instead of building every profile from scratch, we clone a template
 * and customize only the required fields.
 */
public class EmployeeProfile implements Cloneable {

    private String department;
    private String role;
    private String accessLevel;

    public EmployeeProfile(String department,
                           String role,
                           String accessLevel) {
        this.department = department;
        this.role = role;
        this.accessLevel = accessLevel;
    }

    @Override
    public EmployeeProfile clone() {
        try {
            return (EmployeeProfile) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e);
        }
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "EmployeeProfile{" +
                "department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                '}';
    }
}