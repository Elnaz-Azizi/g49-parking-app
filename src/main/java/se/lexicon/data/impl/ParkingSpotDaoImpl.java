package se.lexicon.data.impl;

import se.lexicon.data.ParkingSpotDao;
import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingSpotDaoImpl implements ParkingSpotDao {

    private List<ParkingSpot> storage = new ArrayList<>(); // [ ParkingSpot ,   ParkingSpot]

    @Override

    public ParkingSpot create(ParkingSpot parkingSpot) {
        if (parkingSpot == null) throw new IllegalArgumentException("Parking Spot Number is null.");
        Optional<ParkingSpot> parkingSpotOptional = find(parkingSpot.getSpotNumber());
        if (parkingSpotOptional.isPresent()) throw new IllegalArgumentException("Parking Spot Number is duplicate.");
        storage.add(parkingSpot);
        return parkingSpot;
    }

    @Override
    public Optional<ParkingSpot> find(int spotNumber) { // 1
        for (ParkingSpot parkingSpot : storage) {
            if (parkingSpot.getSpotNumber() == spotNumber) {
                return Optional.of(parkingSpot);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(int spotNumber) {
        Optional<ParkingSpot> parkingSpotOptional = find(spotNumber);
        if (!parkingSpotOptional.isPresent()) return false;
        storage.remove(parkingSpotOptional.get());
        return true;
    }

    @Override
    public List<ParkingSpot> findAll() {

        return new ArrayList<>(storage);
    }

    @Override
    public List<ParkingSpot> findByAreaCode(int areaCode) { //47001
        List<ParkingSpot> filteredParkingSpotsByAreaCode = new ArrayList<>();

        for (ParkingSpot parkingSpotElement : storage) { //   [ ParkingSpot(1, 47001, false) ,   ParkingSpot(2, 47001, true)]
            if (parkingSpotElement.getAreaCode() == areaCode) {
                filteredParkingSpotsByAreaCode.add(parkingSpotElement);
            }
        }

        return filteredParkingSpotsByAreaCode;
    }

    @Override
    public void occupyParkingSpot(int spotNumber) { // 1  //   ParkingSpot(1, 47001, true)
        Optional<ParkingSpot> parkingSpotOptional = find(spotNumber);

        if (parkingSpotOptional.isPresent()) {
            ParkingSpot foundParkingSpot = parkingSpotOptional.get();
            foundParkingSpot.occupy();
        } else {
            throw new IllegalArgumentException("Parking spot not found.");
        }

    }

    @Override
    public void vacateParkingSpot(int spotNumber) {
        Optional<ParkingSpot> parkingSpotOptional = find(spotNumber);
        if (parkingSpotOptional.isPresent()) {
            parkingSpotOptional.get().vacate();
        } else {
            throw new IllegalArgumentException("Parking spot not found.");
        }

    }




}
