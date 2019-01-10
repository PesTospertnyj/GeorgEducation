package com;

import com.model.Employee;
import com.service.Crud;
import com.service.EmployeeService;
import com.util.JPAUtility;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.util.JPAUtility");
        Scanner scanner = new Scanner(System.in);
        Crud<Employee> service = new EmployeeService();
        Employee employee;
        String choice, empId;
        boolean isLoop = true;
        Integer iEmpId = null;

        while (isLoop) {

            System.out.println("1 - Add employee");
            System.out.println("2 - find employee");
            System.out.println("3 - update employee");
            System.out.println("4 - delete employee");
            System.out.println("5 - list of all employees");
            System.out.println("6 - quit");
            choice = scanner.nextLine();

            switch (choice) {

                case "3":
                    System.out.println("Enter id of employee (must be integer)");
                    empId = scanner.nextLine();
                    try {
                        iEmpId = Integer.valueOf(empId.trim());
                    } catch (NumberFormatException e) {
                        System.out.println("incorrect input");
                        break;
                    }

                case "1":
                    System.out.println("Enter name, last name and age of employee (space separated)");
                    String[] sEmployee = scanner.nextLine().split(" ");
                    if (sEmployee.length != 3) {
                        System.out.println("incorrect input");
                        break;
                    } else {
                        try {
                            Integer age = Integer.valueOf(sEmployee[2]);
                            if (choice.equals("1")) {
                                employee = service.create(new Employee(sEmployee[0], sEmployee[1], age));
                                System.out.println("new employee added: " + employee);
                            } else {
                                employee = service.update(new Employee(iEmpId, sEmployee[0], sEmployee[1], age));
                                System.out.println("employee updated: " + employee);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("incorrect input");
                        }
                    }
                    break;

                case "2":
                    System.out.println("Enter id to look up (must be integer)");
                    empId = scanner.nextLine();
                    try {
                        iEmpId = Integer.valueOf(empId.trim());
                        employee = service.read(iEmpId);
                        System.out.println("employee with id #"+iEmpId+" - "+employee);
                    } catch (NumberFormatException e) {
                        System.out.println("incorrect input");
                    }
                    break;

                case "4":
                    System.out.println("Enter id to remove (must be integer)");
                    empId = scanner.nextLine();
                    try {
                        iEmpId = Integer.valueOf(empId.trim());
                        service.remove(new Employee(iEmpId));
                        System.out.println("employee with id #"+iEmpId+" removed");
                    } catch (NumberFormatException e) {
                        System.out.println("incorrect input");
                    }
                    break;

                case "5":
                    service.getAll().forEach(System.out::println);
                    break;

                case "6":
                    isLoop = false;
                    break;
            }
        }

        JPAUtility.close();

    }
}

