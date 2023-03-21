package farmacy.intergace;

import farmacy.Class.Madicine;
import farmacy.Class.Pharmacy;

import java.util.List;

public interface MedicineService {
    Madicine addMedicineToPharmacy(List<Pharmacy>pharmacies);
    Madicine findMedicineByName(List<Pharmacy>pharmacies);
    List<Madicine>getAllMedicine(List<Pharmacy>pharmacies);
    void deleteMedicine(List<Pharmacy>pharmacies);
}
