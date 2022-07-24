package ru.netology.product;

public class Ticket implements Comparable<Ticket> {

    private int ticketId;
    private int ticketPrice;
    private String departureAirport;
    private String airportArrival;
    private int travelTime;


    public Ticket(int ticketId, int ticketPrice, String departureAirport, String airportArrival, int travelTime) {
        this.ticketId = ticketId;
        this.ticketPrice = ticketPrice;
        this.departureAirport = departureAirport;
        this.airportArrival = airportArrival;
        this.travelTime = travelTime;
    }


    public int getTicketId() {
        return ticketId;
    }


    public int getTicketPrice() {
        return ticketPrice;
    }


    public String getDepartureAirport() {
        return departureAirport;
    }


    public String getAirportArrival() {
        return airportArrival;
    }


    public int getTravelTime() {
        return travelTime;
    }


    @Override
    public int compareTo(Ticket compare) {
        if (this.ticketPrice < compare.ticketPrice) {
            return -1;
        } else if (this.ticketPrice > compare.ticketPrice) {
            return 1;
        } else {
            return 0;
        }
    }


    public boolean matchesFrom(Ticket ticket, String search) {

        return getDepartureAirport().contains(search);

    }

    public boolean matchesTo(Ticket ticket, String search) {

        return getAirportArrival().contains(search);

    }
}
