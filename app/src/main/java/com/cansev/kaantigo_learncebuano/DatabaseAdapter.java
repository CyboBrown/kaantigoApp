package com.cansev.kaantigo_learncebuano;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAdapter {

    DatabaseHelper helper;
    SQLiteDatabase db;
    ArrayList<Term> termList = new ArrayList<>();

    public DatabaseAdapter(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

//    public ArrayList<Term> getSomeTerms(String termsStartsWith) {
//        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, new String[]{DatabaseHelper.KEY_WORD_CEB, DatabaseHelper.KEY_WRITTEN_FORM, DatabaseHelper.KEY_AFFIXED_FORM},
//                DatabaseHelper.KEY_WRITTEN_FORM + " LIKE '" + termsStartsWith + "%'", null, null, null, null);
//        while(cursor.moveToNext()) {
//            int index1 = cursor.getColumnIndex(DatabaseHelper.KEY_WORD_CEB);
//            String word_ceb = cursor.getString(index1);
//            int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_WRITTEN_FORM);
//            String written_form = cursor.getString(index2);
//            int index3 = cursor.getColumnIndex(DatabaseHelper.KEY_AFFIXED_FORM);
//            String affixed_form = cursor.getString(index3);
//            Term term = new Term(word_ceb, written_form, affixed_form);
//            termList.add(term);
//        }
//        return termList;
//    }

    public ArrayList<Term> getSearchResults(String searchInput) {
        termList.clear();
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, new String[]{DatabaseHelper.KEY_WORD_CEB, DatabaseHelper.KEY_WRITTEN_FORM, DatabaseHelper.KEY_AFFIXED_FORM},
                DatabaseHelper.KEY_WRITTEN_FORM + " LIKE '%" + searchInput + "%'", null, null, null, null);
        System.out.println(cursor);
        while(cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(DatabaseHelper.KEY_WORD_CEB);
            String word_ceb = cursor.getString(index1);
            int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_WRITTEN_FORM);
            String written_form = cursor.getString(index2);
            int index3 = cursor.getColumnIndex(DatabaseHelper.KEY_AFFIXED_FORM);
            String affixed_form = cursor.getString(index3);
            Term term = new Term(word_ceb, written_form, affixed_form);
            termList.add(term);
        }
        for(Term term : termList) {
            System.out.println(term);
            System.out.println("***");
        }
        System.out.println("___");
        cursor.close();
        return termList;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "kaantigolangdb.db";
        private static final String TABLE_NAME = "tbVerbsCebuano";
        private static final int DATABASE_VERSION = 1;
        private static final String KEY_WORD_CEB = "word_ceb";
        private static final String KEY_WRITTEN_FORM = "written_form";
        private static final String KEY_AFFIXED_FORM = "affixed_form";
        private Context context;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }


        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
