package zad1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileOperator implements IFileOperator{

    private final String FILEPATH = "src/zad1/db/";
    private final String PATIENTS_FILE_NAME = FILEPATH+"patients.txt";
    private final String VISITS_FILE_NAME = FILEPATH+"visits.txt";
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


        Map<Integer,Visit> visitMap = new HashMap<>();
        File file=new File(VISITS_FILE_NAME);
        Scanner sc= null;
        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                Visit visit = parseToVisit(line);
                visitMap.put(visit.getId(),visit);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return visitMap;
    }

    private Visit parseToVisit(String line) {
        String[] splits = line.split(SEPARATOR);
        Visit visit = new Visit();
        visit.setId(Integer.parseInt(splits[0]));
        Patient patient = getAllPatients().get(Integer.parseInt(splits[1]));
        visit.setPatient(patient);
        visit.setDate(splits[2]);
        visit.setDoctorsName(splits[3]);
        visit.setPrice(Double.parseDouble(splits[4]));

        return visit;
    }

    public Map<Integer,Patient> getAllPatients(){

        Map<Integer,Patient> patientMap = new HashMap<>();
        File file=new File(PATIENTS_FILE_NAME);
        Scanner sc= null;
        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                Patient patient = parseToPatient(line);
                patientMap.put(patient.getId(),patient);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return patientMap;
    }

    private Patient parseToPatient(String line) {
        String[] splits = line.split(SEPARATOR);
        Patient patient = new Patient();
        patient.setId(Integer.parseInt(splits[0]));
        patient.setFirstName(splits[1]);
        patient.setLastName(splits[2]);
        patient.setBirthDate(splits[3]);
        patient.setGender(Gender.valueOf(splits[4]));
        patient.setNumberOfVisits(Integer.parseInt(splits[5]));
        return patient;
    }

}
