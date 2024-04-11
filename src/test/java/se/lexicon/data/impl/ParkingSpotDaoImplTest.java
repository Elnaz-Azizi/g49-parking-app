package se.lexicon.data.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.ParkingSpot;

public class ParkingSpotDaoImplTest {
    private ParkingSpotDaoImpl parkingSpotDao;

    @BeforeEach
    public void setUp() {
        parkingSpotDao = new ParkingSpotDaoImpl();
    }


    @Test

    public void testCreat() {

        ParkingSpot parkingSpot = new ParkingSpot(1, 47001);
        ParkingSpot actualParkingSpot = parkingSpotDao.create(parkingSpot);
        ParkingSpot expectedParkingSpot = parkingSpot;
        assertTrue(parkingSpotDao.find(1).isPresent());
        assertEquals(expectedParkingSpot.getSpotNumber(), actualParkingSpot.getSpotNumber());
    }



}


