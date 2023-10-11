package test;

import java.util.Arrays;
import java.util.Random;

public class DiceGame {
    private int[] dice; // 5개의 주사위 눈을 저장하는 배열
    private int rerolls; // 남은 다시 굴리기 횟수

    public DiceGame() {
        dice = new int[5];
        rerolls = 2; // 초기에 2번의 다시 굴리기 기회를 가짐
        rollDice(); // 게임 시작 시 주사위를 굴림
    }

    // 주사위를 굴리는 메서드
    public void rollDice() {
        Random random = new Random();
        for (int i = 0; i < dice.length; i++) {
            dice[i] = random.nextInt(6) + 1; // 1부터 6 사이의 난수 생성
        }
    }

    // 주사위 상태를 출력하는 메서드
    public void displayDice() {
        System.out.println("주사위 눈: " + Arrays.toString(dice));
    }

    // 족보를 판단하는 메서드
    public String determineHand() {
        Arrays.sort(dice); // 주사위를 오름차순으로 정렬
        String result = "No Result"; // 기본 결과

        if (isYacht()) {
            result = "Yacht";
        } else if (isStraight()) {
            result = "Straight";
        } else if (isFullHouse()) {
            result = "Full House";
        } else if (isTriple()) {
            result = "Triple";
        } else if (isTwoPair()) {
            result = "Two Pair";
        } else if (isOnePair()) {
            result = "One Pair";
        }

        return result;
    }

    // 주사위 배열에서 특정 숫자의 개수를 계산하는 메서드
    private int countOccurrences(int number) {
        int count = 0;
        for (int die : dice) {
            if (die == number) {
                count++;
            }
        }
        return count;
    }

    // 다섯 개의 주사위 눈이 모두 같은 숫자인지 확인하는 메서드
    private boolean isYacht() {
        return countOccurrences(dice[0]) == 5;
    }

    // 다섯 개의 주사위 눈이 연속된 숫자인지 확인하는 메서드
    private boolean isStraight() {
        return Arrays.equals(dice, new int[]{1, 2, 3, 4, 5}) || Arrays.equals(dice, new int[]{2, 3, 4, 5, 6});
    }

    // 다섯 개의 주사위 눈 중에서 세 개가 같은 숫자이고 또 다른 두 개가 같은 숫자인지 확인하는 메서드
    private boolean isFullHouse() {
        return (countOccurrences(dice[0]) == 3 && countOccurrences(dice[4]) == 2) &&
               (countOccurrences(dice[0]) == 2 && countOccurrences(dice[4]) == 3);
    }

    // 다섯 개의 주사위 눈 중에서 세 개가 같은 숫자인지 확인하는 메서드
    private boolean isTriple() {
        return countOccurrences(dice[0]) == 4 || countOccurrences(dice[4]) == 3;
    }

    // 다섯 개의 주사위 눈 중에서 두 쌍의 숫자가 있는지 확인하는 메서드
    private boolean isTwoPair() {
        return (countOccurrences(dice[0]) == 2 && countOccurrences(dice[2]) == 2) ||
               (countOccurrences(dice[1]) == 2 && countOccurrences(dice[3]) == 2) ||
               (countOccurrences(dice[2]) == 2 && countOccurrences(dice[4]) == 2);
    }

    // 다섯 개의 주사위 눈 중에서 한 쌍의 숫자가 있는지 확인하는 메서드
    private boolean isOnePair() {
        return countOccurrences(dice[0]) == 2 || countOccurrences(dice[1]) == 2 ||
               countOccurrences(dice[2]) == 2 || countOccurrences(dice[3]) == 2 || countOccurrences(dice[4]) == 2;
    }

    // 주사위 다시 굴리기 메서드
    public void rerollDice() {
        if (rerolls > 0) {
            rollDice();
            rerolls--;
        } else {
            System.out.println("다시 굴리기 횟수를 모두 사용했습니다.");
        }
    }

    public int getRerollsRemaining() {
        return rerolls;
    }

    // 게임 재시작 메서드
    public void restartGame() {
        rerolls = 2;
        rollDice();
    }

    public static void main(String[] args) {
        DiceGame game = new DiceGame();

        // 게임 시작
        System.out.println("주사위 게임을 시작합니다.");
        game.displayDice();

        // 다시 굴리기 횟수 사용
        System.out.println("다시 굴리기 횟수: " + game.getRerollsRemaining());
        game.rerollDice();
        game.displayDice();

        // 족보 판단
        String hand = game.determineHand();
        System.out.println("판단된 족보: " + hand);
    }
}