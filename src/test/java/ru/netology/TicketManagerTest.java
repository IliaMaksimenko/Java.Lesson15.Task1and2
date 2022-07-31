package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Ticket;
import ru.netology.repositories.TicketManager;
import ru.netology.repositories.TicketRepository;

import java.util.Arrays;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket(1265, 1_000, "IKT", "SVX", 420);
    Ticket ticket2 = new Ticket(7549, 1_800, "HER", "KZN", 350);
    Ticket ticket3 = new Ticket(3564, 1_700, "KVX", "GDX", 125);
    Ticket ticket4 = new Ticket(2595, 1_900, "KIV", "GDX", 365);
    Ticket ticket5 = new Ticket(7646, 1_300, "KZN", "MVQ", 752);
    Ticket ticket6 = new Ticket(1546, 1_700, "SVX", "NER", 345);
    Ticket ticket7 = new Ticket(9532, 1_500, "CFU", "IKT", 205);
    Ticket ticket8 = new Ticket(8246, 2_000, "KZN", "MVQ", 752);
    Ticket ticket9 = new Ticket(3745, 2_500, "SVX", "NER", 350);
    Ticket ticket10 = new Ticket(4625, 1_650, "SVX", "NER", 325);
    Ticket ticket11 = new Ticket(9564, 1_050, "IKT", "ADB", 410);
    Ticket ticket12 = new Ticket(6749, 1_650, "IKT", "ADB", 408);
    Ticket ticket13 = new Ticket(2565, 2_750, "SVX", "DMV", 245);
    Ticket ticket14 = new Ticket(7634, 2_250, "SVX", "DMV", 238);
    Ticket ticket15 = new Ticket(1559, 1_750, "KZN", "DMV", 221);

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
        manager.addNewTicket(ticket11);
        manager.addNewTicket(ticket12);
        manager.addNewTicket(ticket13);
        manager.addNewTicket(ticket14);
        manager.addNewTicket(ticket15);

    }

    @Test
    public void addProductAndSortByPrice() {

        Ticket[] expected = {ticket1, ticket11, ticket5, ticket7, ticket10, ticket12, ticket3, ticket6, ticket15, ticket2, ticket4, ticket8, ticket14, ticket9, ticket13};
        Ticket[] actual = manager.getAddTicket();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchTicketFromAndTo() {

        Ticket[] expected = {ticket10, ticket6, ticket9};
        Ticket[] actual = manager.findAll("SVX", "NER");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void noSearchTicketFromTo() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("DAB", "ADB");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchTicketAndSort() {

        Ticket[] expected = {ticket12, ticket11};
        Ticket[] actual = manager.findAll("IKT", "ADB");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchTicketAndDoNotRearrange() {

        Ticket[] expected = {ticket5, ticket8};
        Ticket[] actual = manager.findAll("KZN", "MVQ");

        Assertions.assertArrayEquals(expected, actual);
    }

}
