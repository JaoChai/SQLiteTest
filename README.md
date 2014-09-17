// Check Data
	
	public String[] CheckData(String strMemberID) {
		try {
			String arrData[] = null;

			SQLiteDatabase db;
			db = this.getReadableDatabase();

			Cursor cursor = db.query(TABLE_MEMBER, new String[] { "*" },
					"MemberID=?", new String[] { String.valueOf(strMemberID) },
					null, null, null);
			if (cursor != null) {
				if (cursor.moveToFirst()) {
					arrData = new String[cursor.getColumnCount()];
					arrData[0] = cursor.getString(0);
					arrData[1] = cursor.getString(1);
					arrData[2] = cursor.getString(2);
				}
			}
			cursor.close();
			db.close();
			return arrData;

		} catch (Exception e) {
			return null;
		}
	}
	
// Show All Data

	public ArrayList<HashMap<String, String>> SelectAllData() {
		 try {
			 
			 ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
			 HashMap<String, String> map;
			 
			 SQLiteDatabase db;
			 db = this.getReadableDatabase(); // Read Data
				
			 String strSQL = "SELECT  * FROM " + TABLE_MEMBER;
			 Cursor cursor = db.rawQuery(strSQL, null);
			 
			 	if(cursor != null)
			 	{
			 	    if (cursor.moveToFirst()) {
			 	        do {
			 	        	map = new HashMap<String, String>();
			 	        	map.put("MemberID", cursor.getString(0));
				 	        map.put("Name", cursor.getString(1));
				 	        map.put("Tel", cursor.getString(2));
				 	        MyArrList.add(map);
			 	        } while (cursor.moveToNext());
			 	    }
			 	}
			 	cursor.close();
			 	db.close();
				return MyArrList;
				
		 } catch (Exception e) {
		    return null;
		 }

	}
	

// Update Data

	public long UpdateData(String strMemberID,String strName,String strTel) {
		// TODO Auto-generated method stub
		
		 try {
			
			SQLiteDatabase db;
     		db = this.getWritableDatabase(); // Write Data
			insertCmd = db.compileStatement(strSQL);
			insertCmd.bindString(1, strName);
			insertCmd.bindString(2, strTel);
			insertCmd.bindString(3, strMemberID);
				
			return insertCmd.executeUpdateDelete();
			
            ContentValues Val = new ContentValues();
            Val.put("Name", strName);
            Val.put("Tel", strTel);
     
            long rows = db.update(TABLE_MEMBER, Val, " MemberID = ?",
                    new String[] { String.valueOf(strMemberID) });
            
     		db.close();
     		return rows; // return rows updated.
				
		 } catch (Exception e) {
		    return -1;
		 }
	}



