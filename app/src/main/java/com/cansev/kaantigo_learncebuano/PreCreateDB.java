package com.cansev.kaantigo_learncebuano;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PreCreateDB {
    public static void copyDB(Context context) {
        String destPath = "/data/data/" + context.getPackageName() + "/databases";
        String destPathWithFileName = destPath + "/kaantigolangdb.db";
        File fPath = new File(destPath);
        File fPathWithName = new File(destPathWithFileName);
        if(!fPath.exists()) {
            fPath.mkdirs();
            try {
                rawCopy(context.getAssets().open("kaantigolangdb.db"), new FileOutputStream(destPathWithFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(!fPathWithName.exists()) {
            try {
                rawCopy(context.getAssets().open("kaantigolangdb.db"), new FileOutputStream(destPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void rawCopy(InputStream open, FileOutputStream fileOutputStream) {
        try {
            byte[] buffer = new byte[1024];
            int length;
            while((length = open.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            open.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
