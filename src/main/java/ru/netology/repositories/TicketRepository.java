package ru.netology.repositories;

import ru.netology.exceptions.AlreadyExistsException;
import ru.netology.exceptions.NotFoundException;
import ru.netology.product.Ticket;

import java.util.Arrays;


public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];


    public void addNewTicket(Ticket ticket) {

        if (findById(ticket.getTicketId()) != null) {
            throw new AlreadyExistsException(
                    "Element with id: " + ticket.getTicketId() + " already exists"
            );
        }

        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }


    public Ticket findById(int id) {
        for (Ticket product : tickets) {
            if (product.getTicketId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {

        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }

        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket product : tickets) {
            if (product.getTicketId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        tickets = tmp;

    }


    public Ticket[] getTickets() {
        Arrays.sort(tickets);
        return tickets;
    }
}
