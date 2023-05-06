import java.io.*;
class printvowel implements  Runnable
{  
        Thread t1;
       String s2;
            printvowel(String s1)
            {
            s2=s1;                                   
          t1 = new Thread(this);
           t1.start();
                              
            }

     
            public void run()
            {
  for(int i=0;i<s2.length();i++)
                        {
                      char z=s2.charAt(i);
		 if (z=='a'||z=='e'|| z=='i' ||z=='u'||z=='o')
                                    try
                                    {
                                         System.out.println(z);
                                                Thread.sleep(3000);
                                    }
                                    catch(Exception  e)
                                    {
                                                
                                    }
                        }
            }
}
class slip23_1
{
           


            public static void main(String args[])throws Exception
            {
              BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Enter String");
   String str=br.readLine();
    
                  printvowel t5=new printvowel(str);
            }   
}
