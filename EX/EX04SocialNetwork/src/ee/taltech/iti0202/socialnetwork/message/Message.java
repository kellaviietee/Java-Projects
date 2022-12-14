package ee.taltech.iti0202.socialnetwork.message;

import ee.taltech.iti0202.socialnetwork.user.User;

public class Message {
    private final String title;
    private final String message;
    private final User author;

    /**
     * Constructor for Message class.
     * @param title Title of the message.
     * @param message Content of the message.
     * @param author Author of the message.
     */
    public Message(String title, String message, User author) {
        this.title = title;
        this.message = message;
        this.author = author;

    }

    public String getTitle() {
        return title;

    }

    public String getMessage() {
        return message;

    }

    public User getAuthor() {
        return author;

    }

    @Override
    public String toString() {
        return "Message{"
                + "title='" + title + '\''
                + '}';
    }
}
