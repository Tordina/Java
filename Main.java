
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4 ();
        //task5 ();
    }

    // 1 задание
   /* public static void task1 (){
        System.out.println("task1:");
        Scanner in = new Scanner (System.in);
        System.out.println("Введите  число :");
        int num = in.nextInt();//натуральное число
        int counter = 0;//счётчик
        do
        {
            counter++;
            if (num % 2 == 0) {
                num = num / 2;//если чётное число
            } else {
                num = 3 * num + 1;//если нечётное число
            }

        }
        while(num != 1);
        System.out.printf("количество шагов %d \n",counter);
        in.close();

    }*/
    // 2 задание
    /*
    public static void task2 ()
    {
        System.out.println("task2:");
        Scanner in = new Scanner (System.in);
        System.out.println("Введите  количество чисел :");
        int amount = in.nextInt();//количество чисел
        int sum = 0;
        for (int i=0 ; i < amount ; i++)
        {
            int num=in.nextInt();//вводим числа
            if (i % 2 == 0)//если четные индексы -складываем
            {
                sum += num;
            }
            else //если нечетные индексы -вычетаем
            {
                sum -= num;
            }
        }
        System.out.printf("знакочередующаяся сумма ряда:  %d \n",sum);
        in.close();
    }
    */

    // 3 задание
/*

    public static void task3() {
        System.out.println("task3:");
        Scanner in = new Scanner(System.in);
        //начальные координаты
        int x = 0;
        int y = 0;
        //сколько пройдём в данном направлении
        System.out.println("Введите координаты клада:");
        int direction_x = in.nextInt();
        int direction_y = in.nextInt();
        String route = "";//стороны света
        int count = 0;//кол-во указаний до клада
        int check = 0;//проверка
        int answer=0;
        System.out.println("Введите направление ,затем кол-во шагов:");
        route = in.next();
        int steps = in.nextInt();//количество шагов
        while (true) {

            if (route.equals("Запад"))//если идем на запад
            {
                x -= steps;
                count++;
            } else if (route.equals("Север"))//если идем на север
            {
                y += steps;
                count++;
            } else if (route.equals("Восток"))//если идем на восток
            {
                x += steps;
                count++;
            } else if (route.equals("Юг"))//если идем на юг
            {
                y -= steps;
                count++;
            }
            else if (route.equals("Стоп"))//выходим из цикла
            {
                break;
            }
            route = in.next();
            steps = in.nextInt();//количество шагов
            //находим минимальное кол-во указаний до клада
            if (direction_x == x && direction_y == y) {
                check += 1;
                if (check == 1) {
                    answer = count;
                }
            }
        }
        if (direction_x == x && direction_y == y) {
            System.out.println("кол-во указаний до клада  :" + answer);
        }
        else
        {System.out.println("вы не дошли до клада " ); }
    }

*/
    //задание 4
    /*
    public static void task4 () {
        System.out.println("task4:");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите  количество дорог :");
        int num_roads = in.nextInt();//кол-во дорог
        int compare = 1000;//для сравнения высот тонелля
        int [] max_height = new int[num_roads];
        for (int i=0 ; i<num_roads ; i++)
        {
            System.out.println("Введите  количество тонеллей  :");
            int num_tunnels = in.nextInt();
            System.out.println("Введите  высоту каждого тонелля  :");
            for(int j = 0 ; j < num_tunnels ; j++)
            {
                int height_tunnels = in.nextInt();
                if(compare > height_tunnels)
                {
                    compare = height_tunnels;//находим минимальную высоту в каждом тонелле
                }
            }
            max_height[i] = compare;//заполняем массив минимальными высотами грузовиков
            int k = 0;               //каждой дороги
            compare = 1000;
        }
        int num_maxroads = 0;

        int maxroads = 0;

        //находим максимальную высоту грузовика из всех минимальных
        for(int k=0 ; k < num_roads ; k++)
        {
            for (int j=1 ; j<num_roads ; j++)
                if (max_height[k] < max_height[j])
                {
                    maxroads = max_height[j];
                    num_maxroads = j + 1;

                }
        }
        //вывод:
        System.out.println("Номер дороги  :" + num_maxroads);
        System.out.println("Наибольшая высота грузовика  :" + maxroads);
    }
*/
/*
    //5 задание

    public static void task5 ()
    {
        System.out.println("task5:");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите  число :");
        int num = in.nextInt();
        int x,y=0;
        x=((num / 10) % 10) + ( num / 100 ) + ( num % 10);
        y=((num / 10) % 10) * ( num / 100) * ( num % 10);
        if (x % 2 == 0 && y % 2 == 0 )
        {
            System.out.println("Число дважды чётное ");
        }
        else
        {
            System.out.println("Число не дважды чётное  ");
        }


    }

 */
}