package Service;

import CustomException.NonExistingEntityException;
import Domain.Client;
import Domain.Movie;
import Domain.Reservation;
import Repository.IRepository;

import java.util.List;

public class ReservationService extends IsSearchable<Reservation> {
    private IRepository<Movie> movieRepository;
    private IRepository<Client> clientRepository;
    private IRepository<Reservation> reservationRepository;

    public ReservationService(IRepository<Movie> movieRepository, IRepository<Client> clientRepository, IRepository<Reservation> reservationRepository) {
        this.movieRepository = movieRepository;
        this.clientRepository = clientRepository;
        this.reservationRepository = reservationRepository;
    }

    /**
     * Add a new reservation or update an existing one
     * Update de number of fidelitypoints if the movie or the client is update
     *
     * @param id
     * @param movieId
     * @param idClient
     * @param date
     * @param time
     * @return
     */
    public Reservation addOrUpdate(int id, int movieId, int idClient, String date, String time) throws NonExistingEntityException {

        Reservation existingReservation = reservationRepository.findById(id);

        if (existingReservation != null) {

            Client oldExistingClient = clientRepository.findById(existingReservation.getIdClient());
            Movie oldExistingMovie = movieRepository.findById(existingReservation.getMovieId());
            boolean needsUpdate = true;

            // keep unchanged fields as they were
            if (movieId == 0) {
                movieId = existingReservation.getMovieId();
            } else {
                needsUpdate = false;
                if (oldExistingClient != null) {
                    oldExistingClient.setFidelityPoints(oldExistingClient.getFidelityPoints() - oldExistingMovie.getPoints());
                }
            }

            if (idClient == 0) {
                idClient = existingReservation.getIdClient();
            } else {
                if (needsUpdate == true) {
                    if (oldExistingClient != null) {
                        oldExistingClient.setFidelityPoints(oldExistingClient.getFidelityPoints() - oldExistingMovie.getPoints());
                    }
                }
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
            throw new NonExistingEntityException("There is no movie with the given id!");
        }

        if (existingMovie.isOnCinema() == false) {
            throw new NonExistingEntityException("The movie is not on cinema");
        }

        Client existingClient = clientRepository.findById(idClient);
        if (existingClient != null) {
            existingClient.setFidelityPoints(existingClient.getFidelityPoints() + existingMovie.getPoints());
        }

        Reservation reservation = new Reservation(id, movieId, idClient, date, time);
        reservationRepository.insertOrUpdate(reservation);

        return reservation;
    }


    /**
     * remove a reservation by id reservation
     * update the number of fidelity points
     *
     * @param id to be removed
     */
    public void remove(Integer id) {
        Reservation existingReservation = reservationRepository.findById(id);

        if (existingReservation != null) {
            if (existingReservation.getIdClient() != 0) {
                Client existingClient = clientRepository.findById(existingReservation.getIdClient());
                Movie existingMovie = movieRepository.findById(existingReservation.getMovieId());

                if (existingClient != null) {
                    existingClient.setFidelityPoints(existingClient.getFidelityPoints() - existingMovie.getPoints());
                }
            }
        }

        reservationRepository.remove(id);
    }

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }
}



