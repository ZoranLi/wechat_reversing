package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public class QueryDownloadInfoTask extends GWMainProcessTask {
    public static Creator<QueryDownloadInfoTask> CREATOR = new Creator<QueryDownloadInfoTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new QueryDownloadInfoTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QueryDownloadInfoTask[i];
        }
    };
    public long fCw;
    public ArrayList<FileDownloadTaskInfo> lfM;
    public ArrayList<String> mla;
    public int type;

    public final void PM() {
        w.i("MicroMsg.QueryDownloadInfoTask", "QueryDownloadInfoTask");
        switch (this.type) {
            case 1:
                FileDownloadTaskInfo aU = e.akM().aU(this.fCw);
                this.lfM = new ArrayList();
                this.lfM.add(aU);
                return;
            case 2:
                if (this.mla == null || this.mla.size() == 0) {
                    w.i("MicroMsg.QueryDownloadInfoTask", "appIdList is null");
                    return;
                }
                e.akM();
                this.lfM = e.q(this.mla);
                return;
            default:
                return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeLong(this.fCw);
        parcel.writeList(this.mla);
        parcel.writeList(this.lfM);
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.fCw = parcel.readLong();
        this.mla = parcel.readArrayList(QueryDownloadInfoTask.class.getClassLoader());
        this.lfM = parcel.readArrayList(QueryDownloadInfoTask.class.getClassLoader());
    }

    public QueryDownloadInfoTask(Parcel parcel) {
        f(parcel);
    }
}
