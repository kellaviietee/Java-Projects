package ee.taltech.iti0202.socialnetwork.feed;

import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.Set;

public class Feed {
    private final User user;
    private final Set<Message> messages;

    /**
     * Users social network feed class constructor.
     * @param user User who's feed is it.
     * @param messages Messages on that feed.
     */
    public Feed(User user, Set<Message> messages) {
        this.user = user;
        this.messages = messages;
    }

    public User getUser() {
        return user;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "Feed{"
                + "user=" + user
                + ", messages=" + messages + '}';
    }
}
