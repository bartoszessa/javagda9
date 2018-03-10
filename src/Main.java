import zad1.*;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        RegistrationDesk registrationDesk = new RegistrationDesk();

        Patient patient = new Patient();

        patient.setBirthDate("1993-02-09");
        patient.setGender(Gender.MALE);
        patient.setId(1);
        patient.setFirstName("Johnny");
        patient.setLastName("Cash");
        Patient patient2 = new Patient();
        patient2.setBirthDate("1967-02-08");
        patient2.setGender(Gender.FEMALE);
        patient2.setId(2);
        patient2.setFirstName("Elisabeth");
        patient2.setLastName("Swan");

        registrationDesk.addPatient(patient);
        registrationDesk.addPatient(patient2);

        Optional<Patient> patientOptional = registrationDesk.getPatient(2);
        if(patientOptional.isPresent()){
            Patient patientFromOptional = patientOptional.get();
            System.out.println(patientFromOptional);
        }

        Visit visit = new Visit();
        visit.setDate("2015-12-01");
        visit.setId(1);
        visit.setDoctorsName("drHouse");
        visit.setPrice(100.0);
        visit.setPatient(patient);

        Visit visit2 = new Visit();
        visit2.setDate("2016-12-01");
        visit2.setId(2);
        visit2.setDoctorsName("drHouse");
        visit2.setPrice(100.0);
        visit2.setPatient(patient);

        Visit visit3 = new Visit();
        visit3.setDate("2016-12-01");
        visit3.setId(3);
        visit3.setDoctorsName("drHouse");
        visit3.setPrice(100.0);
        visit3.setPatient(patient2);

        registrationDesk.register(visit);
        registrationDesk.register(visit2);
        registrationDesk.register(visit3);

    }
}
