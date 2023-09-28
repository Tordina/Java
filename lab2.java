import java.util.Arrays;
import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) {
         //task1();
        //task2();
       //  task3();
        // task4();
        //task5();
       //task6();
        //task7();
        //task8();
    }
/*
    //1 задание
    public static void task1()
    {
        System.out.print("Введите строку: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = str.length();
        int[] mas = new int[5000];
        int max = 0;
        int i = 0 , j = 0;//указатели
        String max_str= ""; //для максимальной подстроки
        while (i < n) {
            mas[str.charAt(i)]++ ; // увеличиваем число использований символа
            while (mas[str.charAt(i)] > 1) {
                mas[str.charAt(j)]--; //  двигаем левый указатель
                j++;
            }
            //если найдена новая максимальная подстрока
            if (i-j+1 > max) {
                max = i-j+1;
                max_str = str.substring(j, i+1);
            }
            i++; // сдвигаем правый указатель
        }
        System.out.println("Максимальная подстрока: " + max_str);
        System.out.println("Длина максимальной подстроки: " + max);
    }
*/

    //2 задание

    /*
    public static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите  кол-во элементов для 1 массива  :");
        int n1 = in.nextInt();
        System.out.println("Введите  кол-во элементов для 2 массива  :");
        int n2 = in.nextInt();
        int[] mas1 = new int[n1];
        int[] mas2 = new int[n2];
        System.out.println("Введите элементы для 1 массива   :");
        for (int i = 0; i < n1; i++)
        {
            mas1[i] = in.nextInt();
        }
        System.out.println("Введите элементы для 2 массива   :");
        for (int i = 0; i < n2; i++)
        {
            mas2[i] = in.nextInt();
        }
        //сортируем 1 массив
        for (int i = 0; i < n1; i++)
        {
            for (int j = i + 1; j < n1; j++) {
                if (mas1[i] > mas1[j]) {
                    int tmp = mas1[i];
                    mas1[i] = mas1[j];
                    mas1[j] = tmp;
                }
            }
        }
        //сортируем 2 массив
        for (int i = 0; i < n2; i++)
        {
            for (int j = i + 1; j < n2; j++) {
                if (mas2[i] > mas2[j]) {
                    int tmp = mas2[i];
                    mas2[i] = mas2[j];
                    mas2[j] = tmp;
                }
            }
        }
        int[] mas3 = new int [n1+n2];
        //соединяем 2 массива
        for (int i = 0; i < n1; i++)
        {
            mas3[i]=mas1[i];
        }
        for (int i = 0; i < n2; i++)
        {
            mas3[i+n1]=mas2[i];
        }

        //сортируем итоговый массив
        for (int i = 0; i < n1+n2; i++)
        {
            for (int j = i + 1; j <n1+ n2; j++) {
                if (mas3[i] > mas3[j]) {
                    int tmp = mas3[i];
                    mas3[i] = mas3[j];
                    mas3[j] = tmp;
                }
            }
        }
        System.out.println("Итоговый массив   :");
        for (int i = 0; i < n1+n2; i++)
        {
            System.out.println(mas3[i]);
        }

    }


     */
    /*
    //3 задание
    public static void task3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите  длину массива :");
        int n = in.nextInt();
        int[] mas = new int[n];
        System.out.println("Введите числа для массива :");
        //заполняем массив
        for (int i = 0; i < n; i++) {
            mas[i] = in.nextInt();
        }
        int maxsum = mas[0];
        int sum = mas[0];
        //для каждого элемента выбираем максимум из него самого или его суммы с предыдущими элементами
        //Math.max-возвращает максимальное число из двух элементов
        for (int i = 0; i < n; i++) {
            sum = Math.max(mas[i], sum + mas[i]);
            maxsum = Math.max(maxsum, sum);
        }
        System.out.println("Наибольшая сумма подмассива :  ");
        System.out.println(maxsum);
    }
     */
