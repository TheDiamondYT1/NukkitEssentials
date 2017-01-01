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
package tk.thediamondyt.essentials.commands.teleport;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

import tk.thediamondyt.essentials.Main;
import tk.thediamondyt.essentials.commands.EssentialsCommand;

public class CommandTpall extends EssentialsCommand {

    public CommandTpall(Main plugin) {
        super(plugin, "tpall", "Teleport all players to you.", null, new String[]{"etpall"});
        setPermission("essentials.tpall");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        if(sender.getServer().getOnlinePlayers().values().isEmpty()) {
            sender.sendMessage(f("<gold>There are no players on the server."));
            return true;
        }

        for(Player p : sender.getServer().getOnlinePlayers().values()) {
            if(p != sender) {
                p.teleport(((Player) sender));
                p.sendMessage(f("<gold>Teleporting to " + sender.getName() + "..."));
            }
        }
        sender.sendMessage(f("<gold>Teleporting players to you..."));
        return true;
    }
}
