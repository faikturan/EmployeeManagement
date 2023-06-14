package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


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

/************************* To add details of Employee ****************/

class EmployeeAdd {

    public void createFile() {
        Scanner sc = new Scanner(System.in);

        EmployeeDetail emp = new EmployeeDetail();
        emp.getInfo();
        try {
            File f1 = new File("file" + emp.employee_id + ".txt");
            if (f1.createNewFile()) {
                FileWriter myWriter =
                        new FileWriter("file" + emp.employee_id + ".txt");
                myWriter.write("Employee ID:" + emp.employee_id + "\n" +
                        "Employee Name:" + emp.name + "\n" +
                        "Father's Name:" + emp.father_name + "\n" +
                        "Employee Contact:" + emp.employee_contact + "\n" +
                        "Employee Email:" + emp.email + "\n" +
                        "Employee Position:" + emp.position + "\n" +
                        "Employee Age:" + emp.employee_age + "\n" +
                        "Employee Salary:" + emp.employee_salary);
                myWriter.close();
                System.out.println("\nEmployee has been Added :)\n");

                System.out.println("\nPress Enter to Contunie...");
                sc.nextLine();
            } else {
                System.out.println("\nEmployee already exists :(");
                System.out.println("\nPress Enter to Contunie...");
                sc.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


/************************ Taking Employee Details ************/

class EmployeeDetail {
    String name;
    String father_name;
    String email;
    String position;
    String employee_id;
    String employee_salary;
    String employee_contact;
    String employee_age;

    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee's name");
        name = sc.nextLine();
        System.out.println("Enter Employee's Father name");
        father_name = sc.nextLine();
        System.out.println("Enter Employee's ID");
        employee_id = sc.nextLine();
        System.out.println("Enter Employee's Email");
        email = sc.nextLine();
        System.out.println("Enter Employee's Position");
        position = sc.nextLine();
        System.out.println("Enter Employee's Salary");
        employee_salary = sc.nextLine();
        System.out.println("Enter Employee's Contact");
        employee_contact = sc.nextLine();
        System.out.println("Enter Employee's Age");
        employee_age = sc.nextLine();
    }
}

/****************** To Show details of Employee ************/

class Employee_Show
{
    public void viewFile(String s) throws Exception
    {
        File file = new File("file"+s+".txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
        {
            System.out.println(sc.nextLine());
        }
    }
}


/****************** To Remove Employee ************/
class Employee_Remove {
    public void removeFile(String ID) {
        File file = new File("file" + ID + ".txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("\nEmployee has been removed Successfully");
            }
        } else {
            System.out.println("\nEmployee does not exists :(");
        }
    }
}


/****************** To Update details of Employee ************/
class Employee_Update
{
    public void updateFile(String s,String o,String n) throws IOException
    {
        File file = new File("file"+s+".txt");
        Scanner sc = new Scanner(file);
        String fileContext="";
        while (sc.hasNextLine())
        {
            fileContext =fileContext+"\n"+sc.nextLine();
        }
        FileWriter myWriter = new FileWriter("file"+s+".txt");
        fileContext = fileContext.replaceAll(o,n);
        myWriter.write(fileContext);
        myWriter.close();
    }
}


/******************************** To Exit from EMS Portal ***************/
class CodeExit {
    public void out() {
        System.out.println("\n****************************");
        System.out.println("$ cat Thank You For Using my Software");
        System.out.println("*********************************");
        System.out.println("\t\t/~ <0d3d by Faik Turan\n");
        System.exit(0);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {

        /** To clear the output Screen **/
        System.out.println("\033[H\033[2J");

        Scanner sc = new Scanner(System.in);
        Employee_Show epv = new Employee_Show();

        int i = 0;

        /*** Calling MainMenu Class function ****/
        MainMenu obj1 = new MainMenu();
        obj1.menu();

        /*** Initializing loop for Menu Choices ****/
        while (i < 6) {

            System.out.println("\nPlease Enter choice :");
            i = Integer.parseInt(sc.nextLine());

            /**** Switch Case Statements ****/
            switch (i) {
                case 1: {
                    /*** Creating class's object and calling Function using that object ***/
                    EmployeeAdd ep = new EmployeeAdd();
                    ep.createFile();

                    System.out.println("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 2: {
                    System.out.println("\nPlease Enter Employee's ID");
                    String s = sc.nextLine();
                    try {
                        epv.viewFile(s);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("\nPress Enter to Contunie");
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 3: {
                    System.out.println("\nPlease Enter Employee's ID");
                    String s = sc.nextLine();
                    Employee_Remove epr = new Employee_Remove();
                    epr.removeFile(s);

                    System.out.println("\nPress Enter to Contunie");
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 4: {
                    System.out.println("\nPlease Enter Employee's ID");
                    String I = sc.nextLine();

                    try {
                        epv.viewFile(I);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    Employee_Update epu = new Employee_Update();
                    System.out.println("Please Enter the detil you want to Update :");
                    System.out.println("\nFor Example :\n");
                    System.out.println("If you want to change the name, then enter current name and press enter." +
                            "Then write the new name then pres enter. It will update the name.\n");
                    String s = sc.nextLine();
                    System.out.println("Please enter the updated info :");
                    String n = sc.nextLine();

                    try {
                        epu.updateFile(I, s, n);

                        System.out.println("\nPress Enter to Contunie");
                        sc.nextLine();
                        System.out.println("\033[H\033[2J");
                        obj1.menu();
                        break;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case 5: {
                    CodeExit obj = new CodeExit();
                    obj.out();
                }
            }
        }
    }
}
/**********************CODED BY FAİK TURAN *******************/