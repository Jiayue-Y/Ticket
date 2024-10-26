import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;

public class TicketQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Ticket> queue = new Queue<>();
        char input;

        double totalWaitTime = 0;
        int servedTicketNum = 0;
        double averageWaitTime = 0;

        System.out.println("\nWelcome to the ticket queue!");

        do {
            System.out.println("""
                    
                    Please enter 'Q' to get in the queue and \
                    receive a new ticket number.
                    Enter 'D' to dequeue.
                    Enter 'C' to check current queue status.
                    Enter 'Z' to quit.""");

            input = sc.nextLine().charAt(0);
            switch (input) {
                case 'Q':
                case 'q':
                    Ticket ticket = new Ticket();
                    queue.enqueue(ticket);
                    System.out.println("\nYou are in the queue! Your number " +
                            "is " + ticket.getTicketNumber());
                    break;

                case 'D':
                case 'd':
                    if (queue.empty()) {
                        System.out.println("There is no ticket to dequeue.");
                    } else {
                        servedTicketNum++;
                        Duration duration =
                                Duration.between(queue.peek().getTimestamp(),
                                        LocalDateTime.now());
                        totalWaitTime += (double) duration.toMinutes();

                        System.out.println("No. " +
                                queue.dequeue().getTicketNumber() +
                                " has been dequeued.");

                        // Calculate the average wait time
                        if (servedTicketNum > 0) {
                            averageWaitTime = totalWaitTime / servedTicketNum;
                        }
                    }
                    break;

                case 'C':
                case 'c':
                    if (!queue.empty()) {
                        System.out.println("Next in line: No. " +
                                queue.peek().getTicketNumber());
                        System.out.printf("Average wait time per number is: " +
                                "%.1f minutes\n", averageWaitTime);
                        System.out.println("Number of tickets in line: " +
                                queue.getSize());
                    } else {
                        System.out.println("The queue is currently empty.");
                    }
                    break;

                case 'Z':
                case 'z':
                    System.out.printf("Total serving time: %.1f" +
                            "\nTotal tickets served: %d" +
                            "\nAverage serving time per table: %.1f\n",
                            totalWaitTime, servedTicketNum, averageWaitTime);
                    break;

                default:
                    System.out.println("Invalid input. Please enter Q, D, C, " +
                            "or Z.");
                    break;
            }
        } while (input != 'Z' && input != 'z');

        sc.close();
        System.out.println("\nThanks for using Ticket Service. :)");
    }
}