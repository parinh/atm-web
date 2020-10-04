package th.ac.ku.atm.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import th.ac.ku.atm.model.BankAccount;

@Service
public class BankAccountService {

    private RestTemplate restTemplate;

    public BankAccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<BankAccount> getCustomerBankAccount(int customerId) {
        String url = "http://localhost:8091/api/bankaccount/customer/" +
                customerId;
        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);

        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }

//    public List<BankAccount> getBankAccounts(){
//        String url ="http://localhost:8091/api/bankaccount";
//        ResponseEntity<BankAccount[]> response = restTemplate.getForEntity(url,BankAccount[].class);
//        BankAccount[] accounts = response.getBody();
//        return Arrays.asList(accounts);
//    }

   public  void openBankAccount(BankAccount bankAccount){
        String url = "http://localhost:8091/api/bankaccount";
        restTemplate.postForObject(url,bankAccount,BankAccount.class);
   }

    public void openAccount(BankAccount bankAccount) {
        String url = "http://localhost:8091/api/bankaccount/";

        restTemplate.postForObject(url, bankAccount, BankAccount.class);
    }
    public List<BankAccount> getBankAccounts() {
        String url = "http://localhost:8091/api/bankaccount/";

        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);

        BankAccount[] accounts = response.getBody();
        return Arrays.asList(accounts);
    }

    public BankAccount getBankAccounts(int id){
        String url = "http://localhost:8091/api/bankaccount/" + id;

        ResponseEntity<BankAccount> response =
                restTemplate.getForEntity(url, BankAccount.class);
        return response.getBody();

    }

    public  void editBankAccount(BankAccount bankAccount){
        String url = "http://localhost:8091/api/bankaccount/" + bankAccount.getId();
        restTemplate.put(url,bankAccount);
    }


    public void deleteBankAccount(BankAccount bankAccount){
        String url = "http://localhost:8091/api/bankaccount/" + bankAccount.getId();
        restTemplate.delete(url,bankAccount);
    }
}