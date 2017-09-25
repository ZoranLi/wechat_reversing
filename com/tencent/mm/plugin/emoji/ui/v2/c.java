package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.h;
import com.tencent.mm.sdk.platformtools.w;

public class c extends a {
    protected final int getLayoutId() {
        return R.i.daJ;
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        w.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onAttach");
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreate");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        w.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreateView");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public final void onStart() {
        super.onStart();
        w.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStart");
    }

    public final void onResume() {
        super.onResume();
        w.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
        if (this.kWo != null) {
            this.kWo.aoC();
        }
    }

    public final void onPause() {
        super.onPause();
        w.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onPause");
    }

    public final void onStop() {
        super.onStop();
        w.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStop");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        w.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
    }

    public final void onDestroy() {
        super.onDestroy();
        w.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    }

    public final void onDetach() {
        super.onDetach();
        w.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    }

    public final int amO() {
        return 9;
    }

    public final a amH() {
        return new h(this.uSU.uTo);
    }

    public final boolean aoz() {
        return false;
    }
}
