package exceptions.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddress {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final char AT_SIGN = '@';

    private String email;

    public EmailAddress(String email) throws IllegalEmailException {
        if (email == null) {
             throw new IllegalEmailException("Email address cannot be null");
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if (!matcher.matches())
            throw new IllegalEmailException("Email address is not valid");
        this.email = email;
    }

    public String getHost() {
        return email.substring(email.indexOf(AT_SIGN) + 1, email.length());

    }

}