package com.talentica.talenticaproduct.security;

import org.springframework.security.core.Authentication;

public interface IAuthentication {
	Authentication getAuthentication();
}
