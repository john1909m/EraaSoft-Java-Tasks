package Service.Impl;

import Service.ValidationService;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public Boolean validateName(String username) {
        if (username.length() < 3 || !Character.isUpperCase(username.charAt(0))) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean validatePassword(String password) {
        boolean upCase=password.chars().anyMatch(Character::isUpperCase);
        boolean lowCase=password.chars().anyMatch(Character::isLowerCase);
        boolean special=password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
        boolean length=password.length() >= 8;
        return upCase && lowCase && special&& length;
    }

    @Override
    public Boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length()!=12 || phoneNumber.charAt(0)!='2'|| phoneNumber.charAt(1)!='0') {
            return false;
        }
        return true;
    }
}
