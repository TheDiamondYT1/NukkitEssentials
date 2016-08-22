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
package net.thediamondyt.essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

import net.thediamondyt.essentials.Main;

public class CommandKickall extends EssentialsCommand {

    public CommandKickall(Main plugin) {
        super(plugin, "kickall", "Kick all players from the server", null, new String[]{"ekickall"});
        setPermission("essentials.kickall");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        if(args.length >= 1) {
            sender.sendMessage(f("<red>Usage: /kickall"));
            return false;
        }

        if(sender.getServer().getOnlinePlayers().values().isEmpty()) {
            sender.sendMessage(f("<gold>There are no players on the server."));
            return true;
        }

        for(Player p : sender.getServer().getOnlinePlayers().values()) {
            if(p != sender && !p.isOp()) {
                p.kick("Kicked from the server", false);
            }
        }
        sender.getServer().broadcastMessage(f("<gold>All players have been kicked by " + ((Player) sender).getDisplayName()));
        return true;
    }
}
