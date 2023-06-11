public class InvalidInputCarException extends Exception {
    private int input;
    public InvalidInputCarException(int a){
        this.input = a;
    };
    public String getMessage(){
        return "Input "+input+" diluar range";
    };
}