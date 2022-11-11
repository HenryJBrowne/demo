package com.demo.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/student")
public class CustomerController {

    String returnString="";

    @Autowired
    private CustomerService CustomerService;


    //@RequestMapping("/Registation")
    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST},value="Registation")
    @ResponseBody
    public String form(){
       
        return "<html>"+
                "<body>"+
                "<form action='submit' method='post'>"+
                "<br>email:  "+
                "<input type='text' name='email'>"+
                "<br>title:  "+
                "<input type='text' name='title'>"+
                "<br>firstname:  "+
                "<input type='text' name='firstname'>"+
                "<br>lastname:  "+
                "<input type='text' name='lastname'>"+
                "<br>address line 1:  "+
                "<input type='text' name='addressline1'>"+
                "<br>address line 2:  "+
                "<input type='text' name='addressline2'>"+
                "<br>city:  "+
                "<input type='text' name='city'>"+
                "<br>postcode:  "+
                "<input type='text' name='postcode'>"+
                "<br>phone number:  "+
                "<input type='text' name='phoneNumber'>"+
                "<br>"+
                "<input type='submit' value='Submit!'>"+
                returnString+
                "</form>"+
                "</body>"+
                "</html>";

    }

    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST},value="submit")
    @ResponseBody
    public String submit(@RequestParam String email, @RequestParam String title,@RequestParam String firstname, @RequestParam String lastname,@RequestParam String addressline1, @RequestParam String addressline2,@RequestParam String city, @RequestParam String postcode,@RequestParam String phoneNumber){

        returnString="";

        // Validation

        Boolean invalidInput=false;;

        if (email.equals("") || email.length()>255){
            returnString=returnString+"<br> invalid email";
            invalidInput=true;
        }
        if (title.equals("") || title.length()>5){
            returnString=returnString+"<br> invalid tite";
            invalidInput=true;
        }
        if (firstname.equals("") || firstname.length()>50){
            returnString=returnString+"<br> invalid first name";
            invalidInput=true;
        }
        if (lastname.equals("") || lastname.length()>50){
            returnString=returnString+"<br> invalid last name";
            invalidInput=true;
        }
        if (addressline1.equals("") ||addressline1.length()>255){
            returnString=returnString+"<br> invalid address line 1 ";
            invalidInput=true;
        }
        if (addressline2.length()>255){
            returnString=returnString+"<br> invalid address line 2 ";
            invalidInput=true;
        }
        if (city.length()>255){
            returnString=returnString+"<br> invalid city ";
            invalidInput=true;
        }
        if (postcode.equals("") || postcode.length()>10){
            returnString=returnString+"<br> invalid address postcode ";
            invalidInput=true;
        }
        if (phoneNumber.length()>20){
            returnString=returnString+"<br> invalid phone number ";
            invalidInput=true;
        }
        if (invalidInput==false){
            
            CustomerService.saveCustomer(new Customer(email,title,firstname,lastname,addressline1,addressline2,city,postcode,phoneNumber));
            return       "<html>"+
            "<body>"+
            "<form action='Success' method='post'>"+
            "<input type='submit' value='Continue'>"+
            "</form>"+
            "</body>"+
            "</html>";

        }

        return       "<html>"+
        "<body>"+
        "<br>invalid input!<br>"+
        "<form action='Registation' method='post'>"+
        "<input type='submit' value='Back'>"+
        "</form>"+
        "</body>"+
        "</html>";

    }

    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST},value="Success")
    @ResponseBody
    public String Success(){

            return "<html>"+
            "<body>"+
            "<br> Success! We have saved your information into the database <br>"+
            "</body>"+
            "</html>";
    }
    
}
