package net.thediamondyt.essentials;

import cn.nukkit.Player;

public class Utils {

    public static String toggleFlight(Player player) {
        String state;

        if(player.getAllowFlight()) {
            player.setAllowFlight(false);
            state = "disabled";
        } else {
            player.setAllowFlight(true);
            state = "enabled";
        }
        return state;
    }
}
