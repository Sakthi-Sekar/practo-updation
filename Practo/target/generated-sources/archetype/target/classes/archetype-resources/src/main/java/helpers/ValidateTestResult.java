#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.helpers;

import org.testng.Assert;

public class ValidateTestResult {

public static boolean validateData(Object actual, Object expected, String message) {
try {
Assert.assertEquals(actual, expected);
return true;
} catch (AssertionError assertionError) {
return false;
}
}
}