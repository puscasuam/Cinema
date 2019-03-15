package Service;

import Domain.Client;
import Domain.Movie;
import Domain.Reservation;
import Repository.ClientRepository;
import Repository.MovieRepository;
import Repository.ReservationRepository;

import java.util.List;

public class ReservationService {
    private MovieRepository movieRepository;
    private ClientRepository clientRepository;
    private ReservationRepository reservationRepository;

    public ReservationService(MovieRepository movieRepository, ClientRepository clientRepository, ReservationRepository reservationRepository) {
        this.movieRepository = movieRepository;
        this.clientRepository = clientRepository;
        this.reservationRepository = reservationRepository;
    }

    public Reservation addOrUpdate(int id, int movieId, int idClient, String date, String time) {

        Reservation existingReservation = reservationRepository.findById(id);
        if (existingReservation != null) {
            // keep unchanged fields as they were
            if (movieId == 0) {
                movieId = existingReservation.getMovieId();
            }
            if (idClient == 0) {
                idClient = existingReservation.getIdClient();
            }
            if (date.isEmpty()) {
                date = existingReservation.getDate();
            }
            if (time.isEmpty()) {
                time = existingReservation.getTime();
            }
        }

        Movie existingMovie = movieRepository.findById(movieId);
        if (existingMovie == null) {
            throw new RuntimeException("There is no movie with the given id!");
        }

        if (existingMovie.isOnCinema() == false) {
            throw new RuntimeException("The movie is not on cinema");
        }


        int clientFidelityPoints = 0;

        Client existingClient = clientRepository.findById(idClient);
        if(existingClient != null){
            Double discount = existingMovie.getPrice()*existingReservation.getRateDiscount();
            existingClient.setFidelityPoints(existingClient.getFidelityPoints() + discount.intValue());
            clientFidelityPoints = existingClient.getFidelityPoints();
        }

        Reservation reservation = new Reservation(id, movieId, idClient, date, time, clientFidelityPoints);
        reservationRepository.insertOrUpdate(reservation);

        return reservation;
    }

    public void remove(String id) {
        reservationRepository.remove(id);
    }

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }


}



