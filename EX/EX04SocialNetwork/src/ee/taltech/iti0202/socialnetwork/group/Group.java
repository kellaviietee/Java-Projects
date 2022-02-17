package ee.taltech.iti0202.socialnetwork.group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private  String name;
    private final User owner;
    private Set<User> participants;
    private List<Message> groupMessages;

    /**
     * Constructor for Group class.
     * @param name Name of the group.
     * @param owner Owner of the group.
     */
    public Group(String name, User owner) {
        this.name = name;
        this.owner = owner;
        this.participants = new HashSet<>();
        this.groupMessages = new ArrayList<>();
        addUser(owner);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void addUser(User user) {
        participants.add(user);

    }

    public Set<User> getParticipants() {
        return participants;
    }

    public void publishMessage(Message message) {
        User messageAuthor = message.getAuthor();
        if (participants.contains(messageAuthor)) {
            groupMessages.add(message);
        }

    }

    public List<Message> getMessages() {
        return groupMessages;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}
