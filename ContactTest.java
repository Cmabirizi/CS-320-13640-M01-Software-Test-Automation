import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "12345", "123 Main St")); // Invalid phone length
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "123456789012", "123 Main St")); // Invalid phone length
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", null));
    }

    @Test
    public void testSetters() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhoneNumber("0987654321");
        assertEquals("0987654321", contact.getPhoneNumber());

        contact.setAddress("456 Oak St");
        assertEquals("456 Oak St", contact.getAddress());
    }

    @Test
    public void testInvalidSetters() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("12345")); // Invalid length
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("123456789012")); // Invalid length
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
}
