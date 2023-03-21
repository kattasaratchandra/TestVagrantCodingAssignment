import java.util.*;
public class RecentlyPlayedSongs {
    // created class variables for fixed capacity and user-song pairs
    private final int fixedCapacity;
    private final Map<String, LinkedList<String>> recentlyPlayed;
    public RecentlyPlayedSongs(int fixedCapacity) {
        this.fixedCapacity = fixedCapacity;
        this.recentlyPlayed = new HashMap<>();
    }
    // This method adds song to the specific user
    public void addSong(String user, String song) {
        LinkedList<String> songs = recentlyPlayed.getOrDefault(user, new LinkedList<>());
        if (songs.size() == fixedCapacity) {
            songs.removeFirst();
        }
        songs.addLast(song);
        recentlyPlayed.put(user, songs);
    }
    // This method returns the list of songs of the specific user
    public List<String> getRecentlyPlayed(String user) {
        LinkedList<String> songs = recentlyPlayed.getOrDefault(user, new LinkedList<>());
        return new ArrayList<>(songs);
    }

    public static void main(String[] args) {
        RecentlyPlayedSongs store = new RecentlyPlayedSongs(3);
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        System.out.println(store.getRecentlyPlayed("user1")); // [S1, S2, S3]
        store.addSong("user1", "S4");
        System.out.println(store.getRecentlyPlayed("user1")); // [S2, S3, S4]
        store.addSong("user1", "S2");
        System.out.println(store.getRecentlyPlayed("user1")); // [S3, S4, S2]
        store.addSong("user1", "S1");
        System.out.println(store.getRecentlyPlayed("user1")); // [S4, S2, S1]
    }
}
