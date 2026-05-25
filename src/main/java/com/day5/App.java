package com.day5;

import java.util.List;
import java.util.Scanner;

import com.day5.dao.BugDao;
import com.day5.dao.BugDaoImpl;
import com.day5.model.Bug;

public class App {

    static Scanner scanner = new Scanner(System.in);

    static BugDao bugDao = new BugDaoImpl();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== BUG TRACKER =====");

            System.out.println("1. Add Bug");
            System.out.println("2. View All Bugs");
            System.out.println("3. Update Bug Status");
            System.out.println("4. Delete Bug");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:
                    addBug();
                    break;

                case 2:
                    viewAllBugs();
                    break;

                case 3:
                    updateBugStatus();
                    break;

                case 4:
                    deleteBug();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // ADD BUG
    private static void addBug() {

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        Bug bug =
                new Bug(title, description, status);

        boolean result =
                bugDao.addBug(bug);

        if (result) {
            System.out.println(
                    "Bug Added Successfully"
            );
        } else {
            System.out.println(
                    "Failed to Add Bug"
            );
        }
    }

    // VIEW ALL BUGS
    private static void viewAllBugs() {

        List<Bug> bugList =
                bugDao.getAllBugs();

        if (bugList.isEmpty()) {

            System.out.println("No Bugs Found");

        } else {

            for (Bug bug : bugList) {
                System.out.println(bug);
            }
        }
    }

    // UPDATE BUG STATUS
    private static void updateBugStatus() {

        System.out.print("Enter Bug ID: ");

        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter New Status: ");

        String status = scanner.nextLine();

        boolean result =
                bugDao.updateBugStatus(id, status);

        if (result) {

            System.out.println(
                    "Bug Updated Successfully"
            );

        } else {

            System.out.println(
                    "Bug Not Found"
            );
        }
    }

    // DELETE BUG
    private static void deleteBug() {

        System.out.print("Enter Bug ID: ");

        int id = scanner.nextInt();

        boolean result =
                bugDao.deleteBug(id);

        if (result) {

            System.out.println(
                    "Bug Deleted Successfully"
            );

        } else {

            System.out.println(
                    "Bug Not Found"
            );
        }
    }
}