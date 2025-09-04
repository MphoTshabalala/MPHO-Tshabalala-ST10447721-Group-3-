import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeriesServiceTest {

    private SeriesService service;

    
    @Test
    void TestSearchSeries() {
        Series result = service.searchSeries(101);
        assertNotNull(result);
        assertEquals("Breaking Bad", result.getTitle());
    }

    @Test
    void TestSearchSeries_SeriesNotFound() {
        Series result = service.searchSeries(9999);
        assertNull(result);
    }

    
    @Test
    void TestDeleteSeries() {
        boolean success = service.deleteSeries(102);
        assertTrue(success);
        assertNull(service.searchSeries(102));
    }

    @Test
    void TestDeleteSeries_SeriesNotFound() {
        boolean success = service.deleteSeries(8888);
        assertFalse(success);
    }

    @Test
    void TestSeriesAgeRestriction_AgeValid() {
        boolean valid = service.validateAgeRestriction(16);
        assertTrue(valid);
    }

    @Test
    void TestSeriesAgeRestriction_SeriesAgeInValid() {
        boolean valid = service.validateAgeRestriction(200);
        assertFalse(valid);
    }
}
