/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the ReCubed Mod.
 * 
 * ReCubed is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Dec 14, 2013, 8:18:04 PM (GMT)]
 */
package vazkii.recubed.common.command;

import vazkii.recubed.api.internal.ServerData;
import vazkii.recubed.common.core.helper.MiscHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;

public class CommandWipeData extends CommandBase {

	@Override
	public String getCommandName() {
		return "recubed-wipedata";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "recubed-wipedata";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(icommandsender instanceof EntityPlayer && !MiscHelper.isPlayerAllowedToUseCommands(icommandsender.getCommandSenderName()))
			throw new CommandException("recubed.commands.no_perms");
		
		ServerData.reset();
		ServerData.init();
		icommandsender.sendChatToPlayer(new ChatMessageComponent().addKey("recubed.commands.command_sucessful"));
	}
	
	@Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

}