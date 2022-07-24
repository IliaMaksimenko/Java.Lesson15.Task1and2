package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Ticket;
import ru.netology.repositories.TicketManager;
import ru.netology.repositories.TicketRepository;

public class TicketManagerTest {

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

    TicketManager manager = new TicketManager(new TicketRepository());


    @BeforeEach
    public void setUp() {

        manager.addNewTicket(ticket1);
        manager.addNewTicket(ticket2);
        manager.addNewTicket(ticket3);
        manager.addNewTicket(ticket4);
        manager.addNewTicket(ticket5);
        manager.addNewTicket(ticket6);
        manager.addNewTicket(ticket7);
        manager.addNewTicket(ticket8);
        manager.addNewTicket(ticket9);
        manager.addNewTicket(ticket10);

    }

    @Test
    public void shouldAddProduct() {

        Ticket[] expected = {ticket1, ticket5, ticket7, ticket10, ticket3, ticket6, ticket2, ticket4, ticket8, ticket9};
        Ticket[] actual = manager.getAddTicket();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchTicketFrom() {

        Ticket[] expected = {ticket10, ticket6, ticket9};
        Ticket[] actual = manager.searchByFrom("SVX");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNoSearchTicketFrom() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchByFrom("DAB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketTo() {

        Ticket[] expected = {ticket5, ticket6};
        Ticket[] actual = manager.searchByTo("MVQ");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNoSearchTicketTo() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchByTo("DBB");

        Assertions.assertArrayEquals(expected, actual);
    }

}
