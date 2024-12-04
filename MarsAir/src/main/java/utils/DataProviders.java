package utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "flightSearchDataProvider")
    public Object[][] getFlightSearchData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        // Read JSON and map to the array of FlightSearchDetails
        FlightSearchWrapper wrapper = mapper.readValue(
                new File("src/test/resources/testData/FlightSearchDetails.json"),
                FlightSearchWrapper.class
        );

        List<FlightSearchDetails> flightSearchDetailsList = wrapper.getFlightSearchDetails();

        Object[][] data = new Object[flightSearchDetailsList.size()][1];
        for (int i = 0; i < flightSearchDetailsList.size(); i++) {
            data[i][0] = flightSearchDetailsList.get(i);
        }
        return data;
    }
}

// Helper Wrapper Class for JSON Array
class FlightSearchWrapper {
	@JsonProperty("FlightSearchDetails")
    private List<FlightSearchDetails> flightSearchDetails;

    public List<FlightSearchDetails> getFlightSearchDetails() {
        return flightSearchDetails;
    }

    public void setFlightSearchDetails(List<FlightSearchDetails> flightSearchDetails) {
        this.flightSearchDetails = flightSearchDetails;
    }
}

