/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.twitter.connect;

import org.springframework.social.connect.oauth1.AbstractOAuth10aServiceProvider;
import org.springframework.social.connect.support.ConnectionRepository;
import org.springframework.social.twitter.TwitterApi;
import org.springframework.social.oauth1.OAuth10aTemplate;
import org.springframework.social.twitter.TwitterTemplate;

/**
 * Twitter ServiceProvider implementation.
 * @author Keith Donald
 * @author Craig Walls
 */
public final class TwitterServiceProvider extends AbstractOAuth10aServiceProvider<TwitterApi> {

	public TwitterServiceProvider(String consumerKey, String consumerSecret, ConnectionRepository connectionRepository) {
		super("twitter", connectionRepository, consumerKey, consumerSecret, new OAuth10aTemplate(consumerKey,
				consumerSecret, "https://twitter.com/oauth/request_token",
				"https://twitter.com/oauth/authorize?oauth_token={requestToken}", "https://twitter.com/oauth/access_token"));
	}

	@Override
	protected TwitterApi getApi(String consumerKey, String consumerSecret, String accessToken, String secret) {
		return new TwitterTemplate(consumerKey, consumerSecret, accessToken, secret);
	}

}