package com.bandiera.practice.spring.security.config;

import com.bandiera.practice.spring.security.note.NoteService;
import com.bandiera.practice.spring.security.notice.NoticeService;
import com.bandiera.practice.spring.security.user.User;
import com.bandiera.practice.spring.security.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 초기 상태 등록 Config
 */
@Configuration
@RequiredArgsConstructor
@Profile(value = "!test") // test 에서는 제외
public class InitializeDefaultConfig {

    private final UserService userService;
    private final NoteService noteService;
    private final NoticeService noticeService;

    /**
     * 유저 등록, note 4개 등록
     */
    @Bean
    public void initializeDefaultUser() {
        User user = userService.signup("user", "user");
        noteService.saveNote(user, "test1", "this is test1");
        noteService.saveNote(user, "test2", "this is test2");
        noteService.saveNote(user, "test3", "this is test3");
        noteService.saveNote(user, "summer vacation", "comment about summer vacation...");
    }

    @Bean
    public void initializeDefaultAdmin() {
        userService.signupAdmin("admin", "admin");
        noticeService.saveNotice("Welcome", "Everybody Welcome");
        noticeService.saveNotice("About Note", "1. 회원가입\\n2. 로그인\\n3. 노트 작성\\n4. 저장\\n* 본인 외에는 게시글을 볼 수 없습니다.");
    }
}
