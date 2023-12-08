package kg.java.cafe.core.exceptions;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException() {
        super("entity not found");
    }
}
