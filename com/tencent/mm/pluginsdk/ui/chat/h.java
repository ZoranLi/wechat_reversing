package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

final class h {
    private ContentResolver hRE = this.mContext.getContentResolver();
    protected Context mContext;

    public interface a {
        int bFY();
    }

    protected h(Context context) {
        this.mContext = context;
    }

    private String Nc(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
            return null;
        }
        try {
            Cursor query = this.hRE.query(Thumbnails.EXTERNAL_CONTENT_URI, null, "image_id=\"" + str + "\"", null, null);
            if (query == null) {
                w.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:" + str);
                return null;
            }
            String string;
            if (query.moveToFirst()) {
                do {
                    string = query.getString(query.getColumnIndexOrThrow("_data"));
                } while (query.moveToNext());
            } else {
                string = null;
            }
            query.close();
            return string;
        } catch (Exception e) {
            w.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", e.toString());
            return null;
        }
    }

    public final ArrayList<g> bGb() {
        ArrayList<g> arrayList = new ArrayList();
        String stringBuilder = new StringBuilder("date_added desc limit 1").toString();
        String[] strArr = new String[]{"_id", "_data", "date_added"};
        bg.Nz();
        try {
            Cursor query = this.hRE.query(Media.EXTERNAL_CONTENT_URI, strArr, null, null, stringBuilder);
            if (query == null) {
                return arrayList;
            }
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(query.getColumnIndexOrThrow("_id"));
                    String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                    String string3 = query.getString(query.getColumnIndexOrThrow("date_added"));
                    String Nc = Nc(string);
                    if (bg.mA(string2) || !e.aO(string2)) {
                        w.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
                    } else if (string2.startsWith(com.tencent.mm.compatible.util.e.gSz)) {
                        w.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
                    } else {
                        g gVar = new g();
                        gVar.sQm = bg.getLong(string, 0);
                        gVar.meH = bg.getLong(string3, 0);
                        if (!bg.mA(Nc) && e.aO(Nc)) {
                            gVar.fKz = Nc;
                        }
                        if (!bg.mA(string2) && e.aO(string2)) {
                            gVar.sQn = string2;
                        }
                        if (bg.mA(gVar.sQn) && bg.mA(gVar.sQn)) {
                            w.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
                        } else {
                            arrayList.add(gVar);
                        }
                    }
                } while (query.moveToNext());
            }
            query.close();
            return arrayList;
        } catch (Exception e) {
            w.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", e.toString());
            return null;
        }
    }
}
