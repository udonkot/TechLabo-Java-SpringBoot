package igdxserv.TechLabo4SpringBoot.rooms.dxservice.task.scheduled;

import com.slack.api.methods.SlackApiException;
import igdxserv.TechLabo4SpringBoot.rooms.slackapi.service.messages.SlackApiMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * DXサービスユニット向けスケジュール登録クラス
 */
@Component
public class DxServiceScheduledTask implements IDxServiceScheduledTask{

    // WHATNEW取得API URI
    private final String DXSERVICE_APIURL_WHATNEW = System.getenv("DXSERVICE_APIURL_WHATNEW");

    // unt-dxサービス_全体周知連絡用チャンネルID
    private final String DXSERVICE_CHANNELID_ALL = System.getenv("DXSERVICE_CHANNELID_ALL");

    // Slackメッセージ送信サービス
    @Autowired
    SlackApiMessagesService slackApiMessagesService;

    /**
     * WhatNew送信
     * ポータルサイトのWhatNewを取得し、Slackのチャンネルに送信する。
     * 毎週水曜の12時に送信する(0 0 12 * * 3)
     */
    @Scheduled(cron = "0 0 12 * * 3")
    @Override
    public void sendPortalWhatNew() {
        // APIで取得
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(DXSERVICE_APIURL_WHATNEW, HttpMethod.GET, null, String.class);

        // 2xx以外の場合は終了
        HttpStatusCode status = response.getStatusCode();
        if(!status.is2xxSuccessful()) {
            return;
        }

        // メッセージ送信
        try {
            String body = response.getBody();
            slackApiMessagesService.sendMessage(DXSERVICE_CHANNELID_ALL, body);
        } catch (SlackApiException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
