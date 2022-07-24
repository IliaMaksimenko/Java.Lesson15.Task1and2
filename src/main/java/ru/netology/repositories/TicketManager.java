package ru.netology.repositories;

import ru.netology.product.Ticket;

public class TicketManager {

    private final TicketRepository repository;

    public TicketManager(TicketRepository repository) {

        this.repository = repository;

    }

    public void addNewTicket(Ticket ticket) {

        repository.addNewTicket(ticket);

    }

    public Ticket[] getAddTicket() {
        return repository.getTickets();
    }

    public Ticket[] searchByFrom(String text) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getTickets()) {
            if (ticket.matchesFrom(ticket, text)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public Ticket[] searchByTo(String text) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getTickets()) {
            if (ticket.matchesTo(ticket, text)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }
}
