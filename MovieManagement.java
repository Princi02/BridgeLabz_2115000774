class Movie{
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}



class MovieLinkedList{
    private Movie head;
    private Movie tail;


    public void addAtBeginning(String title, String director, int year, double rating){
        Movie newMovie = new Movie(title, director, year, rating);
        if(head == null){
            head = tail = newMovie;
        }
        else{
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating){
        Movie newMovie = new Movie(title, director, year, rating);
        if(tail == null){
            head = tail = newMovie;
        }
        else{
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(String title, String director, int year, double rating, int position){
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        for(int i = 1; temp != null && i < position - 1; i++){
            temp = temp.next;
        }

        if(temp == null){
            System.out.println("Invalid position!");
            return;
        }
        newMovie.next = temp.next;
        if(temp.next != null){
            temp.next.prev = newMovie;
        }
        else{
            tail = newMovie;
        }
        newMovie.prev = temp;
        temp.next = newMovie;
    }


    public void removeByTitle(String title){
        Movie temp = head;
        while(temp != null && !temp.title.equalsIgnoreCase(title)){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Movie not found.");
            return;
        }
        if(temp == head){
            head = head.next;
            if(head != null){
                head.prev = null;
            }
        }
        else if(temp == tail){
            tail = tail.prev;
            if(tail != null){
                tail.next = null;
            }
        }
        else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }


    public void searchByDirector(String director){
        Movie temp = head;
        boolean found = false;
        while(temp != null){
            if(temp.director.equalsIgnoreCase(director)){
                System.out.println("Movie Found: " + temp.title + " | Year: " + temp.year + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if(!found) System.out.println("No movies found by director: " + director);
    }

    public void searchByRating(double rating){
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Movie Found: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }


    public void displayForward(){
        if(head == null){
            System.out.println("No movies available.");
            return;
        }
        System.out.println("Movies List (Forward Order):");
        Movie temp = head;
        while(temp != null){
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }


    public void displayReverse(){
        if (tail == null) {
            System.out.println("No movies available.");
            return;
        }
        System.out.println("Movies List (Reverse Order):");
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }


    public void updateRating(String title, double newRating){
        Movie temp = head;
        while(temp != null){
            if(temp.title.equalsIgnoreCase(title)){
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found. ");
    }
}



public class MovieManagement {
    public static void main(String[] args) {
        MovieLinkedList list = new MovieLinkedList();

        list.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        list.addAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 2);
        list.addAtEnd("Parasite", "Bong Joon-ho", 2019, 8.6);
        list.addAtBeginning("The Godfather", "Francis Ford Coppola", 1972, 9.2);

        System.out.println("Initial Movie List:");
        list.displayForward();

        System.out.println("\nSearching for movies directed by Christopher Nolan:");
        list.searchByDirector("Christopher Nolan");

        System.out.println("\nSearching for movies with a rating of 8.6:");
        list.searchByRating(8.6);

        System.out.println("\nUpdating rating for 'Interstellar':");
        list.updateRating("Interstellar", 8.7);

        System.out.println("\nMovies List After Rating Update:");
        list.displayForward();

        System.out.println("\nRemoving 'Parasite' from the list:");
        list.removeByTitle("Parasite");

        System.out.println("\nFinal Movies List (Forward Order):");
        list.displayForward();

        System.out.println("\nFinal Movies List (Reverse Order):");
        list.displayReverse();
    }
}
