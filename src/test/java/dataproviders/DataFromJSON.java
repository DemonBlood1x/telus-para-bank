package dataproviders;

import conf.ExpectedValues;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class DataFromJSON {

    @DataProvider(name = ExpectedValues.PROVIDER)
    public Object[][] testData() throws IOException, ParseException {
        // Read test data from a JSON file
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(ExpectedValues.JSON_FILE_PATH));
        JSONObject jsonObject = (JSONObject) obj;

        JSONArray testCases = (JSONArray) jsonObject.get(ExpectedValues.TEST_CASES);
        Object[][] data = new Object[testCases.size()][4];

        for (int i = 0; i < testCases.size(); i++) {
            JSONObject testCase = (JSONObject) testCases.get(i);
            data[i][0] = testCase.get(ExpectedValues.TEST_CASE_NUMBER);
            data[i][1] = testCase.get(ExpectedValues.TEST_CASE_AMOUNT);
            data[i][2] = testCase.get(ExpectedValues.TEST_CASE_DEBIT_ACCOUNT);
            data[i][3] = testCase.get(ExpectedValues.TEST_CASE_CREDIT_ACCOUNT);
        }

        return data;
    }

}

