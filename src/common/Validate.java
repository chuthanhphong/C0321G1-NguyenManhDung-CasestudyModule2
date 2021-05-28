package common;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Validate {

    public boolean validateServiceName(String str) {
        String regexString = "^[A-Z]+[a-z0-9\\s]*$";
        return Pattern.matches(regexString, str);
    }

    public boolean validateId(String str, String type) {
        String regexString;
        switch (type) {
            case "villa":
                regexString = "^SVVL-[0-9]{4}$";
                break;
            case "house":
                regexString = "^SVHO-[0-9]{4}$";
                break;
            case "room":
                regexString = "^SVRO-[0-9]{4}$";
                break;
            default:
                return false;
        }
        return Pattern.matches(regexString, str);
    }

    public boolean validateArea(float area) {
        return area > 30f;
    }

    public boolean validateSwimmingPool(float area) {
        return area > 30f;
    }

    public boolean validatePrice(float price) {
        return price > 0;
    }

    public boolean validateMaxPeople(int people) {
        return people > 0 && people < 20;
    }

    public boolean validateEnclosedService(String str) {
        String[] arrString = {"massage", "karaoke", "food", "drink", "car"};
        for (String v : arrString) {
            if (v.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateAmountService(int amount) {
        return amount > 0;
    }

    public boolean validateFloors(int floor) {
        return floor > 0;
    }

    public boolean validateRentType(String str) {
        String regexString = "^[A-Z]+[a-z0-9\\s]*$";
        return Pattern.matches(regexString, str);
    }

    public boolean validateTypeOfRoom(String str) {
        String regexString = "^[A-Z]+[a-z0-9\\s]*$";
        return Pattern.matches(regexString, str);
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
        if (yearNow - yearDOB < 18) {
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
}
