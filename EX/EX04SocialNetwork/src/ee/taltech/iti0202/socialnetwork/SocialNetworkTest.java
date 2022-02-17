package ee.taltech.iti0202.socialnetwork;

import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SocialNetworkTest {
    private static final int TEST_AGE1 = 32;
    private static final int TEST_AGE2 = 25;
    /**
     * Test Creating a User with two different constructors
     */
    @Test
    public void testUserConstructors(){
        User firstUser = new User("Lauri",TEST_AGE1);
        User secondUser = new User("Terje");
        assertEquals(TEST_AGE1,firstUser.getAge());
        assertNull(secondUser.getAge());
        assertEquals("Terje",secondUser.getName());
        assertEquals("User{name='Lauri'}",firstUser.toString());
    }
    /**
     * Test Creating a message.
     */
    @Test
    public void testMessage(){
        User firstUser = new User("Lauri",TEST_AGE1);
        Message testMessage = new Message("Hello World","To be or not to be",firstUser);
        assertEquals("Hello World",testMessage.getTitle());
        assertEquals("To be or not to be",testMessage.getMessage());
        assertEquals(firstUser,testMessage.getAuthor());
        assertEquals("Message{title='Hello World'}",testMessage.toString());
    }

    /**
     * Test Group creating constructor
     */
    @Test
    public void testGroup(){
        User firstUser = new User("Lauri",TEST_AGE1);
        Group testGroup = new Group("testGroup",firstUser);
        assertEquals("testGroup", testGroup.getName());
        assertEquals(firstUser,testGroup.getOwner());
    }
    /**
     * Test Group changing name.
     */
    @Test
    public void testGroupChangeName(){
        User firstUser = new User("Lauri",TEST_AGE1);
        Group testGroup = new Group("testGroup",firstUser);
        testGroup.setName("anotherGroup");
        assertEquals("anotherGroup", testGroup.getName());
    }
    /**
     * Test Group participants.
     */
    @Test
    public void testGroupParticipants(){
        Set<User> testSet = new HashSet<>();
        User firstUser = new User("Lauri",TEST_AGE1);
        testSet.add(firstUser);
        Group testGroup = new Group("testGroup",firstUser);
        assertEquals(testSet, testGroup.getParticipants());
    }
    /**
     * Test Group publish Message method with Group member.
     */
    @Test
    public void testGroupPublishMessageMember(){
        User firstUser = new User("Lauri",TEST_AGE1);
        Group testGroup = new Group("testGroup",firstUser);
        Message testMessage = new Message("William Shakesphere","to be or not to be",firstUser);
        testGroup.publishMessage(testMessage);
        List<Message> testMessages = new ArrayList<>();
        testMessages.add(testMessage);
        assertEquals(testMessages,testGroup.getMessages());
    }
    /**
     * Test Group publish Message method with non - Group member.
     */
    @Test
    public void testGroupToString(){
        User firstUser = new User("Lauri",TEST_AGE1);
        User secondUser = new User("Terje");
        Group testGroup = new Group("testGroup",secondUser);
        Message testMessage = new Message("William Shakesphere","to be or not to be",firstUser);
        testGroup.publishMessage(testMessage);
        List<Message> testMessages = new ArrayList<>();
        assertEquals(testMessages,testGroup.getMessages());
    }
    /**
     * Test Group toString method.
     */
    @Test
    public void testGroupPublishMessageNonMember(){
        User secondUser = new User("Terje");
        String testString = "Group{name='testGroup'}";
        Group testGroup = new Group("testGroup",secondUser);
        assertEquals(testString,testGroup.toString());
    }
    /**
     * Test Feed constructor.
     */
    @Test
    public void feedConstructor(){
        User firstUser = new User("Lauri",TEST_AGE1);
        User secondUser = new User("Terje");
        User thirdUser = new User("Kaupo");
        Set<Message> testMessages = new HashSet<>();
        Message testMessage = new Message("William Shakesphere","to be or not to be",secondUser);
        Message testMessage1 = new Message("William Shakesphere","what would be more noble",firstUser);
        testMessages.add(testMessage);
        testMessages.add(testMessage1);
        Feed testFeed = new Feed(thirdUser,testMessages);
        assertEquals(thirdUser,testFeed.getUser());
        assertEquals(testMessages,testFeed.getMessages());
    }
    /**
     * Test Social network register Group.
     */
    @Test
    public void testSocialNetworkRegister(){
        SocialNetwork socialNetwork = new SocialNetwork();
        Set<Group> testSet = new HashSet<>();
        User firstUser = new User("Lauri",TEST_AGE1);
        User secondUser = new User("Terje");
        User thirduser = new User("Kaupo");
        Group testGroup = new Group("testGroup",secondUser);
        Group testGroup1 = new Group("testGroup1",firstUser);
        Group testGroup2 = new Group("testGroup2",thirduser);
        Message testMessage = new Message("William Shakesphere","to be or not to be",firstUser);
        socialNetwork.registerGroup(testGroup);
        socialNetwork.registerGroup(testGroup1);
        testSet.add(testGroup);
        testSet.add(testGroup1);
        assertEquals(testSet,socialNetwork.getGroups());
    }
    /**
     * Test Social network get user Feed.
     */
    @Test
    public void testSocialNetworkUserFeed(){
        //Creating test Feed for third User.
        User firstUser = new User("Lauri",TEST_AGE1);
        User secondUser = new User("Terje");
        User thirdUser = new User("Kaupo");
        Set<Message> testMessages = new HashSet<>();
        Message testMessage = new Message("William Shakesphere","to be or not to be",secondUser);
        Message testMessage1 = new Message("William Shakesphere","what would be more noble",firstUser);
        testMessages.add(testMessage);
        testMessages.add(testMessage1);
        Feed testFeed = new Feed(thirdUser,testMessages);
        //First group
        Group group1 = new Group("Group1",thirdUser);
        group1.addUser(firstUser);
        group1.publishMessage(testMessage1);
        //Second group
        Group group2 = new Group("Group2",thirdUser);
        group2.addUser(secondUser);
        group2.publishMessage(testMessage);
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.registerGroup(group1);
        socialNetwork.registerGroup(group2);
        assertEquals(testFeed,socialNetwork.getFeedForUser(thirdUser));

    }


}