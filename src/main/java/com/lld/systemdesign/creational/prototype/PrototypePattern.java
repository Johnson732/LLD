package com.lld.systemdesign.creational.prototype;

/**
 * Prototype example
 */
public final class PrototypePattern {

    private PrototypePattern() {
    }

    public static void main(String[] args) {

        // Existing template profile
        EmployeeProfile developerTemplate =
                new EmployeeProfile(
                        "Engineering",
                        "Software Engineer",
                        "STANDARD");

        // Clone instead of creating from scratch
        EmployeeProfile seniorDeveloper =
                developerTemplate.clone();

        seniorDeveloper.setRole("Senior Software Engineer");
        seniorDeveloper.setAccessLevel("ELEVATED");

        System.out.println("Template:");
        System.out.println(developerTemplate);

        System.out.println();

        System.out.println("Cloned Profile:");
        System.out.println(seniorDeveloper);
    }
}