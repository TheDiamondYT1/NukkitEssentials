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

import cn.nukkit.utils.Config;
import static cn.nukkit.utils.TextFormat.*;

import net.thediamondyt.essentials.commands.*;
import net.thediamondyt.essentials.commands.warp.*;
import net.thediamondyt.essentials.commands.teleport.*;
import net.thediamondyt.essentials.commands.override.*;

public class Main extends PluginBase {
    
    public Config warps;

    public void onEnable() {
        saveResource("warps.yml", true);
        this.warps = new Config("warps.yml", Config.YAML);
        
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
        
        // Teleportation commands
        map.register("tpall", new CommandTpall(this));
        map.register("setwarp", new CommandSetwarp(this));
        
        // Overriden commands
        map.register("tell", new CommandMsg(this));
    }
    
    public Config getWarps() {
        return warps;
    }
}
