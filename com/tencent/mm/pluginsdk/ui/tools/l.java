package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class l {
    public Context context;
    public String filePath;
    public int fileType = 0;
    public Uri uri;

    public l(Context context, Uri uri) {
        String str = null;
        this.context = context;
        this.uri = uri;
        if (uri == null) {
            w.e("MicroMsg.UriFileHelper", "initFileTypeAndPath uri == null");
        } else if (this.context == null) {
            w.e("MicroMsg.UriFileHelper", "initFileTypeAndPath context == null");
        } else {
            String str2;
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String type = this.context.getContentResolver().getType(uri);
            int lastIndexOf;
            if (type == null || type.length() <= 0) {
                if (uri.getPath() != null) {
                    File file = new File(uri.getPath());
                    if (file.exists()) {
                        this.filePath = file.getAbsolutePath();
                        lastIndexOf = this.filePath.lastIndexOf(".");
                        if (lastIndexOf == -1 || lastIndexOf >= this.filePath.length() - 1) {
                            this.fileType = 1;
                            str2 = type;
                        } else {
                            str2 = singleton.getMimeTypeFromExtension(this.filePath.substring(lastIndexOf + 1));
                        }
                    } else {
                        w.e("MicroMsg.UriFileHelper", "File is null");
                        this.fileType = 0;
                        return;
                    }
                }
                str2 = type;
            } else {
                if (this.context == null) {
                    w.e("MicroMsg.UriFileHelper", "getFilePath context == null");
                } else {
                    Cursor query = this.context.getContentResolver().query(uri, null, null, null, null);
                    if (query == null) {
                        w.e("MicroMsg.UriFileHelper", "getFilePath : fail, cursor is null");
                    } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                        query.close();
                        w.e("MicroMsg.UriFileHelper", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                    } else {
                        lastIndexOf = query.getColumnIndex("_data");
                        if (lastIndexOf == -1) {
                            query.close();
                            w.e("MicroMsg.UriFileHelper", "getFilePath : columnIdx is -1, column with columnName = _data does not exist");
                        } else {
                            str = query.getString(lastIndexOf);
                            query.close();
                        }
                    }
                }
                this.filePath = str;
                str2 = type;
            }
            if (str2 == null || this.filePath == null) {
                this.fileType = 0;
                return;
            }
            if (str2.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                this.fileType = 3;
            } else if (str2.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                this.fileType = 4;
            } else if (str2.contains(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                this.fileType = 5;
            } else if (str2.contains("mm_item")) {
                this.fileType = 2;
            } else {
                this.fileType = 1;
            }
            w.d("MicroMsg.UriFileHelper", "MimeType[%s], filePath = [%s], fileType = [%s], type = [%s], Uri[%s]", str2, this.filePath, Integer.valueOf(this.fileType), str2, uri.toString());
        }
    }
}
