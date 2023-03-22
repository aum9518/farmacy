package farmacy.intergace.impl;

import farmacy.Class.Person;
import farmacy.Class.Pharmacy;
import farmacy.exception.MyException;
import farmacy.intergace.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {
    //static int counter = 0;
    @Override
    public Person addPersonToPharmacy(List<Pharmacy> pharmacies) {
        System.out.println("Enter group id: ");
        int id = new Scanner(System.in).nextInt();
        for (Pharmacy a:pharmacies) {
            if (a.getId()==id){
                Person person = new Person();
                System.out.println("Enter first name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.println("Enter last name: ");
                String lastName = new Scanner(System.in).nextLine();
                System.out.println("Enter email: ");
                String email = new Scanner(System.in).nextLine();
                 try {
                    if (email.contains("@")){

                       if (!a.getPeople().isEmpty()){
                           for (Person b:a.getPeople()) {
                               if (b.getEmail().equals(email)){
                                   throw new MyException("Same email address!");
                               }else {
                                   person.setEmail(email);
                               }
                           }
                       }else {
                           person.setEmail(email);
                       }
                    }else {
                        throw new MyException("Email should contain '@'!");
                    }

                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
                //person.setEmail(email);
                person.setFirstName(name);
                person.setLastName(lastName);
                person.setId(a.getPeople().size()+1);
                a.getPeople().add(person);
                return person;
            }


    }
        return null;
    }

    @Override
    public Person findPersonById(List<Pharmacy> pharmacies) {
        boolean isTrue=true;
        List<Pharmacy>list = new ArrayList<>();
                for (Pharmacy a:pharmacies) {
                    System.out.println("Enter group id:");
                    int groupId = new Scanner(System.in).nextInt();
                    if (a.getId()==groupId) {
                       list.add(a);
                    }else {
                        System.out.println("Not found group");
                    }
                }
        System.out.println("Enter person's id: ");
        int id = new Scanner(System.in).nextInt();
        for (Pharmacy c:list) {
            for (Person p : c.getPeople()) {
                if (p.getId() == id) {
                    isTrue = true;
                    return p;
                } else {
                    isTrue = false;
                }
            }
        }


        try{
            if (!isTrue){
                throw new MyException("Not found staff with id: ");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Person> getAllPharmacyStaff(List<Pharmacy> pharmacies) {
        List<Pharmacy>list=new ArrayList<>();
        boolean isTrue = true;
        try {
            System.out.println("Enter groups id:");
            int idGroup = new Scanner(System.in).nextInt();
            for (Pharmacy a : pharmacies) {
                if (a.getId() == idGroup) {
                    isTrue = true;
                   return a.getPeople();
                } else {
                    isTrue = false;
                }
            }
            if (!isTrue){
                throw new MyException("Not found group");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Person updatePersonFromPharmacy(List<Pharmacy> pharmacies) {
        return null;
    }
}
