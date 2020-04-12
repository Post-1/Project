package Password;

import java.util.Random;

import java.io.*;
import java.util.*;

public class Password 
{
    static Random ran = new Random();
    static String pass = "";
    String[] Upp = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String[] Low = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    String[] num = {"0","1","2","3","4","5","6","7","8","9"};
    public static void main(String[] args) throws IOException 
    {
        Password test = new Password();
        test.Make(100);
        //Check();
    }
    public void Make(int len)
    {
        int Up, low, n = 0;
        int cho = ran.nextInt(12);
        while(len>0)
        {
            switch(cho)
            {
                case 0: case 1: case 2: case 3: pass+=Upp[ran.nextInt(Upp.length)]; break;
                case 4: case 5: case 6: case 7: pass+=Low[ran.nextInt(Low.length)]; break;
                case 8: case 9: case 10: case 11: pass+=num[ran.nextInt(num.length)]; break;
                default: System.out.println("Error");
            }
            cho = ran.nextInt(12);
            len--;
        }
        System.out.println(pass);
    }
    static void Check() throws IOException
    {
        String total = "";
        Scanner file = new Scanner(new File("C:\\Users\\20POST27\\Desktop\\RandomProjects\\src\\Password\\createdpassword.txt"));
        while(file.hasNextLine())
        {
            total+=file.nextLine()+" ";
        }
        String[] t = total.split(" ");
        //System.out.println("");
        File f = new File("C:\\Users\\20POST27\\Desktop\\RandomProjects\\src\\Password\\createdpassword.txt");
        FileWriter fw = new FileWriter(f);
        //fw.write("1234567890");
        BufferedWriter bw;
        bw= new BufferedWriter(fw);
        //bw.write("1234567890");
        if(!total.isEmpty())
        {
            for(String s : t)
            {
                bw.write(s+"");
                //bw.write("");
            }
        }
        bw.write(pass);
        bw.write("\n");
        /*String s = ""+ran.nextInt(10);
        bw.write(s+"");
        
        s = ""+ran.nextInt(10);
        bw.write(s+"");*/
        
        //bw.write(total);
        bw.close();
        fw.close();
    }
}
