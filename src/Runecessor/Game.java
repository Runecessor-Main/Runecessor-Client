package Runecessor;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Execute the game.
 *
 * @author Lava, created on 24-03-2015.
 */
public class Game {
    /**
     * Main settings to launch the client.
     *
     * @throws Exception
     */
    public static void clientLaunch() throws Exception {
        try {

            Client.nodeID = 10;
            Client.portOff = 0;
            Client.isMembers = true;
            SignLink.storeid = 32;
            try {
                SignLink.startpriv(InetAddress.getLocalHost());
            } catch (UnknownHostException uhe) {
                SignLink.startpriv(InetAddress.getByName("127.0.0.1"));
            }
			Client.clientIdVersion = 675_908_213;
            Client.generateLoadingBarColour();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
