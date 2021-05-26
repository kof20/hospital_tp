package org.example.view;

import org.example.controller.PatientController;
import org.example.entity.Patient;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PatientView {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);
    private Scanner scanner2 = new Scanner(System.in);
    private Scanner scanner3 = new Scanner(System.in);
    private Scanner scanner4 = new Scanner(System.in);
    private PatientController patientController = new PatientController();


    public void printPatient() throws SQLException {
        List<Patient> patients = patientController.getAllPatients();
        System.out.println("List of all patients : ");
        patients.forEach(patient1 -> System.out.println(patient1.toString()));
    }

    public void deletePatient() throws SQLException {
        System.out.println("Enter id in order to delete row : ");
        Long id = Long.parseLong(scanner.next());
        patientController.deletePatient(id);
    }

    public void getByIdPatient() throws SQLException {
        System.out.println("Enter id to get patient :");
        Long id = Long.parseLong(scanner.next());
        try {
            if (patientController.getPatientById(id) != null) {
                System.out.println(patientController.getPatientById(id).toString());
            } else {
                System.out.println("This id is doesn't exist");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdPatient();
        }
    }

    public void savePatient() throws SQLException {
        try {
            Patient newPatient = new Patient();

            System.out.println("Enter name :");
            String name = scanner1.nextLine();
            newPatient.setName(name);

            System.out.println("Enter surname :");
            String surname = scanner1.nextLine();
            newPatient.setSurname(surname);

            System.out.println("Enter date of birthday :");
            String dateOfBirth = scanner1.nextLine();
            newPatient.setDateOfBirth(dateOfBirth);

            System.out.println("Enter telephone :");
            String telephone = scanner1.nextLine();
            newPatient.setTelephone(telephone);

            patientController.savePatient(newPatient);
        } catch (InputMismatchException | SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updatePatient() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(scanner2.next());

            Patient newPatient = new Patient();
            newPatient = patientController.getPatientById(id);

            System.out.println("Enter name :");
            String name = scanner3.nextLine();
            newPatient.setName(name);

            System.out.println("Enter surname :");
            String surname = scanner3.nextLine();
            newPatient.setSurname(surname);

            System.out.println("Enter date of birthday :");
            String dateOfBirth = scanner3.nextLine();
            newPatient.setDateOfBirth(dateOfBirth);

            System.out.println("Enter telephone :");
            String telephone = scanner3.nextLine();
            newPatient.setTelephone(telephone);

            patientController.editPatient(newPatient);
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
                    printPatient();
                    break;
                case 2:
                    savePatient();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    updatePatient();
                    break;
                case 5:
                    getByIdPatient();
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

