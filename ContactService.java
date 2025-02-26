import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        if (contactId == null || contactId.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be null or empty.");
        }
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactId);
    }

    // Update specific contact fields
    public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }

        if (firstName != null && !firstName.trim().isEmpty()) {
            contact.setFirstName(firstName);
        }
        if (lastName != null && !lastName.trim().isEmpty()) {
            contact.setLastName(lastName);
        }
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            contact.setPhoneNumber(phoneNumber);
        }
        if (address != null && !address.trim().isEmpty()) {
            contact.setAddress(address);
        }
    }

    // Retrieve a contact by ID
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
