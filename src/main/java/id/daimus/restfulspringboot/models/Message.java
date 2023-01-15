package id.daimus.restfulspringboot.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message_book_id")
    private String messageBookId;
    @Column(name = "message")
    private String message;
    @Column(name = "from")
    private String from;
    @Column(name = "is_anonymous")
    private Boolean isAnonymous = true;
}
