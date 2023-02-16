public class Data{
	public static void main(String args[])
	{
	String str = "navan";
	boolean flag = true;
	
	 for(int i = 0, j = str.length()-1; i < j; i++, j--)
	 {
	     if(str.charAt(i) != str.charAt(j))
	     {
	        flag =false;
	        
	        break;
	        
	     }
	     
	     System.out.println(flag);
	 }
	
		}
}
