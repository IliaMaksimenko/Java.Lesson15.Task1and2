package ru.netology.exceptions;

import ru.netology.product.Ticket;

import java.util.Comparator;

public class TicketByTravelTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket compare1, Ticket compare2) {
        if (compare1.getTravelTime() < compare2.getTravelTime()) {
            return -1;
        } else if (compare1.getTravelTime() > compare2.getTravelTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}
