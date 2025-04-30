import java.io.*;
/**
 The {@code VideoSettings} class represents user-configurable video settings,
 including volume level and playback speed. This class supports serialization
 to allow saving and loading settings from a file.
 */
public class VideoSettings implements Serializable {
    // Ensures class version consistency during serialization
    private static final long serialVersionUID = 1L;
    // Volume level (e.g., 0 to 100)
    private int volumeLevel = 6;
    // Playback speed (e.g., 0.5x, 1x, 1.5x, etc.)
    private double playbackSpeed = 1.0;
    /**
     Default constructor initializes settings with default values.
     */
    public VideoSettings() {}
    /**
     Parameterized constructor to initialize settings with specified values.
     *
     @param volumeLevel   The volume level (range: 0 to 100).
     @param playbackSpeed The playback speed (e.g., 0.5x, 1x, 1.5x).
     */
    public VideoSettings(int volumeLevel, double playbackSpeed) {
        this.volumeLevel = volumeLevel;
        this.playbackSpeed = playbackSpeed;
    }
    /**
     Retrieves the current volume level.
     *
     @return The volume level.
     */
    public int getVolumeLevel() {
        return volumeLevel;
    }
    /**
     Updates the volume level.
     *
     @param volumeLevel The new volume level.
     */
    public void setVolumeLevel(int volumeLevel) {
        this.volumeLevel = volumeLevel;
    }
    /**
     Retrieves the current playback speed.
     *
     @return The playback speed.
     */
    public double getPlaybackSpeed() {
        return playbackSpeed;
    }
    /**
     Updates the playback speed.
     *
     @param playbackSpeed The new playback speed.
     */
    public void setPlaybackSpeed(double playbackSpeed) {
        this.playbackSpeed = playbackSpeed;
    }
    /**
     Serializes the {@code VideoSettings} object and saves it to a file.
     *
     @param settings The {@code VideoSettings} object to be saved.
     @param filePath The file path where the settings will be stored.
     */
    public static void serializeSettings(VideoSettings settings, String filePath) {
        // Try-with-resources ensures the stream is closed automatically
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(settings);
        } catch (IOException e) {
            System.err.println("Error saving settings: " + e.getMessage());
        }
    }
    /**
     Deserializes the {@code VideoSettings} object from a file.
     *
     @param filePath The file path from which the settings will be loaded.
     @return The deserialized {@code VideoSettings} object, or a new instance if an error occurs.
     */
    public static VideoSettings deserializeSettings(String filePath) {
        VideoSettings settings = null;
        // Try-with-resources ensures the stream is closed automatically
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            settings = (VideoSettings) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading settings: " + e.getMessage());
            // Return default settings if deserialization fails
            settings = new VideoSettings();
        }
        return settings;
    }
}
