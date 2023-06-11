import java.io.*;

public class FuelException extends Exception {
    private String fuel;

    public FuelException(String fuel){
        this.fuel = fuel;
    };
    public String getMessage() {
        return "Bensin jenis "+ this.fuel+" tidak sesuai" ;
    };
}