/*
    //4 задание
    public static void task4() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите  кол-во строк для массива ");
        int n = in.nextInt();
        System.out.println("Введите  кол-во столбцов  для массива ");
        int m = in.nextInt();
        int[][] mas=new int [n][m];//изначальный массив
        int[][] mas_turn=new int [m][n];//итоговый перевернутый массив
        System.out.println("Введите  числа для массива построчно");
        //заполняем массив
        for (int i = 0; i < n; i++) {  //идём по строкам
            for (int j = 0; j < m; j++) {//идем по столбцам
                mas[i][j] = in.nextInt();
            }
        }
        //переворачиваем массив на 90 градусов по часовой стрелке
        for (int i = 0; i < n; i++) {//идём по строкам
            for (int j = 0; j < m; j++) {//идем по столбцам
                mas_turn[j][n-i-1] = mas[i][j];
            }
        }
        //выводим массив
        for (int i = 0; i < m; i++) {  //идём по строкам
            for (int j = 0; j < n; j++) {//идем по столбцам
                System.out.print(" " + mas_turn[i][j] + " ");
            }
            System.out.println();
        }
    }
*/
/*
    //5 задание
    public static void task5() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите  размер для массива");
        int n = in.nextInt();
        System.out.println("Введите  число которое нужно найти в сумме");
        int target = in.nextInt();
        int[] mas = new int[n];
        int[] res_mas = new int[n];
        int count =0;//счётчик
        System.out.println("Введите  числа для массива ");
        //заполняем массив
        for (int i = 0; i < n; i++) {
            mas[i] = in.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i; j < n; j++) {
                if (mas[i]+mas[j]==target)//если сумма совпадает с нужным числом
                {
                    System.out.print(" " + mas[i] + " " + mas[j]);
                    count ++;
                    break;
                }
            }
        }
        if (count==0)//если пара не существует
        {
            System.out.print("null");
        }
    }
*/
/*
    //6 задание
    public static void task6() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во строк  для массива");
        int n = in.nextInt();
        System.out.println("Введите кол-во столбцов   для массива");
        int m = in.nextInt();
        int[][] mas=new int [n][m];
        int sum=0;
        System.out.println("Введите  числа для массива построчно");
        //заполняем массив
        for (int i = 0; i < n; i++) {  //идём по строкам
            for (int j = 0; j < m; j++) {//идем по столбцам
                mas[i][j] = in.nextInt();
            }
        }
        //считаем сумму
        for (int i = 0; i < n; i++) {  //идём по строкам
            for (int j = 0; j < m; j++) {//идем по столбцам
            sum+=mas[i][j];
            }
        }
        //выводим
        System.out.print("Сумма : ");
        System.out.print(sum);
    }

*/
/*
    //7 задание
    public static void task7() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во строк  для массива");
        int n = in.nextInt();
        System.out.println("Введите кол-во столбцов   для массива");
        int m = in.nextInt();
        int[][] mas=new int [n][m];
        int[] res=new int [n];//массив который будет содержать макс элемент из кадой строки
        System.out.println("Введите  числа для массива построчно");
        //заполняем массив
        for (int i = 0; i < n; i++) {  //идём по строкам
            for (int j = 0; j < m; j++) {//идем по столбцам
                mas[i][j] = in.nextInt();
            }
        }
        int min=0;
        //находим максимальный элемент
        for (int i = 0; i < n; i++) {  //идём по строкам
                for (int j = 0; j < m; j++) {//идем по столбцам
                    if(mas[i][j]>min)
                        min=mas[i][j];
                }
            res[i]=min;
            min=0;
        }
        //выводим
        System.out.print("максимальные элементы каждой строки : ");
        for (int i = 0; i < n; i++) {
            System.out.print(res[i]+" ");
        }
    }
    */

/*
    //8 задание
    public static void task8() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите  кол-во строк для массива ");
        int n = in.nextInt();
        System.out.println("Введите  кол-во столбцов  для массива ");
        int m = in.nextInt();
        int[][] mas=new int [n][m];//изначальный массив
        int[][] mas_turn=new int [m][n];//итоговый перевернутый массив
        System.out.println("Введите  числа для массива построчно");
        //заполняем массив
        for (int i = 0; i < n; i++) {  //идём по строкам
            for (int j = 0; j < m; j++) {//идем по столбцам
                mas[i][j] = in.nextInt();
            }
        }
        //переворачиваем массив на 90 градусов против часовой стрелки
        for (int i = 0; i < n; i++) {//идём по строкам
            for (int j = 0; j < m; j++) {//идем по столбцам
                mas_turn[m-j-1][i] = mas[i][j];
            }
        }
        //выводим массив
        for (int i = 0; i < m; i++) {  //идём по строкам
            for (int j = 0; j < n; j++) {//идем по столбцам
                System.out.print(" " + mas_turn[i][j] + " ");
            }
            System.out.println();
        }
    }
*/

}
