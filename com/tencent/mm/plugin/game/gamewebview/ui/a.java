package com.tencent.mm.plugin.game.gamewebview.ui;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    private String lang = v.ea(ab.getContext());
    boolean mlS;
    private String mlT;
    private String mlU;
    private String mlV;
    private String mlW;
    private String mlX;
    private String mlY;

    public a(Bundle bundle) {
        this.mlS = bundle.getBoolean("close_window_confirm_dialog_switch");
        this.mlT = bundle.getString("close_window_confirm_dialog_title_cn");
        this.mlU = bundle.getString("close_window_confirm_dialog_title_eng");
        this.mlV = bundle.getString("close_window_confirm_dialog_ok_cn");
        this.mlW = bundle.getString("close_window_confirm_dialog_ok_eng");
        this.mlX = bundle.getString("close_window_confirm_dialog_cancel_cn");
        this.mlY = bundle.getString("close_window_confirm_dialog_cancel_eng");
    }

    public final String azs() {
        if ("zh_CN".equals(this.lang)) {
            return this.mlT;
        }
        return this.mlU;
    }

    public final String azt() {
        if ("zh_CN".equals(this.lang)) {
            return this.mlV;
        }
        return this.mlW;
    }

    public final String azu() {
        if ("zh_CN".equals(this.lang)) {
            return this.mlX;
        }
        return this.mlY;
    }
}
