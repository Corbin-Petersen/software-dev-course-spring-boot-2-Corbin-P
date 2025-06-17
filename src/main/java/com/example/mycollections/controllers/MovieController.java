package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import com.example.mycollections.models.Book;
import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movie> movies = new ArrayList<>() {{
        add(new Movie("Inception", "Christopher Nolan", 2010, 148));
        add(new Movie("Coherence", "James Byrkit", 2013, 89));
        add(new Movie("Star Wars: Episode IV - A New Hope", "George Lucas", 1977, 121));
    }};

    @GetMapping("/json")
    public List<Movie> getMoviesJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie.getName() + "</li>";
        }
        movieList += "</ul>";

        return """
            <html>
                <body>
                    <h1>Albums</h1>
                    <ul>
            """ +
            movieList +
            """
                    </ul>
                </body>
            """;
    }
}
