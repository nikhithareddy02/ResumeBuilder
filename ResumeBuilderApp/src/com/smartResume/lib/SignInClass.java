package com.smartResume.lib;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.smartResume.helper.CaesarCipher;

public class SignInClass {
	static DB db;
	public SignInClass() {
		db = DBManagerMongo.connectToMongo();
	}

	public Boolean ValidateUser(String Email, String Password){

		return false;
	}

	public Boolean ValidateLogin(String email,String password){
		DBCollection user = db.getCollection(email);
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("title", "Profile Information");
		/*
		 * we are encrypting the entered password
		 * as we stored the password to the database by encrypting
		 */
		CaesarCipher cc = new CaesarCipher();
		String encryptedPwd = cc.encrypt(password, 3);
		/*
		 * fetching the document from collection whose title is Profile Information
		 * i.e. fetching profile info of user from database
		 */
		DBCursor cursor = user.find(whereQuery);
		//System.out.println("length: "+cursor.length());
		while(cursor.hasNext()) {
			BasicDBObject obj = (BasicDBObject) cursor.next();
			/*
			 * obj.getInt(str) or obj.getString(str) will return the value corresponding to the key str
			 */
			//System.out.println(encryptedPwd+"\t"+obj.getString("password"));
			if(encryptedPwd.equals(obj.getString("password"))){
				return true;
			}
		}
		return false;
	}
	public Boolean isVerified(String email){
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
			 * if verified status == 1 then user is already verified else No
			 */
			if(1 == obj.getInt("verifiedStatus")){
				return true;
			}
		}
		return false;
	}
}
