package Service;

import Domain.Client;
import Repository.ClientRepository;

import java.util.List;

public class ClientService {
    private ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void addOrUpdate(int id, String CNP, int fidelityPoints, String lastName, String firstName, String dateOfBirth, String dateOfRegistration) {

        //we will make sure that the CNP is not already used
        for (Client i : repository.getAll()) {
            if (i.getCNP() == CNP) {
                throw new RuntimeException("The CNP is already used!");
            }
        }

        Client existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (fidelityPoints == 0) {
                fidelityPoints = existing.getFidelityPoints();

                if (lastName.isEmpty()) {
                    lastName = existing.getLastName();
                }
                if (firstName.isEmpty()) {
                    firstName = existing.getFirstName();
                }
                if (CNP.isEmpty()) {
                    CNP = existing.getCNP();
                }
                if (dateOfBirth.isEmpty()) {
                    dateOfBirth = existing.getDateOfBirth();
                }
                if (dateOfRegistration.isEmpty()) {
                    dateOfRegistration = existing.getDateOfRegistration();
                }
            }
            Client client = new Client(id, CNP, fidelityPoints, lastName, firstName, dateOfBirth, dateOfRegistration);
            repository.insertOrUpdate(client);
        }
    }
        public void remove ( int id){
            repository.remove(id);
        }

        public List<Client> getAll () {
            return repository.getAll();
        }


}
