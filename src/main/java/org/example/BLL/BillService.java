package org.example.BLL;
import org.example.DAL.BillRepo;
import org.example.model.Bill;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BillService {

    BillRepo billRepository = new BillRepo();

    public BillService() {

    }

    public Bill getById(int BillId) {
        Bill nota = billRepository.getById(BillId);

        if (nota == null) {
            throw new NoSuchElementException("Bill with id = " + BillId + " was not found!");
        }

        return nota;
    }

    public ArrayList<Bill> get() {
        ArrayList<Bill> bills = billRepository.get();

        if (bills == null) {
            throw new NoSuchElementException("There are no Bills!");
        }

        return bills;
    }

    public ArrayList<Bill> getAll(){
        return billRepository.get();
    }


    public int add(Bill bill) {
        return billRepository.add(bill);
    }

}
