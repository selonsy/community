package com.selonsy.community.controller;

import com.selonsy.community.dto.AccessTokenDTO;
import com.selonsy.community.dto.GithubUser;
import com.selonsy.community.provider.GithubProvider;
//import org.graalvm.compiler.nodes.memory.Access;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("5550a9bd21e25864cf23");
        accessTokenDTO.setClient_secret("4a018ea12861a895ee0f1dd69018f7697181accb");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        System.out.println(githubUser.getName());
        return "index";
    }
}
