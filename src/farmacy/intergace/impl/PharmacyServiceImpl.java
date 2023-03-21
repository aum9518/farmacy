package farmacy.intergace.impl;

import farmacy.Class.Person;
import farmacy.Class.Pharmacy;
import farmacy.exception.MyException;
import farmacy.intergace.PharmacyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class PharmacyServiceImpl implements PharmacyService {
    private static int counter;
    List<Person>stuff=new ArrayList<>();
    List<Person> medicines = new ArrayList<>();
    @Override
    public Pharmacy addPharmacy(List<Pharmacy> pharmacies) {
        Pharmacy pharmacy = new Pharmacy();
        boolean isTrue = true;
        while (isTrue) {
            try {
                System.out.println("         *Welcome*");
                System.out.print("Enter pharmacy name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Enter pharmacy address: ");
                String address = new Scanner(System.in).nextLine();
                pharmacy.setName(name);
                pharmacy.setAddress(address);
                pharmacy.setPeople(new ArrayList<>());
                pharmacy.setMadicines(new ArrayList<>());
                if (!pharmacies.isEmpty()) {
                    for (Pharmacy p : pharmacies) {
                        if (p.getName().equalsIgnoreCase(name)) {
                            isTrue = false;
                            pharmacy.setId(++counter);
                            pharmacies.add(pharmacy);
                            throw new MyException("Same pharmacy name!");
                        } else {
                            pharmacy.setId(++counter);
                            pharmacies.add(pharmacy);
                            isTrue = false;
                            return pharmacy;
                        }
                    }
                } else {
                    pharmacy.setId(++counter);
                    pharmacy.setName(name);
                    pharmacy.setAddress(address);
                    pharmacies.add(pharmacy);
                    isTrue = false;
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        return pharmacy;
    }
    @Override
    public Pharmacy getPharmacyById(List<Pharmacy> pharmacies) {
        try{
        System.out.println("Enter pharmacy id: ");
        int id = new Scanner(System.in).nextInt();
        boolean isFalse = false;
        for (Pharmacy p: pharmacies) {
            if (p.getId()==id){
                isFalse = false;

                return p;
            }else {
                isFalse = true;
            }
        }
        if (!isFalse){
            throw new MyException("Pharmacy with id "+ id + " not found");
        }


    } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Pharmacy> getAllPharmacy(List<Pharmacy> pharmacies) {
        return pharmacies;
    }

    @Override
    public Pharmacy getPharmacyByAddress(List<Pharmacy> pharmacies) {
        try{
            int counter = 0;
            System.out.println("Enter pharmacy address: ");
            String address = new Scanner(System.in).nextLine();
            for (Pharmacy p :pharmacies) {
                if (p.getAddress().equalsIgnoreCase(address)){
                    return p;
                }else {
                    counter++;
                }
            }
            if (counter>0){
                throw new MyException("Not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Pharmacy updatePharmacyName(List<Pharmacy> pharmacies) {
        try{
            System.out.println("Enter pharmacy id");
            int id = new Scanner(System.in).nextInt();
            boolean isFalse = false;
            for (Pharmacy p:pharmacies) {
                if (p.getId()==id){
                    isFalse = false;
                    System.out.println("Enter new pharmacy name: ");
                    String name = new Scanner(System.in).nextLine();
                    p.setName(name);
                    return p;
                }else {
                    isFalse=true;
                }
            }
            if (isFalse){
                throw new MyException(" Pharmacy with id "+ id+" nut found");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deletePharmacyById(List<Pharmacy> pharmacies) {
        try{
            boolean davran = true;
            System.out.println("Enter pharmacy id: ");
            int id = new Scanner(System.in).nextInt();
            String idString = id+"";
            if (idString.isBlank()){
                throw new MyException("is empty");
            }
            for (Pharmacy p:pharmacies) {
                if(p.getId()==id){
                    davran=true;
                    pharmacies.remove(p);
                }else {
                    davran=false;
                }
            }
            if (!davran){
                throw new MyException("Pharmacy with id "+id+ " not found");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
