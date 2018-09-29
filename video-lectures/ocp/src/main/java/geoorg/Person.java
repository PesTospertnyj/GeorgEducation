package geoorg;

public class Person {
    private String firstName;
    private String lastName;

    private Person( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {

            this.lastName = lastName;
            return this;
        }

        public Person build() {
            if (firstName == null) {
                throw new RuntimeException("cannot be null");
            }
            return new Person(this.firstName, this.lastName);
        }
    }

    public static void main(String[] args) {
        new Person( "Ivanov", "Ivan");

//        new PersonBuilder().firstName
    }

}
