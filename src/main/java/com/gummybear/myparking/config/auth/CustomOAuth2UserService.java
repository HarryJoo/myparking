package com.gummybear.myparking.config.auth;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.gummybear.myparking.config.auth.dto.OAuthAttributes;
import com.gummybear.myparking.config.auth.dto.SessionUser;
import com.gummybear.myparking.domain.user.User;
import com.gummybear.myparking.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	
	private final UserRepository userRepository;
	private final HttpSession httpSession;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId(); // 구글만 사용하는 값(로그인 진행 중인 서비를 구분하는 코드)
		String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().
				getUserInfoEndpoint().getUserNameAttributeName(); // OAuth2 로그인 진행 시 키가 되는 필드값
	
		OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, 
				oAuth2User.getAttributes()); // OAuth2UserService를 통해 가져온  OAuth2User의 attributes
		
		User user = saveOrUpdate(attributes);
		
		httpSession.setAttribute("user", new SessionUser(user));
		
		return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
				attributes.getAttributes(),
				attributes.getNameAttributeKey());
	}
	
	private User saveOrUpdate(OAuthAttributes attributes) {
		User user = userRepository.findByEmail(attributes.getEmail())
									.map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
									.orElse(attributes.toEntity());
		
		return userRepository.save(user);
	}
}
