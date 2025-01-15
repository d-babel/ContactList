public class Teacher extends Person {
    private String subject;

    public Teacher(String firstName, String lastName, String phoneNumber, String subject) {
        super(firstName, lastName, phoneNumber);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return super.toString() + " Subject: " + subject;
    }
}
