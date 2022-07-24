package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exceptions.AlreadyExistsException;
import ru.netology.exceptions.NotFoundException;
import ru.netology.product.Ticket;
import ru.netology.repositories.TicketRepository;


public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1265, 1_000, "IKT", "ADB", 420);
    Ticket ticket2 = new Ticket(7549, 1_800, "HER", "KZN", 350);
    Ticket ticket3 = new Ticket(3564, 1_700, "KVX", "GDX", 125);
    Ticket ticket4 = new Ticket(2595, 1_900, "KIV", "GDX", 365);
    Ticket ticket5 = new Ticket(7646, 1_300, "KEJ", "MVQ", 752);
    Ticket ticket6 = new Ticket(1546, 1_700, "SVX", "MVQ", 245);
    Ticket ticket7 = new Ticket(9532, 1_500, "CFU", "IKT", 205);
    Ticket ticket8 = new Ticket(8246, 2_000, "KRO", "HER", 342);
    Ticket ticket9 = new Ticket(3745, 2_500, "SVX", "NER", 135);
    Ticket ticket10 = new Ticket(4625, 1_650, "SVX", "NER", 165);

    TicketRepository repository = new TicketRepository();


    @BeforeEach
    public void setUp() {

        repository.addNewTicket(ticket1);
        repository.addNewTicket(ticket2);
        repository.addNewTicket(ticket3);
        repository.addNewTicket(ticket4);
        repository.addNewTicket(ticket5);
        repository.addNewTicket(ticket6);
        repository.addNewTicket(ticket7);
        repository.addNewTicket(ticket8);
        repository.addNewTicket(ticket9);
        repository.addNewTicket(ticket10);

    }

    @Test
    public void shouldAddNewTicket() {

        Ticket[] expected = {ticket1, ticket5, ticket7, ticket10, ticket3, ticket6, ticket2, ticket4, ticket8, ticket9};
        Ticket[] actual = repository.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldRemoveById() {

        repository.removeById(ticket2.getTicketId());

        Ticket[] expected = {ticket1, ticket5, ticket7, ticket10, ticket3, ticket6, ticket4, ticket8, ticket9};
        Ticket[] actual = repository.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void nonExistentId() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(189451);
        });

    }

    @Test
    public void thisIdAlreadyExists() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.addNewTicket(ticket1);
        });
    }
}
