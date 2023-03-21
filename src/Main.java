import farmacy.Class.Person;
import farmacy.Class.Pharmacy;
import farmacy.intergace.impl.MadiceineServiceImpl;
import farmacy.intergace.impl.PersonServiceImpl;
import farmacy.intergace.impl.PharmacyServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Pharmacy> pharmacies = new ArrayList<>();

        PersonServiceImpl personService = new PersonServiceImpl();
        MadiceineServiceImpl medicine = new MadiceineServiceImpl();
        while (true) {
            System.out.println("Choose command");
            PharmacyServiceImpl pharmacy = new PharmacyServiceImpl();
            System.out.println("""   
                    1.Add pharmasy
                    2.Get pharmacy by id
                    3.Update pharmacy by name
                    4.Get all pharmasy
                    5.Get pharmacy  by address
                    6.Delete pharamacy by id
                    7.Add stuff to pharmacy
                    8.Find staff by id
                    9.Update staff from pharmacy
                    10.Get all staff
                    11.Add medicine to pharmacy
                    12.Find medicine by name
                    13.Get all medicine
                    14.Delete medicine 
                    """);
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1:
                    System.out.println(pharmacy.addPharmacy(pharmacies));
                    break;
                case 2:
                    System.out.println(pharmacy.getPharmacyById(pharmacies));
                    break;
                case 3:
                    System.out.println(pharmacy.updatePharmacyName(pharmacies));
                    break;
                case 4:
                    System.out.println(pharmacy.getAllPharmacy(pharmacies));
                    break;
                case 5:
                    System.out.println(pharmacy.getPharmacyByAddress(pharmacies));
                    break;
                case 6:
                    pharmacy.deletePharmacyById(pharmacies); break;
                case 7:
                    System.out.println(personService.addPersonToPharmacy(pharmacies));break;
                case 8:
                    System.out.println(personService.findPersonById(pharmacies));break;
                case 9:
                    System.out.println(personService.updatePersonFromPharmacy(pharmacies));break;
                case 10:
                    System.out.println(personService.getAllPharmacyStaff(pharmacies));break;
                case 11:
                    System.out.println(medicine.addMedicineToPharmacy(pharmacies));break;
                case 12:
                    System.out.println(medicine.findMedicineByName(pharmacies));break;
                case 13:
                    System.out.println(medicine.getAllMedicine(pharmacies));break;
                case 14:
                    medicine.deleteMedicine(pharmacies);break;

                default:
                    System.out.println("Error"); break;
            }
        }
    }
}