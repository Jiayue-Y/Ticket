import java.time.LocalDateTime;

public class Ticket {
    public static int count;
    public int ticketNumber;
    LocalDateTime timestamp;

    public Ticket(){
        count++;
        ticketNumber = count;
        timestamp = LocalDateTime.now();
    }

    LocalDateTime getTimestamp(){ return timestamp; }

    int getTicketNumber(){ return ticketNumber; }

    void resetTicketNumber(){ count = 0; }
}

