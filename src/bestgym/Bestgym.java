package bestgym;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Bestgym {
    public Bestgym() {
        Methodes count;
        String filepath = ("C:\\Users\\pavel\\Documents\\NetBeansProjects\\Bestgym\\src\\bestgym\\customers.txt");
        String indata;
        int days, checker = 0;
        String firstLine = "default";
        String secondLine = "default";
        String firstpersnumber;
        String firstname;
        Path outfilepath = Paths.get(filepath);
    while(true){
        indata = JOptionPane.showInputDialog("Write the name or personal number.");
        if (indata == null){
              System.exit(0);
        }

        try(Scanner sc = new Scanner(outfilepath); ){
            File myfile = new File("parsedfile.txt");
            FileWriter fileWriter = new FileWriter(myfile, true);
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(buffer);
            while(sc.hasNext()){
                firstLine = sc.nextLine();
                firstname = ((firstLine.substring(12)).toLowerCase()).trim();
                firstpersnumber = firstLine.substring(0, 10);
                secondLine =((sc.nextLine().trim()));
                count = new Methodes();
                days = count.days(secondLine);
                
                if (firstname.equalsIgnoreCase((indata.toLowerCase()).trim()) || firstpersnumber.equalsIgnoreCase(indata.trim())) {
                    checker+=1;
                    if(365>=days){
                        JOptionPane.showMessageDialog(null, "This client has recently payed and is therefore acceptable.");
                        printWriter.println(firstLine);
                        printWriter.println(LocalDate.now());
                        printWriter.close();
                    }  
                    else{
                    JOptionPane.showMessageDialog(null, "This client payed before, but has not yet payed for this year.");
                    }

                }
            }
            if (checker == 0) {
                JOptionPane.showMessageDialog(null, "This client is not registered at the gym.");
            }
        }
        catch(InputMismatchException e){
            System.out.println("Wrong input.");
        }
        catch(IOException e){
            System.out.println("Could not read from file.");
        }
        catch(Exception e){
            System.out.println("Something went wrong, try again.");
        }
        
    }

        
        
        
        
        
    }
    public static void main(String[] args) {
        Bestgym o = new Bestgym();
    }

}




//                JOptionPane.showMessageDialog(null, "This client is unknown.");
//                System.out.println(firstLine);
//                System.out.println(secondLine);
//                System.out.println(firstpersnumber);
//                System.out.println(firstname);


//PrintWriter w = new PrintWriter(Files.newBufferedWriter(infilepath));