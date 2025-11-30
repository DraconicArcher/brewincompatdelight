package com.draconicarcher.brewincompatdelight.integration;

import com.draconicarcher.brewincompatdelight.items.BCDItems;
import dev.ghen.thirst.api.ThirstHelper;
import dev.ghen.thirst.foundation.common.event.RegisterThirstValueEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ThirstWasTakenIntegration {

     @SubscribeEvent
    public static void compat(RegisterThirstValueEvent event) {
        event.addDrink(BCDItems.RUM.get(), 10, 14);
         event.addDrink(BCDItems.LEMON_LIME.get(), 8, 13);
         event.addDrink(BCDItems.WHITE_WINE.get(), 10, 14);
         event.addDrink(BCDItems.HALF_AND_HALF.get(), 10, 14);
         event.addDrink(BCDItems.RED_WINE.get(), 10, 14);
         event.addDrink(BCDItems.SWEET_RED_WINE.get(), 10, 14);
         event.addDrink(BCDItems.MULLED_WINE.get(), 12, 22);
         event.addDrink(BCDItems.PEACH_WINE.get(), 10, 14);
         event.addDrink(BCDItems.TEQUILA.get(), 10, 14);
         event.addDrink(BCDItems.MOONSHINE.get(), 10, 14);
         event.addDrink(BCDItems.NUT_BROWN_ALE.get(), 10, 14);
         event.addDrink(BCDItems.HARD_CIDER.get(), 10, 14);
         event.addDrink(BCDItems.HARD_LEMONADE.get(), 10, 14);
         event.addDrink(BCDItems.GIN.get(), 10, 14);
         event.addDrink(BCDItems.BLUE_CURACAO.get(), 10, 14);
         event.addDrink(BCDItems.BLACK_RUSSIAN.get(), 12, 18);
         event.addDrink(BCDItems.WHITE_RUSSIAN.get(), 12, 18);
         event.addDrink(BCDItems.SCREWDRIVER.get(), 10, 16);
         event.addDrink(BCDItems.MOJITO.get(), 10, 16);
         event.addDrink(BCDItems.PINA_COLADA.get(), 10, 16);
         event.addDrink(BCDItems.WHISKEY.get(), 10, 14);
         event.addDrink(BCDItems.BOILERMAKER.get(), 12, 18);
         event.addDrink(BCDItems.MARGARITA.get(), 10, 16);
         event.addDrink(BCDItems.SALTED_MARGARITA.get(), 12, 18);
         event.addDrink(BCDItems.TEQUILA_SUNRISE.get(), 10, 16);
         event.addDrink(BCDItems.KRAKEN_RUM.get(), 12, 22);
         event.addDrink(BCDItems.WHISKEY_SOUR.get(), 10, 16);
         event.addDrink(BCDItems.CHINA_BLUE.get(), 12, 18);
         event.addDrink(BCDItems.SINGAPORE_SLING.get(), 12, 18);
         event.addDrink(BCDItems.AQUA_VELVA.get(), 10, 16);
         event.addDrink(BCDItems.GIN_AND_TONIC.get(), 10, 16);
         event.addDrink(BCDItems.GIN_AND_JUICE.get(), 10, 16);
         event.addDrink(BCDItems.MERMAID_LEMONADE.get(), 10, 16);
         event.addDrink(BCDItems.BEES_KNEES.get(), 10, 16);
         event.addDrink(BCDItems.GIMLET.get(), 10, 16);
         event.addDrink(BCDItems.BRASS_MONKEY.get(), 12, 22);
         event.addDrink(BCDItems.VODKA_TONIC.get(), 10, 16);
         event.addDrink(BCDItems.MEDINA.get(), 12, 22);
         event.addDrink(BCDItems.JOHNNY_SILVERHAND.get(), 10, 16);
    }


}
