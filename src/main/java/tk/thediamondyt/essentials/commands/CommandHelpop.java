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

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

import tk.thediamondyt.essentials.Main;

public class CommandHelpop extends EssentialsCommand {

    public CommandKickall(Main plugin) {
        super(plugin, "helpop", "Ask an operator for help.", null, new String[]{"ehelpop"});
        setPermission("essentials.helpop");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        for(Player p : sender.getServer().getOnlinePlayers().values()) {
            if(!p.isOp()) {
				sender.sendMessage(f("<gold>There are no operators on the server."));
				return true;
            } else {
				// TODO: Match Essentials message format
				p.sendMessage(f("<darkred>HelpOp: <yellow>" + args.split(" ")));
				sender.sendMessage(f("<darkred>HelpOp: <yellow>" + args.split(" ")));
				return true;
			}
        }
        return true;
    }
}
