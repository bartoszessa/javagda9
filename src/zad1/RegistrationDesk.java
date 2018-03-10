package zad1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RegistrationDesk {

    private Map<Integer,Visit> visits = new HashMap<>();
    private Map<Integer,Patient> patients = new HashMap<>();

    public int addPatient(Patient patient){
        patients.put(patient.getId(),patient);
        return patient.getId();
    }
    public Optional<Patient> getPatient(int id){
        Patient patient=patients.get(id);
        if(patient==null) return Optional.empty();
        else return Optional.of(patient);
    }

    public int register(Visit visit){
        visits.put(visit.getId(),visit);
        return visit.getId();
    }

    public Optional<Visit> getVisit(int id){
        Visit visit =visits.get(id);
        if(visit==null) return Optional.empty();
        else return Optional.of(visit);
    }
}
