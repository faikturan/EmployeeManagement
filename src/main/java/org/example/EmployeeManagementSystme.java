package org.example;

public class EmployeeManagementSystme {
    public static void main(String[] args) {
        MainMenu obj1 = new MainMenu();
        obj1.menu();

    }
}

/********************************** MENU OF EMS *****************************/

class MainMenu {
    public void menu() {
        System.out.println("\t\t*********************************");
        System.out.println("\t\tEMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("\t\t*********************************");
        System.out.println("\t\t\t ---------------------------");
        System.out.println("\t\t\t ~$ Faik Turan");
        System.out.println("\t\t\t ---------------------------");
        System.out.println("\n\nPress 1: To Add an Employee Details");
        System.out.println("Press 2: To See an Employee Details");
        System.out.println("Press 3: To Remove an Employee");
        System.out.println("Press 4: To Update an Employee");
        System.out.println("Press 5: Exit to EMS Portal");
    }
}

