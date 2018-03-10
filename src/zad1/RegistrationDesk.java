package zad1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RegistrationDesk {

    private Map<Integer,Visit> visits = new HashMap<>();
    private Map<Integer,Patient> patients = new HashMap<>();
    private IFileOperator fileOperator = new FileOperator();

    public RegistrationDesk() {
        loadFromFiles();
    }

    public int addPatient(Patient patient){
        patient.setNumberOfVisits(0);
        patients.put(patient.getId(),patient);
        fileOperator.savePatientsToFile(patients);
        return patient.getId();
    }
    public Optional<Patient> getPatient(int id){
        Patient patient=patients.get(id);
        if(patient==null) return Optional.empty();
        else return Optional.of(patient);
    }

    public int register(Visit visit){
        visit.getPatient().setNumberOfVisits(visit.getPatient().getNumberOfVisits()+1);
        fileOperator.savePatientsToFile(patients);
        visits.put(visit.getId(),visit);
        fileOperator.saveVisitsToFile(visits);
        return visit.getId();
    }

    public Optional<Visit> getVisit(int id){
        Visit visit =visits.get(id);
        if(visit==null) return Optional.empty();
        else return Optional.of(visit);
    }

    private void loadFromFiles(){

        visits = fileOperator.getAllVisits();
        patients = fileOperator.getAllPatients();
    }
}
