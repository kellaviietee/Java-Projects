    package ee.taltech.iti0202.socialnetwork;
    import ee.taltech.iti0202.socialnetwork.feed.Feed;
    import ee.taltech.iti0202.socialnetwork.group.Group;
    import ee.taltech.iti0202.socialnetwork.message.Message;
    import ee.taltech.iti0202.socialnetwork.user.User;

    import java.util.HashSet;
    import java.util.Set;

    public class SocialNetwork {
        private Set<Group> groups = new HashSet<>();

        /**
         * Register a new group to the social network.
         * @param group Group to be added.
         */
        public void registerGroup(Group group) {
            groups.add(group);

        }

        /**
         * Get all the groups on the social network.
         * @return Set of the groups.
         */
        public Set<Group> getGroups() {
            return groups;
        }

        /**
         * Get all the messages for the user from different groups.
         * @param user User who gets the messages.
         * @return Set of messages for the user.
         */
        public Feed getFeedForUser(User user) {
            Set<Message> messages = new HashSet<>();
            Set<Group> allGroups = getGroups();
            for (Group group:allGroups) {
                if (group.getParticipants().contains(user)) {
                    messages.addAll(group.getMessages());
                }
            }
            return new Feed(user, messages);
        }
    }
