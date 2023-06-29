package com.cityeyelab.dt.controller.api;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;

public class RTSPPlayer {
    public static void main(String[] args) {
        // VLC 실행 파일 경로를 찾음
        new NativeDiscovery().discover();

        SwingUtilities.invokeLater(() -> {
            String rtspUrl = "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov"; // RTSP 스트리밍 주소 설정

            // EmbeddedMediaPlayerComponent를 생성하여 RTSP 스트리밍을 재생합니다.
            EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
            MediaPlayer mediaPlayer = mediaPlayerComponent.mediaPlayer();
            mediaPlayer.media().play(rtspUrl);

            // JFrame을 생성하여 EmbeddedMediaPlayerComponent를 표시합니다.
            JFrame frame = new JFrame();
            frame.setContentPane(mediaPlayerComponent);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
}
