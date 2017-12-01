package test_facade;

import facade.Operation;
import facade.StringFacade;
import facade.StringFacade.ValidationType;

import java.util.Arrays;

public class TestFacade
{
    public static void main(String[] args)
    {
        //test our validation routines
        System.out.println(StringFacade.isValid("e@e@e.com",
                ValidationType.EMAIL));

        //tests our string operations
        Operation op = StringFacade.getStringOperations(new String[] {"money", "money", "mitochondria",
                "turkey", "turkey", "turkey", "lunch", "stuffing", "mashed potatoes"});

        System.out.println(Arrays.toString(
                op.filter("lunch").removeDuplicates().resize(4).getSubject()));
    }
}
