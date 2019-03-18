import Domain.ClientValidator;
import Domain.MovieValidator;
import Domain.ReservationValidator;
import Repository.ClientRepository;
import Repository.MovieRepository;
import Repository.ReservationRepository;
import Service.ClientService;
import Service.MovieService;
import Service.ReservationService;
import UI.Console;
import UI.NewConsole;

public class Main {

    public static void main(String[] args) {

        MovieValidator movieValidator = new MovieValidator();
        ClientValidator clientValidator = new ClientValidator();
        ReservationValidator reservationValidator = new ReservationValidator();

        MovieRepository movieRepository = new MovieRepository(movieValidator);
        ClientRepository clientRepository = new ClientRepository(clientValidator);
        ReservationRepository reservationRepository = new ReservationRepository(reservationValidator);

        MovieService movieService = new MovieService(movieRepository);
        ClientService clientService = new ClientService(clientRepository);
        ReservationService reservationService = new ReservationService(movieRepository, clientRepository, reservationRepository);
        NewConsole console = new NewConsole(movieService, clientService, reservationService);
        console.run();
    }
}