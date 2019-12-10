package com.selonsy.community.controller;

import com.selonsy.community.dto.AccessTokenDTO;
import com.selonsy.community.dto.GithubUser;
import com.selonsy.community.provider.GithubProvider;
//import org.graalvm.compiler.nodes.memory.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright：Sichen International Co. Ltd.
 *
 * @author selonsy
 * Created on 2019/12/10.
 * Desc : none
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    //@Value 注解，可以从 application.properties 文件中读取配置信息。
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        System.out.println(githubUser.getName());
        return "index";
    }
}
