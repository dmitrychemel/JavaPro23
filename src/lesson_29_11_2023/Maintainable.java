package lesson_29_11_2023;

public interface Maintainable {

    void repairItem();
    void updateItemCondition(ItemCondition condition);
    ItemCondition checkCondition();
}
