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

public class CommandClearInv extends EssentialsCommand {

    public CommandClearInv(Main plugin) {
        super(plugin, "clearinventory", "Clear your inventory", "[player]", new String[]{"eci", "ci", "eclearinventory", "clearinv", "eclearinv"});
        setPermission("essentials.clearinventory");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        if(args.length >= 2) {
            sender.sendMessage(sender instanceof Player ? "<red>Usage: /clearinventory [player]" : "<red>Usage: /clearinventory <player>");
            return false;
        }

        if(args.length == 1) {
            Player target = sender.getServer().getPlayer(args[0]);

            if(!(target instanceof Player)) {
                sender.sendMessage(f("<red>That player is not online."));
                return true;
            }
            ((Player) target).getInventory().clearAll();
            target.sendMessage(f("<gold>Inventory cleared by " + ((Player) sender).getDisplayName()));
            sender.sendMessage(f("<gold>Inventory of <red>" + ((Player) target).getDisplayName() + " <gold>cleared."));
            return true;
        }

        if(!(sender instanceof Player)) {
            sender.sendMessage(f("<red>Usage: /clearinventory <player>"));
            return true;
        }

        ((Player) sender).getInventory().clearAll();
        sender.sendMessage(f("<gold>Inventory cleared."));
        return true;
    }
}
