package com.cansev.kaantigo_learncebuano.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.cansev.kaantigo_learncebuano.flashcard.Flashcard;

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

    public ArrayList<Term> getSearchResults(String searchInput, boolean isEnglish, boolean isSQL, boolean isPhonetic) {
        termList.clear();
        Cursor cursor = null;
        String searchColumn = DatabaseHelper.KEY_WRITTEN_FORM;
        String searchCommand = searchInput + "%";
        if(isEnglish) {
            searchColumn = DatabaseHelper.KEY_WORD_EN;
        } else if(isPhonetic) {
            searchColumn = DatabaseHelper.KEY_WORD_CEB;
        }
        if(isSQL) {
            searchCommand = searchInput;
        }
        try {
            cursor = db.rawQuery("SELECT * FROM (SELECT word_ceb, written_form, affixed_form, word_en, pos, category FROM ceb_adjectives UNION SELECT word_ceb, written_form, affixed_form, word_en, pos, category FROM ceb_nouns UNION SELECT word_ceb, written_form, affixed_form, word_en, pos, category FROM ceb_verbs UNION SELECT word_ceb, written_form, affixed_form, word_en, pos, category FROM ceb_special) merged_table" +
                            " WHERE " + searchColumn + " LIKE '" + searchCommand + "' ORDER BY " + searchColumn + " LIMIT 100", new String[]{});
//            cursor = db.query(DatabaseHelper.TABLE_NAME, new String[]{DatabaseHelper.KEY_WORD_CEB, DatabaseHelper.KEY_WRITTEN_FORM, DatabaseHelper.KEY_AFFIXED_FORM, DatabaseHelper.KEY_WORD_EN, DatabaseHelper.KEY_VERB_TYPE},
//                    searchColumn + " LIKE '" + searchCommand + "'", null, null, null, searchColumn);
//            System.out.println(cursor);
            while(cursor.moveToNext()) {
                int index1 = cursor.getColumnIndex(DatabaseHelper.KEY_WORD_CEB);
                String word_ceb = cursor.getString(index1);
                int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_WRITTEN_FORM);
                String written_form = cursor.getString(index2);
                int index3 = cursor.getColumnIndex(DatabaseHelper.KEY_AFFIXED_FORM);
                String affixed_form = cursor.getString(index3);
                int index4 = cursor.getColumnIndex(DatabaseHelper.KEY_WORD_EN);
                String word_en = cursor.getString(index4);
                int index5 = cursor.getColumnIndex(DatabaseHelper.KEY_POS);
                String pos = cursor.getString(index5);
                int index6 = cursor.getColumnIndex(DatabaseHelper.KEY_CATEGORY);
                String category = cursor.getString(index6);
                Term term = new Term(word_ceb, written_form, affixed_form, word_en, pos, category);
                termList.add(term);
            }
//            for(Term term : termList) {
//                System.out.println(term);
//                System.out.println("***");
//            }
//            System.out.println("___");
        } catch (SQLiteException e) {
            return termList;
        } finally {
            if(cursor != null) {
                cursor.close();
            }
        }
        return termList;
    }

    public Verb getVerb(String searchInput, boolean isEnglish) {
        Verb verb = null;
        Cursor cursor = null;
        String searchColumn = DatabaseHelper.KEY_WRITTEN_FORM;
        String searchCommand = searchInput;
        if(isEnglish) {
            searchColumn = DatabaseHelper.KEY_WORD_EN;
        }
        try {
            cursor = db.rawQuery("SELECT * FROM ceb_verbs" +
                    " WHERE " + searchColumn + " LIKE '" + searchCommand + "' ORDER BY " + searchColumn + " LIMIT 1", new String[]{});
            if(cursor.moveToNext()) {
                int index1 = cursor.getColumnIndex(DatabaseHelper.KEY_WORD_CEB);
                String word_ceb = cursor.getString(index1);
                int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_WRITTEN_FORM);
                String written_form = cursor.getString(index2);
                int index3 = cursor.getColumnIndex(DatabaseHelper.KEY_AFFIXED_FORM);
                String affixed_form = cursor.getString(index3);
                int index4 = cursor.getColumnIndex(DatabaseHelper.KEY_WORD_EN);
                String word_en = cursor.getString(index4);
                int index6 = cursor.getColumnIndex(DatabaseHelper.KEY_CATEGORY);
                String category = cursor.getString(index6);
                System.out.println(written_form + " " + word_en);
                verb = new Verb(word_ceb, written_form, affixed_form, word_en, category);
            } else {
                if(!isEnglish) {
                    verb = new Verb(searchInput, searchInput, "");
                } else {
                    switch (searchInput) {
                        case " ":
                            verb = new Verb("kuan", "kuan", "*");
                            break;
                        case "do":
                            verb = new Verb("buhat", "buhat", "*");
                            break;
                        case "make":
                            verb = new Verb("himo", "himo", "*");
                            break;
                        case "put":
                            verb = new Verb("butang", "butng", "*");
                            break;
                        case "write":
                            verb = new Verb("sulat", "sulat", "*");
                            break;
                        default:
                            verb = new Verb("-" + searchInput, "-" + searchInput + "-", "*");
                            break;
                    }
                }
            }
        } catch (SQLiteException e) {
            return verb;
        } finally {
            if(cursor != null) {
                cursor.close();
            }
        }
        return verb;
    }

    public Term getNoun(String searchInput) {
        Term term = null;
        String searchColumn = DatabaseHelper.KEY_WORD_EN;
        try (Cursor cursor = db.rawQuery("SELECT * FROM ceb_nouns" +
                " WHERE " + searchColumn + " LIKE '" + searchInput + "' ORDER BY " + searchColumn + " LIMIT 1", new String[]{})) {
            if (cursor.moveToNext()) {
                int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_WRITTEN_FORM);
                String written_form = cursor.getString(index2);
                int index4 = cursor.getColumnIndex(DatabaseHelper.KEY_WORD_EN);
                String word_en = cursor.getString(index4);
                term = new Term(written_form, word_en);
            } else {
                term = new Term(searchInput, searchInput);
            }
        } catch (SQLiteException e) {
            return term;
        }
        return term;
    }

    public ArrayList<Flashcard> getFlashcards() {
        ArrayList<Flashcard> flashcards = new ArrayList<>();
        try (Cursor cursor = db.rawQuery("SELECT * FROM ceb_nouns", new String[]{})) {
            while (cursor.moveToNext()) {
                int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_WRITTEN_FORM);
                String written_form = cursor.getString(index2);
                int index4 = cursor.getColumnIndex(DatabaseHelper.KEY_WORD_EN);
                String word_en = cursor.getString(index4);
                Flashcard f = new Flashcard(written_form, word_en);
                flashcards.add(f);
            }
        } catch (SQLiteException e) {
            return flashcards;
        }
        return flashcards;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "kaantigolangdb.db";
        private static final String TABLE_ADJECTIVES = "ceb_adjectives";
        private static final String TABLE_NOUNS = "ceb_nouns";
        private static final String TABLE_VERBS = "ceb_verbs";
        private static final String TABLE_SPECIAL = "ceb_special";
        private static final int DATABASE_VERSION = 1;
        private static final String KEY_WORD_CEB = "word_ceb";
        private static final String KEY_WRITTEN_FORM = "written_form";
        private static final String KEY_AFFIXED_FORM = "affixed_form";
        private static final String KEY_WORD_EN = "word_en";
        private static final String KEY_POS = "pos";
        private static final String KEY_CATEGORY = "category";
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

        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.setVersion(oldVersion);
        }
    }
}
