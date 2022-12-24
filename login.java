import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import loginp.tictoc;
import loginp.guess;
import loginp.sps;
// import loginp.*;
import java.lang.*;
class LogReg {
    Scanner sc=new Scanner(System.in);
    int x;
    int flag=0;
    int g;
    String name;
     String pass;
    String name1;
    String pass1,greet;
    public void landr() throws IOException, InterruptedException {
        System.out.println("1.login\n2.Registor");
         x=sc.nextInt();
        switch (x) {
            case 1:
               log();
                break;
            case 2:
                reg();
                break;
            default:
                break;
        }
    }
    public void reg()  throws IOException, InterruptedException{
       System.out.println("enter your name");
        name=sc.next();
        System.out.println("enter your password");
        pass=sc.next();
        File f=new File("login1.txt");
        f.createNewFile();
        FileWriter fw=new FileWriter("login1.txt",true);
        fw.write(name+" ");
        fw.write(pass+" ");
        fw.close();
        System.out.println("registor succesfully");
    }
    public void log() throws IOException, InterruptedException{
        System.out.println("enter your userName");
        name1=sc.next();
        System.out.println("enter your password");
        pass1=sc.next();
        File f=new File("login1.txt");
        Scanner read =new Scanner(f);
        while(read.hasNext())
         { 
           String y=read.next();
           if(name1.equals(y))
           {
             flag++;
             greet=y;
           }
          
           if(pass1.equals(y))
           flag++;
         }
         if(flag>=2)
            {
                System.out.println("login succesfull");
                System.out.println("welcome "+greet);
                System.out.println("---------------");
                while(true)
                {
                System.out.println("chose any game you want");
                System.out.println("1.tictoc game\n2.guessing game\n3.stone paper seccior\n4.exit");
                g=sc.nextInt();
                switch (g) {
                    case 1:
                            tictoc o=new tictoc();
                            o.great();
                            o.dis();
                            o.game();
                        break;
                    case 2:
                        guess obj=new guess();
                        System.out.println("total chance is 3");
                        obj.rondoms();
                        int i;
                        for(i=0;i<2;i++){
                            obj.check();
                            obj.get();
                        }
                        obj.check();
                        if(i==2)
                        {
                            System.out.println("try again..!");
                        }
                        break;
                    case 3:
                        sps obj1 =new sps();
                        while(true)
                        {
                                System.out.println("1.play\n2.exit");
                                int x=sc.nextInt();
                                switch (x) {
                                    case 1:
                                    obj1.userget();
                                    obj1.rondoms();
                                    obj1.check();
                                    break;
                                    case 2:
                                    System.out.println("exit....");
                                    System.exit(0);
                                    break;
                                }
                        }
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("wrong Input...!");
                        break;
                }
            }
            }
            else
            {
                System.out.println("wrong username password ");
            }
    }
}
class login{
    public static void main(String[] args) throws IOException, InterruptedException  {
        LogReg o=new LogReg();
        o.landr();
    }
}