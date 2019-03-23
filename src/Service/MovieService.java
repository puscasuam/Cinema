package Service;

import Domain.Movie;
import Repository.IRepository;


import java.util.List;

public class MovieService extends IsSearchable<Movie>{
    private IRepository<Movie> repository;

    public MovieService(IRepository<Movie> repository) {
        this.repository = repository;
    }

    public void addOrUpdate(Integer id, String title, String releaseDate, Double price, Boolean onCinema) {
        Movie existing = repository.findById(id);

        if (existing != null) {
            // update only the fields which are not empty or != 0
            if (id == 0) {
                id = existing.getId();
            }
            if (title.isEmpty()) {
                title = existing.getTitle();
            }
            if (releaseDate.isEmpty()) {
                releaseDate = existing.getReleaseDate();
            }
            if (price == 0.0) {
                price = existing.getPrice();
            }
        }

        Movie movie = new Movie(id, title, releaseDate, price, onCinema);
        repository.insertOrUpdate(movie);
    }

    public void remove(Integer id) {
        repository.remove(id);
    }

    public List<Movie> getAll() {
        return repository.getAll();
    }

    public List<Integer> textSearch(String[] words) {
        return super.fullTextSearch(words, repository.getAll());
    }

}
