package Domain;

public class Movie {
    private Integer id;
    private String title, releaseDate;
    private Double price;
    private Boolean onCinema;

    public Movie(Integer id, String title, String releaseDate, Double price, Boolean onCinema) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.price = price;
        this.onCinema = onCinema;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", price=" + price +
                ", onCinema=" + onCinema +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isOnCinema() {
        return onCinema;
    }

    public void setOnCinema(boolean onCinema) {
        this.onCinema = onCinema;
    }
}

