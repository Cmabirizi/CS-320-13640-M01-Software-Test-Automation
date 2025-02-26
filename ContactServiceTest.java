import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testAddContact() {
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    public void testAddDuplicateContact() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    public void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test
    public void testDeleteNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("54321"));
    }

    @Test
    public void testUpdateContact() {
        service.addContact(contact);
        service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Oak St");

        Contact updatedContact = service.getContact("12345");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhoneNumber());
        assertEquals("456 Oak St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("54321", "Jane", "Smith", "0987654321", "456 Oak St"));
    }

    @Test
    public void testUpdateWithInvalidData() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("12345", null, "Smith", "0987654321", "456 Oak St"));
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("12345", "Jane", null, "0987654321", "456 Oak St"));
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("12345", "Jane", "Smith", "12345", "456 Oak St")); // Invalid phone
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("12345", "Jane", "Smith", "123456789012", "456 Oak St")); // Invalid phone
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("12345", "Jane", "Smith", "0987654321", null));
    }
}
