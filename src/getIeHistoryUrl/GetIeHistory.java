package getIeHistoryUrl;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetIeHistory 
{
	static{
		  System.loadLibrary("getIeHistory");
	  }
	  public static native void getIeHistory();
	  
	  public static void main(String args[])
	  {
		  
		 
		  List<String> sa=GetIeHistory.readUrl();
		  for(int i=0;i<sa.size();i++)
			  System.out.println(sa.get(i));
	  }
	  public static List<String> readUrl()
	  {
		  getIeHistory();
//		  try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		  System.out.print("javaªÒ»°url");
		  try {
	           BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream( new File("IeHistory.txt")), "gbk") );
	           List<String> szContent=new ArrayList<String>();
	           String szTemp;
	           
	           while ( (szTemp = bis.readLine()) != null) {
	               if(szTemp.startsWith("http"))
	               {
	            	   szContent.add(szTemp);
	               }
	           }
	           bis.close();
	           System.out.println("  szie: "+szContent.size());
	           return szContent;
	       }
	       catch( Exception e ) 
	       {
	       	//System.out.println("null"+e.getMessage());
	           return null;
	       }
         
	  }
}
