package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> dataLogin(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{"noam@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        list.add(new Object[]{"noam@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});


        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> dataRegistration(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{new User().setName("Doroti").setLastName("Doe").setEmail("mor78@gmail.com").setPassword("Dd12345$")});
        list.add(new Object[]{new User().setName("Doroti").setLastName("Doe").setEmail("mor79@gmail.com").setPassword("Dd12345$")});
        list.add(new Object[]{new User().setName("Doroti").setLastName("Doe").setEmail("mor80@gmail.com").setPassword("Dd12345$")});
        list.add(new Object[]{new User().setName("Doroti").setLastName("Doe").setEmail("mor90@gmail.com").setPassword("Dd12345$")});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> dataBase(){
        List<Object[]> list=new ArrayList<>();

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginCsv() throws IOException {
        List<Object[]> list=new ArrayList<>();

        BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader("src/test/resources/login.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataCreateNewCar() throws IOException {

        List<Object[]> list=new ArrayList<>();

        BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader("src/test/resources/cars.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split("/");
            list.add(new Object[]{Car.builder()
                    .address(split[0])
                    .make(split[1])
                    .model(split[2])
                    .year(split[3])
                    .engine(split[4])
                    .fuel(split[5])
                    .gear(split[6])
                    .WD(split[7])
                    .doors(split[8])
                    .seats(split[9])
                    .carClass(split[11])
                    .fuelConsumption(split[12])
                    .carRegistrationNumber(split[13])
                    .price(split[14])
                    .distanceIncluded(split[15])
                    .features(split[16])
                    .about(split[17])
                    .build()});
            line = reader.readLine();
        }

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]>dataCreateNewCar2() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader("src/test/resources/cars.csv")));
        String line = reader.readLine();
            while (line!=null){
                String[]split =line.split("/");
                list.add(new Object[]{Car.builder()
                        .address(split[0])
                        .make(split[1])
                        .model(split[2])
                        .year(split[3])
                        .engine(split[4])
                        .fuel(split[5])
                        .gear(split[6])
                        .WD(split[7])
                        .doors(split[8])
                        .seats(split[9])
                        .carClass(split[10])
                        .fuelConsumption(split[11])
                        .carRegistrationNumber(split[12])
                        .price(split[13])
                        .distanceIncluded(split[14])
                        .features(split[15])
                        .about(split[16])
                        .build()});
                line = reader.readLine(); }



        return list.iterator();
    }

}

