package zad1;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class FileOperator implements IFileOperator{

    private final String PATIENTS_FILE_NAME = "patients.txt";
    private final String VISITS_FILE_NAME = "visits.txt";
    private final String SEPARATOR = ";";

    public void savePatientsToFile(Map<Integer,Patient> patientMap){

        try {
            FileWriter fileWriter = new FileWriter(PATIENTS_FILE_NAME,false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(Patient patient:patientMap.values()){

                printWriter.println(toLine(patient));
            }
            fileWriter.close();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveVisitsToFile(Map<Integer,Visit> visitMap){
        try {
            FileWriter fileWriter = new FileWriter(VISITS_FILE_NAME,false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(Visit visit:visitMap.values()){

                printWriter.println(toLine(visit));
            }

            fileWriter.close();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toLine(Visit visit) {

        String result = "";
        result += visit.getId() + SEPARATOR;
        result += visit.getPatient().getId() + SEPARATOR;
        result += visit.getDate() + SEPARATOR;
        result += visit.getDoctorsName() + SEPARATOR;
        result += visit.getPrice();
        return result;
    }


    private String toLine(Patient patient){

        String result = "";
        result += patient.getId() + SEPARATOR;
        result += patient.getFirstName() + SEPARATOR;
        result += patient.getLastName() + SEPARATOR;
        result += patient.getBirthDate() + SEPARATOR;
        result += patient.getGender() + SEPARATOR;
        result += patient.getNumberOfVisits();
        return result;
    }
    public Map<Integer,Visit> getAllVisits(){
        return null;
    }

    public Map<Integer,Patient> getAllPatients(){

        File file=new File(PATIENTS_FILE_NAME);
        Scanner sc= null;
        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
