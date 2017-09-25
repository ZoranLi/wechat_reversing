package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout extends LinearLayout {
    Context context;
    List<String> oEu = new ArrayList();

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ String oEA;
        final /* synthetic */ MailAttachListLinearLayout oEB;
        final /* synthetic */ String oEv;
        final /* synthetic */ String oEw;
        final /* synthetic */ String oEx;
        final /* synthetic */ long oEy;
        final /* synthetic */ int oEz;

        AnonymousClass1(MailAttachListLinearLayout mailAttachListLinearLayout, String str, String str2, String str3, long j, int i, String str4) {
            this.oEB = mailAttachListLinearLayout;
            this.oEv = str;
            this.oEw = str2;
            this.oEx = str3;
            this.oEy = j;
            this.oEz = i;
            this.oEA = str4;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.oEB.context, AttachDownloadPage.class);
            intent.putExtra("attach_name", this.oEv);
            intent.putExtra("mail_id", this.oEw);
            intent.putExtra("attach_id", this.oEx);
            intent.putExtra("total_size", this.oEy);
            intent.putExtra("is_preview", this.oEz);
            intent.putExtra("is_compress", MailAttachListLinearLayout.Da(this.oEA));
            this.oEB.context.startActivity(intent);
        }
    }

    static /* synthetic */ boolean Da(String str) {
        return str != null && str.contains("/cgi-bin/viewcompress");
    }

    public MailAttachListLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    static String dg(String str, String str2) {
        if (str == null || str.length() == 0 || str2.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf("&", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring((indexOf + str2.length()) + 1, indexOf2);
    }
}
