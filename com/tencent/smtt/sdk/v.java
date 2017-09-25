package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.wcdb.database.SQLiteDatabase;

final class v extends FrameLayout implements OnErrorListener {
    Context mContext = null;
    String mUrl;
    Object wWn;
    z wWo;
    VideoView wWp;

    public v(Context context) {
        super(context.getApplicationContext());
        this.mContext = context;
    }

    public final boolean ceU() {
        return (this.wWo == null || this.wWn == null) ? false : true;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            if (this.mContext instanceof Activity) {
                Activity activity = (Activity) this.mContext;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context = getContext();
            if (context != null) {
                Toast.makeText(context, "播放失败，请选择其它播放器播放", 1).show();
                context = context.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.setDataAndType(Uri.parse(this.mUrl), "video/*");
                context.startActivity(intent);
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
