package chapter01.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)//for postgres
    @GeneratedValue(strategy = GenerationType.AUTO)//for mysql
    Long id;
    @Column(nullable = false)
    String text;

    public Message(String text) {
        setText(text);
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + getId() +
                ", text='" + getText() + '\'' +
                '}';
    }
}
