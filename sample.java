popular.addListenerForSingleValueEvent(new ValueEventListener() {
	@Override
	public void onDataChange(DataSnapshot _dataSnapshot) {
		page_1 = new ArrayList<>();
		try {
			GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
			for (DataSnapshot _data : _dataSnapshot.getChildren()) {
				HashMap<String, Object> _map = _data.getValue(_ind);
				page_1.add(_map);
			}
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		SketchwareUtil.showMessage(getApplicationContext(), String.valueOf((long)(page_1.size())));
		l_grid.setAdapter(new L_gridAdapter(page_1));
		movie_id.edit().putString("raw", new Gson().toJson(page_1)).commit();
	}
	@Override
	public void onCancelled(DatabaseError _databaseError) {
	}
});
