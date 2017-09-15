package com.wheezygold.happybot.events;

import com.wheezygold.happybot.Util.C;
import com.wheezygold.happybot.Util.Roles;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class AutoMod extends ListenerAdapter {
    private final String owner;


    public AutoMod(String owner) {
        this.owner = owner;
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (C.hasRole(event.getGuild(), event.getMember(), Roles.SUPER_ADMIN))
            return;
        if (!event.getMessage().getContent().contains("discord.gg/"))
            return;
        event.getMessage().delete().queue();
        event.getChannel().sendMessage(event.getMember().getAsMention() + "! Do not advert other discord servers!").queue();
        event.getJDA().getTextChannelById("318456047993880577").sendMessage(event.getMember().getAsMention() + " attempted to advert the following link: " + event.getMessage().getContent()).queue();
        return;
    }

}
