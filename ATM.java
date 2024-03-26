import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
ATMop obj = new ATMop();
    }
}
class Data{
     float balance;
}
class ATMop{
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Data> map = new HashMap<>();
    public ATMop() {
        System.out.println("Wellcome to our ATM");
        op();
    }
    public  void op(){
        System.out.println("Enter Your Pin: ");
        int epin = sc.nextInt();

        if(map.containsKey(epin)==true){
            Data obj = map.get(epin);
            menu(obj);
        }
        else{
            System.out.println("please create Your Pin First: ");
            System.out.println("Enter New Pin: ");
            int i =sc.nextInt();
            Data obj = new Data();
            map.put(i,obj);
            menu(obj);

        }
    }

    public void menu(Data obj){
        System.out.println("******************************");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Check Another Account");
        System.out.println("5. Exit \n");
        System.out.println("******************************");

        int x =sc.nextInt();
        if(x==1)
            check_Balance(obj);
        else if (x==2)
            deposit_Amount(obj);
        else if(x==3)
            withdraw_Amount(obj);
        else if (x==4)
            op();
        else if (x==5) {
            System.out.println("Thank You......!!");
            System.out.println("Visit Again...🙏");
        }
        else {
            System.out.println("please Enter Valid Option");
            menu(obj);
        }
    }

    public void check_Balance(Data obj) {
        System.out.println("Available Balance: "+obj.balance+"\n");
        menu(obj);
    }
    public void deposit_Amount(Data obj){
        System.out.println("Enter Amount For Deposit: ");
        float a = sc.nextFloat();
        obj.balance +=  a;
        System.out.println("Deposit Success...!!!");
        menu(obj);
    }
    public  void  withdraw_Amount(Data obj){
        System.out.println("Enter Amount for Withdraw: ");
        float a = sc.nextFloat();
        if(obj.balance >= a) {
            obj.balance -= a;
            System.out.println("Withdraw Success");
            menu(obj);
        }
        else{
            System.out.println("Insufficient Balance!!!!");
            System.out.println("Press 1 for Go Back to Manu \n press 2 for Check Another Account \n press 3 for Exit: ");
            int i=sc.nextInt();
            if(i==1){
                menu(obj);
            } else if (i==2) {
                op();
            }else{
                System.out.println("Thank You For Visiting...🙏");
            }
        }
    }

}
