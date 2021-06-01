package common;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidateCustomer {
    public boolean validateName(String name){
        String regex = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$";
        return Pattern.matches(regex,name);
    }

    public boolean validateDateOfBirth(String str) {
        String formatDOB = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        if (!Pattern.matches(formatDOB, str)) {
            return false;
        }
        String time = String.valueOf(LocalDate.now());
        int yearNow = Integer.parseInt(time.substring(0, 4));
        int monthNow = Integer.parseInt(time.substring(5, 7));
        int dayNow = Integer.parseInt(time.substring(8, 10));
        int yearDOB = Integer.parseInt(str.substring(6, 10));
        if (yearNow - yearDOB < 18 || yearDOB < 1900) {
            return false;
        }
        if (yearNow - yearDOB == 18) {
            int monthDOB = Integer.parseInt(str.substring(3, 5));
            if (monthDOB > monthNow) {
                return false;
            }
            if (monthDOB == monthNow) {
                int dayDOB = Integer.parseInt(str.substring(0, 2));
                if (dayDOB > dayNow) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validateGender(String str){
        str = str.toLowerCase();
        str = str.replace(str.charAt(0), (char) (str.charAt(0)-32));
        return str.equals("Male") || str.equals("Female") || str.equals("Unknow");
    }

    public boolean validateID(String id) {
        String regex = "^[0-9]{3} [0-9]{3} [0-9]{3}$";
        return Pattern.matches(regex, id);
    }

    public boolean validatePhoneNumber(String phoneNumber){
        String regex = "^0[0-9]{9}$";
        return Pattern.matches(regex,phoneNumber);
    }

    public boolean validateEmail(String email){
        String regex = "^\\w*@[a-zA-Z]+\\.[a-zA-Z]+$";
        return Pattern.matches(regex, email);
    }
}
