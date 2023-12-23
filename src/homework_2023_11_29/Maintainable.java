package homework_2023_11_29;

public interface Maintainable {

    void repairItem();
    void updateItemCondition(ItemCondition condition);
    ItemCondition checkCondition();
}
