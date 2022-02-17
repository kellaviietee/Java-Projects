    package ee.taltech.iti0202.socialnetwork;
    import ee.taltech.iti0202.socialnetwork.feed.Feed;
    import ee.taltech.iti0202.socialnetwork.group.Group;
    import ee.taltech.iti0202.socialnetwork.message.Message;
    import ee.taltech.iti0202.socialnetwork.user.User;

    import java.util.HashSet;
    import java.util.Set;

    public class SocialNetwork {
        private static final Set<Group> groups = new HashSet<>();

        public void registerGroup(Group group) {
            groups.add(group);

        }

        public Set<Group> getGroups() {
            return groups;
        }

        public Feed getFeedForUser(User user) {
            Set<Message> messages = new HashSet<>();
            Set<Group> allGroups = getGroups();
            for(Group group:allGroups){
                if(group.getParticipants().contains(user)){
                    messages.addAll(group.getMessages());
                }
            }
            return new Feed(user, messages);
        }
    }