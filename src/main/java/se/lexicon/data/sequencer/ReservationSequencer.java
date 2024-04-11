package se.lexicon.data.sequencer;

public class ReservationSequencer {
    private static int sequencer = 100;

    public static String nextId() {
        String id = "Reservation Number" + sequencer;
        sequencer++;
        return id;
    }
}
