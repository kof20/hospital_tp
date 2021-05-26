package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class MainView {

    private PatientView patientView;
    private DoctorView doctorView;
    private static MainView mainView;

    public MainView() {
        patientView = new PatientView();
        doctorView = new DoctorView();
    }


    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;
    }

    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nChoose file to do operations , please :");
            System.out.println("Enter number : ");
            System.out.println("1.Patient");
            System.out.println("2.Doctor");
            System.out.println("3. End ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runPatient();
                    break;
                case 2:
                    runDoctor();
                    break;
                case 3:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number");
                    System.out.println("Enter number from 1 to 3, please");
            }
        }
    }

    public void runPatient() throws SQLException {
        patientView.run();
    }

    public void runDoctor() throws SQLException {
        doctorView.run();
    }

}
