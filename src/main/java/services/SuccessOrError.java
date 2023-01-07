package services;

public class SuccessOrError {
    Object object;
    String error;



    public SuccessOrError(String error) {
        this.error = error;
    }

    public SuccessOrError(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public String getError() {
        return error;
    }
}
