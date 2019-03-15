package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationValidator {
    public void validate(Reservation reservation) {
        if (reservation.getId() <= 0) {
            throw new RuntimeException("This is an invalid id number");
        }

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try {
            format.parse(reservation.getDate());
        } catch (ParseException pe) {
            throw new RuntimeException("The date is not in a correct format!");
        }

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            format.parse(reservation.getDate());
        } catch (ParseException pe) {
            throw new RuntimeException("The time is not in a correct format!");
        }

    }
}
