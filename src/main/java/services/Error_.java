package services;

public class Error_ {
    String text;

    public Error_(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }
}
