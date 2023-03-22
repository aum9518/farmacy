package farmacy.intergace.impl;

import farmacy.Class.Madicine;
import farmacy.Class.Pharmacy;
import farmacy.exception.MyException;
import farmacy.intergace.MedicineService;

import java.util.List;
import java.util.Scanner;

public class MadiceineServiceImpl implements MedicineService {

    @Override
    public Madicine addMedicineToPharmacy(List<Pharmacy> pharmacies) {
        boolean isTrue = true;
        Madicine madicine =  new Madicine();
        System.out.println("Enter pharmacy id: ");
        int pharmacyId = new Scanner(System.in).nextInt();
        for (Pharmacy a:pharmacies) {
            if (a.getId()==pharmacyId){
                isTrue = true;
                System.out.println("Enter medicine name: ");
                String name = new Scanner(System.in).nextLine();
                madicine.setName(name);
                System.out.println("Enter medicine price: ");
                int price = new Scanner(System.in).nextInt();
                madicine.setPrice(price);
                madicine.setId(a.getMadicines().size()+1);
                a.getMadicines().add(madicine);
                return madicine;

            }else {
                isTrue=false;
            }
        }
        try {
            if (!isTrue){
                throw new MyException("Not found pharmacy");

            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Madicine findMedicineByName(List<Pharmacy> pharmacies) {
        boolean isTrue = true;
        boolean isTrue1 = true;
        System.out.println("Enter pharmacy id: ");
        int pharmacyId = new Scanner(System.in).nextInt();
        for (Pharmacy a :pharmacies) {
            if (a.getId()==pharmacyId){
                isTrue=true;
                for (Madicine b:a.getMadicines()) {
                    System.out.println("Enter medicine name: ");
                    String name = new Scanner(System.in).nextLine();
                    if (b.getName().equalsIgnoreCase(name)){
                        isTrue1 = true;
                        return b;
                    }else {
                        isTrue1 = false;
                    }
                }
            }else {
                isTrue=false;
            }
        }
        try {
            if (!isTrue){
                throw new MyException("Not found pharmacy");
            }
            if (!isTrue1){
                throw new MyException("Not found medicine");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Madicine> getAllMedicine(List<Pharmacy> pharmacies) {
        return null;
    }

    @Override
    public void deleteMedicine(List<Pharmacy> pharmacies) {

    }
}
