package org.cnu.realcoding.weathercrawler.api;

import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChampionApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-37e245b2-2acd-4150-a291-75419fb3a190";
    private final String summonerApiURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/rc21?api_key=RGAPI-37e245b2-2acd-4150-a291-75419fb3a190";

    public CurrentWeather getChampion(String champion) {
        CurrentWeather currentWeather = restTemplate.exchange(summonerApiURL, HttpMethod.GET, null, CurrentWeather.class, champion, apiKey)
                .getBody();
        return currentWeather;
    }
}
