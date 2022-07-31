package ru.netology.repositories;

import ru.netology.exceptions.TicketByTravelTimeComparator;
import ru.netology.product.Ticket;

import java.util.Arrays;

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

    public Ticket[] findAll(String departureAirport, String airportArrival) {

        Ticket[] resultFrom = new Ticket[0];

        for (Ticket ticket : repository.getTickets()) {
            if (ticket.matchesFrom(ticket, departureAirport)) {
                Ticket[] tmp = new Ticket[resultFrom.length + 1];
                System.arraycopy(resultFrom, 0, tmp, 0, resultFrom.length);
                tmp[tmp.length - 1] = ticket;
                resultFrom = tmp;
            }
        }

        Ticket[] resultTo = new Ticket[0];

        for (Ticket ticket : resultFrom) {
            if (ticket.matchesTo(ticket, airportArrival)) {
                Ticket[] tmp = new Ticket[resultTo.length + 1];
                System.arraycopy(resultTo, 0, tmp, 0, resultTo.length);
                tmp[tmp.length - 1] = ticket;
                resultTo = tmp;
            }
        }
        TicketByTravelTimeComparator travelTimeComparator = new TicketByTravelTimeComparator();
        Arrays.sort(resultTo, travelTimeComparator);

        return resultTo;
    }

}
