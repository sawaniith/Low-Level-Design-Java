package LibraryManagementSystem;

import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private User user;
    private Book book;
    private LocalDateTime borrowedAt;
    private LocalDateTime returnedAt;
}
