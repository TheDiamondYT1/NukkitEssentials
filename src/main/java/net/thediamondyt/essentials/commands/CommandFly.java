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
import net.thediamondyt.essentials.Utils;

public class CommandFly extends EssentialsCommand {

    public CommandFly(Main plugin) {
        super(plugin, "fly", "Fly around the server!", "[player]");
        setPermission("essentials.fly");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        if(args.length >= 2) {
            sender.sendMessage(sender instanceof Player ? f("<red>Usage: /fly [player]") : f("<red>Usage: /fly <player>"));
            return false;
        }

        if(args.length == 1) {
            Player target = sender.getServer().getPlayer(args[0]);

            if(!(target instanceof Player)) {
                sender.sendMessage(f("<red>That player is not online."));
                return true;
            }

            String message = Utils.toggleFlight((Player) sender);

            target.sendMessage(f("<gold>Set fly mode <red>" + message + " <gold>by " + ((Player) sender).getDisplayName() + "<gold>."));
            sender.sendMessage(f("<gold>Set fly mode <red>" + message + " <gold>for "  + target.getDisplayName() + "<gold>."));
            return true;
        }

        if(!(sender instanceof Player)) {
            sender.sendMessage(f("<red>Usage: /fly <player>"));
            return true;
        }

        String message = Utils.toggleFlight((Player) sender);

        sender.sendMessage(f("<gold>Set fly mode <red>" + message + " <gold>for "  + ((Player) sender).getDisplayName() + "<gold>."));
        return true;
    }
}
