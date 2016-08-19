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

import static  cn.nukkit.utils.TextFormat.*;

import net.thediamondyt.essentials.Main;

public class CommandHeal extends EssentialsCommand {

    public CommandHeal(Main plugin) {
        super(plugin, "heal", "Heal yourself or another player", "[player]");
        setPermission("essentials.heal");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        if(args.length >= 2) {
            sender.sendMessage(sender instanceof Player ? RED + "Usage: /heal [player]" : RED + "Usage: /heal <player>");
            return false;
        }

        if(args.length == 1) {
            Player target = sender.getServer().getPlayer(args[0]);

            if(!(target instanceof Player)) {
                sender.sendMessage(RED + "That player is not online");
                return true;
            }
            ((Player) target).setHealth(20);
            target.sendMessage(GREEN + "You have been healed by " + YELLOW + sender.getName());
            sender.sendMessage(GOLD + "You healed " + YELLOW + target.getName());
            return true;
        }

        if(!(sender instanceof Player)) {
            sender.sendMessage("Usage: /heal <player>");
            return true;
        }
        ((Player) sender).setHealth(20);
        sender.sendMessage(GREEN + "Your have been healed");
        return true;
    }
}
