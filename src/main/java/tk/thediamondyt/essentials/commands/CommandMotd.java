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
package tk.thediamondyt.essentials.commands;

import cn.nukkit.command.CommandSender;

import static cn.nukkit.utils.TextFormat.*;

import tk.thediamondyt.essentials.Main;

import java.util.Scanner;

public class CommandMotd extends EssentialsCommand {

    public CommandMotd(Main plugin) {
        super(plugin, "motd", "Display the message of the day.", null);
        setPermission("essentials.motd");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        Scanner s = new Scanner(getPlugin().getClass().getResourceAsStream("/motd.txt"));
        while(s.hasNextLine()) {
            sender.sendMessage(colorize(s.nextLine()).replace("{PLAYER}", sender.getName()));
        }
        return true;
    }
}
