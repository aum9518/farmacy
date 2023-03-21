package farmacy.intergace;

import farmacy.Class.Person;
import farmacy.Class.Pharmacy;

import java.util.List;

public interface PersonService {
    Person addPersonToPharmacy(List<Pharmacy>pharmacies);
    Person findPersonById(List<Pharmacy>pharmacies);
    List<Person>getAllPharmacyStaff(List<Pharmacy>pharmacies);
    Person updatePersonFromPharmacy(List<Pharmacy>pharmacies);


}
