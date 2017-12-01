package facade;

import string_manipulation.StringRegex;

import java.util.Arrays;

public class StringFacade
{
    public static boolean isValid(String subject, ValidationType type)
    {
        switch (type)
        {
            case EMAIL:
                return StringRegex.isEmail(subject);
            case PHONE:
                return StringRegex.isPhoneNumber(subject);
            case URL:
                return StringRegex.isUrl(subject);
            case ZIP_CODE:
                return StringRegex.isZipCode(subject);
        }

        throw new IllegalStateException("Missing enum value: " + type.toString());
    }

    public static Operation getStringOperations(String[] subject)
    {
        return new Operation(subject);
    }

    public enum ValidationType
    {
        EMAIL,
        PHONE,
        URL,
        ZIP_CODE
    }
}
