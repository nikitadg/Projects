import java.util.Scanner;

public class CowsNBulls {
    private int difficulty;//сложность и размер массива
    private  int[] realArray; //массив из чисел, заполненных компьютером
    private  int[] guessedArray; // массив из чисел, заполненных человеком
    private int cows=0; //одинаковые числа на разных позициях
    private int bulls=0;//одинаковые числа на одинаковых позициях

    private void setDifficulty(){
        System.out.println("Введите уровень сложности:");
        Scanner scanner=new Scanner(System.in);
        difficulty=scanner.nextInt();
        System.out.print("Ваш выбранный уровень сложности: "+ difficulty+"\n");
    }

    private int getDifficulty(){
        return difficulty;
    }

    private void setRealArray() {
        realArray=new int[getDifficulty()];
        for (int i = 0; i < getDifficulty(); i++) {
            boolean flag=false;
            int tmp=(int)(Math.random()*10);
            for(int j=0;j<i;j++){
                if(realArray[j]==tmp) {
                    flag=true;
                    i--;
                    break;
                }
            }
            if(!flag)
                realArray[i]=tmp;

        }
    }
    private void printRealArray(){
        for(int i=0;i<getDifficulty();i++){
            System.out.print(realArray[i]);
        }
    }

    private void setGuessedArray(){
        guessedArray=new int[getDifficulty()];
        Scanner scanner=new Scanner(System.in);
        boolean enterLoop=true;
        while(enterLoop) {
            String defeat = scanner.nextLine();
            if (defeat.equals("Сдаюсь")) {
                printRealArray();
                enterLoop = false;
                System.exit(1);
            } else {
                String[] array=defeat.split("");
                for(int i=0;i<array.length;i++){
                    guessedArray[i]=Integer.parseInt(array[i]);

                }
                if(array.length<difficulty){
                    System.out.println("Введите последовательность заново");
                    setGuessedArray();
                }
                enterLoop=false;
            }
        }
    }


    private void compare(){
        cows=0; bulls=0;
        for(int i=0;i<getDifficulty();i++){
            for(int j=0;j<getDifficulty();j++){
                if(realArray[i]==guessedArray[j]){
                    if(i==j)bulls++;
                    else cows++;
                }
            }
        }
        System.out.println("Cows:"+cows+" Bulls:"+bulls);
    }

    private void game(){
        setDifficulty();
        setRealArray();
        int count=0;
        while(bulls!=getDifficulty()){
            setGuessedArray();
            compare();
            count++;
        }
        System.out.println("Количество попыток равно: "+count);
        printRealArray();
    }

    public static void main(String[] args){
        CowsNBulls test=new CowsNBulls();
        test.game();
    }
}



