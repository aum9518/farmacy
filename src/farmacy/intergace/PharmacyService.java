package farmacy.intergace;

import farmacy.Class.Pharmacy;

import java.util.List;

public interface PharmacyService {

    Pharmacy addPharmacy(List<Pharmacy> pharmacies);
    Pharmacy getPharmacyById(List<Pharmacy>pharmacies);
    List<Pharmacy>getAllPharmacy(List<Pharmacy>pharmacies);
    Pharmacy getPharmacyByAddress(List<Pharmacy>pharmacies);
    Pharmacy updatePharmacyName(List<Pharmacy>pharmacies);
    void deletePharmacyById(List<Pharmacy>pharmacies);

}
