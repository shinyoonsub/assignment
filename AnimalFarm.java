package test;
// ArrayList 생성
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 소리내기와 이름, 무게, 색깔 속성을 갖는 Animal 클래스를 생성
class Animal {
    private String name;
    private double weight;
    private String color;
    

    
    // 동물의 이름, 몸무게, 색깔의 정보를 저장
    public Animal(String name, double weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String speak() {
        return "소리";
    }

    // 동물의 정보를 반환한다
    public String animalInfo() {
        return "정보 - 이름: " + name + " / 무게: " + weight + "kg / 색깔: " + color;
    }

	public Object getName() {
		return name;
	}
}

// Animal의 기능을 Dog가 상속받는다
class Dog extends Animal {
    private String sound;

    public Dog(String name, double weight, String color) {
        super(name, weight, color);
        this.sound = "왈! 왈!";
    }

    @Override
    public String speak() {
        return sound;
    }
}

// Animal의 기능을 Cat이 상속받는다
class Cat extends Animal {
    private String sound;

    public Cat(String name, double weight, String color) {
        super(name, weight, color);
        this.sound = "애용~";
    }

    @Override
    public String speak() {
        return sound;
    }
}

//Animal의 기능을 Chicken이 상속받는다
class Chicken extends Animal {
    private String sound;

    public Chicken(String name, double weight, String color) {
        super(name, weight, color);
        this.sound = "꼬끼오~!";
    }

    @Override
    public String speak() {
        return sound;
    }
}

// ArrayList선언
public class AnimalFarm {
    private List<Animal> animals;

    public AnimalFarm() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // 동물의 이름으로 검색
    public Animal findAnimal(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
            	System.out.println(name+ "이(가) 동물농장 안에 존재합니다!");
            	
                return animal;
            }
        }
        return null;
    }

    // 모든 동물이 소리내도록 시키기
    public void speakAll() {
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " : " + animal.speak());
        }
    }

    // 동물의 정보 출력
    public void AnimalsInfo() {
        for (Animal animal : animals) {
            System.out.println(animal.animalInfo());
        }
    }

    // AnimalFarm 클래스의 객체(동물) 생성 
    public static void main(String[] args) {
        AnimalFarm farm = new AnimalFarm();
        Scanner sc = new Scanner(System.in);
        Dog dog1 = new Dog("코코", 8.0, "흰색");
        Dog dog2 = new Dog("초코", 10.0, "갈색");
        Cat cat1 = new Cat("나비", 4.0, "검은색");
        Cat cat2 = new Cat("애용이", 5.0, "흰색");
        Chicken chicken1 = new Chicken("치킨", 0.9, "갈색");
        Chicken chicken2 = new Chicken("꼬꼬", 1.3, "흰색");

        farm.addAnimal(dog1);
        farm.addAnimal(dog2);
        farm.addAnimal(cat1);
        farm.addAnimal(cat2);
        farm.addAnimal(chicken1);
        farm.addAnimal(chicken2);

        farm.speakAll();
        farm.AnimalsInfo();
        System.out.print("찾으려는 동물의 이름 : ");
        String str = sc.nextLine();
        
        farm.findAnimal(str);
    }
}