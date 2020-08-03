import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties({"firstName", "lastName"})
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AnnotationObject extends AnnotationFather{
    @JsonIgnoreType
    public static class Address {
        public String streetName  = null;
        public String houseNumber = null;
        public String zipCode     = null;
        public String city        = null;
        public String country     = null;
    }


    @JsonIgnore
    public long    personId = 0;
    public String  firstName = null;
    public String  lastName  = null;
    public Address address = null;
    private String nonIgnore = null;

    AnnotationObject() {

    }

    AnnotationObject(long personId, String firstName, String lastName, Address address, String nonIgnore) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.nonIgnore = nonIgnore;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "AnnotationObject{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", nonIgnore='" + nonIgnore + '\'' +
                ", extendValue=" + extendValue +
                '}';
    }

    public static class Builder {
        public long    personId = 0;
        public String  firstName = null;
        public String  lastName  = null;
        public Address address = null;
        private String nonIgnore = null;

        public Builder personId(long personId) {
            this.personId = personId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder nonIgnore(String nonIgnore) {
            this.nonIgnore = nonIgnore;
            return this;
        }

        public AnnotationObject build() {
            return new AnnotationObject(personId, firstName, lastName, address, nonIgnore);
        }
    }




}
