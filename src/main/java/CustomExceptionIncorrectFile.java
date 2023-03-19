public class CustomExceptionIncorrectFile extends Exception {
    @Override
    public String toString() {
        return  "File is incorrect";
    }
}
