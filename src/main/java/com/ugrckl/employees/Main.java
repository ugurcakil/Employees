package com.ugrckl.employees;

import org.w3c.dom.ls.LSOutput;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String peopleText = """
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Flinstone, Fred, 1/1/1900, Programmerzzzzzzz, {locpd=2000,yoe=10,iq=140}
                Flinstone, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
                Flinstone, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
                Flinstone, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
                Flinstone, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                Rubble, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
                Rubble, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
                Rubble, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
                Rubble, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
                Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
                Flinstone, Wilma2, 3/3/1910, Analyst, {projectCount=4}
                Flinstone, Wilma3, 3/3/1910, Analyst, {projectCount=5}
                Flinstone, Wilma4, 3/3/1910, Analyst, {projectCount=6}
                Flinstone, Wilma5, 3/3/1910, Analyst, {projectCount=9}
                Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
                """;

        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(peopleText);
        Programmer coder = new Programmer(peopleText);
        coder.cook("Hamburger");

        int totalSalaries = 0;
        IEmployee employee = null;
        while(peopleMat.find()){
            employee = Employee.createEmployee(peopleMat.group());
            System.out.println(employee.toString());
            totalSalaries += employee.getSalary();

        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s",currencyInstance.format(totalSalaries));

        Weirdo larry = new Weirdo("David","Larry", LocalDate.of(1950,1,1));
        Weirdo jake = new Weirdo("Snake","Jake");
    }

}
