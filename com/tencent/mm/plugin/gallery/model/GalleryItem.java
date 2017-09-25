package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bg;

public final class GalleryItem {

    public static class AlbumItem implements Parcelable {
        public static final Creator<AlbumItem> CREATOR = new Creator<AlbumItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AlbumItem(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AlbumItem[i];
            }
        };
        public int fIM;
        public String meC;
        public MediaItem meD;

        public AlbumItem(String str, int i) {
            this.meC = bg.mz(str);
            this.fIM = i;
        }

        protected AlbumItem(Parcel parcel) {
            this.meC = parcel.readString();
            this.fIM = parcel.readInt();
            this.meD = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
        }

        public final String ayB() {
            if (this.meD == null) {
                return null;
            }
            return this.meD.ayB();
        }

        public final long ayC() {
            if (this.meD == null) {
                return -1;
            }
            return this.meD.meG;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.meC);
            parcel.writeInt(this.fIM);
            parcel.writeParcelable(this.meD, i);
        }
    }

    public static abstract class MediaItem implements Parcelable, Comparable<MediaItem> {
        public String hTf;
        public String lAL;
        public String mMimeType;
        public String meE;
        public String meF;
        public long meG;
        public long meH;

        public abstract String ayB();

        public abstract int getType();

        public /* synthetic */ int compareTo(Object obj) {
            return a((MediaItem) obj);
        }

        public MediaItem() {
            this(0, "", "", "");
        }

        public MediaItem(long j) {
            this(j, "", "", "");
        }

        public MediaItem(long j, String str, String str2, String str3) {
            this.meG = j;
            this.hTf = str;
            this.lAL = str2;
            this.mMimeType = str3;
        }

        public static MediaItem a(int i, long j, String str, String str2, String str3) {
            if (i == 1) {
                return new ImageMediaItem(j, str, str2, str3);
            }
            return new VideoMediaItem(j, str, str2, str3);
        }

        public static MediaItem u(int i, long j) {
            if (i == 1) {
                return new ImageMediaItem(j);
            }
            return new VideoMediaItem(j);
        }

        public final int a(MediaItem mediaItem) {
            if (this.meH > mediaItem.meH) {
                return 1;
            }
            return this.meH < mediaItem.meH ? -1 : -1;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof MediaItem)) {
                return false;
            }
            MediaItem mediaItem = (MediaItem) obj;
            if (this.hTf == null || !this.hTf.equals(mediaItem.hTf)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "MediaItem{mOrignalPath='" + this.hTf + '\'' + ", mThumbPath='" + this.lAL + '\'' + ", origId=" + this.meG + ", addDate=" + this.meH + ", mMimeType='" + this.mMimeType + '\'' + '}';
        }
    }

    public static class ImageMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                MediaItem imageMediaItem = new ImageMediaItem();
                imageMediaItem.hTf = parcel.readString();
                imageMediaItem.lAL = parcel.readString();
                imageMediaItem.meG = parcel.readLong();
                imageMediaItem.meH = parcel.readLong();
                imageMediaItem.mMimeType = parcel.readString();
                return imageMediaItem;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }
        };

        public ImageMediaItem(long j) {
            super(j);
        }

        public ImageMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 1;
        }

        public final String ayB() {
            if (bg.mA(this.lAL)) {
                return this.hTf;
            }
            return this.lAL;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hTf);
            parcel.writeString(this.lAL);
            parcel.writeLong(this.meG);
            parcel.writeLong(this.meH);
            parcel.writeString(this.mMimeType);
        }
    }

    public static class VideoMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                VideoMediaItem videoMediaItem = new VideoMediaItem();
                videoMediaItem.hTf = parcel.readString();
                videoMediaItem.lAL = parcel.readString();
                videoMediaItem.meG = parcel.readLong();
                videoMediaItem.mMimeType = parcel.readString();
                videoMediaItem.hTk = parcel.readInt();
                videoMediaItem.hTj = parcel.readInt();
                videoMediaItem.hTi = parcel.readInt();
                videoMediaItem.hTg = parcel.readString();
                videoMediaItem.hTh = parcel.readString();
                videoMediaItem.hTl = parcel.readInt();
                videoMediaItem.videoFrameRate = parcel.readInt();
                videoMediaItem.videoBitRate = parcel.readInt();
                return videoMediaItem;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        public String hTg;
        public String hTh;
        public int hTi = -1;
        public int hTj = -1;
        public int hTk = -1;
        public int hTl = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;

        public VideoMediaItem(long j) {
            super(j);
        }

        public VideoMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 2;
        }

        public final String ayB() {
            if (bg.mA(this.lAL)) {
                return this.hTf;
            }
            return this.lAL;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hTf);
            parcel.writeString(this.lAL);
            parcel.writeLong(this.meG);
            parcel.writeString(this.mMimeType);
            parcel.writeInt(this.hTk);
            parcel.writeInt(this.hTj);
            parcel.writeInt(this.hTi);
            parcel.writeString(this.hTg);
            parcel.writeString(this.hTh);
            parcel.writeInt(this.hTl);
            parcel.writeInt(this.videoFrameRate);
            parcel.writeInt(this.videoBitRate);
        }

        public String toString() {
            return "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.hTg + '\'' + ", audioTrackMime='" + this.hTh + '\'' + ", durationMs=" + this.hTi + ", videoHeight=" + this.hTj + ", videoWidth=" + this.hTk + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.hTl + ", videoFrameRate=" + this.videoFrameRate + '}';
        }
    }
}
