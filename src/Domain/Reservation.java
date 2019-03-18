package Domain;

public class Reservation {
    private int id, movieId, idClient;
    private String date, time;


    public Reservation(int id, int movieId, int idClient, String date, String time) {
        this.id = id;
        this.movieId = movieId;
        this.idClient = idClient;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", idClient=" + idClient +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
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

}
