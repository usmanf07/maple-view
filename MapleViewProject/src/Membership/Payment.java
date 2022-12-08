/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Membership;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.PaymentMethod;
import com.stripe.model.Token;
import com.stripe.net.RequestOptions;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.CustomerRetrieveParams;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usman
 */
public class Payment {
    
    public static String verifyPayment(String cc, String mon, String yr, String cvv)
    {
        String result = "success";
        if(cc.isBlank())
            return result = "Invalid Card Number";
        if(mon.isBlank())
            return result = "Invalid Expiry Month";
        if(yr.isBlank())
            return result = "Invalid Expiry Year";
        if(cvv.isBlank())
            return result = "Invalid CVV Code";
        
        
        Stripe.apiKey = "your key";
        System.out.println("cc: "+cc+"mon: "+mon+"yr: "+yr+"cvv: "+cvv);
        try{
            Map<String, Object> customerParam = new HashMap<>();
            customerParam.put("email","2@2.com");
            Customer newCustomer = Customer.create(customerParam);
            
            CustomerRetrieveParams retrieveParams = CustomerRetrieveParams.builder()
				    .addExpand("sources")
				    .build();
Customer customer = Customer.retrieve(newCustomer.getId(), retrieveParams, null);
            
            Map<String, Object> cardparam = new HashMap<>();
            cardparam.put("number", cc);
            cardparam.put("exp_month", Integer.parseInt(mon));
            cardparam.put("exp_year", Integer.parseInt(yr));
            cardparam.put("cvc", cvv);
            
            Map<String, Object> tokenparam = new HashMap<>();
            tokenparam.put("card", cardparam);
            
            Token token = Token.create(tokenparam);
            
            Map<String, Object> source = new HashMap<>();
            source.put("source", token.getId());
            
            customer.getSources().create(source);
            
            Map<String, Object> chargeparam = new HashMap<>();
            chargeparam.put("amount", "50");
            chargeparam.put("currency", "usd");
            chargeparam.put("customer", customer.getId());
            
            Charge.create(chargeparam);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(customer));
            
        } catch (StripeException ex) 
        {
            String error = ex.toString();
            System.out.println(error);
           if(error.contains("Your card number is incorrect."))
               return "Your card number is incorrect.";
           if(error.contains("invalid_expiry_year"))
               return "Your card's Expiration Date is Invalid.";
            if(error.contains("invalid_expiry_month"))
               return "Your card's Expiration Date is Invalid.";
            if(error.contains("invalid_cvc"))
               return "Your card's Security Code is Invalid.";
            if(error.contains("card_declined"))
               return "Your card was Declined, Try A Different Card.";
            if(error.contains("testmode_charges_only"))
               return "API Key is Down.";
        }
        return result;
    }
}
