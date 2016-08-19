package net.thediamondyt.essentials;

import cn.nukkit.Player;

public class Utils {

    public static String toggleFlight(Player player) {
        String message;

        if(player.getAllowFlight()) {
            player.setAllowFlight(false);
            message = "disabled";
        } else {
            player.setAllowFlight(true);
            message = "enabled";
        }
        return message;
    }

}
