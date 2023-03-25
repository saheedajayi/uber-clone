package africa.semicolon.uberClone.data.models;

public enum Rating {
    BAD(1),
    FAIR(2),
    SATISFACTORY(3),
    GOOD(4),
    EXCELLENT(5);

    private int rating;

    public int getRating(){
        return rating;
    }
    Rating(int rating){
        this.rating = rating;
    }
}
