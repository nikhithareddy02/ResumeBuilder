/*
 * 
 */
package com.smartResume.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Set;



//importing mongoJDBC driver collection
import com.mongodb.MongoClient;
import com.mongodb.DB;

/*This class holds database related properties and includes methods to get database connections. 
 * Creating a new connection whenever we want to interact with database is expensive.
 * In this class, we create a database object only if it doesn't exist,
 * such that we can use it at any point of time further by calling methods in it without establishing
 * a new connection every time.
 */

public class DBManagerMongo {
	private static MongoClient client = null;

	public static DB connectToMongo(){
		String ip= "";
		int portNumber=0;
		String database="";
		String DBPath="";
		try {
			/*
			 * The Properties class represents a persistent set of properties. 
			 * The Properties can be saved to a stream or loaded from a stream.
			 *  Each key and its corresponding value in the property list is a string. 
			 */
			Properties pro=new Properties();			
			FileInputStream fi = null;
			try {
				/*
				 * Loading the database properties from properties file to propeties class object
				 */
				fi = new FileInputStream("jdbc.properties");
				pro.load(fi);
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*
			 * getting the values from properties values to variables
			 */
			ip =pro.getProperty("ip");
			portNumber=Integer.parseInt(pro.getProperty("port"));
			database=pro.getProperty("database");
			DBPath = pro.getProperty("DBPath");
			//System.out.println(ip+"\n"+portNumber+"\n"+database);
			/*
			 * If mongo db client exists, returns the database with db name as mentioned in properties file
			 */
			if (null != client) {
				return client.getDB(database);
			}
			/*
			 * If client doesn't exists 
			 * Connecting to mongo server
			 */
			 Runtime rt = Runtime.getRuntime();
			 Process p;
		     try {
				p= rt.exec("C://Program Files//MongoDB 2.6 Standard//bin//mongod.exe --dbpath "+DBPath);//D://Mongo//data");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			client = new MongoClient(ip, portNumber);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}                
		/*
		 * after establishing a connection with mongo server
		 * returns the database with db name as mentioned in properties file
		 */
		return client.getDB(database);   
	}

	//Below main function is written for testing

	public static void main(String[] args) {
		try {
			File currentDirectory = new File(new File(".").getAbsolutePath());
			try {
				System.out.println(currentDirectory.getCanonicalPath());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(currentDirectory.getAbsolutePath());
			DB db = DBManagerMongo.connectToMongo();
			Set<String> st = db.getCollectionNames();
			System.out.println(st.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}