package Domain;

public class Reservation {
    private int id, movieId, idClient, clientFidelityPoints;
    private String date, time;
    private final Double rateDiscount = 0.1;

    public Reservation(int id, int movieId, int idClient, String date, String time, int clientFidelityPoints) {
        this.id = id;
        this.movieId = movieId;
        this.idClient = idClient;
        this.date = date;
        this.time = time;
        this.clientFidelityPoints = clientFidelityPoints;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", idClient=" + idClient +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", discount=" + rateDiscount +
                '}';
    }

    public int getClientFidelityPoints() {
        return clientFidelityPoints;
    }

    public void setClientFidelityPoints(int clientFidelityPoints) {
        this.clientFidelityPoints = clientFidelityPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getRateDiscount() {
        return rateDiscount;
    }
}
