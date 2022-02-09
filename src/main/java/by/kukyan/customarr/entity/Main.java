package by.kukyan.customarr.entity;
import by.kukyan.customarr.service.impl.CustomArrayService;

public class Main {
    public static void main(String[] args) {
        CustomArrayService serv = new CustomArrayService();
        CustomArray arr = new CustomArray(1, -2 ,4, -6);
        serv.bubleSort(arr);
        System.out.println(arr);
    }
}
