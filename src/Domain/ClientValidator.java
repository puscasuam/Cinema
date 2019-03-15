package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientValidator {
    public void validate(Client client) {
        if (client.getId() <= 0) {
            throw new RuntimeException("This is an invalid id number");
        }

        if (client.getFirstName() == null || client.getFirstName().isEmpty()) {
            throw new RuntimeException("First name should be given");
        }

        if (client.getLastName() == null || client.getLastName().isEmpty()) {
            throw new RuntimeException("Last name should be given");
        }

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try {
            format.parse(client.getDateOfBirth());
        } catch (ParseException pe) {
            throw new RuntimeException("The release date is not in a correct format!");
        }

        try {
            format.parse(client.getDateOfRegistration());
        } catch (ParseException pe) {
            throw new RuntimeException("The release date is not in a correct format!");
        }

        if (client.getCNP().length() != 13) {
            throw new RuntimeException("The license plate must have 13 characters!");
        }

        if (client.getCNP().charAt(0) < '1' || client.getCNP().charAt(0) > '8') {
            throw new RuntimeException("CNP not valid!");
        }
    }

}