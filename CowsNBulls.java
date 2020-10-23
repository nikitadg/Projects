import java.util.Scanner;

public class CowsNBulls {
    private int difficulty;//сложность и размер массива
   private  int[] realMassive; //массив из чисел, заполненных компьютером
   private  int[] guessedMassive; // массив из чисел, заполненных человеком
   private int cows=0; //одинаковые числа на разных позициях
   private int bulls=0;//одинаковые числа на одинаковых позициях

    public void setDifficulty(){
        Scanner scanner=new Scanner(System.in);
        difficulty=scanner.nextInt();
        System.out.print("Ваш выбранный уровень сложности: "+ difficulty);
    }

    public void setRealMassive() {
        realMassive=new int[difficulty];
        for (int i = 0; i < difficulty; i++) {
            boolean flag=false;
            int tmp=(int)(Math.random()*10);
            for(int j=0;j<i;j++){
                if(realMassive[j]==tmp) {
                    flag=true;
                    i--;
                    break;
                }
            }
            if(!flag)
                realMassive[i]=tmp;

        }
    }
    public void getRealMassive(){
        for(int i=0;i<difficulty;i++){
            System.out.print(realMassive[i]);
        }
    }

    public void setGuessedMassive(){
        int argCount=0;
        guessedMassive=new int[difficulty];
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            if(argCount>difficulty){
                break;
            }
                guessedMassive[argCount]=scanner.nextInt();
                argCount++;
        }

    }

    public void compare(){
        cows=0;
        bulls=0;
        for(int i=0;i<difficulty;i++){
            for(int j=0;j<difficulty;j++){
                if(realMassive[i]==guessedMassive[j]){
                    if(i==j)bulls++;
                    else cows++;
                }
            }
        }
        System.out.println("Cows:"+cows+" Bulls:"+bulls);
    }

    public void game(){
        setDifficulty();
        setRealMassive();
        int count=0;
        while(bulls!=difficulty){
            setGuessedMassive();
            compare();
            count++;
        }
        System.out.println("Количество попыток равно: "+count);
        getRealMassive();
    }

    public static void main(String[] args){
        CowsNBulls test=new CowsNBulls();
        test.game();
    }
}

/*todo
1.Дать выбор пользователю выбирать сложность самому - DONE
2.Дать возможность сдаться ключевым словом "сдаюсь"
3.Ошибка при вводе бОльшего количества симвлов 
 */
