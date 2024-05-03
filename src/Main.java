import java.util.*;

public class Main {

    public static class Singer {
        String name;
        Double rating;
        int NumberOfAlbums;

        public Singer(String name, Double rating, int NumberOfAlbums) {
            this.name = name;
            this.rating = rating;
            this.NumberOfAlbums = NumberOfAlbums;
        }

        @Override
        public String toString() {
            return ("Фамилия - " + name + ", рейтинг - " + rating + ", Количество альбомов - " + NumberOfAlbums);
        }

        public String setName(String name) {
            this.name = name;
            return name;
        }

        public double setRating(Double rating) {
            this.rating = rating;
            return rating;
        }
    }


    public static void main(String[] args) {

        List<Singer> list = new ArrayList<>();
        list.add(new Singer("Petrov", 3.5, 3));
        list.add(new Singer("Ivanov", 4.3, 2));
        list.add(new Singer("Morozov", 5.0, 1));
        list.add(new Singer("Korobov", 4.5, 4));
        list.add(new Singer("Romanov", 3.8, 2));

        Singer popular = list.get(0);

        for (Singer el : list) {
            if (el.rating > popular.rating) {
                popular = el;
            }
            System.out.println(el);
        }
        System.out.println("//////////");
        System.out.println("Самый популярный исполнитель - " + popular.name + ", его рейтинг соствил - " + popular.rating);
        System.out.println("//////////");

        Singer MoreThenOther = list.get(0);
        double AllCount = 0;
        double MidCount = 0;
        int count = 0;
        for (Singer el : list) {
            AllCount += el.NumberOfAlbums;
            count++;
        }
        MidCount = AllCount / count;
        System.out.println("Среднее количество альбомов - " + MidCount);

        for (Singer el : list) {
            if (el.NumberOfAlbums > MidCount) {
                System.out.println("Певец с количеством альбомов больше среднего - " + el.name + ", кол-во его альбомов - " + el.NumberOfAlbums);
            }
        }

        System.out.println("////////");

        System.out.println("Список до сортировки: ");
        for (Singer el : list) {
            System.out.println(el.name);
        }

        Collections.sort(list, new Comparator<Singer>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o2.name.compareTo(o1.name);
            }
        });


        System.out.println("Список после сортировки: ");
        for (Singer el : list) {
            System.out.println(el.name);
        }


        System.out.println("/////////////");

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию певца..");
        String namee = sc.nextLine();
        for (Singer el : list) {
            if (namee.equals(el.name)) {
                System.out.println(el);
                System.out.println("Желаете изменить данные для этого певца?");
                System.out.println("0 - Нет");
                System.out.println("1 - Да");
                int choice = sc.nextInt();
                sc.nextLine(); // Пропустить символ новой строки
                if (choice == 1) {
                    System.out.println("Что нужно изменить?");
                    System.out.println("1 - фамилию");
                    System.out.println("2 - рейтинг");
                    System.out.println("3 - кол-во альбомов");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Введите новую фамилию");
                            sc.nextLine(); // Пропустить символ новой строки
                            el.name = sc.nextLine();
                            System.out.println(el);
                            break;
                        case 2:
                            sc.nextLine();
                            System.out.println("Введите новый рейтинг");
                            el.rating = Double.parseDouble(sc.nextLine());
                            System.out.println(el);
                            break;
                        case 3:
                            System.out.println("Введите новое кол-во альбомов");
                            el.NumberOfAlbums = sc.nextInt();
                            System.out.println(el);
                            break;
                    }
                }
            }
        }

    }
}


