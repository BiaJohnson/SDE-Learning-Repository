/**The {@code VideoSettingsTest} class tests the serialization and deserialization
        functionality of the {@code VideoSettings} class. It creates a settings object,
saves it to a file, loads it back, and verifies that the values are correctly retained.
        */
public class VideoSettingsTest {
    /**
     The main method serves as the entry point for testing the {@code VideoSettings} class.
     *
     @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a VideoSettings object with specific settings
        VideoSettings initialSettings = new VideoSettings(50, 1.5);
        String filePath = "videoSettings.ser"; // File path for serialization
        // Print initial settings before serialization
        System.out.println("Initial Settings:");
        System.out.println("Volume Level: " + initialSettings.getVolumeLevel());
        System.out.println("Playback Speed: " + initialSettings.getPlaybackSpeed());
        // Serialize the settings object to a file
        VideoSettings.serializeSettings(initialSettings, filePath);
        // Deserialize the settings object from the file
        VideoSettings loadedSettings = VideoSettings.deserializeSettings(filePath);
        // Print the loaded settings after deserialization
        System.out.println("\nLoaded Settings:");
        System.out.println("Volume Level: " + loadedSettings.getVolumeLevel());
        System.out.println("Playback Speed: " + loadedSettings.getPlaybackSpeed());
        // Verify if the loaded settings match the original settings
        if (initialSettings.getVolumeLevel() == loadedSettings.getVolumeLevel() &&
                initialSettings.getPlaybackSpeed() == loadedSettings.getPlaybackSpeed()) {
            System.out.println("\nTest passed: The loaded settings match the initial settings.");
        } else {
            System.out.println("\nTest failed: The loaded settings do not match the initial settings.");
        }
    }
}








