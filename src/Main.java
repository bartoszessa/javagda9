import zad1.Gender;
import zad1.Patient;
import zad1.RegistrationDesk;
import zad1.Visit;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
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


    }
}
