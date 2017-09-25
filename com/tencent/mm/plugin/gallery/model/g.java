package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import java.util.ArrayList;

public interface g {

    public interface a {
        void A(ArrayList<AlbumItem> arrayList);
    }

    public interface b {
        void a(ArrayList<MediaItem> arrayList, long j);
    }

    public interface c {
        void a(ArrayList<MediaItem> arrayList, long j);
    }

    ArrayList<MediaItem> a(String str, int i, c cVar, long j);

    ArrayList<AlbumItem> ayE();

    void ayF();
}
