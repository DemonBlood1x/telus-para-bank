package conf;

public class ExpectedValues {

    /*    Time Control  */
    public static final int WAIT_SECONDS = 20;

    /*    Values To Login & New Account Creation    */
    public static final String USER = "test1";
    public static final String PASS = "123";
    public static final String WELCOME = "Welcome";
    public static final String AMOUNT = "$100.00";

    /*    Values To ParaBankTransfer    */
    public static final String PROVIDER = "testData";
    public static final String JSON_FILE_PATH = "src/test/java/fixtures/testData.json";
    public static final String TEST_CASES = "testCases";
    public static final String TEST_CASE_NUMBER = "testCaseNumber";
    public static final String TEST_CASE_AMOUNT = "amount";
    public static final String TEST_CASE_DEBIT_ACCOUNT = "debitAccount";
    public static final String TEST_CASE_CREDIT_ACCOUNT = "creditAccount";

    public static final String EXPECTED_TEXT = "Transfer Complete!";
}
