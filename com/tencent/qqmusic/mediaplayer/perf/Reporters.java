package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.OverallInfo;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.SpeedCheck;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.Visitor;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class Reporters {
    public static Visitor detail(final AudioInformation audioInformation, final Map<String, String> map) {
        return new Visitor() {
            public final void visitSpeedCheck(List<SpeedCheck> list, OverallInfo overallInfo) {
                File file = overallInfo.mediaFile;
                long round = Math.round(((double) overallInfo.totalPcmToBePlayed) / ((double) overallInfo.timeCostInMs));
                double channels = ((double) (((long) (audioInformation.getBitDept() == 1 ? 1 : 2)) * (((long) audioInformation.getChannels()) * audioInformation.getPlaySample()))) / 1000.0d;
                double d = ((double) round) / channels;
                StringBuilder stringBuilder = new StringBuilder("\n============== Info start ==============\n");
                stringBuilder.append("媒体文件信息:\n");
                stringBuilder.append("\t播放时间: ").append(new Date().toString()).append("\n");
                stringBuilder.append("\t文件路径: ").append(file.getAbsolutePath()).append("\n");
                stringBuilder.append("\t文件大小: ").append(file.length()).append("\n");
                stringBuilder.append("\t音频类型: ").append(audioInformation.getAudioType().toString()).append("\n");
                stringBuilder.append("\t文件采样率: ").append(audioInformation.getSampleRate()).append("\n");
                stringBuilder.append("\t播放采样率: ").append(audioInformation.getPlaySample()).append("\n");
                stringBuilder.append("\t位深: ").append(audioInformation.getBitDept()).append("\n");
                stringBuilder.append("\t声道数: ").append(audioInformation.getChannels()).append("\n");
                stringBuilder.append("\t时长: ").append(audioInformation.getDuration()).append("\n");
                stringBuilder.append("\t平均码率: ").append((file.length() / audioInformation.getDuration()) * 8).append("\n");
                stringBuilder.append("\n整体性能\n");
                stringBuilder.append("\t总耗时 (ms): ").append(overallInfo.timeCostInMs).append("\n");
                stringBuilder.append("\t播放PCM数据量 (byte): ").append(overallInfo.totalPcmToBePlayed).append("\n");
                stringBuilder.append("\t总速度 (byte/ms): ").append(round).append(" (").append(Math.round(d)).append(" 倍于最低要求速度)\n");
                stringBuilder.append("\t最低要求速度 (byte/ms): ").append(channels).append("\n");
                stringBuilder.append("\n额外信息:");
                for (Entry entry : map.entrySet()) {
                    stringBuilder.append("\n\t").append((String) entry.getKey()).append(": ").append((String) entry.getValue());
                }
                stringBuilder.append("\n");
                Reporters.generateDetailedPerformance(list, stringBuilder, overallInfo.timeCostInMs);
                stringBuilder.append("============== Info end ==============");
                FileLogger.write(stringBuilder, new File(file.getAbsolutePath() + ".perf"), false);
            }
        };
    }

    public static void generateDetailedPerformance(List<SpeedCheck> list, StringBuilder stringBuilder, long j) {
        stringBuilder.append("\n详细性能数据:\n");
        stringBuilder.append(String.format(Locale.getDefault(), "\t%15s%15s%15s%15s%15s", new Object[]{"名称", "平均速度(byte/ms)", "耗时(ms)", "数据量(byte)", "占总耗时比"}));
        for (SpeedCheck speedCheck : list) {
            stringBuilder.append("\n");
            stringBuilder.append(String.format(Locale.getDefault(), "\t%15s%15.0f%15.0f%15.0f%15d%15d%13.2f", new Object[]{speedCheck.getName(), Double.valueOf(speedCheck.getAvg()), Double.valueOf(speedCheck.getMax()), Double.valueOf(speedCheck.getMin()), Long.valueOf(speedCheck.getTotalTimeMs()), Long.valueOf(speedCheck.getTotalBufferLength()), Double.valueOf(((double) speedCheck.getTotalTimeMs()) / ((double) j))}));
        }
        stringBuilder.append("\n");
    }
}
