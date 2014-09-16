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
