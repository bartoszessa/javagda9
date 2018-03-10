package zad1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FileOperator {

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

    public void saveVisitsToFile(Map<Integer,Visit> visitMap){
        try {
            FileWriter fileWriter = new FileWriter(VISITS_FILE_NAME);
            PrintWriter printWriter = new PrintWriter(fileWriter);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer,Visit> getAllVisits(){
        return null;
    }

    public Map<Integer,Visit> getAllPatients(){
        return null;
    }

}
