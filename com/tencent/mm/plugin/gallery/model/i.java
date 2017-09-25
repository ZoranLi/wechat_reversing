package com.tencent.mm.plugin.gallery.model;

import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class i extends k {
    private String[] meN = new String[]{"camera", "screenshot", "download"};

    protected final int getType() {
        return 1;
    }

    public final ArrayList<AlbumItem> ayE() {
        return super.ayE();
    }

    public final Uri ayG() {
        return Media.EXTERNAL_CONTENT_URI;
    }

    public final String[] getProjection() {
        return new String[]{"_id", "_data", "bucket_display_name", "count(*)", "COALESCE(" + k.meR, k.meQ + ",0) AS " + meS, k.meR, k.meQ, "mime_type"};
    }

    public final String getSelection() {
        return "0==0) GROUP BY (bucket_display_name";
    }

    public final String ayI() {
        return k.meS + " desc,_id desc";
    }

    protected final String ayJ() {
        return "bucket_display_name";
    }

    protected final String[] ayH() {
        return new String[]{"_id", "_data", "COALESCE(" + k.meR, k.meQ + ",0) AS " + meS, k.meR, k.meQ, "mime_type"};
    }

    protected final String xn(String str) {
        if (!bg.mA(str)) {
            return "bucket_display_name=\"" + str + "\"";
        }
        w.w("MicroMsg.ImageQuery", "get media item selection, but album name is null, do select all");
        String stringBuilder = new StringBuilder("_size>10240").toString();
        String[] strArr = this.meN;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            i++;
            stringBuilder = stringBuilder + " or lower(_data) like '%" + strArr[i] + "%'";
        }
        w.d("MicroMsg.ImageQuery", "where %s", new Object[]{stringBuilder});
        return stringBuilder;
    }
}
