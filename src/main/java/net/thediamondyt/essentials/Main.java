/*
 *
 *   __________         ______                                   ____      _________
 *   |__   __| |        |  __ \(_)                               | \ \   / /__   __|
 *      | |  | |__   ___| |  | |_  __ _ _ __ ___   ___  _ __   __| |\ \_/ /   | |
 *      | |  | '_ \ / _ \ |  | | |/ _` | '_ ` _ \ / _ \| '_ \ / _` | \   /    | |
 *      | |  | | | |  __/ |__| | | (_| | | | | | | (_) | | | | (_| |  | |     | |
 *      |_|  |_| |_|\___|_____/|_|\__,_|_| |_| |_|\___/|_| |_|\__,_|  |_|     |_|
 *
 *
 * NukkitEssentials v1.0
 */
package net.thediamondyt.essentials;

import cn.nukkit.command.CommandMap;
import cn.nukkit.plugin.PluginBase;

import static cn.nukkit.utils.TextFormat.*;

import net.thediamondyt.essentials.commands.*;

public class Main extends PluginBase {

    public void onEnable() {
        getServer().getLogger().info(GREEN + "NukkitEssentials by TheDiamondYT loaded!");
        loadCommands();
    }

    private void loadCommands() {
        CommandMap map = getServer().getCommandMap();

        map.register("heal", new CommandHeal(this));
        map.register("fly", new CommandFly(this));
        map.register("kickall", new CommandKickall(this));
        map.register("broadcast", new CommandBroadcast(this));
    }
}
