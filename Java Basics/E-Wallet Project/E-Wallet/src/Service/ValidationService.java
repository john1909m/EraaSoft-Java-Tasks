package Service;

public interface ValidationService {
    Boolean validateName(String username);
    Boolean validatePassword(String password);
    Boolean validatePhoneNumber(String phoneNumber);

}
