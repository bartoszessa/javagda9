package zad1;

import java.util.Map;

public interface IFileOperator {

    void savePatientsToFile(Map<Integer,Patient> patientMap);

    void saveVisitsToFile(Map<Integer,Visit> visitMap);

    Map<Integer,Patient> getAllPatients();

    Map<Integer,Visit> getAllVisits();
}
