package stringexample;

public class aaa {
    String name;
    String surName;
    String address;
    String email;

    @Override
    public String toString() {
        return "Class aaa {"+String.join(", ", "name = "+name, surName, address, email)+"}";


//        return "aaa{" +
//                 + name + '\'' +
//                 surName + '\'' +
//                ", address='" + address + '\'' +
//                ", email='" + email + '\'' +
//                '}';

    }
}
