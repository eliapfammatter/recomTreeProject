package recomTree;

public class GenreTree {
    private GenreNode root;

    public GenreTree(GenreNode root) {
        this.root = new GenreNode("Root");
    }

    public GenreNode getRoot() {
        return root;
    }

    public GenreNode findGenre(String name){
        return root.findSubGenre(name);
    }

    public boolean addGenre(String parentName, String newGenreName){
        GenreNode parent = findGenre(parentName);

        if(parent != null){
            parent.addChild(new GenreNode(newGenreName));
            return true;
        }

        return false;
    }

    public boolean addMovieToGenre(String genreName, Movie movie){
        GenreNode genre = findGenre(genreName);
        if(genre != null){
            genre.addMovie(movie);
            return true;
        }

        return false;
    }

    public Movie findMovieByTitle(String title){
        return root.findMovie(title);
    }
}
