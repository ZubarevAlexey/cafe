package kg.java.cafe.core.exceptions;

public class EntityDuplicateException extends Exception{
    public EntityDuplicateException() {
        super("entity exist");
    }
}
