package recomTree;

import java.util.ArrayList;
import java.util.List;

public class GenreNode {
    private String name;
    private GenreNode parent;
    private ArrayList<GenreNode> children;
    private ArrayList<Movie> movies;

    public GenreNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenreNode getParent() {
        return parent;
    }

    public void setParent(GenreNode parent) {
        this.parent = parent;
    }

    public ArrayList<GenreNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<GenreNode> children) {
        this.children = children;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void addChild(GenreNode child) {
        if(child == null){
            return;
        }
        child.setParent(this);
        children.add(child);
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>(this.movies);
        for (GenreNode child : children) {
            movies.addAll(child.getAllMovies());
        }
        return movies;
    }

    public void addMovie(Movie movie) {
        if(movie != null){
            movies.add(movie);
        }
    }

    public GenreNode findSubGenre(String name){
        if(this.name.equalsIgnoreCase(name)){
            return this;
        }

        for (GenreNode child : children){
            GenreNode found = child.findSubGenre(name);
            if(found != null){
                return found;
            }
        }

        return null;
    }

    public Movie findMovie(String title){
        for (Movie m : movies){
            if(m.getTitle().equalsIgnoreCase(title)){
                return m;
            }
        }

        for(GenreNode child : children){
            Movie m = child.findMovie(title);
            if(m != null){
                return m;
            }
        }

        return null;
    }
}
