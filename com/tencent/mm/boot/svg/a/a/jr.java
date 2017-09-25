package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class jr extends c {
    private final int height = 103;
    private final int width = 967;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 967;
            case 1:
                return 103;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
                Paint g = c.g(looper);
                g.setFlags(385);
                g.setStyle(Style.FILL);
                Paint g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.STROKE);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                g2.setStrokeWidth(1.0f);
                g2.setStrokeCap(Cap.BUTT);
                g2.setStrokeJoin(Join.MITER);
                g2.setStrokeMiter(4.0f);
                g2.setPathEffect(null);
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h = c.h(looper);
                h.moveTo(47.2f, 46.0f);
                h.lineTo(47.2f, 59.5f);
                h.lineTo(65.0f, 59.5f);
                h.lineTo(65.0f, 46.0f);
                h.lineTo(47.2f, 46.0f);
                h.close();
                h.moveTo(47.2f, 66.2f);
                h.lineTo(47.2f, 81.1f);
                h.lineTo(65.0f, 81.1f);
                h.lineTo(65.0f, 66.2f);
                h.lineTo(47.2f, 66.2f);
                h.close();
                h.moveTo(47.2f, 88.0f);
                h.lineTo(47.2f, 92.6f);
                h.lineTo(40.1f, 92.6f);
                h.lineTo(40.1f, 34.0f);
                h.cubicTo(37.7f, 37.8f, 35.0f, 41.4f, 32.2f, 44.8f);
                h.lineTo(29.8f, 37.2f);
                h.cubicTo(38.0f, 26.4f, 43.7f, 14.5f, 47.1f, DownloadHelper.SAVE_FATOR);
                h.lineTo(54.1f, 2.9f);
                h.cubicTo(52.6f, 8.3f, 50.7f, 13.5f, 48.5f, 18.6f);
                h.lineTo(66.6f, 18.6f);
                h.cubicTo(65.0f, 13.3f, 63.0f, 8.1f, 60.7f, 3.1f);
                h.lineTo(67.6f, 1.2f);
                h.cubicTo(70.0f, 7.2f, 71.8f, 12.6f, 73.1f, 17.6f);
                h.lineTo(70.4f, 18.6f);
                h.lineTo(89.5f, 18.6f);
                h.lineTo(89.5f, 25.6f);
                h.lineTo(72.1f, 25.6f);
                h.lineTo(72.1f, 39.2f);
                h.lineTo(87.5f, 39.2f);
                h.lineTo(87.5f, 46.0f);
                h.lineTo(72.1f, 46.0f);
                h.lineTo(72.1f, 59.5f);
                h.lineTo(87.5f, 59.5f);
                h.lineTo(87.5f, 66.2f);
                h.lineTo(72.1f, 66.2f);
                h.lineTo(72.1f, 81.1f);
                h.lineTo(90.6f, 81.1f);
                h.lineTo(90.6f, 88.0f);
                h.lineTo(47.2f, 88.0f);
                h.close();
                h.moveTo(65.0f, 25.6f);
                h.lineTo(47.2f, 25.6f);
                h.lineTo(47.2f, 39.2f);
                h.lineTo(65.0f, 39.2f);
                h.lineTo(65.0f, 25.6f);
                h.close();
                h.moveTo(30.9f, 42.5f);
                h.lineTo(30.9f, 49.8f);
                h.cubicTo(27.9f, 51.3f, 24.8f, 52.7f, 21.6f, 54.0f);
                h.lineTo(21.6f, 82.9f);
                h.cubicTo(21.6f, 88.5f, 18.6f, 91.4f, 12.7f, 91.4f);
                h.lineTo(3.5f, 91.4f);
                h.lineTo(2.0f, 84.4f);
                h.cubicTo(4.8f, 84.7f, 7.6f, 84.9f, 10.2f, 84.9f);
                h.cubicTo(12.9f, 84.9f, 14.3f, 83.6f, 14.3f, 81.0f);
                h.lineTo(14.3f, 56.9f);
                h.cubicTo(10.2f, 58.3f, 6.0f, 59.7f, 1.8f, 60.9f);
                h.lineTo(0.0f, 53.7f);
                h.cubicTo(4.9f, 52.6f, 9.7f, 51.2f, 14.3f, 49.6f);
                h.lineTo(14.3f, 26.6f);
                h.lineTo(DownloadHelper.SAVE_FATOR, 26.6f);
                h.lineTo(DownloadHelper.SAVE_FATOR, 19.6f);
                h.lineTo(14.3f, 19.6f);
                h.lineTo(14.3f, 1.1f);
                h.lineTo(21.6f, 1.1f);
                h.lineTo(21.6f, 19.6f);
                h.lineTo(31.7f, 19.6f);
                h.lineTo(31.7f, 26.6f);
                h.lineTo(21.6f, 26.6f);
                h.lineTo(21.6f, 46.8f);
                h.cubicTo(24.8f, 45.4f, 27.9f, 44.0f, 30.9f, 42.5f);
                h.close();
                h.moveTo(102.7f, 8.6f);
                h.lineTo(125.4f, 8.6f);
                h.lineTo(125.4f, 1.4f);
                h.lineTo(132.8f, 1.4f);
                h.lineTo(132.8f, 8.6f);
                h.lineTo(159.2f, 8.6f);
                h.lineTo(159.2f, 1.4f);
                h.lineTo(166.6f, 1.4f);
                h.lineTo(166.6f, 8.6f);
                h.lineTo(189.3f, 8.6f);
                h.lineTo(189.3f, 15.2f);
                h.lineTo(166.6f, 15.2f);
                h.lineTo(166.6f, 22.5f);
                h.lineTo(159.2f, 22.5f);
                h.lineTo(159.2f, 15.2f);
                h.lineTo(132.8f, 15.2f);
                h.lineTo(132.8f, 22.4f);
                h.lineTo(125.4f, 22.4f);
                h.lineTo(125.4f, 15.2f);
                h.lineTo(102.7f, 15.2f);
                h.lineTo(102.7f, 8.6f);
                h.close();
                h.moveTo(104.0f, 29.2f);
                h.lineTo(132.2f, 29.2f);
                h.cubicTo(133.4f, 26.6f, 134.5f, 24.1f, 135.5f, 21.6f);
                h.lineTo(142.5f, 22.8f);
                h.cubicTo(141.7f, 25.0f, 140.8f, 27.1f, 140.0f, 29.2f);
                h.lineTo(188.8f, 29.2f);
                h.lineTo(188.8f, 35.8f);
                h.lineTo(136.7f, 35.8f);
                h.cubicTo(133.7f, 41.1f, 130.1f, 46.1f, 126.0f, 50.8f);
                h.lineTo(126.0f, 93.2f);
                h.lineTo(119.1f, 93.2f);
                h.lineTo(119.1f, 57.8f);
                h.cubicTo(114.9f, 61.6f, 110.3f, 65.1f, 105.3f, 68.5f);
                h.lineTo(100.8f, 62.7f);
                h.cubicTo(112.7f, 54.9f, 121.9f, 45.9f, 128.4f, 35.8f);
                h.lineTo(104.0f, 35.8f);
                h.lineTo(104.0f, 29.2f);
                h.close();
                h.moveTo(160.6f, 58.2f);
                h.cubicTo(164.2f, 56.0f, 168.3f, 53.3f, 173.1f, 50.1f);
                h.lineTo(140.2f, 50.1f);
                h.lineTo(140.2f, 43.5f);
                h.lineTo(183.3f, 43.5f);
                h.lineTo(183.3f, 48.7f);
                h.cubicTo(178.7f, 52.3f, 173.5f, 56.2f, 167.8f, 60.2f);
                h.lineTo(167.8f, 64.4f);
                h.lineTo(189.8f, 64.4f);
                h.lineTo(189.8f, 71.2f);
                h.lineTo(167.8f, 71.2f);
                h.lineTo(167.8f, 84.7f);
                h.cubicTo(167.8f, 90.1f, 165.1f, 92.8f, 159.8f, 92.8f);
                h.lineTo(148.1f, 92.8f);
                h.lineTo(146.0f, 85.8f);
                h.cubicTo(150.6f, 86.1f, 154.3f, 86.3f, 156.9f, 86.3f);
                h.cubicTo(159.3f, 86.3f, 160.6f, 85.1f, 160.6f, 82.7f);
                h.lineTo(160.6f, 71.2f);
                h.lineTo(133.0f, 71.2f);
                h.lineTo(133.0f, 64.4f);
                h.lineTo(160.6f, 64.4f);
                h.lineTo(160.6f, 58.2f);
                h.close();
                h.moveTo(230.2f, 11.5f);
                h.lineTo(256.4f, 11.5f);
                h.lineTo(256.4f, 1.3f);
                h.lineTo(263.7f, 1.3f);
                h.lineTo(263.7f, 11.5f);
                h.lineTo(291.2f, 11.5f);
                h.lineTo(291.2f, 18.4f);
                h.lineTo(263.7f, 18.4f);
                h.lineTo(263.7f, 27.9f);
                h.lineTo(287.1f, 27.9f);
                h.lineTo(287.1f, 56.2f);
                h.lineTo(263.3f, 56.2f);
                h.cubicTo(262.5f, 65.2f, 260.8f, 72.1f, 258.1f, 77.1f);
                h.cubicTo(268.1f, 82.6f, 279.7f, 85.7f, 292.8f, 86.4f);
                h.lineTo(291.0f, 93.3f);
                h.cubicTo(277.0f, 92.4f, 264.7f, 88.9f, 254.1f, 82.7f);
                h.cubicTo(248.7f, 88.2f, 240.2f, 91.8f, 228.6f, 93.5f);
                h.lineTo(225.5f, 86.9f);
                h.cubicTo(235.7f, 85.8f, 243.2f, 83.0f, 247.8f, 78.6f);
                h.cubicTo(241.9f, 74.4f, 236.6f, 69.3f, 232.0f, 63.4f);
                h.lineTo(237.5f, 59.6f);
                h.cubicTo(241.8f, 65.0f, 246.6f, 69.5f, 251.9f, 73.3f);
                h.cubicTo(254.0f, 68.9f, 255.4f, 63.2f, 256.0f, 56.2f);
                h.lineTo(233.6f, 56.2f);
                h.lineTo(233.6f, 27.9f);
                h.lineTo(256.4f, 27.9f);
                h.lineTo(256.4f, 18.4f);
                h.lineTo(230.2f, 18.4f);
                h.lineTo(230.2f, 11.5f);
                h.close();
                h.moveTo(280.3f, 49.7f);
                h.lineTo(280.3f, 34.3f);
                h.lineTo(263.7f, 34.3f);
                h.lineTo(263.7f, 47.3f);
                h.cubicTo(263.7f, 48.1f, 263.6f, 48.9f, 263.6f, 49.7f);
                h.lineTo(280.3f, 49.7f);
                h.close();
                h.moveTo(256.3f, 49.7f);
                h.cubicTo(256.3f, 48.9f, 256.4f, 48.1f, 256.4f, 47.3f);
                h.lineTo(256.4f, 34.3f);
                h.lineTo(240.4f, 34.3f);
                h.lineTo(240.4f, 49.7f);
                h.lineTo(256.3f, 49.7f);
                h.close();
                h.moveTo(211.9f, 37.4f);
                h.cubicTo(208.7f, 41.9f, 205.3f, 46.2f, 201.5f, 50.3f);
                h.lineTo(199.1f, 42.7f);
                h.cubicTo(209.5f, 30.5f, 217.0f, 16.5f, 221.6f, 0.7f);
                h.lineTo(228.4f, 3.8f);
                h.cubicTo(225.9f, 11.6f, 222.8f, 19.0f, 219.1f, 25.9f);
                h.lineTo(219.1f, 93.2f);
                h.lineTo(211.9f, 93.2f);
                h.lineTo(211.9f, 37.4f);
                h.close();
                h.moveTo(317.3f, 36.2f);
                h.lineTo(317.3f, 53.7f);
                h.lineTo(342.7f, 53.7f);
                h.lineTo(342.7f, 36.2f);
                h.lineTo(317.3f, 36.2f);
                h.close();
                h.moveTo(316.9f, 60.3f);
                h.cubicTo(315.8f, 73.1f, 312.1f, 83.7f, 305.7f, 92.1f);
                h.lineTo(300.2f, 87.2f);
                h.cubicTo(306.6f, 78.3f, 309.9f, 67.0f, 310.1f, 53.3f);
                h.lineTo(310.1f, 5.3f);
                h.lineTo(384.6f, 5.3f);
                h.lineTo(384.6f, 80.2f);
                h.cubicTo(384.6f, 87.2f, 381.1f, 90.7f, 374.1f, 90.7f);
                h.lineTo(362.6f, 90.7f);
                h.lineTo(360.7f, 83.6f);
                h.cubicTo(364.7f, 83.8f, 368.4f, 84.0f, 371.8f, 84.0f);
                h.cubicTo(375.4f, 84.0f, 377.3f, 81.9f, 377.3f, 77.7f);
                h.lineTo(377.3f, 60.3f);
                h.lineTo(350.1f, 60.3f);
                h.lineTo(350.1f, 89.6f);
                h.lineTo(342.7f, 89.6f);
                h.lineTo(342.7f, 60.3f);
                h.lineTo(316.9f, 60.3f);
                h.close();
                h.moveTo(377.3f, 53.7f);
                h.lineTo(377.3f, 36.2f);
                h.lineTo(350.1f, 36.2f);
                h.lineTo(350.1f, 53.7f);
                h.lineTo(377.3f, 53.7f);
                h.close();
                h.moveTo(377.3f, 29.5f);
                h.lineTo(377.3f, 12.3f);
                h.lineTo(350.1f, 12.3f);
                h.lineTo(350.1f, 29.5f);
                h.lineTo(377.3f, 29.5f);
                h.close();
                h.moveTo(342.7f, 12.3f);
                h.lineTo(317.3f, 12.3f);
                h.lineTo(317.3f, 29.5f);
                h.lineTo(342.7f, 29.5f);
                h.lineTo(342.7f, 12.3f);
                h.close();
                h.moveTo(396.5f, 11.6f);
                h.lineTo(417.0f, 83.0f);
                h.lineTo(426.1f, 83.0f);
                h.lineTo(442.4f, 23.5f);
                h.lineTo(442.7f, 23.5f);
                h.lineTo(458.9f, 83.0f);
                h.lineTo(468.0f, 83.0f);
                h.lineTo(488.5f, 11.6f);
                h.lineTo(479.3f, 11.6f);
                h.lineTo(463.6f, 71.5f);
                h.lineTo(463.2f, 71.5f);
                h.lineTo(447.0f, 11.6f);
                h.lineTo(438.1f, 11.6f);
                h.lineTo(421.8f, 71.5f);
                h.lineTo(421.4f, 71.5f);
                h.lineTo(405.7f, 11.6f);
                h.lineTo(396.5f, 11.6f);
                h.close();
                h.moveTo(516.5f, 29.9f);
                h.cubicTo(524.8f, 29.9f, 531.1f, 32.7f, 535.3f, 38.3f);
                h.cubicTo(539.1f, 43.3f, 541.1f, 50.4f, 541.3f, 59.4f);
                h.lineTo(500.5f, 59.4f);
                h.cubicTo(500.9f, 65.2f, 502.4f, 69.7f, 505.2f, 72.9f);
                h.cubicTo(508.0f, 76.1f, 511.9f, 77.7f, 516.8f, 77.7f);
                h.cubicTo(521.0f, 77.7f, 524.5f, 76.6f, 527.1f, 74.5f);
                h.cubicTo(529.3f, 72.7f, 531.0f, 70.0f, 532.3f, 66.4f);
                h.lineTo(540.3f, 66.4f);
                h.cubicTo(539.1f, 71.4f, 536.8f, 75.4f, 533.3f, 78.6f);
                h.cubicTo(529.0f, 82.4f, 523.5f, 84.4f, 516.8f, 84.4f);
                h.cubicTo(509.4f, 84.4f, 503.4f, 81.9f, 499.0f, 77.1f);
                h.cubicTo(494.4f, 72.1f, 492.2f, 65.5f, 492.2f, 57.1f);
                h.cubicTo(492.2f, 49.5f, 494.3f, 43.1f, 498.7f, 38.0f);
                h.cubicTo(503.1f, 32.6f, 509.0f, 29.9f, 516.5f, 29.9f);
                h.close();
                h.moveTo(516.7f, 36.6f);
                h.cubicTo(512.1f, 36.6f, 508.4f, 38.1f, 505.6f, 41.1f);
                h.cubicTo(502.8f, 44.1f, 501.2f, 48.1f, 500.7f, 53.2f);
                h.lineTo(533.0f, 53.2f);
                h.cubicTo(532.0f, 42.1f, 526.5f, 36.6f, 516.7f, 36.6f);
                h.close();
                h.moveTo(582.5f, 10.2f);
                h.cubicTo(571.5f, 10.2f, 562.9f, 13.9f, 556.9f, 21.5f);
                h.cubicTo(551.4f, 28.3f, 548.7f, 37.0f, 548.7f, 47.6f);
                h.cubicTo(548.7f, 58.2f, 551.3f, 66.8f, 556.7f, 73.4f);
                h.cubicTo(562.6f, 80.7f, 571.1f, 84.4f, 582.2f, 84.4f);
                h.cubicTo(589.8f, 84.4f, 596.4f, 82.2f, 601.9f, 77.9f);
                h.cubicTo(607.8f, 73.3f, 611.5f, 66.8f, 613.1f, 58.5f);
                h.lineTo(605.2f, 58.5f);
                h.cubicTo(603.8f, 64.7f, 600.9f, 69.4f, 596.7f, 72.6f);
                h.cubicTo(592.7f, 75.6f, 587.9f, 77.1f, 582.2f, 77.1f);
                h.cubicTo(573.8f, 77.1f, 567.5f, 74.3f, 563.1f, 68.8f);
                h.cubicTo(558.9f, 63.6f, 556.9f, 56.5f, 556.9f, 47.6f);
                h.cubicTo(556.9f, 38.7f, 559.0f, 31.6f, 563.2f, 26.2f);
                h.cubicTo(567.7f, 20.4f, 574.1f, 17.5f, 582.4f, 17.5f);
                h.cubicTo(588.0f, 17.5f, 592.7f, 18.8f, 596.6f, 21.5f);
                h.cubicTo(600.6f, 24.3f, 603.2f, 28.3f, 604.2f, 33.5f);
                h.lineTo(612.1f, 33.5f);
                h.cubicTo(611.1f, 26.4f, 607.9f, 20.7f, 602.5f, 16.5f);
                h.cubicTo(597.1f, 12.3f, 590.4f, 10.2f, 582.5f, 10.2f);
                h.close();
                h.moveTo(623.5f, 10.2f);
                h.lineTo(623.5f, 83.0f);
                h.lineTo(631.5f, 83.0f);
                h.lineTo(631.5f, 53.5f);
                h.cubicTo(631.5f, 48.7f, 632.8f, 44.6f, 635.5f, 41.4f);
                h.cubicTo(638.1f, 38.2f, 641.4f, 36.6f, 645.4f, 36.6f);
                h.cubicTo(649.7f, 36.6f, 653.0f, 37.9f, 655.4f, 40.5f);
                h.cubicTo(657.6f, 43.1f, 658.8f, 46.8f, 658.8f, 51.6f);
                h.lineTo(658.8f, 83.0f);
                h.lineTo(666.8f, 83.0f);
                h.lineTo(666.8f, 50.4f);
                h.cubicTo(666.8f, 43.8f, 665.2f, 38.7f, 662.0f, 35.2f);
                h.cubicTo(658.8f, 31.6f, 654.1f, 29.9f, 648.1f, 29.9f);
                h.cubicTo(644.6f, 29.9f, 641.5f, 30.7f, 638.7f, 32.3f);
                h.cubicTo(635.7f, 34.0f, 633.3f, 36.5f, 631.5f, 39.8f);
                h.lineTo(631.5f, 10.2f);
                h.lineTo(623.5f, 10.2f);
                h.close();
                h.moveTo(701.6f, 29.9f);
                h.cubicTo(709.0f, 29.9f, 714.4f, 31.8f, 718.0f, 35.7f);
                h.cubicTo(721.0f, 39.1f, 722.6f, 43.8f, 722.6f, 49.8f);
                h.lineTo(722.6f, 83.0f);
                h.lineTo(715.1f, 83.0f);
                h.lineTo(715.1f, 74.3f);
                h.cubicTo(713.1f, 77.1f, 710.4f, 79.4f, 707.2f, 81.2f);
                h.cubicTo(703.4f, 83.3f, 699.1f, 84.4f, 694.3f, 84.4f);
                h.cubicTo(689.1f, 84.4f, 685.0f, 83.1f, 681.9f, 80.5f);
                h.cubicTo(678.7f, 77.8f, 677.1f, 74.3f, 677.1f, 70.1f);
                h.cubicTo(677.1f, 64.2f, 679.4f, 59.8f, 684.2f, 56.8f);
                h.cubicTo(688.4f, 54.0f, 694.4f, 52.5f, 702.2f, 52.4f);
                h.lineTo(714.6f, 52.2f);
                h.lineTo(714.6f, 49.5f);
                h.cubicTo(714.6f, 40.8f, 710.1f, 36.5f, 701.1f, 36.5f);
                h.cubicTo(697.3f, 36.5f, 694.2f, 37.2f, 691.8f, 38.8f);
                h.cubicTo(689.1f, 40.4f, 687.4f, 42.9f, 686.6f, 46.2f);
                h.lineTo(678.7f, 45.6f);
                h.cubicTo(679.8f, 40.2f, 682.5f, 36.1f, 686.7f, 33.5f);
                h.cubicTo(690.5f, 31.1f, 695.4f, 29.9f, 701.6f, 29.9f);
                h.close();
                h.moveTo(714.6f, 58.2f);
                h.lineTo(702.7f, 58.4f);
                h.cubicTo(691.1f, 58.6f, 685.3f, 62.4f, 685.3f, 69.9f);
                h.cubicTo(685.3f, 72.3f, 686.2f, 74.2f, 688.2f, 75.8f);
                h.cubicTo(690.2f, 77.3f, 692.8f, 78.1f, 696.0f, 78.1f);
                h.cubicTo(700.9f, 78.1f, 705.2f, 76.5f, 709.0f, 73.3f);
                h.cubicTo(712.7f, 70.2f, 714.6f, 66.6f, 714.6f, 62.6f);
                h.lineTo(714.6f, 58.2f);
                h.close();
                h.moveTo(748.8f, 14.6f);
                h.lineTo(740.9f, 17.9f);
                h.lineTo(740.9f, 31.3f);
                h.lineTo(730.5f, 31.3f);
                h.lineTo(730.5f, 38.0f);
                h.lineTo(740.9f, 38.0f);
                h.lineTo(740.9f, 70.9f);
                h.cubicTo(740.9f, 74.8f, 741.7f, 77.7f, 743.4f, 79.7f);
                h.cubicTo(745.2f, 81.9f, 748.3f, 83.0f, 752.5f, 83.0f);
                h.lineTo(760.3f, 83.0f);
                h.lineTo(760.3f, 76.3f);
                h.lineTo(753.7f, 76.3f);
                h.cubicTo(751.9f, 76.3f, 750.6f, 75.8f, 749.9f, 75.0f);
                h.cubicTo(749.1f, 74.2f, 748.8f, 72.8f, 748.8f, 70.9f);
                h.lineTo(748.8f, 38.0f);
                h.lineTo(761.6f, 38.0f);
                h.lineTo(761.6f, 31.3f);
                h.lineTo(748.8f, 31.3f);
                h.lineTo(748.8f, 14.6f);
                h.close();
                h.moveTo(804.8f, 11.6f);
                h.lineTo(834.0f, 11.6f);
                h.cubicTo(850.4f, 11.6f, 858.6f, 18.6f, 858.6f, 32.6f);
                h.cubicTo(858.6f, 46.7f, 850.3f, 53.8f, 833.9f, 53.8f);
                h.lineTo(813.0f, 53.8f);
                h.lineTo(813.0f, 83.0f);
                h.lineTo(804.8f, 83.0f);
                h.lineTo(804.8f, 11.6f);
                h.close();
                h.moveTo(813.0f, 18.7f);
                h.lineTo(813.0f, 46.7f);
                h.lineTo(833.5f, 46.7f);
                h.cubicTo(839.3f, 46.7f, 843.5f, 45.5f, 846.3f, 43.2f);
                h.cubicTo(849.0f, 40.9f, 850.4f, 37.4f, 850.4f, 32.6f);
                h.cubicTo(850.4f, 27.8f, 849.0f, 24.3f, 846.2f, 22.2f);
                h.cubicTo(843.4f, 19.8f, 839.2f, 18.7f, 833.5f, 18.7f);
                h.lineTo(813.0f, 18.7f);
                h.close();
                h.moveTo(890.5f, 29.9f);
                h.cubicTo(897.9f, 29.9f, 903.3f, 31.8f, 906.9f, 35.7f);
                h.cubicTo(909.9f, 39.1f, 911.5f, 43.8f, 911.5f, 49.8f);
                h.lineTo(911.5f, 83.0f);
                h.lineTo(904.0f, 83.0f);
                h.lineTo(904.0f, 74.3f);
                h.cubicTo(902.0f, 77.1f, 899.3f, 79.4f, 896.1f, 81.2f);
                h.cubicTo(892.3f, 83.3f, 888.0f, 84.4f, 883.2f, 84.4f);
                h.cubicTo(878.0f, 84.4f, 873.9f, 83.1f, 870.8f, 80.5f);
                h.cubicTo(867.6f, 77.8f, 866.0f, 74.3f, 866.0f, 70.1f);
                h.cubicTo(866.0f, 64.2f, 868.3f, 59.8f, 873.1f, 56.8f);
                h.cubicTo(877.3f, 54.0f, 883.3f, 52.5f, 891.1f, 52.4f);
                h.lineTo(903.5f, 52.2f);
                h.lineTo(903.5f, 49.5f);
                h.cubicTo(903.5f, 40.8f, 899.0f, 36.5f, 890.0f, 36.5f);
                h.cubicTo(886.2f, 36.5f, 883.1f, 37.2f, 880.7f, 38.8f);
                h.cubicTo(878.0f, 40.4f, 876.3f, 42.9f, 875.5f, 46.2f);
                h.lineTo(867.6f, 45.6f);
                h.cubicTo(868.7f, 40.2f, 871.4f, 36.1f, 875.6f, 33.5f);
                h.cubicTo(879.4f, 31.1f, 884.3f, 29.9f, 890.5f, 29.9f);
                h.close();
                h.moveTo(903.5f, 58.2f);
                h.lineTo(891.6f, 58.4f);
                h.cubicTo(880.0f, 58.6f, 874.2f, 62.4f, 874.2f, 69.9f);
                h.cubicTo(874.2f, 72.3f, 875.1f, 74.2f, 877.1f, 75.8f);
                h.cubicTo(879.1f, 77.3f, 881.7f, 78.1f, 884.9f, 78.1f);
                h.cubicTo(889.8f, 78.1f, 894.1f, 76.5f, 897.9f, 73.3f);
                h.cubicTo(901.6f, 70.2f, 903.5f, 66.6f, 903.5f, 62.6f);
                h.lineTo(903.5f, 58.2f);
                h.close();
                h.moveTo(918.2f, 31.3f);
                h.lineTo(938.7f, 81.8f);
                h.lineTo(929.8f, 102.8f);
                h.lineTo(938.5f, 102.8f);
                h.lineTo(966.8f, 31.3f);
                h.lineTo(958.0f, 31.3f);
                h.lineTo(942.7f, 72.1f);
                h.lineTo(926.9f, 31.3f);
                h.lineTo(918.2f, 31.3f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}