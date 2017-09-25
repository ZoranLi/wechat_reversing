package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GameProcessActivityTask implements Parcelable {
    private static Map<String, WeakReference<GameProcessActivityTask>> iJU = new ConcurrentHashMap();
    static final Set<Object> iKx = new HashSet();
    private String iKz = (Process.myPid() + hashCode());
    private Context mContext;
    private int mju = -1;
    private com.tencent.mm.ui.MMActivity.a mjv = new com.tencent.mm.ui.MMActivity.a(this) {
        final /* synthetic */ GameProcessActivityTask mjw;

        {
            this.mjw = r1;
        }

        public final void a(int i, int i2, Intent intent) {
            if (i == (this.mjw.hashCode() & 65535) && intent != null) {
                GameProcessActivityTask gameProcessActivityTask = (GameProcessActivityTask) intent.getParcelableExtra("task_object");
                GameProcessActivityTask xw = GameProcessActivityTask.xw(intent.getStringExtra("task_id"));
                if (xw == null) {
                    w.e("MicroMsg.GameProcessActivityTask", "task is null");
                    return;
                }
                GameProcessActivityTask.a(gameProcessActivityTask, xw);
                GameProcessActivityTask.iKx.remove(xw);
                xw.SK();
            }
        }
    };

    public interface a {
        void TP();
    }

    public abstract void a(Context context, a aVar);

    public GameProcessActivityTask(Context context) {
        this.mContext = context;
    }

    public void SK() {
    }

    public void f(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final void avz() {
        if (this.mContext != null) {
            iJU.put(this.iKz, new WeakReference(this));
            Intent intent = new Intent();
            intent.putExtra("task_object", this);
            intent.putExtra("task_id", this.iKz);
            intent.putExtra("orientation", this.mju);
            if (this.mContext instanceof MMActivity) {
                iKx.add(this);
                ((MMActivity) this.mContext).uSV = this.mjv;
                d.b(this.mContext, "game", ".gamewebview.ui.GameIpcProxyUI", intent, hashCode() & 65535);
                return;
            }
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            d.b(this.mContext, "game", ".gamewebview.ui.GameIpcProxyUI", intent);
        }
    }

    public static void a(GameProcessActivityTask gameProcessActivityTask, GameProcessActivityTask gameProcessActivityTask2) {
        Parcel obtain = Parcel.obtain();
        gameProcessActivityTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        gameProcessActivityTask2.f(obtain);
        obtain.recycle();
    }

    public static GameProcessActivityTask xw(String str) {
        if (!iJU.containsKey(str)) {
            return null;
        }
        if (((WeakReference) iJU.get(str)).get() == null) {
            return null;
        }
        return (GameProcessActivityTask) ((WeakReference) iJU.get(str)).get();
    }
}
