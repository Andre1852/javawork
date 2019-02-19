package homework2;

public class MyArreyDataException extends NumberFormatException{
public int line;
public int column;

    public MyArreyDataException(int line, int column) {
        this.line = line;
        this.column = column;
    }
}
