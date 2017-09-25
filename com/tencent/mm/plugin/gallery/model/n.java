package com.tencent.mm.plugin.gallery.model;

import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class n extends k {
    protected final int getType() {
        return 2;
    }

    public final ArrayList<AlbumItem> ayE() {
        return super.ayE();
    }

    protected final Uri ayG() {
        return Media.EXTERNAL_CONTENT_URI;
    }

    protected final String[] getProjection() {
        return new String[]{"_id", "_data", "bucket_display_name", "count(*)", "COALESCE(" + k.meR, k.meQ + ",0) AS " + meS, k.meR, k.meQ, "mime_type"};
    }

    protected final String getSelection() {
        return "0==0) GROUP BY (bucket_display_name";
    }

    protected final String ayI() {
        return k.meR + " desc,_id desc";
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
        w.w("MicroMsg.VideoQuery", "get media item selection, but album name is null, do select all");
        return null;
    }
}
