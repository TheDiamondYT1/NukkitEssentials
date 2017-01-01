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
package tk.thediamondyt.essentials;

import cn.nukkit.command.CommandMap;
import cn.nukkit.plugin.PluginBase;

import cn.nukkit.utils.Config;
import static cn.nukkit.utils.TextFormat.*;

import tk.thediamondyt.essentials.commands.*;
import tk.thediamondyt.essentials.commands.teleport.*;
import tk.thediamondyt.essentials.commands.override.*;

public class Main extends PluginBase {

    public void onEnable() {
        saveDefaultConfig();
        saveResource("motd.txt");

        loadCommands();
        
        getServer().getLogger().info(GREEN + "NukkitEssentials by TheDiamondYT loaded!");
    }

    private void loadCommands() {
        CommandMap map = getServer().getCommandMap();

        // Normal commands
        map.register("heal", new CommandHeal(this));
        map.register("fly", new CommandFly(this));
        map.register("feed", new CommandFeed(this));
        map.register("kickall", new CommandKickall(this));
        map.register("broadcast", new CommandBroadcast(this));
        map.register("clearinventory", new CommandClearinv(this));
        map.register("motd", new CommandMotd(this));
        
        // Teleportation commands
        map.register("tpall", new CommandTpall(this));
        
        // Overriden commands
        map.register("tell", new CommandMsg(this));
    }
}
