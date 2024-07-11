/**
 * @author 6510450305 chaiyapat
 * in the given code is contrast with the single-responsiblility principle
 * cuz the given code in the register function do both validation and registrantion(return true)
 */

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LoginController {
    public boolean register(User user){

        validateUserName(user.getName());
        validateEmail(user.getEmail());
        validateAge(user.getAge());

        return true;
    }

    private void validateUserName(String userName) {
        if (userName == null || userName.trim().equals("")) {
            throw new IllegalArgumentException("Name should not empty");
        }
        if ( !userName.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException("Name is wrong format");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().equals("")) {
            throw new IllegalArgumentException("Email should not empty");
        }

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern validEmailPattern = Pattern.compile(EMAIL_PATTERN);
        if( !validEmailPattern.matcher(email).matches() ) {
            throw new IllegalArgumentException("Email is wrong format");
        }

        List<String> notAllowDomains = Arrays.asList("dom1.cc","dom2.cc", "dom3.cc");
        if(notAllowDomains.contains(email.split("@")[1])) {
            throw new IllegalArgumentException("Domain Email is not allow");
        }
    }

    private void validateAge(int age) {
        if( age < 20 ) {
            throw new IllegalArgumentException("Age should more than 20 years");
        }
    }
}
