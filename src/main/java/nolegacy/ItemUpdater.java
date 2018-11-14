package nolegacy;

import legacy.Item;

public interface ItemUpdater {

    default void updateQuality(Item item) {
        if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        item.setSellIn(item.getSellIn() - 1);

        if (item.getName().equals("Aged Brie")) {
            increaseQuality(item);

            if (item.getSellIn() < 0) increaseQuality(item);
        } else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality(item);

            if (item.getSellIn() < 10) increaseQuality(item);
            if (item.getSellIn() < 5) increaseQuality(item);
            if (item.getSellIn() < 0) item.setQuality(0);
        } else {
            decreaseQuality(item);

            if (item.getSellIn() < 0) decreaseQuality(item);
        }
    }

    default void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    default void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }
}
