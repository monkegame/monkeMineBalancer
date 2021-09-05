package online.monkegame.monkesimp.clans;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Clan {

    private String name;
    private String acronym;

    public Clan(String name, @Nullable String acronym) {
        this.name = name;
        if (acronym != null) {
            this.acronym = acronym;
        }
    }


    public List<UUID> getMembers(String clanName) {

        return new ArrayList<>();

    }


    public void newClan() {



    }


}
