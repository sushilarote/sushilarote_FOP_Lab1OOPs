package oopslabassignment01;


import java.util.Random;
import java.util.Scanner;

class Employee {
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = "";
        this.email = "";
        this.password = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayCredentials() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Department: " + department);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }
}

class CredentialService {
    private static final String COMPANY_DOMAIN = "abc.com";

    public static String generateEmailAddress(Employee employee) {
        String department = employee.getDepartment().toLowerCase();
        String email = employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() +
                "@" + department + "." + COMPANY_DOMAIN;
        return email;
    }

    public static String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public static void showCredentials(Employee employee) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to select a department
        System.out.println("Select a department:");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. HR");
        System.out.println("4. Legal");
        System.out.print("Enter the department number: ");
        int departmentChoice = scanner.nextInt();

        String department;
        switch (departmentChoice) {
            case 1:
                department = "Technical";
                break;
            case 2:
                department = "Admin";
                break;
            case 3:
                department = "HR";
                break;
            case 4:
                department = "Legal";
                break;
            default:
                System.out.println("Invalid department choice. Using default: Technical");
                department = "Technical";
                break;
        }

        employee.setDepartment(department);
        employee.setEmail(generateEmailAddress(employee));
        employee.setPassword(generatePassword());
        employee.displayCredentials();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        // Create a new employee with user-provided first name and last name
        Employee newHire = new Employee(firstName, lastName);

        // Generate and display credentials
        CredentialService.showCredentials(newHire);
    }
}


