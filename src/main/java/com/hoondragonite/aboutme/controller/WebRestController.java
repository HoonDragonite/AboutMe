package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.domain.posts.PostsRepository;
import com.hoondragonite.aboutme.domain.posts.PostsSaveRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity()); // 실제로는 이런 형태 : this.postsRepository = postsRepository;
    }
}
