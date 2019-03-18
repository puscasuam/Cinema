package UI;

import Domain.Client;
import Domain.Movie;
import Domain.Reservation;
import Service.ClientService;
import Service.MovieService;
import Service.ReservationService;

import java.util.Scanner;

public class Console {

    private MovieService movieService;
    private ClientService clientService;
    private ReservationService reservationService;

    private Scanner scanner;

    public Console(MovieService movieService, ClientService clientService, ReservationService reservationService) {
        this.movieService = movieService;
        this.clientService = clientService;
        this.reservationService = reservationService;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Movie CRUD");
        System.out.println("2. Client CRUD");
        System.out.println("3. Reservation CRUD");
        System.out.println("x. Exit");
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runMovieCrud();
                    break;
                case "2":
                    runClientCrud();
                    break;
                case "3":
                    runReservationCrud();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runReservationCrud() {
        while (true) {
            System.out.println("1. Add or update a reservation");
            System.out.println("2. Remove a reservation");
            System.out.println("3. View all reservation");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateReservation();
                    break;
                case "2":
                    handleRemoveReservation();
                    break;
                case "3":
                    handleViewReservations();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewReservations() {
        for (Reservation transaction : reservationService.getAll()) {
            System.out.println(transaction);
        }
    }

    private void handleRemoveReservation() {
        try {
            System.out.print("Enter the id to remove:");
            int id = Integer.parseInt(scanner.nextLine());
            reservationService.remove(id);

            System.out.println("Reservation removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateReservation() {
        try {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter movie id (0 to not change for update): ");
            int movieId = scanner.nextInt();
            System.out.print("Enter client card (-1 for unknown client card and 0 to not change for update): ");
            int idClient = scanner.nextInt();
            System.out.print("Enter date (empty to not change for update): ");
            scanner.nextLine();
            String date = scanner.nextLine();
            System.out.print("Enter time (empty to not change for update): ");
            String time = scanner.nextLine();

            reservationService.addOrUpdate(id, movieId, idClient, date, time);

            System.out.println("Reservation added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runClientCrud() {
        while (true) {
            System.out.println("1. Add or update a client");
            System.out.println("2. Remove a client");
            System.out.println("3. View all clients");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateClient();
                    break;
                case "2":
                    handleRemoveClient();
                    break;
                case "3":
                    handleViewClients();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewClients() {
        for (Client client : clientService.getAll()) {
            System.out.println(client);
        }
    }

    private void handleRemoveClient() {
        try {
            System.out.print("Enter the id to remove:");
            int id = scanner.nextInt();
            clientService.remove(id);

            System.out.println("Client removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateClient() {
        try {
            System.out.print("Enter id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter CNP (empty to not change for update): ");
            String CNP = scanner.nextLine();
            System.out.print("Enter fidelity points : ");
            int fidelityPoints = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter last name (empty to not change for update): ");
            String lastName = scanner.nextLine();
            System.out.print("Enter first name (empty to not change for update): ");
            String firstName = scanner.nextLine();
            System.out.print("Enter date of birth (empty to not change for update): ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter date of registration (empty to not change for update): ");
            String dateOfRegistration = scanner.nextLine();

            clientService.addOrUpdate(id, CNP, fidelityPoints, lastName, firstName, dateOfBirth, dateOfRegistration);

            System.out.println("Client added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runMovieCrud() {
        while (true) {
            System.out.println("1. Add or update a movie");
            System.out.println("2. Remove a movie");
            System.out.println("3. View all movies");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateMovie();
                    break;
                case "2":
                    handleRemoveMovie();
                    break;
                case "3":
                    handleViewMovies();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewMovies() {
        for (Movie movie : movieService.getAll()) {
            System.out.println(movie);
        }
    }

    private void handleRemoveMovie() {
        try {
            System.out.print("Enter the id to remove:");
            int id = Integer.parseInt(scanner.nextLine());
            movieService.remove(id);
            System.out.println("Movie removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateMovie() {

        try {
            System.out.print("Enter id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter title (empty to not change for update): ");
            String title = scanner.nextLine();
            System.out.print("Enter releaseDate (empty to not change for update): ");
            String releaseDate = scanner.nextLine();
            System.out.print("Enter price (0 to not change for update): ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter on cinema (true / false): ");
            boolean onCinema = Boolean.parseBoolean(scanner.nextLine());

            movieService.addOrUpdate(id, title, releaseDate, price, onCinema);

            System.out.println("Movie added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
}