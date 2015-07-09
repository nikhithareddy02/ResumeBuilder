package com.smartResume.lib;

import java.util.Random;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.smartResume.helper.Mailer;



public class RegistrationClass {
	static DB db;

	public RegistrationClass() {
		System.out.println("Constructor : ");
		db = DBManagerMongo.connectToMongo();
	}

	public void InsertAndSendOTP(User user)
	{
		String OTP="";
		String email = user.getEmailId();
		String firstname = user.getFirstName();
		String lastname = user.getLastName();
		long phoneNo = user.getMobileNumber();
		String password = user.getPassword();
		int verifiedStatus = user.getVerifiedStatus();
		/*
		 *generating a random number 
		 */
		int n=6; //number of digits in random number
		Random randGen = new Random();
		int startNum = (int) Math.pow(10, n-1);
		int range = (int) (Math.pow(10, n) - startNum + 1);
		int randomNum = randGen.nextInt(range) + startNum;
		//System.out.println(randomNum);
		/*
		 * Create a new collection of user and adding profile details to the user collection
		 * with title as "Profile Information"
		 */
		OTP = randomNum+"";

		DBCollection coll = db.getCollection(email);
		BasicDBObject doc = new BasicDBObject("title", "Profile Information").
				append("firstname", firstname).
				append("lastname", lastname).
				append("mobileNumber", phoneNo).
				append("emailId",email).
				append("password", password).
				append("verifiedStatus", verifiedStatus).
				append("OTP", OTP);
		coll.insert(doc);

		/*
		 * Sending a confirmation mail to user
		 */
		String subject = "OTP for activation at Smart Resume Builder";
		String msg="Congratulations.. You have succesfully registered with SMART RESUME BUILDER"+"\n"+"Enter this confirmation code to validate your account"+"\n"+"Code : "+randomNum+"";
		msg=msg+"\n\t\t\t"+"Smart Resume Builder"+"\n\t\t\t"; 
		System.out.println(msg);
		Mailer.send(email, subject, msg);

	}

	public DBCollection getUser(String email){
		/*if collection of the user exists, this will return user collection
		 * else creates a new user
		 */		
		DBCollection userCollection = db.getCollection(email);
		return userCollection;
	}


	public boolean VerifyOTP(String email,int otp)
	{
		DBCollection user = db.getCollection(email);
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("title", "Profile Information");
		/*
		 * fetching the document from collection whose title is Profile Information
		 * i.e. fetching profile info of user from database
		 */
		DBCursor cursor = user.find(whereQuery);
		while(cursor.hasNext()) {
			BasicDBObject obj = (BasicDBObject) cursor.next();
			/*
			 * obj.getInt(str) or obj.getString(str) will return the value corresponding to the key str
			 */
			String otp1 = otp+"";
			if(otp1.equals(obj.getString("OTP"))){
				//int verif = obj.getInt("verifiedStatus");
				/*
				 *Not completed getting error here
				 *everything is replaced by single object 
				 */
				System.out.println("Collection before Update");
				printAllDocuments(user);
				BasicDBObject updateDocument = new BasicDBObject();
				updateDocument.append("$set", new BasicDBObject().append("verifiedStatus", 1));
				BasicDBObject searchQuery2 = new BasicDBObject().append("emailId",email);
				user.update(searchQuery2, updateDocument);
				System.out.println("Collection");
				printAllDocuments(user);
				return true;
			}
		}
		return false;
	}
	public static void printAllDocuments(DBCollection collection) {
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	public static void main(String[] args) {
		RegistrationClass r = new RegistrationClass();
		User user = new User();
		r.InsertAndSendOTP(user);
	}

	public boolean checkEmailExists(String email){
		if(db.collectionExists(email)){
			return true;
		}
		return false;
	}

}
