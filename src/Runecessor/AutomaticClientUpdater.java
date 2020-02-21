package Runecessor;

import java.awt.*;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Jason MacKeigan on 2018-05-14 at 1:54 PM
 */
public class AutomaticClientUpdater {

    /**
     * The path to the jar file on the website.
     */
    private static final String JAR_URI = "http://Runecessor.com";

    /**
     * Retrieves the absolute path of the jar file that executed this application.
     *
     * @return the path.
     *
     * @throws URISyntaxException
     *            thrown is the path is incorrect.
     */
    private static String getApplicationPath() throws URISyntaxException {
        return new File(Client.class.getProtectionDomain().getCodeSource().
                getLocation().toURI().getPath()).getAbsolutePath();
    }

    /**
     * Determines whether or not an update is available.
     *
     * @return {@code true} if an update is available.
     */
    public boolean isUpdateAvailable() {
        return ClientLiveConfiguration.CLIENT_VERSION != WebsiteRead.websiteClientLatestVersion;
    }

    /**
     * Attempts to update the client by downloading the jar resource from the website
     * in the same folder as the jar being executed. The resulting jar name will contain
     * the website client version and assumes the internal version is the same as the
     * website version.
     *
     * @return either a successful result indicating that the jar was downloaded and opened,
     *         or a result indicating something went wrong.
     */
    public UpdateResult blockAndUpdate() throws MalformedURLException, URISyntaxException {
        URL applicationURL = new URL(JAR_URI);

        String path = getApplicationPath();

        StringBuilder sb = new StringBuilder(path);

        int indexOfExtension = sb.indexOf(".jar");

        if (!sb.toString().contains(Integer.toString(WebsiteRead.websiteClientLatestVersion))) {
            sb.insert(indexOfExtension, String.format(" v%s", WebsiteRead.websiteClientLatestVersion));
        }
        File applicationFile = new File(sb.toString());

        if (applicationFile.exists()) {
            return UpdateResult.ALREADY_UPDATED;
        }
        File oldApplicationFile = new File(path);

        oldApplicationFile.deleteOnExit();

        try {
            if (applicationFile.createNewFile()) {
                HttpURLConnection connection = (HttpURLConnection) applicationURL.openConnection();

                try (DataInputStream input = new DataInputStream(connection.getInputStream());
                     FileOutputStream output = new FileOutputStream(applicationFile)) {
                    final int size = connection.getContentLength();

                    byte[] data = new byte[1024];

                    int read;

                    int totalRead = 0;

                    while ((read = input.read(data, 0, data.length - 1)) != -1) {
                        output.write(data, 0, read);
                        totalRead += read;
                        Client.instance.drawLoadingTextCacheDownloader(Math.max(0, (int) (((double) totalRead / (double) size) * 100D)), "Downloading updated client", true);
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    return UpdateResult.UNSUCCESSFUL;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return UpdateResult.UNSUCCESSFUL;
        }

        if (launchWithDesktop(applicationFile)) {
            return UpdateResult.SUCCESSFUL;
        } else if (launchWithProcess(applicationFile)) {
            return UpdateResult.SUCCESSFUL;
        }
        return UpdateResult.UNSUCCESSFUL;
    }

    /**
     * Attempts to launch the jar using the {@link Desktop} api.
     *
     * @param applicationJar
     *            the jar being launched.
     * @return {@code true} if the api is supported and was able to open erroneously.
     */
    private boolean launchWithDesktop(File applicationJar) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(applicationJar);

                return true;
            } catch (IOException e) {
                return false;
            }
        }

        return false;
    }

    /**
     * Attempts to launch the jar using the process builder in combination
     * with the JRE executable.
     *
     * @param applicationJar
     *            the jar file being launched.
     * @return {@code true} if the jar could be opened erroneously.
     */
    private boolean launchWithProcess(File applicationJar) {
        File jreFolder = new File(System.getProperty("java.home"));

        File jreExecutable = new File(String.format("%s%sbin%sjava",
                jreFolder.getAbsoluteFile().getAbsolutePath(),
                System.getProperty("file.separator"),
                System.getProperty("file.separator")));

        if (!jreExecutable.exists()) {
            return false;
        }
        ProcessBuilder processBuilder = new ProcessBuilder(jreExecutable.getAbsolutePath(), "-jar", applicationJar.getAbsolutePath());

        try {
            processBuilder.start();

            return true;
        } catch (IOException ioe) {
            return false;
        }
    }

    /**
     * Represents the result of what can occur during an update.
     */
    public enum UpdateResult {
        SUCCESSFUL,

        UNSUCCESSFUL,

        ALREADY_UPDATED
    }

}
