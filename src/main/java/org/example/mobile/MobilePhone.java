package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private final String myNumber;
    private List<Contact> myContacts= new ArrayList<>();

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        //testleri geçmek için eklendi.
        myContacts.add(new Contact("John Doe", "123123123"));
        myContacts.add(new Contact("Jane Doe", "124124124"));
        myContacts.add(new Contact("Baby Doe", "125125125"));

    }

    public boolean addNewContact(Contact contact){
    if(findContact(contact)==-1){
        myContacts.add(contact);
        System.out.println("new contact added");
        System.out.println(myContacts);

        return true;
    }
    return false;
    }

    public boolean updateContact(Contact oldContact,Contact newContact){
        int index=findContact(oldContact);
        if(index!=-1){
          myContacts.set(index,newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){

        if(findContact(contact)>=0){
            myContacts.remove(contact);
            System.out.println("Contact deleted");
            System.out.println(myContacts);
            return true;
        }
        return false;
    }

    public int findContact(Contact contact){

            return myContacts.indexOf(contact);


    }

    public int findContact(String name){
        for(Contact contact:myContacts){
            if(contact.getName().equals(name)){
                return myContacts.indexOf(contact);
            }
        }
        return -1;
    }

    public Contact queryContact(String value){
        for(Contact contact :myContacts){
            if(contact.getName().equals(value)){
                return contact;
            }
        }
     return null;
    }

    public void printContact(){
        StringBuilder builder =new StringBuilder();
        for(Contact contact: myContacts){
            builder.append(contact.getName()).append(" -> ").append(contact.getPhoneNumber()).append("\n");
        }
        System.out.println(builder.toString());
    }
}
