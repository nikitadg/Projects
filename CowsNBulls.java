import java.util.Scanner;

public class CowsNBulls {
    private int difficulty;//сложность и размер массива
   private  int[] realMassive; //массив из чисел, заполненных компьютером
   private  int[] guessedMassive; // массив из чисел, заполненных человеком
   private int cows=0; //одинаковые числа на разных позициях
   private int bulls=0;//одинаковые числа на одинаковых позициях

    private void setDifficulty(){
        Scanner scanner=new Scanner(System.in);
        difficulty=scanner.nextInt();
        System.out.print("Ваш выбранный уровень сложности: "+ difficulty+"\n");
    }

    private int getDifficulty(){
        return difficulty;
    }

    private void setRealMassive() {
        realMassive=new int[getDifficulty()];
        for (int i = 0; i < getDifficulty(); i++) {
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
    private void getRealMassive(){
        for(int i=0;i<getDifficulty();i++){
            System.out.print(realMassive[i]);
        }
    }

   /* private void setGuessedMassive(){
        guessedMassive=new int[getDifficulty()];
        Scanner scanner=new Scanner(System.in);
        boolean enterLoop=true;
        while(enterLoop){
            String defeat=scanner.nextLine();
            if(defeat.equals("Сдаюсь")){
                getRealMassive();
                enterLoop=false;
            }
        }
        todo: если не сдаюсь, заполнять массив 
    }

    */
   private void setGuessedMassive(){
       guessedMassive=new int[getDifficulty()];
       Scanner scanner=new Scanner(System.in);
       for(int i=0;i<getDifficulty();i++){
           guessedMassive[i]=scanner.nextInt();
       }

   }

    private void compare(){
        cows=0; bulls=0;
        for(int i=0;i<getDifficulty();i++){
            for(int j=0;j<getDifficulty();j++){
                if(realMassive[i]==guessedMassive[j]){
                    if(i==j)bulls++;
                    else cows++;
                }
            }
        }
        System.out.println("Cows:"+cows+" Bulls:"+bulls);
    }

    private void game(){
        setDifficulty();
        setRealMassive();
        int count=0;
        while(bulls!=getDifficulty()){
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


