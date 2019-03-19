public class Finish extends GameException {
    public Finish(){
        super();
    }

    @Override
    public String message() {
        return "Congraturations!";
    }
}
