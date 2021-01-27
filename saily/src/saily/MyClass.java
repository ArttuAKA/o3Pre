package saily;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class MyClass {

   public static void main(String args[])throws IOException {
	  Scanner keyboard= new Scanner(System.in);
	  Scanner s= new Scanner(System.in);
	  Scanner as= new Scanner(System.in);
      File file = new File("Hello1.txt");
      System.out.println("Anna Käyttäjätunnus");
      String k = as.nextLine();
  
      file.createNewFile();
     // System.out.println("Tiedosto sijainti " + file.getAbsolutePath());
      
      FileWriter writer = new FileWriter(file); 
      Scanner lukija = new Scanner(file);
     

      
   
      
      
      while(true)
      {
          
          System.out.println("\nValitse 1 kirjoittaaksesi viestin");
          System.out.println("Valitse 2 tulostaaksesi");
          System.out.println("Valitse 3 lopettaaksesi:");
          int n = s.nextInt();
          switch(n)
          {
              

              case 1:
            	  System.out.println("Kirjoita haluamasi viesti");
                  String viesti = keyboard.nextLine();
                  
                  
                  Date date = new Date();
            	  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
            	  String formattedDate = sdf.format(date);
                  
            	  writer.write(formattedDate);
            	  writer.write(" <"+k+">");
                  writer.write(" "+viesti);                   
                  writer.write(".\n");
                  writer.flush();
                 
              break;

              

              case 3:
            	  writer.close();
            
            	  s.close();
            	  keyboard.close();
            	  as.close();
            	  lukija.close();
                  System.exit(0);
              
              case 2:
            	  
            	  System.out.println(tail(file));
            	   
          }
      }
      
   }
  
	   public static String tail( File file ) {
		    RandomAccessFile fileHandler = null;
		    try {
		        fileHandler = new RandomAccessFile( file, "r" );
		        long fileLength = fileHandler.length() - 1;
		        StringBuilder sb = new StringBuilder();

		        for(long filePointer = fileLength; filePointer != -1; filePointer--){
		            fileHandler.seek( filePointer );
		            int readByte = fileHandler.readByte();

		            if( readByte == 0xA ) {
		                if( filePointer == fileLength ) {
		                    continue;
		                }
		                break;

		            } else if( readByte == 0xD ) {
		                if( filePointer == fileLength - 1 ) {
		                    continue;
		                }
		                break;
		            }

		            sb.append( ( char ) readByte );
		        }

		        String lastLine = sb.reverse().toString();
		        return lastLine;
		    } catch( java.io.FileNotFoundException e ) {
		        e.printStackTrace();
		        return null;
		    } catch( java.io.IOException e ) {
		        e.printStackTrace();
		        return null;
		    } finally {
		        if (fileHandler != null )
		            try {
		                fileHandler.close();
		            } catch (IOException e) {
		                
		            }
		    }
		}
	  
}