package com.adi.config.demo;

public class Testfordublicate {

	
	public static void main(String[] args) {
		
		String str = "Today Jun 2 at 6.00 PM CT";  
		String s[]=str.split(" ");
		int l=s.length;
		String ampm=(s[l-2].equalsIgnoreCase("am"))?"A.M.":"P.M.";
		StringBuilder sb=new StringBuilder("");
		for(int i=0;i<l;i++)
		{
		    if(i!=l-2)
		    sb.append(s[i]+" ");
		    else
		    sb.append(ampm+" ");
		}
		System.out.println(sb);
		
		
//		 String str = "Today Jun 2 at 6.00 PM am CT";  
//		 str = str.replace("PM","P.M.");
//	     str = str.replace("AM","A.M."); 
//	     str = str.replace("am","A.M."); 
//	     str = str.replace("pm","P.M."); 
//
//	        System.out.println(str);  
//	        rs = rs.replace("s","h"); // Replace 's' with 'h'  
//	        System.out.println(rs); 
		
		
	
//		List<Activity> lst=new ArrayList<>();
//		List<Activity> lst1=new ArrayList<>();
//		lst.add(new Activity("111","Aditya"));
//		lst.add(new Activity("222","gaurav"));
//		lst.add(new Activity("111","Adia"));
//		lst.add(new Activity("45","Ajhg"));
//		System.out.println(lst.toString());
//		
//		Set<Activity> set = lst.stream()
//	            .collect(Collectors.toCollection(() -> 
//	                 new TreeSet<>(Comparator.comparing(Activity::getId))));
//		
//		
//		
//		
//		//System.out.println(set.toString());
//		
//		lst1.addAll(set);
//		System.out.println(lst1.toString());

	}

}


class Activity{
	
	private String id;
	private String name;
	
	
	
	
	public Activity(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
