package irina;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
//        Напиши программу, которая моделирует ситуацию.Ты попросил(а) друзей скинуться на подарок на твой День Рождения.
//        Каждый друг случайным образом может подарить тебе одну купюру номиналом 50, 100, 200 или 500 долларов. Твоя цель - новенький игровой компьютер,
//        который стоит 10 000 долларов.Как только друзья подарят тебе нужную сумму (или даже чуть больше),
//        останавливай сбор подарков и веди всех выпить за твоё здоровье в лучший бар города!

    }
    public static void giftSum(int target) {
        int giftCount = 0;
        int friends = 0;
        Random random = new Random();
        while (giftCount >= target) {
            int gift = rndSum();
            giftCount += gift;
            friends++;
        }
    }

    public static int rndSum() {
        int[] giftMoney = new int[]{50, 100, 200, 500};
        Random rndom = new Random();
        return giftMoney[rndom.nextInt(giftMoney.length)];
    }
}
