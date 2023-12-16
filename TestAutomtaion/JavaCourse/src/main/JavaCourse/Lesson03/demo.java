package Lesson03;

public class demo {
    public static void main(String[] args) {
        int[] numbers= {3,2,4,-5,6,71,11};

        demo d= new demo();
        d.handleNumbers(numbers);
    }




    void handleNumbers(int[] numbers){
        System.out.println(miniNumber(numbers));
        System.out.println(maxNumber(numbers));
        System.out.println(calAvarage(numbers));


    }

    int miniNumber(int[] numbers){
        int mini=0;
        for (int number:numbers){
            if (mini>number){;
                mini=number;
            }
        }
        return mini;
    }

    int maxNumber(int[] numbers){
        int max=0;
        for (int number:numbers){
            if (max<number){;
                max=number;
            }
        }
        return max;
    }
    int calAvarage(int[] numbers){
        int sum=0;
        for (int number:numbers){
            sum+=number;
        }
    return sum/numbers.length;
    }


}
