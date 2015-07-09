package com.smartResume.lib;

import java.io.*;

public class StartMongo {
	public static void main(String[] args) {
		try {
			StartMongo st= new StartMongo();
 			st.accessCommandLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void accessCommandLine(){
	    try {
	        Runtime rt = Runtime.getRuntime();
	        //Process p = rt.exec(new String[]{"cmd.exe", "/c", "cd \"C:\\Program Files\\MongoDB 2.6 Standard\\bin \" && mongod.exe --dbpath \"D:\\Mongo\\data \" "});
	        //cd "C:\\Program Files\\MongoDB 2.6 Standard" && mongod.exe --dbpath "D:\\Mongo\\data"

	        Process p= rt.exec("C://Program Files//MongoDB 2.6 Standard//bin//mongod.exe --dbpath D://Mongo//data");
	        
	        //System.out.println(p.getInputStream());
	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        while (true) {
	            line = r.readLine();
	            if (line == null) { break; }
	            System.out.println(line);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}