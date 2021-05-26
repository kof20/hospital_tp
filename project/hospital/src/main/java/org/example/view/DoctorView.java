package org.example.view;

import org.example.controller.DoctorController;
import org.example.controller.PatientController;
import org.example.entity.Doctor;
import org.example.entity.Patient;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DoctorView {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);
    private Scanner scanner2 = new Scanner(System.in);
    private Scanner scanner3 = new Scanner(System.in);
    private Scanner scanner4 = new Scanner(System.in);
    private DoctorController doctorController = new DoctorController();


    public void printDoctor() throws SQLException {
        List<Doctor> doctors = doctorController.getAllDoctors();
        System.out.println("List of all doctors : ");
        doctors.forEach(doctor1 -> System.out.println(doctor1.toString()));
    }

    public void deleteDoctor() throws SQLException {
        System.out.println("Enter id in order to delete row : ");
        Long id = Long.parseLong(scanner.next());
        doctorController.deleteDoctor(id);
    }

    public void getByIdDoctor() throws SQLException {
        System.out.println("Enter id to get patient :");
        Long id = Long.parseLong(scanner.next());
        try {
            if (doctorController.getDoctorById(id) != null) {
                System.out.println(doctorController.getDoctorById(id).toString());
            } else {
                System.out.println("This id is doesn't exist");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdDoctor();
        }
    }

    public void saveDoctor() throws SQLException {
        try {
            Doctor newDoctor = new Doctor();

            System.out.println("Enter name :");
            String name = scanner1.nextLine();
            newDoctor.setName(name);

            doctorController.saveDoctor(newDoctor);
        } catch (InputMismatchException | SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateDoctor() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(scanner2.next());


            Doctor newDoctor = new Doctor();
            newDoctor = doctorController.getDoctorById(id);

            System.out.println("Enter name :");
            String name = scanner1.nextLine();
            newDoctor.setName(name);


            doctorController.editDoctor(newDoctor);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void run() throws SQLException {
        boolean go = true;
        while (go) {
            System.out.println("\n Choose option, please :");
            System.out.println(" Enter number : ");
            System.out.println(" 1. Show all rows");
            System.out.println(" 2. Insert new row");
            System.out.println(" 3. Delete row ");
            System.out.println(" 4. Update row  ");
            System.out.println(" 5. Search by id ");
            System.out.println(" 6. End ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printDoctor();
                    break;
                case 2:
                    saveDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    updateDoctor();
                    break;
                case 5:
                    getByIdDoctor();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number");
                    System.out.println("Enter number from 1 to 6, please");
            }
        }
    }
}
